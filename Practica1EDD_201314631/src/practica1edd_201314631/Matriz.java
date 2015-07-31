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

public class Matriz {
    
        public NodoCabecera cabezasXI;
        public NodoCabecera cabezasYI;
        public int size;
        public int numCX;
        public int numCY;

        public Matriz()
        {
            this.cabezasXI = null;
            this.cabezasYI = null;
            this.size = 0;
            this.numCX = 0;
            this.numCY = 0;
        }

        public void Add(int x, int y, int dimension, Object d)
        {
            NodoMatriz nuevoNodo = new NodoMatriz(dimension, d, x, y);
            
            /*Si esta vacia la matriz*/
            if(vacia())
            {
                //Crear nuevas cabezas y ponerlas como iniciales
                this.cabezasXI = new NodoCabecera(x);
                this.cabezasYI = new NodoCabecera(y);

                cabezasXI.nodoMatriz = nuevoNodo;
                cabezasYI.nodoMatriz = nuevoNodo;

                nuevoNodo.cabezaX = cabezasXI;
                nuevoNodo.cabezaY = cabezasYI;

                numCX++;
                numCY++;
            }
            /*Si no esta vacia*/
            else {
                NodoCabecera cabezaX = getCabezaX(x);
                NodoCabecera cabezaY = getCabezaY(y);

                /*Si no hay nodos cabeza con los indices enviados*/
                if (cabezaX == null && cabezaY == null)
                {
                    //Crear nuevas cabezas
                    cabezaX = new NodoCabecera(x);
                    cabezaY = new NodoCabecera(y);

                    numCX++;
                    numCY++;

                    //Encontrar las cabezas X anterior y siguiente al indice 
                    NodoCabecera tempXA = getCabezaXAnterior(x);
                    NodoCabecera tempXS = getCabezaXSiguiente(x);
                    
                    //Realizar enlaces nuevos
                    if(tempXA != null)
                    {
                        tempXA.siguiente = cabezaX;
                        cabezaX.anterior = tempXA;
                    }

                    if(tempXS != null)
                    {
                        tempXS.anterior = cabezaX;
                        cabezaX.siguiente = tempXS;
                        if (tempXS == cabezasXI) { cabezasXI = cabezaX; }
                    }

                    //Encontrar las cabezas Y anterior y siguiente al indice
                    NodoCabecera tempYA = getCabezaYAnterior(y);
                    NodoCabecera tempYS = getCabezaYSiguiente(y);

                    //Realizar enlaces nuevos
                    if(tempYA != null)
                    {
                        tempYA.siguiente = cabezaY;
                        cabezaY.anterior = tempYA;
                    }

                    if(tempYS != null) 
                    {
                        tempYS.anterior = cabezaY;
                        cabezaY.siguiente = tempYS;
                        if (tempYS == cabezasYI) { cabezasYI = cabezaY; }
                    }

                    //Enlazar cabeza con el nodo de la matriz
                    cabezaX.nodoMatriz = nuevoNodo;
                    cabezaY.nodoMatriz = nuevoNodo;
                    nuevoNodo.cabezaX = cabezaX;
                    nuevoNodo.cabezaY = cabezaY;
                }
                /*Si no hay cabeza X*/
                else if(cabezaX == null && cabezaY != null)
                {
                    //Crear nueva cabeza X
                    cabezaX = new NodoCabecera(x);
                    numCX++;
                    
                    //Encontrar las cabezas X anterior y siguiente al indice 
                    NodoCabecera tempXA = getCabezaXAnterior(x);
                    NodoCabecera tempXS = getCabezaXSiguiente(x);

                    //Realizar enlaces nuevos con las cabeceras
                    if(tempXA != null)
                    {
                        tempXA.siguiente = cabezaX;
                        cabezaX.anterior = tempXA;
                    }

                    if(tempXS != null)
                    {
                        tempXS.anterior = cabezaX;
                        cabezaX.siguiente = tempXS;
                        if (tempXS == cabezasXI) { cabezasXI = cabezaX; }
                    }

                    //Enlazar cabeza X con el nodo de la matriz
                    cabezaX.nodoMatriz = nuevoNodo;
                    nuevoNodo.cabezaX = cabezaX;

                    //Integrar nuevo nodo a los nodos de Y
                    NodoMatriz anterior = getYAnterior(x,y);
                    NodoMatriz siguiente = getYSiguiente(x,y);

                    //Realizar enlaces nuevos con el nodo
                    if(anterior != null)
                    {
                        anterior.siguienteH = nuevoNodo;
                        nuevoNodo.anteriorH = anterior;
                    }

                    if (siguiente != null)
                    {
                        siguiente.anteriorH = nuevoNodo;
                        nuevoNodo.siguienteH = siguiente;
                        if (siguiente == cabezaY.nodoMatriz)
                        {
                            cabezaY.nodoMatriz = nuevoNodo;
                            nuevoNodo.cabezaY = cabezaY;
                            siguiente.cabezaY = null;
                        }
                    }  
                }
                
                /*Si no hay cabeza Y*/
                else if (cabezaX != null && cabezaY == null)
                {
                    //Crear nueva cabeza Y
                    cabezaY = new NodoCabecera(y);
                    numCY++;

                    //Encontrar las cabezas Y anterior y siguiente al indice 
                    NodoCabecera tempYA = getCabezaYAnterior(y);
                    NodoCabecera tempYS = getCabezaYSiguiente(y);

                    //Realizar enlaces nuevos con las cabeceras
                    if(tempYA != null)
                    {
                        tempYA.siguiente = cabezaY;
                        cabezaY.anterior = tempYA;
                    }
                   
                    if(tempYS != null)
                    {
                        tempYS.anterior = cabezaY;
                        cabezaY.siguiente = tempYS;
                        if (tempYS == cabezasYI) { cabezasYI = cabezaY; }
                    }

                    //Enlazar cabeza Y con el nodo de la matriz
                    cabezaY.nodoMatriz = nuevoNodo;
                    nuevoNodo.cabezaY = cabezaY;

                    //Integrar nuevo nodo a los nodos de X
                    NodoMatriz anterior = getXAnterior(x, y);
                    NodoMatriz siguiente = getXSiguiente(x, y);

                    //Realizar enlaces nuevos con el nodo
                    
                    if(anterior != null)
                    {
                        anterior.siguienteV = nuevoNodo;
                        nuevoNodo.anteriorV = anterior;
                    }
                    
                    if(siguiente != null)
                    {
                        siguiente.anteriorV = nuevoNodo;
                        nuevoNodo.siguienteV = siguiente;
                        if (siguiente == cabezaX.nodoMatriz)
                        {
                            cabezaX.nodoMatriz = nuevoNodo;
                            nuevoNodo.cabezaX = cabezaX;
                            siguiente.cabezaX = null;
                        }
                    }  
                }
                /*Si ya existen ambas cabezas*/
                else
                {
                    NodoMatriz elNodo;
                    if (numCX >= numCY)
                    {
                        elNodo = getY(x,y);
                    }
                    else
                    {
                        elNodo = getX(x,y);
                    }

                    /*Si existe ya un nodo en la posicion*/
                    if (elNodo != null)
                    {
                        if (elNodo.dimension == nuevoNodo.dimension)
                        {
                            elNodo.dato = nuevoNodo.dato;
                        }
                        else
                        {
                            NodoMatriz ultimo = getLast(elNodo);
                            ultimo.atras = nuevoNodo;
                            nuevoNodo.delante = ultimo;
                        }
                    }
                    /*Si no hay ningun nodo en la posicion*/
                    else
                    {
                        //Integrar nuevo nodo a los nodos de X
                        NodoMatriz antX = getXAnterior(x,y);
                        NodoMatriz sigX = getXSiguiente(x,y);

                        //Realizar enlaces nuevos con el nodo
                        if(antX != null)
                        {
                            antX.siguienteV = nuevoNodo;
                            nuevoNodo.anteriorV = antX;
                        }
                        
                        if(sigX != null)
                        {
                            sigX.anteriorV = nuevoNodo;
                            nuevoNodo.siguienteV = sigX;
                            if (sigX == cabezaX.nodoMatriz)
                            {
                                cabezaX.nodoMatriz = nuevoNodo;
                                nuevoNodo.cabezaX = cabezaX;
                                sigX.cabezaX = null;
                            }
                        }

                        //Integrar nuevo nodo a los nodos de Y
                        NodoMatriz antY = getYAnterior(x, y);
                        NodoMatriz sigY = getYSiguiente(x, y);

                        //Realizar enlaces nuevos con el nodo
                        if(antY != null)
                        {
                            antY.siguienteH = nuevoNodo;
                            nuevoNodo.anteriorH = antY;
                        }
                        
                        if(sigY != null)
                        {
                            sigY.anteriorH = nuevoNodo;
                            nuevoNodo.siguienteH = sigY;
                            if (sigY == cabezaY.nodoMatriz)
                            {
                                cabezaY.nodoMatriz = nuevoNodo;
                                nuevoNodo.cabezaY = cabezaY;
                                sigY.cabezaY = null;
                            }
                        }
                    }
                }
            }
            this.size++;
        }

