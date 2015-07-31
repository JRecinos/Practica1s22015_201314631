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
public class ListaDE {
   
    NodoDE inicio;
    int tamano;
    NodoDE fin;
   
    
    public boolean agregar(int direccion){
    if(inicio==null){
    inicio=new NodoDE(null,direccion,null);
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
    temp.setSiguiente(new NodoDE(temp,direccion,null));
    tamano++;
    return true;
    }
    }
    
    public void eliminar(String nombre)
    {
        NodoDE aux= inicio;
        NodoDE aux2= inicio;
        
        while(aux != null)
        {
            
            if(aux.siguiente.nombre.equals(nombre))
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
