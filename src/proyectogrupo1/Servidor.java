/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


/**
 *
 * @author joel
 */
public class Servidor {
    private static DataOutputStream output;
    private static DataInputStream input;
    private static ServerSocket server;
    private static final int PORT = 5500;
    private static Socket client;
    
    private static long ingresosDiarios = 0;
    private static List<Usuario> clientesRecibidos = new ArrayList<>();
    
    
    
            
    public static void main(String args[]) {
        initServer();
    }

    
    public static void initServer() {
        Handler handler = new Handler();
        
        try {
            server = new ServerSocket(PORT);
            System.out.println("Esperando una conexión...");
            client = server.accept();
            
            input = new DataInputStream(client.getInputStream());
            output = new DataOutputStream(client.getOutputStream());
            
            System.out.println("Conexión establecida");
        
            
            long ingresos = input.readLong();
            ingresosDiarios += ingresos;
            
            String[] clientes = input.readUTF().split("\\|");
                    
            if (clientes.length != 0)  {
                for (String users : clientes) {
                    System.out.println(users);
                    String[] cliente = users.split(" ");
                    if (cliente.length < 6) continue;
                    
                    try {
                        clientesRecibidos.add(new Usuario(cliente[1], cliente[2], cliente[3], Byte.parseByte(cliente[6]), cliente[0], cliente[7], cliente[5], "true".equals(cliente[8]), cliente[4]));

                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        handler.showMessage("Error al guardar los clientes en el servidor: " + e.getMessage(), "Error en conversión", handler.ERROR);
                    }
                }            
            }
            


            saveDataBase();

            client.close();
            server.close();
            
            System.out.println("Conexión finalizada con el servidor");
        } catch (IOException ex) {
            handler.showMessage("Error en el servidor: " + ex.getMessage(), "Error en servidor", handler.ERROR);
        }
        
    }
    
    
    public static void saveDataBase() {
        Handler handler = new Handler();
        //Falta completar
        try {
            
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Proyecto", "root", "12345678");
            System.out.println("Conexión establecida con la base de datos");
            
            Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            if (!clientesRecibidos.isEmpty()) {
                for (Usuario cliente : clientesRecibidos) {
                    statement.executeUpdate("insert into Cliente(identification, name, firstSurName, secondSurName, age, email, password, state, nickName)" + "values('" + cliente.getIdentification() + "', '"
                                            + cliente.getName() + "', '" 
                                            + cliente.getFirstSurName() + "', '"
                                            + cliente.getSecondSurName() + "', "
                                            + cliente.getAge() + ", '"
                                            + cliente.getEmail() + "', '"
                                            + cliente.getPassword() + "', "
                                            + cliente.getState() + ", '" 
                                            + cliente.getNickName() + "')");
                    System.out.println("Usuario agregado");
                }
            }
            
           
            ResultSet result = statement.executeQuery("select * from Earnings");
            
            while (result.next()) {
                System.out.println(result.getLong("earnings"));
                ingresosDiarios += result.getLong("earnings");
            }
           statement.executeUpdate("update Earnings set earnings = " + ingresosDiarios);
           System.out.println("Ingresos actualizados"); 
           
        } catch(SQLException sqle) {
            handler.showMessage("Error en el acceso a la base de datos: " + sqle.getMessage(), "Error en la base de datos", handler.ERROR);
        }
    }
}