        public void Edit(int x, int y, int dimension, Object d)
        {
            NodoMatriz elNodo;
            if (numCX >= numCY)
            {
                elNodo = getY(x, y);
            }
            else
            {
                elNodo = getX(x, y);
            }

            
            if (elNodo.dimension < dimension)
            {
                NodoMatriz aux = elNodo.atras;
                while (aux != null)
                {
                    if (aux.dimension == dimension)
                    {
                        aux.dato = d;
                        break;
                    }
                    else
                    {
                        aux = aux.atras;
                    }

                }
            }
            else if (elNodo.dimension > dimension)
            {
                NodoMatriz aux = elNodo.delante;
                while (aux != null)
                {
                    if (aux.dimension == dimension)
                    {
                        aux.dato = d;
                        break;
                    }
                    else
                    {
                        aux = aux.delante;
                    }

                }
            }
            else
            {
                elNodo.dato = d;
            }
        }

        public void Remove(int indice, String eje)
        {
            if (eje.equals("x"))
            {
                NodoCabecera cabeza = this.cabezasXI;

                while (cabeza != null)
                {
                    if (cabeza.indice == indice)
                    {
                        try
                        {
                            cabeza.anterior.siguiente = cabeza.siguiente;
                        }
                        catch (Exception ewa) { }

                        try
                        {
                            cabeza.siguiente.anterior = cabeza.anterior;
                        }
                        catch (Exception ewa) { }
                    }

                    cabeza = cabeza.siguiente;
                }
            }
            else if (eje.equals("y"))
            {
                NodoCabecera cabeza = this.cabezasYI;

                while (cabeza != null)
                {
                    if (cabeza.indice == indice)
                    {
                        try
                        {
                            cabeza.anterior.siguiente = cabeza.siguiente;
                        }
                        catch (Exception eww) { }

                        try
                        {
                            cabeza.siguiente.anterior = cabeza.anterior;
                        }
                        catch (Exception ewe) { }

                        NodoCabecera aux = cabeza;
                        cabeza = cabeza.siguiente;

                        aux = null;
                    }
                }

            }
        }

