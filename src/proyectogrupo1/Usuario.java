/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.util.*;

/**
 *
 * @author joel
 */
public class Usuario extends Persona {
    private String password;
    private boolean state;
    private String nickName;
    public static List<Usuario> users = new ArrayList<>();
    
    public Usuario (String name, String firstSurName, String secondSurName, byte age, String identification, String password, boolean state, String nickName) {
        super(name, firstSurName, secondSurName, age, identification);
        this.password = password;
        this.nickName = nickName;
        this.state = state;
    }
}
