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
    private String name;
    private String firstSurName;
    private String secondSurName;
    private byte age;
    private String identification;
    private String email;
    
    public Persona(String name, String firstSurName, String secondSurName, byte age, String identification, String email) {
        this.name = name;
        this.firstSurName = firstSurName;
        this.secondSurName = secondSurName;
        this.age = age;
        this.identification = identification;
        this.email = email;
    }

    
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurName() {
        return firstSurName;
    }

    public void setFirstSurName(String firstSurName) {
        this.firstSurName = firstSurName;
    }

    public String getSecondSurName() {
        return secondSurName;
    }

    public void setSecondSurName(String secondSurName) {
        this.secondSurName = secondSurName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
    
    
}