        public void Remove(int x, int y, int dimension)
        {
            NodoCabecera cabezaY = getCabezaY(y);
            NodoCabecera cabezaX = getCabezaX(x);
            NodoMatriz elNodo;
            if (numCX >= numCY)
            {
                elNodo = getY(x,y);
            }
            else
            {
                elNodo = getX(x,y);
            }

            if (elNodo.dimension == dimension)
            {
                NodoMatriz siguienteH = elNodo.siguienteH;
                NodoMatriz anteriorH = elNodo.anteriorH;
                NodoMatriz siguienteV = elNodo.siguienteV;
                NodoMatriz anteriorV = elNodo.anteriorV;
                NodoMatriz delanteD = elNodo.delante;
                NodoMatriz atrasD = elNodo.atras;

                if (siguienteH == null && siguienteV == null && anteriorH == null && anteriorV == null
                    && delanteD == null && atrasD == null)
                {
                    if (cabezasXI == cabezaX && cabezasYI == cabezaY)
                    {
                        cabezasXI = cabezaX.siguiente;
                        cabezasYI = cabezaY.siguiente;
                    }

                    cabezaX.nodoMatriz = null;
                    cabezaY.nodoMatriz = null;
                    cabezaX = null;
                    cabezaY = null;
                    elNodo = null;
                }
                else
                {
                    if (delanteD != null)
                    {
                        elNodo.dimension = delanteD.dimension;
                        elNodo.dato = delanteD.dato;
                        elNodo.delante = delanteD.delante;

                        try 
                        {
                            NodoMatriz delanteDD = delanteD.delante;
                            delanteDD.atras = elNodo;
                            elNodo.delante = delanteDD;
                        }
                        catch (Exception ewsa){}

                        delanteD = null;
                    }
                    else if (atrasD != null)
                    {
                        elNodo.dimension = atrasD.dimension;
                        elNodo.dato = atrasD.dato;
                        elNodo.atras = atrasD.atras;

                        try
                        {
                            NodoMatriz atrasDD = atrasD.atras;
                            atrasDD.delante = elNodo;
                            elNodo.atras = atrasDD;
                        }
                        catch (Exception ewsa) { }


                        atrasD = null;
                    }
                    else
                    {
                        try
                        {
                            anteriorH.siguienteH = siguienteH;
                        }
                        catch (Exception ew) { }

                        try
                        {
                            if (elNodo.cabezaY != null)
                            {
                                cabezaY.nodoMatriz = siguienteH;
                                siguienteH.cabezaY = cabezaY;
                            }

                            siguienteH.anteriorH = anteriorH;

                            if (cabezaY.nodoMatriz == null)
                            {
                                try
                                {
                                    cabezaY.anterior.siguiente = cabezaY.siguiente;
                                }
                                catch (Exception ews) { }

                                try
                                {
                                    cabezaY.siguiente.anterior = cabezaY.anterior;
                                }
                                catch (Exception ews) { }

                                if (cabezaY == cabezasYI)
                                {
                                    cabezasYI = cabezaY.siguiente;
                                }
                            }
                        }
                        catch (Exception ew) { }

                        try
                        {
                            anteriorV.siguienteV = siguienteV;
                        }
                        catch (Exception ew) { }

                        try
                        {
                            if (elNodo.cabezaX != null)
                            {
                                cabezaX.nodoMatriz = siguienteV;
                                siguienteV.cabezaX = cabezaX;
                            }

                            siguienteV.anteriorV = anteriorV;

                            if (cabezaX.nodoMatriz == null)
                            {
                                try
                                {
                                    cabezaX.anterior.siguiente = cabezaX.siguiente;
                                }
                                catch (Exception ews) { }

                                try
                                {
                                    cabezaX.siguiente.anterior = cabezaX.anterior;
                                }
                                catch (Exception ews) { }

                                if (cabezaX == cabezasXI)
                                {
                                    cabezasXI = cabezaX.siguiente;
                                }
                            }
                        }
                        catch (Exception ew) { }

                        elNodo = null;
                    }
                }
            }
            else
            {
                NodoMatriz delanteD = elNodo.delante;
                NodoMatriz atrasD = elNodo.atras;

                if (delanteD != null)
                {
                    elNodo.dimension = delanteD.dimension;
                    elNodo.dato = delanteD.dato;
                    elNodo.delante = delanteD.delante;

                    try
                    {
                        NodoMatriz delanteDD = delanteD.delante;
                        delanteDD.atras = elNodo;
                        elNodo.delante = delanteDD;
                    }
                    catch (Exception ewsa) { }

                    delanteD = null;
                }
                else if (atrasD != null)
                {
                    elNodo.dimension = atrasD.dimension;
                    elNodo.dato = atrasD.dato;
                    elNodo.atras = atrasD.atras;

                    try
                    {
                        NodoMatriz atrasDD = atrasD.atras;
                        atrasDD.delante = elNodo;
                        elNodo.atras = atrasDD;
                    }
                    catch (Exception ewsa) { }


                    atrasD = null;
                }
                
            }

            this.size--;
        }

