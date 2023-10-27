/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mendezdavidp04;

import java.io.*;
import java.util.List;

/**
 *
 * @author David
 */
public class Fichero {
     public static void guardarEmpleados(MyList empleados, String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(empleados);
            System.out.println("Empleados guardados en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public static MyList cargarEmpleados(String nombreArchivo) {
        MyList empleados = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            empleados = (MyList) ois.readObject();
            System.out.println("Empleados cargados desde el archivo: " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
