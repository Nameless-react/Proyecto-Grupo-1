/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Daniel Lopez
 */
public class CategoriasAtracciones {
    private static LinkedList<CategoriasAtracciones> categorias = new LinkedList<>();
    
    private String categoria;
    private String caracteristicas;
    private boolean estado;
    
    
    public CategoriasAtracciones(String categoria, String caracteristicas, boolean estado){
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
     
    }
   
    public static LinkedList<CategoriasAtracciones> getCategorias(String fileName) {
        Handler handler = new Handler();
        String fileContent = "";
        
        if (!categorias.isEmpty()) return categorias;
        
        try {
            fileContent = handler.readFile(fileName);
        } catch (IOException ex01) {
            
            if (ex01.getMessage().matches("[0-9A-Za-z]*\\.txt \\(No such file or directory\\)")) {
              
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    writer.write("\nAcuatica\n" +
                              "Es una atraccion que se desliza sobre una superficie con agua en lugar de railes, suelen usar un barco en vez de un coche o tren, una atraccion que salpica agua a las personas dentro de la barca.\n"
                            + "true\n"
                            + "|"
                            + "\nMontañas rusas\n"
                            + "Es una atraccion que se desliza sobre railez, pueden llegar a tener una gran altura, usan un coche o un tren como vehiculo, tienen una imagen muchas veces impactante debido a su diseño pero es una atraccion muy segura.\n"
                            + "true\n"
                            + "|"
                            + "\nTematicas\n"
                            + "Son atracciones que tienen una tematica ya sea patriotica, de algun juego, de alguna pelicula, de alguna epoca del año como puede ser halloween, navidad, año nuevo chino, etc.\n"
                            + "true\n"
                            + "|"
                            + "\nNoria\n"
                            + "Es una atraccion que consiste en una rueda vertical que va girando, donde en esa rueda tiene sillas o cabinas donde las personas pueden entrar, tienen vistas espectaculares del larque de atracciones.\n"
                            + "true\n"
                            + "|");
                  writer.close(); 
                
                
                
                    categorias.add(new CategoriasAtracciones("Acuatica","Es una atraccion que se desliza sobre una superficie con agua en lugar de railes, suelen usar un barco en vez de un coche o tren, una atraccion que salpica agua a las personas dentro de la barca.", true));
                    categorias.add(new CategoriasAtracciones("Montañas rusas","Es una atraccion que se desliza sobre railez, pueden llegar a tener una gran altura, usan un coche o un tren como vehiculo, tienen una imagen muchas veces impactante debido a su diseño pero es una atraccion muy segura.", true));
                    categorias.add(new CategoriasAtracciones("Tematicas","Son atracciones que tienen una tematica ya sea patriotica, de algun juego, de alguna pelicula, de alguna epoca del año como puede ser halloween, navidad, año nuevo chino, etc.", true));
                    categorias.add(new CategoriasAtracciones("Noria","Es una atraccion que consiste en una rueda vertical que va girando, donde en esa rueda tiene sillas o cabinas donde las personas pueden entrar, tienen vistas espectaculares del larque de atracciones.", true));
                    return categorias;
                
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
            String[] categoria = fileContentList[i].trim().split("\n");
       
            if (categoria.length < 3) continue;
            
            try {
                categorias.add(new CategoriasAtracciones(categoria[0], categoria[1], categoria[2].equals("true"))); 
            } catch (IndexOutOfBoundsException e) {
                handler.showMessage("Error en la conversión de datos: " + e.getMessage(), "Error", handler.ERROR);
            }
        }
        
        
        
        return categorias;
    }
    
    public static LinkedList<CategoriasAtracciones> addCategorias(String nombre, String descripcion, boolean estado) { 
        Handler handler = new Handler();
        
        for (CategoriasAtracciones categoria : categorias) {
            if(categoria.getCategoria().equals(nombre)) {
                handler.showMessage("Ya existe una categoría con ese nombre", "Categoría duplicada", handler.ERROR);
                return new LinkedList<>();
            }
        
        }
        
        categorias.add(new CategoriasAtracciones(nombre, descripcion, estado));
        return categorias;
    }

    
    public static void safeCategorias(String fileName) {
        Handler handler = new Handler();
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String data = "";
            
            
            for (CategoriasAtracciones categoria : categorias) {
                
                data += "\n"
                        + categoria.getCategoria() + "\n"
                        + categoria.getCaracteristicas() + "\n"
                        + categoria.isEstado() + "\n"
                        + "|";               
            }
            
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            handler.showMessage("Error al guardar los datos", "Error", handler.ERROR);
        }
    }
    
    
    public static void toggleStateCategory(String nombreCategoria) {
        Handler handler = new Handler();
        
        for (Atraccion atraccion : Atraccion.getAtracciones("atracciones.txt")) {
            if (atraccion.getCat().equals(nombreCategoria)) {
                handler.showMessage("No se puede desactivar la categoría debido a que contiene atracciones", "Error", handler.ERROR);
                return;
            }
        }
        
        for (CategoriasAtracciones categoria : categorias) {
            if (categoria.categoria.equals(nombreCategoria)) {
                categoria.setEstado(!categoria.isEstado());
                handler.showMessage("La categoría está " + (categoria.estado ? "Activada" : "Desactivada"), "Categoría: " + nombreCategoria, handler.INFORMATION);
                return;
            }
        }
        
        handler.showMessage("La categoría no fue encontrada", "No encontrado", handler.ERROR);
    }
    
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}