        public NodoMatriz Get(int x, int y, int dimension)
        {
            NodoCabecera cabezaY = getCabezaY(y);
            NodoCabecera cabezaX = getCabezaX(x);
            NodoMatriz elNodo;
            if (numCX >= numCY)
            {
                elNodo = getY(x,y);
            }
            else
            {
                elNodo = getX(x,y);
            }

            if (elNodo != null)
            {
                if (elNodo.dimension == dimension)
                {
                    return elNodo;
                }
                else
                {
                    return getPorAtras(elNodo, dimension);
                }
            }
            else
            {
                return null;
            }
        }

        public void Clear()
        {
            NodoCabecera cabeza = this.cabezasXI;

            while (cabeza != null)
            {
                NodoMatriz temp = cabeza.nodoMatriz;

                while (temp != null)
                {
                    NodoMatriz aux = temp.siguienteV;

                    if (temp.atras != null)
                    {
                        NodoMatriz help = getLast(temp);

                        while (help != temp && help != null)
                        {
                            NodoMatriz tmp = help.delante;
                            Remove(help.x, help.y, help.dimension);

                            help = tmp;
                        }
                    }
                    Remove(temp.x, temp.y, temp.dimension);
                    temp = aux;
                }
                cabeza = cabeza.siguiente;
            }

            this.cabezasXI = null;
            this.cabezasYI = null;
        }

