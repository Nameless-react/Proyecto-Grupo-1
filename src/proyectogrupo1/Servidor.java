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
            
            int option = 0;
            while (true) {
                option = input.readInt();
                
                if (option == 3) break;
                
                if(option == 1) {
                    String[] cliente = input.readUTF().split(" ");
                    try {
                        clientesRecibidos.add(new Usuario(cliente[0], cliente[1], cliente[2], Byte.parseByte(cliente[3]), cliente[4], cliente[5], cliente[6], "true".equals(cliente[7]), cliente[8]));
                    
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        handler.showMessage("Error al guardar los clientes en servidor", "Error en conversión", handler.ERROR);
                    } 
                } else if(option == 2) {
                    long ingresos = input.readLong();
                    ingresosDiarios += ingresos;
                }
            }
            client.close();
            server.close();
            
            saveDataBase();
        } catch (IOException ex) {
            handler.showMessage("Error en el servidor: " + ex.getMessage(), "Error en servidor", handler.ERROR);
        }
        
    }
    
    
    public static void saveDataBase() {
        Handler handler = new Handler();
        //Falta completar
        try {
            
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Proyecto", "root", "");
            
            Statement statement = conexion.createStatement();
            
            //ResultSet result = statement.executeQuery("INSERT");
            
            
        } catch(SQLException sqle) {
            handler.showMessage("Error en el acceso a la base de datos: " + sqle.getMessage(), "Error en la base de datos", handler.ERROR);
        }
    }
}
