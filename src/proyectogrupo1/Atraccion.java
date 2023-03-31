/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Daniel Lopez
 */
public class Atraccion {
    private static LinkedList<Atraccion> atracciones = new LinkedList<>();
    private String nombreAtraccion = "";
    private String cat = "";
    private String empleado = "";
    private boolean state;
    
    
    public Atraccion (String nombreAtraccion, String cat, String empleado, boolean state) {
        this.nombreAtraccion = nombreAtraccion;
        this.cat = cat;
        this.empleado = empleado;
        this.state = true;
        
    }
    
    public Atraccion() {}
    
    
    public static LinkedList<Atraccion> getAtracciones(String fileName) {
        Handler handler = new Handler();
        String fileContent = "";
        
        if (!atracciones.isEmpty()) return atracciones;
        
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
                  BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                  writer.write("\nEl martillo\n" +
                            "Montañas Rusas\n" +
                            "2223456789876543\n" +
                            "true\n" +
                            "|");
                writer.close(); 
                
                
                
                atracciones.add(new Atraccion("El martillo", "Montañas Rusas", "2223456789876543", true));
                return atracciones;
                
              } catch (IOException ex02) {
                  handler.showMessage("Error al crear archivo: " + ex02.getMessage(), "Error", handler.ERROR);
                  return new LinkedList<>();
              }
            }
            
            
            
            
            handler.showMessage("Error al leer el archivo: " + ex01.getMessage(), "Error", handler.ERROR);
            return new LinkedList<>();
        }
        
        
        
        String[] fileContentList = fileContent.split("\\|");
       
        for (String element : fileContentList) {
            String[] atraccion = element.trim().split("\n");
            if (atraccion.length < 2) continue;
            try {
                atracciones.add(new Atraccion(atraccion[0], atraccion[1], atraccion[2], atraccion[3].equals("true"))); 
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                handler.showMessage("Error en la conversión de datos: " + e.getMessage(), "Error", handler.ERROR);
            }
        }
        return atracciones;
    }
    
    
    
    //metodo que verifica si existe la categoria
    public static boolean verificarCat(String categoriaCreada) {
        Handler handler = new Handler();
        
        for (CategoriasAtracciones categoria : CategoriasAtracciones.getCategorias("categorias.txt")) {
            if(categoria.getCategoria().equals(categoriaCreada)) return true;
        }    
        
        handler.showMessage("La categoria no existe", "Error", handler.ERROR);
        return false;
    }
    
    
    public static void crearAtraccion(String nombreAtraccion, String categoriaCreada, String identificacionEmpleado){
        Handler handler = new Handler();
        
        boolean continuar = verificarCat(categoriaCreada);
        if(!continuar) return;
        
        atracciones.add(new Atraccion(nombreAtraccion, categoriaCreada, identificacionEmpleado, true));
        handler.showMessage("Atracción creada existosamente", "Exito", handler.INFORMATION);
        
    }
    
    // Metodo para editar estado de la atraccion
    public static void cambiarEstadoAtraccion(String nombreAtraccion) {
        Handler handler = new Handler();
        //cambiar el estado dependiendo del empleado enlazado
       
        
        for (Atraccion atraccion : atracciones) {
            if (atraccion.getNombreAtraccion().equals(nombreAtraccion)) {
                for (Empleado empleado : Empleado.getEmployee("empleados.txt")) {
                    if (atraccion.getEmpleado().equals(empleado.getIdentification())) {
                        handler.showMessage("La atracción tiene un empleado relacionado", "Información", handler.ERROR);
                        return;
                    }
                }   
        
                
                atraccion.setState(!atraccion.isState());
                handler.showMessage("La atracción " + (atraccion.isState() ? "activado" : "desactivado"), "Atracción: " + atraccion.getNombreAtraccion(), handler.INFORMATION);
                return;
            }
        }
        
        handler.showMessage("Atracción no encontrada", "Error", handler.ERROR);
    }

    
    //metodo para editar atracciones
    public static LinkedList<Atraccion> editAtraccion(String nombreAtraccion, Atraccion newAtraccion) {
        Handler handler = new Handler();
        
        for (int i = 0; i < atracciones.size(); i++) {
            
            if (nombreAtraccion.equals(atracciones.get(i).getNombreAtraccion())) {
                atracciones.set(i, newAtraccion);
                handler.showMessage("Datos actualizados correctamente", "Información", handler.INFORMATION);
                return atracciones;
            }
        }
        handler.showMessage("Los datos no fueron actualizados, por favor vuelva a intentarlo", "Error", handler.ERROR);
        return atracciones;
    }
    
    public static void safeAtraccion(String fileName) {
        Handler handler = new Handler();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String data = "";
            
            
            for (Atraccion atraccion : atracciones) {
                data += "\n"
                        + atraccion.getNombreAtraccion() + "\n"
                        + atraccion.getCat() + "\n"
                        + atraccion.getEmpleado() + "\n"
                        + atraccion.isState() + "\n"
                        + "|";               
            }
            
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            handler.showMessage("Error al guardar los datos", "Error", handler.ERROR);
        }
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}