        public boolean vacia()
        {
            if (cabezasXI == null && cabezasYI == null)
                return true;
            else
                return false;
        }

        public String CodGraphviz(int dim)
        {
            int xMax = maxIndiceX();
            int yMax = maxIndiceY();
            String cod1 = "";

            String inc = "{y "+ "\\" + "\\" +"  x|";

            int i = 0;


            while (i <= yMax)
            {
                if (i != yMax)
                {
                    inc = inc + i + "|";
                }
                else
                {
                    inc = inc + i + "}";
                }

                i++;
            }

            cod1 = cod1 + inc;

            int j = 0;

            while( j <= xMax)
            {
            
              NodoCabecera cbzX = getCabezaX(j);
              if(cbzX != null){
                    String piv1 = "{" + IntToLetters(j) + "|";

                    int h = 0;
                    while(h <=yMax)
                    {
                        NodoMatriz nodo = Get(cbzX.indice,h,dim);
                        
                        if (h != yMax)
                        {
                            if (nodo != null)
                            {
                                piv1 = piv1 + dim + "|";
                            }
                            else
                            {
                                piv1 = piv1 + 0 + "|";
                            }
                            
                        }
                        else
                        {
                            if (nodo != null)
                            {
                                piv1 = piv1 + dim + "}";
                            }
                            else
                            {
                                piv1 = piv1 + 0 + "}";
                            }
                        }

                        h++;

                    }

                    cod1 = cod1 + "|" + piv1;

                }
                else 
                {
                    String piv2 = "{" + IntToLetters(j);

                    int k = 0;
                    while( k <= yMax)
                    {
                        piv2 = piv2 + "|0";
                        k++;
                    }
                    piv2 = piv2 + "}";

                    cod1 = cod1 + "|" + piv2;
                }

              j++;
            }

            return cod1;
        }

