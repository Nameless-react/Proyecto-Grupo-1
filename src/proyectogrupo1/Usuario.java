/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedWriter;
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
    private static List<Usuario> newUsers = new ArrayList<>();
    
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
            fileContent = handler.readFile(fileName);
        
        } catch (IOException ex01) {
            
            if (ex01.getMessage().matches("[0-9A-Za-z]*\\.txt \\(No such file or directory\\)")) {
              
              try {
                  
                  BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
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
                users.add(new Usuario(usuario[1], usuario[2], usuario[3], Byte.parseByte(usuario[6]), usuario[0], usuario[7], usuario[5], usuario[8].equals("true"), usuario[4])); 
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                handler.showMessage("Error en la conversión de datos: " + e.getMessage(), "Error", handler.ERROR);
            }
        }
        return users;
    }
    
    public static List<Usuario> Agregar(Usuario u){
        Handler h = new Handler();
        for (Usuario usuario : users) {
            if (usuario.equals(u)) {
                h.showMessage("La identificación ya pertenece a un usuario", "Error", h.ERROR);
                return new ArrayList<>();
            }
        }
        
        users.add(u);
        newUsers.add(u);
        h.showMessage("Usuario agregado exitosamente!", "Exito", h.INFORMATION);
        return users;
    }
    
    
    
    public static void safeUsers(String fileName) {
        Handler handler = new Handler();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String data = "";
            for (Usuario usuario : users) {
                data += "\n"
                        + usuario.getIdentification() + "\n"
                        + usuario.getName() + "\n"
                        + usuario.getFirstSurName() + "\n"
                        + usuario.getSecondSurName() + "\n"
                        + usuario.getNickName() + "\n"
                        + usuario.getPassword() + "\n"
                        + usuario.getAge() + "\n"
                        + usuario.getEmail() + "\n"
                        + usuario.getState() + "\n"
                        + "|";                
            }
            
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            handler.showMessage("Error al guardar los datos", "Error", handler.ERROR);
        }
    }
    public static void toggleUserState(String identification){
        Handler handler = new Handler();
        
        for(Usuario usuario: users){ 
            if(usuario.equals(identification)){
                usuario.setState(!usuario.getState());
                handler.showMessage("Se cambio correctamente el estado de usuario.",  "Usuario: " + usuario.getIdentification(), handler.INFORMATION);
                return;
            }
        }
        handler.showMessage("El usuario no fue encontrado", "Error", handler.ERROR);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.getName() + " " + this.getFirstSurName() + " " + this.getSecondSurName() +
               "\nCédula: " + this.getIdentification() + 
               "\nCorreo: " + this.getEmail() +
               "\nEstado: " + this.getState();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.getIdentification());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {   
        if (obj instanceof String string) return string.equals(this.getIdentification());
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.getIdentification(), other.getIdentification());
    }
    
    
    
    public static String newUsers() {
        String usersText = "";
        
        for (Usuario usuario : newUsers) {
            usersText += usuario.getIdentification() + " "
                        + usuario.getName() + " "
                        + usuario.getFirstSurName() + " "
                        + usuario.getSecondSurName() + " "
                        + usuario.getNickName() + " "
                        + usuario.getPassword() + " "
                        + usuario.getAge() + " "
                        + usuario.getEmail() + " "
                        + usuario.getState() + "|"; 
        }
        
        return usersText;
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