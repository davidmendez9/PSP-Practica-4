/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */
public class Excepciones extends Exception {
    public Excepciones(){}
    public Excepciones(String mensaje)
    {
        super(mensaje);
    }
}