        private int maxIndiceX()
        {
            NodoCabecera tempX = this.cabezasXI;
            while (tempX != null)
            {
                if (tempX.siguiente == null)
                    break;
                else
                    tempX = tempX.siguiente;
            }

            return tempX.indice;
        }

        private int maxIndiceY()
        {
            NodoCabecera tempY = this.cabezasYI;
            while (tempY != null)
            {
                if (tempY.siguiente == null)
                    break;
                else
                    tempY = tempY.siguiente;
            }

            return tempY.indice;
        }

        private String IntToLetters(int value)
        {
            String result = "";
            while (--value >= 0)
            {
                result = (char)('A' + value % 26) + result;
                value /= 26;
            }
            return result;
        }

        private NodoCabecera getCabezaX(int x)
        {
            NodoCabecera tempX = this.cabezasXI;
            while (tempX != null)
            {
                if (tempX.indice == x)
                    break;
                else
                    tempX = tempX.siguiente;
            }

            return tempX;
        }
        private NodoCabecera getCabezaXAnterior(int x)
        {
            NodoCabecera tempX = this.cabezasXI;
            while (tempX != null)
            {
                if (tempX.indice < x)
                {
                    if (tempX.siguiente == null)
                    {
                        break;
                    }
                    else
                    {
                        tempX = tempX.siguiente;
                    }
                }
                else if(tempX.indice > x)
                {
                    tempX = tempX.anterior;
                    break;
                }
            }

            return tempX;
        }
        private NodoCabecera getCabezaXSiguiente(int x)
        {
            NodoCabecera tempX = this.cabezasXI;
            while (tempX != null)
            {
                if (tempX.indice > x)
                    break;
                else
                    tempX = tempX.siguiente;
            }

            return tempX;
        }

        private NodoCabecera getCabezaY(int y)
        {
            NodoCabecera tempY = this.cabezasYI;
            while (tempY != null)
            {
                if (tempY.indice == y)
                    break;
                else
                    tempY = tempY.siguiente;
            }
            return tempY;
        }
        private NodoCabecera getCabezaYAnterior(int y)
        {
            NodoCabecera tempY = this.cabezasYI;
            while (tempY != null)
            {
                if (tempY.indice < y)
                {
                    if (tempY.siguiente == null)
                    {
                        break;
                    }
                    else
                    {
                        tempY = tempY.siguiente;
                    }
                }
                else if(tempY.indice > y)
                {
                    tempY = tempY.anterior;
                    break;
                }
            }
            return tempY;
        }
        private NodoCabecera getCabezaYSiguiente(int y)
        {
            NodoCabecera tempY = this.cabezasYI;
            while (tempY != null)
            {
                if (tempY.indice > y)
                    break;
                else
                    tempY = tempY.siguiente;
            }
            return tempY;
        }

        private NodoMatriz getX(int x, int y)
        {
            NodoCabecera cabezaX = getCabezaX(x);
            if (cabezaX != null)
            {
                NodoMatriz tempX = cabezaX.nodoMatriz;
                while (tempX != null)
                {
                    if (tempX.y == y)
                        break;
                    else
                        tempX = tempX.siguienteV;
                }
                return tempX;
            }
            else
            {
                return null;
            }
        }
        private NodoMatriz getXAnterior(int x, int y)
        {
            NodoCabecera cabeza = getCabezaX(x);

            if (cabeza != null)
            {
                NodoMatriz tempX = cabeza.nodoMatriz;
                while (tempX != null)
                {
                    if (tempX.y < y)
                    {
                        if (tempX.siguienteV == null)
                        {
                            break;
                        }
                        else
                        {
                            tempX = tempX.siguienteV;
                        }
                    }
                    else if (tempX.y > y)
                    {
                        tempX = tempX.anteriorV;
                        break;
                    }
                }

                return tempX;
            }
            else
            {
                return null;
            }
        }
        private NodoMatriz getXSiguiente(int x, int y)
        {
            NodoCabecera cabeza = getCabezaX(x);

            if (cabeza != null)
            {
                NodoMatriz tempX = cabeza.nodoMatriz;
                while (tempX != null)
                {
                    if (tempX.y > y)
                        break;
                    else
                        tempX = tempX.siguienteV;
                }

                return tempX;
            }
            else
            {
                return null;
            }
        }

