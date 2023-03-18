/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.util.LinkedList;

/**
 *
 * @author Daniel Lopez
 */
public class Atraccion {
    
    
    public static LinkedList<Atraccion> atracciones=new LinkedList<>();
    String NAtraccion="";
    String Cat="";
    String Emp="";
    boolean state=true;
    Handler handler = new Handler();
    char tipo=' ';
    
    
    public Atraccion (String NAtraccion, String Cat, String Emp, boolean state){
        
        this.NAtraccion=NAtraccion;
        this.Cat=Cat;
        this.Emp=Emp;
        this.state=true;
        
    }
    
    public Atraccion(){
        
    }
    
    //metodo que verifica si existe la categoria
    public static void verificarCat(String Cat){
        Handler handler=new Handler();
            for (categoriasAtracciones Categoria : categoriasAtracciones.Categoria) {
                if(Categoria.getCate().equals(Cat)){
                    handler.showMessage("La categoria esta correcta!", "Categoria asignada exitosamente", handler.INFORMATION);
                    
                }else{
                    handler.showMessage("La categoria no existe!", "Rrror", handler.ERROR);
                    return;
                }
        }


        
    }
    //Metodo que verifica si existe ya ese nombre de atraccion dentro del LinkedList
    public static void verificarNAtraciones (String NAtraccion){
        Handler handler=new Handler();
        if (atracciones==null){
            
            handler.showMessage("El nombre de la atraccion esta disponible!", "Informacion", handler.INFORMATION);
        }else if(atracciones!=null){
            
            for (Atraccion atraccion : atracciones) {
                if(atraccion.getNAtraccion().equals(NAtraccion)){
                    handler.showMessage("El nombre no se encuentra disponible", "Error", handler.ERROR);
                    return;
                }
        }
        }
    }
    
    //metodo que verifica si existe el empleado
    public static void verificarEmpleado(String Emp){
//        Se busca el empleado por la cedula
        Handler handler=new Handler();
        for (Empleado employees : Empleado.getEmployee("empleados.txt")) {  
            if(employees.getIdentification().equals(Emp)){
                handler.showMessage("El empleado esta disponible", "Informacion", handler.INFORMATION);
                return;
            }
          
        }
        handler.showMessage("El empleado no existe", "Error", handler.ERROR);
                return;
    }
    public static void crearAtraccion(String NAtraccion, String Cat ,String Emp ){
       
        Atraccion a=new Atraccion(NAtraccion, Cat, Emp, true);
        atracciones.add(a);
        
    }
    
    // Metodo para editar estado de la atraccion
    public static void cambiarStateAtracc(String NAtraccion) {
        
        
        Handler handler = new Handler();
        for (Atraccion atraccion : atracciones) {
            if (atraccion.getNAtraccion()==NAtraccion) {
                atraccion.setState(!atraccion.isState());
                handler.showMessage("La atraccion " + (atraccion.isState() ? "activado" : "desactivado"), "Empleado: " + atraccion.getNAtraccion(), handler.INFORMATION);
                return;
            }
        }
        
        handler.showMessage("Atraccion no encontrada", "Error", handler.ERROR);
    }
    
    
    
    
    
    
    
    
    //metodo para editar atracciones
    public static LinkedList<Atraccion> editAtracc(String NAtraccion, Atraccion newNAtraccion) {
        Handler handler = new Handler();
        
        for (int i = 0; i < atracciones.size(); i++) {
            if (NAtraccion.equals(atracciones.get(i).getNAtraccion())) {
                atracciones.set(i, newNAtraccion);
                handler.showMessage("Nombre actualizado correctamente", "Informacion", handler.INFORMATION);
                return atracciones;
            }
        }
        handler.showMessage("Los datos no fueron actualizados, por favor vuelva a intentarlo", "Error", handler.INFORMATION);
        return atracciones;
    }
    
    
    
    
    
    
    
    

    public LinkedList<Atraccion> getAtracciones() {
        return atracciones;
    }

    public void setAtraccion(LinkedList<Atraccion> atracciones) {
        this.atracciones = atracciones;
    }

    public String getNAtraccion() {
        return NAtraccion;
    }

    public void setNAtraccion(String NAtraccion) {
        this.NAtraccion = NAtraccion;
    }

    public String getCat() {
        return Cat;
    }

    public void setCat(String Cat) {
        this.Cat = Cat;
    }

    public String getEmp() {
        return Emp;
    }

    public void setEmp(String Empleado) {
        this.Emp = Empleado;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}




