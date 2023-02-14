/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario.users.add(new Usuario("Joel", "García", "Rojas", (byte) 19, "118930275", "1223", false, "Joel"));
        Usuario.users.add(new Usuario("Josué", "García", "Rojas", (byte) 18, "123456785", "122ff3", false, "Josué"));
        
        
        
        System.out.println(String.join("\n", 
                Usuario.users.stream().map(user -> user.name + " " + user.firstSurName + " "+ user.secondSurName).collect(Collectors.toList())));
    }
    
}