        private NodoMatriz getY(int x, int y)
        {
            NodoCabecera cabezaY = getCabezaY(y);

            if (cabezaY != null)
            {
                NodoMatriz tempY = cabezaY.nodoMatriz;
                while (tempY != null)
                {
                    if (tempY.x == x)
                        break;
                    else
                        tempY = tempY.siguienteH;
                }
                return tempY;
            }
            else
            {
                return null;
            }
        }
        private NodoMatriz getYAnterior(int x, int y)
        {
            NodoCabecera cabeza = getCabezaY(y);
            if (cabeza != null)
            {
                NodoMatriz tempY = cabeza.nodoMatriz;
                while (tempY != null)
                {
                    if (tempY.x < x)
                    {
                        if (tempY.siguienteH == null)
                        {
                            break;
                        }
                        else
                        {
                            tempY = tempY.siguienteH;
                        }
                    }
                    else if (tempY.x > x)
                    {
                        tempY = tempY.anteriorH;
                        break;
                    }
                }

                return tempY;
            }
            else
            {
                return null;
            }
        }
        private NodoMatriz getYSiguiente(int x, int y)
        {
            NodoCabecera cabeza = getCabezaY(y);

            if (cabeza != null)
            {
                NodoMatriz tempY = getCabezaY(y).nodoMatriz;
                while (tempY != null)
                {
                    if (tempY.x > x)
                        break;
                    else
                        tempY = tempY.siguienteH;
                }
                return tempY;
            }
            else
            {
                return null;
            }
        }   

        private NodoMatriz getLast(NodoMatriz elNodo)
        {
            NodoMatriz aux = elNodo;
            while (aux != null)
            {
                if (aux.atras == null)
                {
                    return aux;
                }
                aux = aux.atras;                
            }
            return aux;
        }
        public NodoMatriz getPorAtras(NodoMatriz elNodo, int dim)
        {
            NodoMatriz aux = elNodo;
            while (aux != null)
            {
                if (aux.dimension == dim)
                {
                    break;
                }
                else
                {
                    aux = aux.atras;
                }
            }
            return aux;
        }
    }



    
    class NodoCabecera
    {
        public NodoCabecera siguiente;
        public NodoCabecera anterior;
        public NodoMatriz nodoMatriz;
        public int indice;

        public NodoCabecera(int i)
        {
            this.indice = i;
            this.anterior = null;
            this.siguiente = null;
            this.nodoMatriz = null;
        }
    }

     class NodoMatriz
    {
        public NodoMatriz anteriorH;
        public NodoMatriz siguienteH;
        public NodoMatriz siguienteV;
        public NodoMatriz anteriorV;

        public NodoMatriz delante;
        public NodoMatriz atras;
        public int dimension; /* 1:satelite 2:avion 3:barco 4:submarino */

        public NodoCabecera cabezaX;
        public int x;
        public NodoCabecera cabezaY;
        public int y;
        public Object dato;

        public NodoMatriz(int dim, Object d, int f, int c)
        {
            this.dato = d;
            this.siguienteH = null;
            this.anteriorH = null;
            this.siguienteV = null;
            this.anteriorV = null;
            this.delante = null;
            this.atras = null;

            this.cabezaX = null;
            this.cabezaY = null;
            this.x = f;
            this.y = c;
            this.dimension = dim;
        }
    }
