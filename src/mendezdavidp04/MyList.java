/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mendezdavidp04;

/**
 *
 * @author David
 */
public class MyList <E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private Node<E> actualNode;
    
    
    public MyList(){
        this.firstNode = null;
        this.lastNode = null;
        this.actualNode = null;
        
    }
    
    public void showMyList(){
        Node<E> temporary = this.firstNode;
        while (temporary != null){
            System.out.println(temporary.getMain().toString());
            temporary=temporary.getNextNode();
        }
    }
    
    public void add(E p, int index){
        
        
        Node<E> newNode = new Node(p,index);
        
        //creas empleado 1 y lo añades
        
        if(firstNode == null){
            this.firstNode = newNode;
            this.lastNode = newNode;
    
        }else{
            
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
            lastNode = newNode;
        }
        this.actualNode = lastNode;
    }
    
    public boolean isFirst(){
        return (actualNode == firstNode);
    }
    
    public boolean isLast(){
        
        return (actualNode == lastNode);
    
    }
    
    public void avanzar()
    {
        actualNode = actualNode.previousNode;
    }
    
    public void retroceder()
    {
        actualNode = actualNode.nextNode;
    }
    
    public void modifyElement(){
        
    }
    
    public void removeElement(){
        
        if(actualNode == firstNode){
            firstNode = actualNode.nextNode;
        }else if(actualNode == lastNode){
            lastNode = actualNode.previousNode;
        }else{
            actualNode.previousNode.setNextNode(actualNode.nextNode);
            actualNode.nextNode.setPreviousNode(actualNode.previousNode);
        }
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<E> getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node<E> lastNode) {
        this.lastNode = lastNode;
    }

    public Node<E> getActualNode() {
        return actualNode;
    }

    public void setActualNode(Node<E> actualNode) {
        this.actualNode = actualNode;
    }

    
    public boolean existe(int numEmpl)
    { 
        Node<E> temporary = this.firstNode;
        while (temporary != null){
            if(temporary.getIndex() == numEmpl)
            {
                return true;
            }
            temporary=temporary.getNextNode();
        }
        return false;
    }
    
    public int contarNodos()
    {
        int contador = 0;
        Node<E> temporary = this.firstNode;
        
        while (temporary != null){
            contador++;
            temporary=temporary.getNextNode();
        }
        
        
        return contador;
    }
    
    public void intercambiar(int numEmp1, int numEmp2)
    {
        Node<E> temp = this.firstNode;
        Node<E> nodo1 = null;
        Node<E> nodo2 = null;
        Node<E> aux = null;
        
        if(existe(numEmp1) && existe(numEmp2))
        {
            while(temp != null)
            {
                if(temp.getIndex() == numEmp1)
                {
                    nodo1 = temp;
                }
                else if(temp.getIndex() == numEmp2)
                {
                    nodo2 = temp;
                }
                
                temp = temp.getNextNode();
            }
            
            int index = nodo1.getIndex();
            E e1 = nodo1.getMain();
            
            nodo1.setIndex(nodo2.getIndex());
            nodo1.setMain(nodo2.getMain());
            
            nodo2.setIndex(index);
            nodo2.setMain(e1);
        }
        else
        {
            System.out.println("No existe alguno de los empleados.");
        }
               
    }
    
    /*
    
     public void ordenar() {
        if (cabeza == null) {
            return; // La lista está vacía, no hay nada que ordenar
        }

        boolean intercambiado;
        Nodo nodoActual;
        Nodo nodoSiguiente = null;

        do {
            intercambiado = false;
            nodoActual = cabeza;

            while (nodoActual.siguiente != nodoSiguiente) {
                if (nodoActual.valor > nodoActual.siguiente.valor) {
                    // Intercambiar los valores de los nodos
                    int temp = nodoActual.valor;
                    nodoActual.valor = nodoActual.siguiente.valor;
                    nodoActual.siguiente.valor = temp;
                    intercambiado = true;
                }
                nodoActual = nodoActual.siguiente;
            }
            nodoSiguiente = nodoActual;
        } while (intercambiado);
    }
    */
    
    public void ordenar()
    {
        Node<E> temporary = firstNode;
        Node<E> temp2 = null;
        int numNodos = contarNodos();
        
        if(temporary == null)
        {return;}
        
        boolean intercambiado;
        
        do
        {
            intercambiado = false;
            temporary = firstNode;
            
            while(temporary.nextNode != temp2)
            {
                if(temporary.getIndex() > temporary.nextNode.getIndex())
                {
                    intercambiar(temporary.getIndex(), temporary.nextNode.getIndex());
                    intercambiado = true;
                }
                temporary = temporary.getNextNode();
            }
            temp2 = temporary;
            
        }while(intercambiado);
          
    }
    
    
// Inner class

    public class Node<E>{
        private Node<E> nextNode;
        private Node<E> previousNode;
        E main;
        int index = 1;
        
        public Node(E p, int index){
            this.nextNode = null;
            this.main = p;
            this.index = index;
        }
        
        public Node<E> getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public E getMain() {
            return main;
        }

        public void setMain(E p) {
            this.main = p;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node<E> getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node<E> previousNode) {
            this.previousNode = previousNode;
        }
        
        
        
        
    }
}
