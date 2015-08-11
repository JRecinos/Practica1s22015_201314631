/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1edd_201314631;

/**
 *
 * @author Dell
 */
public class NodoDE {
    public NodoDE anterior;
    public int tipo;
    public NodoDE siguiente;
    public String nombre;
    public int cantidad;
    
        public NodoDE(){}
        
    public NodoDE(NodoDE anterior,String nombre, int tipo, int cantidad, NodoDE siguiente){
    
    this.anterior = anterior;
    this.nombre = nombre;
    this.tipo = tipo;
    this.cantidad = cantidad;
    this.siguiente = siguiente;
    
    }
    
    public int getCantidad(){
    return cantidad;
    }
    public void setCantidad (int cantidad){
        this.cantidad = cantidad;
    }
    
    
    public String getNombre(){
    return nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    
    public NodoDE getAnterior(){

    return anterior;
    }
    
    public void setAnterior(NodoDE anterior){
    this.anterior = anterior;
    }
    public int getTipo(){
    return tipo;
    }
    public void setTipo (int tipo){
        this.tipo = tipo;
    }
    public NodoDE getSiguiente(){
    return siguiente;
    }
    public void setSiguiente(NodoDE siguiente){
    this.siguiente = siguiente;
    }
    public boolean tienesiguiente(){
    return siguiente!=null;
    }
    public boolean tieneanterior(){
    return anterior!=null;
    }
    
    
}

