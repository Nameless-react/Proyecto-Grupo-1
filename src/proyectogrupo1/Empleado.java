/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author joel
 */
public class Empleado extends Persona {
    private String department;
    private String yearJoined;
    private long wage;
    private String profession;
    private long employeeNumber;
    private String address;
    private String phone;
    private String city;
    private boolean state;
    
    private static LinkedList<Empleado> employees = new LinkedList<>();
    
    public Empleado(String name, String firstSurName, String secondSurName, byte age, String identification, String email, String department, String yearJoined, long wage, String profession, long employeeNumber, String address, String phone, String city, boolean state) {
        super(name, firstSurName, secondSurName, age, identification, email);
        this.department = department;
        this.yearJoined = yearJoined;
        this.wage = wage;
        this.profession = profession;
        this.employeeNumber = employeeNumber;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.state = state;
    }

    
    public static LinkedList<Empleado> getEmployee(String fileName) {
        Handler handler = new Handler();
        String fileContent = "";
        
        if (!employees.isEmpty()) return employees;
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent += line + "\n";
            }
        
            bufferedReader.close();
        
        } catch (IOException ex01) {
            
            if (ex01.getMessage().matches("[0-9A-Za-z]*\\.txt \\(No such file or directory\\)")) {
              
              try {
                  File file = new File(fileName);
                  file.createNewFile();
                  FileWriter writer = new FileWriter(fileName);
                  writer.write("\n2223456789876543\n" +
                            "Ignacio\n" +
                            "Duarte\n" +
                            "Gómez\n" +
                            "1200000\n" +
                            "Finanzas\n" +
                            "24\n" +
                            "ig124@gmail.com\n" +
                            "2012\n" +
                            "Contador\n" +
                            "345676543\n" +
                            "100 metros sur de la luna\n" +
                            "83944839\n" +
                            "Guadalajara\n" +
                            "ocupado\n"
                          + "|\n");
                writer.close();
                
                employees.add(new Empleado("Ignacio", "Duarte", "Gómez", (byte) 34, "223456789876543", "ig124@gmail.com", "Finanzas", "2012", 1200000L, "Contador", 345676543L, "100 metros sur de la luna", "83944839", "Guadalajara", true));
                return employees;
                
              } catch (IOException ex02) {
                  handler.showMessage("Error al crear archivo: " + ex02.getMessage(), "Error", handler.ERROR);
                  return new LinkedList<>();
              }
            }
            
            
            
            
            handler.showMessage("Error al leer el archivo: " + ex01.getMessage(), "Error", handler.ERROR);
            return new LinkedList<>();
        }
        
        
        
        String[] fileContentList = fileContent.split("\\|");
       
        for (int i = 0; i < fileContentList.length; i++) {
            String[] empleado = fileContentList[i].trim().split("\n");
            if (empleado.length < 6) continue;
            
            try {
                employees.add(new Empleado(empleado[1], empleado[2], empleado[3], Byte.parseByte(empleado[6]), empleado[0], empleado[7], empleado[5], empleado[8], Long.parseLong(empleado[4]), empleado[9], Long.parseLong(empleado[10]), empleado[11], empleado[12], empleado[13], Boolean.parseBoolean(empleado[14]))); 
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                handler.showMessage("Error en la conversión de datos: " + e.getMessage(), "Error", handler.ERROR);
            }
        }
        return employees;
    }
    
    public static LinkedList<Empleado> addEmployee(Empleado empleado) {
        Handler handler = new Handler();
        
        for (Empleado employee : employees) {
            if (employee.getIdentification().equals(empleado.getIdentification())) {
                handler.showMessage("La identificación ya está asignada a otro empleado", "Error", handler.ERROR);
                return new LinkedList<>();
            }
        }
        
        employees.add(empleado);
        
        handler.showMessage("Datos guardados exitosamente", "Exito", handler.PLAIN);
        return employees;
    }
    
    public static LinkedList<Empleado> editEmployee(String identification, Empleado newEmpleado) {
        Handler handler = new Handler();
        
        for (int i = 0; i < employees.size(); i++) {
            if (identification.equals(employees.get(i).getIdentification())) {
                employees.set(i, newEmpleado);
                handler.showMessage("Datos actualizados correctamente", "Exito", handler.PLAIN);
                return employees;
            }
        }
        handler.showMessage("Los datos no fueron actualizados, por favor vuelva a intentarlo", "Exito", handler.PLAIN);
        return employees;
    }
    
    public void safeEmployees(String fileName) {
        Handler handler = new Handler();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            
            //Completar guardado de datos
            for (Empleado empleado : employees) {
                writer.write("\n"
                        + empleado.getIdentification() + "\n"
                        + empleado.getName() + "\n"
                        + empleado.getFirstSurName() + "\n"
                        + empleado.getSecondSurName() + "\n"
                        + empleado.getWage() + "\n"
                        + empleado.getAge() + "\n"
                        + empleado.getDepartment() + "\n"
                        + empleado.getEmail() + "\n"
                        + empleado.getYearJoined() + "\n"
                        + empleado.getProfession() + "\n"
                        + empleado.getEmployeeNumber() + "\n"
                        + empleado.getAddress() + "\n"
                        + empleado.getPhone() + "\n"
                        + empleado.getCity() + "\n"
                        + empleado.isState() + "\n"
                        + "|\n");                
            }
            
            writer.close();
        } catch (IOException ex) {
            handler.showMessage("Error al guardar los datos", "Error", handler.ERROR);
        }
    }
    
    public static void toggleEmployeeState(String identification) {
        Handler handler = new Handler();
        for (Empleado empleado : employees) {
            if (empleado.getIdentification().equals(identification)) {
                empleado.setState(!empleado.isState());
                handler.showMessage("Empleado " + (empleado.isState() ? "activado" : "desactivado"), "Usuario: " + empleado.getIdentification(), handler.INFORMATION);
                return;
            }
        }
        
        handler.showMessage("Usuario no encontrado", "Error", handler.ERROR);
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(String yearJoined) {
        this.yearJoined = yearJoined;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
