/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

/**
 *
 * @author joel
 */
public abstract class Persona {
    protected String name;
    protected String firstSurName;
    protected String secondSurName;
    protected byte age;
    protected String identification;
    
    public Persona(String name, String firstSurName, String secondSurName, byte age, String identification) {
        this.name = name;
        this.firstSurName = firstSurName;
        this.secondSurName = secondSurName;
        this.age = age;
        this.identification = identification;
    }
}
