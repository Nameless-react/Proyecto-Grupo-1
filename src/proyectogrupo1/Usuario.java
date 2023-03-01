/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 *
 * @author joel
 */
public class Usuario extends Persona {
    private String password;
    private boolean state;
    private String nickName;
    private static List<Usuario> users = new ArrayList<>();
    
    public Usuario (String name, String firstSurName, String secondSurName, byte age, String identification, String email, String password, boolean state, String nickName) {
        super(name, firstSurName, secondSurName, age, identification, email);
        this.password = password;
        this.nickName = nickName;
        this.state = state;
    }
    
    public static List<Usuario> getUsers(String fileName) {
        Handler handler = new Handler();
        String fileContent = "";
        
        if (!users.isEmpty()) return users;
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent += line + "\n";
            }
        
            bufferedReader.close();
        
        } catch (IOException ex01) {
            
            if (ex01.getMessage().matches("[0-9A-Za-z]*\\.txt \\(No such file or directory\\)")) {
              
              try {
                  File file = new File(fileName);
                  file.createNewFile();
                  FileWriter writer = new FileWriter(fileName);
                  writer.write("\n234567873456\n" +
                            "Gerardo\n" +
                            "Escamilla\n" +
                            "Alvarado\n" +
                            "Gera\n" +
                            "con\n" +
                            "24\n" +
                            "gera1234@gmail.com\n" +
                            "true\n"
                          + "|\n");
                writer.close();
                
                users.add(new Usuario("Gerardo", "Escamilla", "Alvarado", (byte) 24, "23456787654356", "gera1234@gmail.com", "con", false, "Gera"));
                return users;
                
              } catch (IOException ex02) {
                  handler.showMessage("Error al crear archivo: " + ex02.getMessage(), "Error", handler.ERROR);
                  return new ArrayList<>();
              }
            }
            
            
            
            
            handler.showMessage("Error al leer el archivo: " + ex01.getMessage(), "Error", handler.ERROR);
            return new ArrayList<>();
        }
        
        
        
        String[] fileContentList = fileContent.split("\\|");
       
        for (int i = 0; i < fileContentList.length; i++) {
            String[] usuario = fileContentList[i].trim().split("\n");
            if (usuario.length < 6) continue;
            
            try {
                users.add(new Usuario(usuario[1], usuario[2], usuario[3], Byte.parseByte(usuario[6]), usuario[0], usuario[7], usuario[5], Boolean.parseBoolean(usuario[8]), usuario[4])); 
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                handler.showMessage("Error en la conversión de datos: " + e.getMessage(), "Error", handler.ERROR);
            }
        }
        return users;
    }
    
    public static List<Usuario> Agregar(Usuario u){
        Handler h = new Handler();
        for (Usuario usuario : users) {
            if (usuario.getIdentification().equals(u.getIdentification())) {
                h.showMessage("La identificación ya pertenece a un usuario", "Error", h.ERROR);
                return new ArrayList<>();
            }
        }
        
        users.add(u);
        h.showMessage("Usuario agregado exitosamente!", "Exito", h.INFORMATION);
        return users;
    }
    
    
    
    public static void safeUsers(String fileName) {
        Handler handler = new Handler();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            
            //Completar guardado de datos
            for (Usuario usuario : users) {
                writer.write("\n"
                        + usuario.getIdentification() + "\n"
                        + usuario.getName() + "\n"
                        + usuario.getFirstSurName() + "\n"
                        + usuario.getSecondSurName() + "\n"
                        + usuario.getNickName() + "\n"
                        + usuario.getPassword() + "\n"
                        + usuario.getAge() + "\n"
                        + usuario.getEmail() + "\n"
                        + usuario.getState() + "\n"
                        + "|");                
            }
            
            writer.close();
        } catch (IOException ex) {
            handler.showMessage("Error al guardar los datos", "Error", handler.ERROR);
        }
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
