/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class MyList <E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private Node<E> actualNode;
    private int contador = -1;
    
    
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
        
        contador++;
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
        contador--;
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
    
    public void crearFichero() 
     {

         Node<E> aux = this.firstNode;
         
        try {
            // A partir del objeto File creamos el fichero físicamente
           
                System.out.println("El fichero se ha creado correctamente");
                FileOutputStream fos = new FileOutputStream("C:\\Users\\David\\Desktop\\2DAM\\PSP\\Java\\MendezDavidP04\\fichero.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                while(aux != null)
                {
                    E objeto = (E) aux.getMain();
                    oos.writeObject(objeto);
                    aux = aux.getNextNode();
                }
            
           fos.close();
           oos.close();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
     }
    
    public ArrayList deserializar() throws FileNotFoundException, IOException, ClassNotFoundException
    {  
        ArrayList<E> lista = new ArrayList();
        E emp = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("fichero.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            try{
               while(true){
                emp = (E) in.readObject();
                lista.add(emp);
                
                } 
            }catch(EOFException ex){}
            in.close();
            fileIn.close();         
        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Clase Empleado no encontrada");
            c.printStackTrace();
        }
        return lista;   
}
    public boolean existeFichero()
    {
        File buscar = new File("fichero.dat");
        if(buscar.exists())
        {
            return true;
        }
        else
        {
            return false;
        }
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
        
//        if(existe(numEmp1) && existe(numEmp2))
//        {
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
//        }
//        else
//        {
//            System.out.println("No existe alguno de los empleados.");
//        }
               
    }

//    public void ordenar() {
//    if (firstNode == null || firstNode.getNextNode() == null) {
//        return;  // La lista está vacía o tiene solo un elemento, ya está ordenada
//    }
//
//    boolean intercambiado;
//    do {
//        Node<E> current = firstNode;
//        intercambiado = false;
//        
//        while (current.getNextNode() != null) {
//            if (current.getIndex() > current.getNextNode().getIndex()) {
//                intercambiar(current.getIndex(), current.getNextNode().getIndex());
//                intercambiado = true;
//                System.out.println("Intercambio " +current.getMain());
//            }
//            current = current.getNextNode();
//        }
//    } while (intercambiado);
//}

    public void intercambiarMain(Node n1, Node n2){
        Node<E> node1 = n1;
        Node<E> node2 = n2;

        int indexAux = node1.getIndex();
        node1.setIndex(node2.getIndex());
        node2.setIndex(indexAux);

        E tempMain= node1.getMain();
        node1.setMain(node2.getMain());
        node2.setMain(tempMain);
    }
    
    public void ordenar(){
        boolean ordenado = false;
        int tamanio = this.contador;
        int cont = 0;
        do{
            ordenado = false;
            Node<E> node1 = this.firstNode;
            Node<E> node2  = node1.getNextNode();
            for(int i=0;i<tamanio;i++){
                if(node1.getIndex()>node2.getIndex()){
                    intercambiarMain(node1,node2);
                    ordenado = true;
                }
                node1 = node1.getNextNode();
                node2 = node2.getNextNode();
            }
            System.out.println("Numero de ordenados: "+cont);
            cont++;
        }while(ordenado);
    }

    


    
//    public boolean ordenar(){
//        
//        
//        
//        boolean controlador = false;
//        int nuevoContador = 0;
//        
//        Node aux;
//        if(this != null){
//           for(int i = 0; i < contador+1; i++){
//            Node temp = this.firstNode;
//            for(int j = 0; j < contador - nuevoContador; j++){
//                //si el siguiente no es nulo porque me daba un error ya que llegaba hasta el siguiente del ultimo
//                if(temp.getNextNode()!= null){
//                  if(temp.getIndex() > temp.getNextNode().getIndex()){
//                    aux = new Node(temp.getMain(), temp.getIndex());
//            
//                    temp.setIndex(temp.getNextNode().getIndex());
//                    temp.setMain(temp.getNextNode().getMain());
//            
//                    temp.getNextNode().setIndex(aux.getIndex());
//                    temp.getNextNode().setMain(aux.getMain());
//                      
//                      System.out.println("Intercambiado "+nuevoContador);
//                    }else{
//                        controlador = true;
//                    }
//                    temp = temp.getNextNode();
//                    
//                    }
//                nuevoContador++;
//                }
//            }
//            return true;    
//        }
//        return false; 
//    }
    
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
