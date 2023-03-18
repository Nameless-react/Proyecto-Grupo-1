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
public class categoriasAtracciones {
    public static LinkedList<categoriasAtracciones> Categoria= new LinkedList<>();
    Handler handler = new Handler();
    String Cate;
    String caract;
    boolean estado=true;
    public categoriasAtracciones(String Cate,String caract,boolean estado){
        this.Cate=Cate;
        this.caract=caract;
        this.estado=true;
     
    }

    public LinkedList<categoriasAtracciones> getCategoria() {
        return Categoria;
    }

    public void setCategoria(LinkedList<categoriasAtracciones> Categoria) {
        this.Categoria = Categoria;
    }

    public String getCate() {
        return Cate;
    }

    public void setCate(String cate) {
        this.Cate = Cate;
    }

    public String getCaract() {
        return caract;
    }

    public void setCaract(String caract) {
        this.caract = caract;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   

   
    
     
    public static void main(String[] args) {
        LinkedList<categoriasAtracciones> Categoria= new LinkedList<>();
        
        Categoria.add(new categoriasAtracciones("Acuatica","Es una atraccion que se desliza sobre una superficie con agua en lugar de "
                + "railez, suelen usar un barco en vez de un coche o tren, una "
                + "atraccion que salpica agua a las personas dentro de la barca",true));
        Categoria.add(new categoriasAtracciones("Montañas rusas","Es una atraccion que se desliza sobre railez, pueden llegar a tener una"
                + "gran altura, usan un coche o un tren como vehiculo, tienen una imagen muchas veces impactante debido a su diseño pero "
                + "es una atraccion muy segura ",true));
        Categoria.add(new categoriasAtracciones("Tematicas","Son atracciones que tienen una tematica ya sea patriotica, de algun juego, de alguna pelicula, "
                + "de alguna epoca del año como puede ser halloween, navidad, año nuevo chino, etc",true));
        Categoria.add(new categoriasAtracciones("Noria","Es una atraccion que consiste en una rueda vertical que va girando, donde en esa rueda tiene sillas o cabinas donde las "
                + "personas pueden entrar, tienen vistas espectaculares del larque de atracciones",true));
        
        
        
        
    }
    
}
