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
        Empleado.addEmployee(new Empleado("Joel", "García", "Rojas", (byte) 19, "118930275", "joel33960@gmail.com", "IT", "2022", 4000000L, "Ingeniero en sistemas", 2345678456L, "1150 metros sur de la estrella de la muerte", "83962643", "Corusant", true));
        //char tipo = JOptionPane.showInputDialog(null, "Que desea hacer c) registrar empleado o e) editar empleado").toLowerCase().charAt(0);
        Menu.main();
        //FormEmpleado.main(tipo);
    }
    
}

//https://www.upgrad.com/blog/runnable-interface-in-java/
//https://www.geeksforgeeks.org/io-bufferedwriter-class-methodsedwri-java/
//https://medium.com/@isaacjumba/why-use-bufferedreader-and-bufferedwriter-classses-in-java-39074ee1a966
//https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiQra6njbb9AhUFRTABHWS3BoQQFnoECA4QAw&url=https%3A%2F%2Fcrunchingthedata.com%2Fpython-init-file%2F&usg=AOvVaw3npFkgdfrB3fYlgqKjq8uB