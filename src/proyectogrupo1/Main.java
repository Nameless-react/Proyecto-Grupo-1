/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;



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
        Empleado.addEmployee("Joel", "García", "Rojas", (byte) 19, "118930275", "joel33960@gmail.com", "IT", "2022", 4000000L, "Ingeniero en sistemas", 2345678456L);
        FormEmpleado.main(args);
    }
    
}