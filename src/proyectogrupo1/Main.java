/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

import javax.swing.JOptionPane;



/**
 *
 * @author joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Usuario.getUsers("usuarios.txt").stream().forEach(usuario -> System.out.println(usuario.getName() + " " + usuario.getFirstSurName() + " " + usuario.getSecondSurName() + "\n" + usuario.getEmail()));
        Empleado.addEmployee(new Empleado("Joel", "García", "Rojas", (byte) 19, "118930275", "joel33960@gmail.com", "IT", "2022", 4000000L, "Ingeniero en sistemas", 2345678456L, "1150 metros sur de la estrella de la muerte", "83962643", "Corusant", "desocupado"));
        
        char tipo = JOptionPane.showInputDialog(null, "Que desea hacer c) registrar empleado o e) editar empleado").toLowerCase().charAt(0);
        FormEmpleado.main(tipo);
    }
    
}

//https://www.upgrad.com/blog/runnable-interface-in-java/