/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.MyList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public class MendezDavidP04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        MyList lista = new MyList();
        
        try
        {
            lista.add(new Analista(50, "David", 1200, 1300, new Fecha(03,11, 2015), 2, "pablete"), 50);
        }catch(Excepciones e){
            System.out.println(e.getMessage());
        }
        
        try
        {
            lista.add(new Analista(4, "David2", 1200, 1300, new Fecha(03,11, 2015), 2, "pablete"), 4);
        }catch(Excepciones e){
            System.out.println(e.getMessage());
        }
        
        try
        {
            lista.add(new Analista(2, "David", 1200, 1300, new Fecha(03,11, 2015), 2, "pablete"), 2);
        }catch(Excepciones e){
            System.out.println(e.getMessage());
        }
        
        try
        {
            lista.add(new Analista(7, "David", 1200, 1300, new Fecha(03,11, 2015), 2, "pablete"), 7);
        }catch(Excepciones e){
            System.out.println(e.getMessage());
        }
        
        try
        {
            lista.add(new Analista(3, "David", 1200, 1300, new Fecha(03,11, 2015), 2, "pablete"), 3);
        }catch(Excepciones e){
            System.out.println(e.getMessage());
        }
        
        
       lista.ordenar();
      
       lista.showMyList();
        
       System.out.println("----------------------FICHEROS-------------------------------------------------------");
       
       lista.crearFichero();
       
       ArrayList<Empleado> juan = new ArrayList();
       
       juan = lista.deserializar();
       
        System.out.println(juan);
        MyList listaputita = new MyList();
        for(int i = 0; i < juan.size(); i++){
            listaputita.add(juan.get(i), juan.get(i).getNumero());
        }
        System.out.println("--  COMPROBACION--");
        listaputita.showMyList();
      
    }
    
}
