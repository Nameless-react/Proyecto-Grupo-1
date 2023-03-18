/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogrupo1;

import java.util.LinkedList;

/**
 *
 * @author Daniel Lopez
 */
public class CategoriasAtracciones {
    private static LinkedList<CategoriasAtracciones> categorias = new LinkedList<>();
    
    public String categoria;
    public String caracteristicas;
    public boolean estado;
    
    
    public CategoriasAtracciones(String categoria, String caracteristicas, boolean estado){
        this.categoria = categoria;
        this.caracteristicas = caracteristicas;
        this.estado = true;
     
    }
    //Refactorizar
    public static LinkedList<CategoriasAtracciones> getCategorias() {
        
//        if(!categorias.isEmpty()) {   
        categorias.add(new CategoriasAtracciones("Acuatica","Es una atraccion que se desliza sobre una superficie con agua en lugar de "
                + "railez, suelen usar un barco en vez de un coche o tren, una "
                + "atraccion que salpica agua a las personas dentro de la barca",true));


        categorias.add(new CategoriasAtracciones("Montañas rusas","Es una atraccion que se desliza sobre railez, pueden llegar a tener una"
                + "gran altura, usan un coche o un tren como vehiculo, tienen una imagen muchas veces impactante debido a su diseño pero "
                + "es una atraccion muy segura ",true));


        categorias.add(new CategoriasAtracciones("Tematicas","Son atracciones que tienen una tematica ya sea patriotica, de algun juego, de alguna pelicula, "
                + "de alguna epoca del año como puede ser halloween, navidad, año nuevo chino, etc",true));


        categorias.add(new CategoriasAtracciones("Noria","Es una atraccion que consiste en una rueda vertical que va girando, donde en esa rueda tiene sillas o cabinas donde las "
                + "personas pueden entrar, tienen vistas espectaculares del larque de atracciones",true));
//        }
        
        
        return categorias;
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
