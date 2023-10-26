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
public class MendezDavidP04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
        
        
       lista.ordenar();
      
       lista.showMyList();
        
        System.out.println("-----------------------------------------------------------------------------");
       
      /* try
        {
            lista.add(new Analista(1, "David", 1200, 1300, new Fecha(03,11, 2015), 2, "pablete"), 1);
        }catch(Excepciones e){
            System.out.println(e.getMessage());
        }
        
        lista.ordenar();
        
        lista.showMyList(); */
      
    }
    
}
