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
    public int direccion;
    public NodoDE siguiente;
    public String nombre;
    
    
        public NodoDE(){}
        
    public NodoDE(NodoDE anterior, int direccion, NodoDE siguiente){
    
    this.anterior = anterior;
    this.direccion = direccion;
    this.siguiente = siguiente;
    
    }
    
    public NodoDE getAnterior(){

    return anterior;
    }
    
    public void setAnterior(NodoDE anterior){
    this.anterior = anterior;
    }
    public int getDireccion(){
    return direccion;
    }
    public void setDireccion (int direccion){
        this.direccion = direccion;
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

