/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1edd_201314631;

import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ListaDE {
   
    NodoDE inicio;
    int tamano;
    NodoDE fin;
   NodoDE Aux;
   
     
    
    public boolean agregar(String nombre, int tipo, int cantidad){
    
    if(inicio==null){
    inicio=new NodoDE(null,nombre,tipo,cantidad,null);
    fin=inicio;
    tamano++;
    return true;
    }
    else{
    NodoDE temp=inicio;
    while (temp.tienesiguiente()){
    temp=temp.getSiguiente();
    fin=temp;
    }
    temp.setSiguiente(new NodoDE(temp,nombre,tipo,cantidad,null));
    tamano++;
    return true;
    
    }
    }
    
    public int getTamano(){

        return tamano;

    }
        public void imprimir() {
     
         if(tamano != 0) {
            NodoDE temp = inicio;
            String str = "";
            for(int i = 0; i < this.tamano; i++) {
                str = str + temp.nombre + "\n";
                temp = temp.siguiente;
            }
            JOptionPane.showMessageDialog(null, str);
        }
     }
        public void llenarCombo(){
            NodoDE tempo = inicio;
            String Nom = "";
           for(int i=0; i< this.tamano; i++){
            Nom = tempo.nombre;
            tempo=tempo.siguiente;
        
        }}
        
         /*public void modificaLista(String DatoB,String DatoI){
            
             if(inicio==null){
            System.out.println ("lista vacia");
        }
        else{
            if(buscar(DatoB)==true){
                Aux.nombre=DatoI;
                System.out.println("Se ha modificado el nombre");
                }
            }
        }*/
         public boolean  buscar(String DatoB, String DatoI){
        NodoDE Aux = inicio;
        boolean bandera = false;
        while (Aux != null && bandera != true) {
            if(DatoB.equals(Aux.getNombre())){// si encuentra el dato //la funcion .equals sirve para comparar el contenido de una direccion de memoria
                bandera = true;
                JOptionPane.showMessageDialog(null, "Se ha encontrado el nombre y se ha modificado");
                Aux.nombre=DatoI;
                
                
                
                
            }
            else{//apunta al siguiente nodo
                Aux.anterior = Aux;
                Aux = Aux.siguiente;
                
            }
        }
        if(bandera == true){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "ese dato no existe");
            
            return false;
        }
    }
        
    public void eliminar(String nombre)
    {
        NodoDE aux= inicio;
        NodoDE aux2= inicio;
        
        while(aux != null)
        {
            
            if(aux.siguiente.nombre == nombre)
            {
               if(aux.siguiente==fin)
               {
                   aux.siguiente.anterior=null;
                   aux.siguiente=null;
                   
               }
               else
               {
                   aux2=aux.siguiente.siguiente;
                   aux2.anterior=aux;
                   aux.siguiente.anterior=null;
                   aux.siguiente.siguiente=null;
                   aux.siguiente=aux2;
                    JOptionPane.showMessageDialog(null, "Se ha Eliminado");
               }
                aux=null;
            }
            else
            {
                aux=aux.siguiente;
            }
                 
        
        }
    }
    
}
