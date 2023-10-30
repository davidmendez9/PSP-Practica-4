/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Excepciones;
import Modelo.Fecha;
import java.io.Serializable;

/**
 *
 * @author David
 */
public abstract class Empleado implements Serializable {
    private int numero;
    private transient String nombre; // Marcar como transient para evitar la serialización
    private double sueldo;
    private double sueldoMaximo;
    private Fecha fechaAlta;
    
    public Empleado(int numero, String nombre, double sueldo, double sueldoMaximo, Fecha fechaAlta) throws Excepciones{
        this.numero = numero;
        this.nombre = nombre;
        
        if(sueldo > sueldoMaximo)
        {
            throw new Excepciones("El sueldo debe ser inferior o igual al sueldo máximo");
        }
        else
        {
            this.sueldo = sueldo;
        }
        
        if(sueldoMaximo < sueldo)
        {
            throw new Excepciones("El sueldo máximo debe ser igual o superior al sueldo.");
        }
        else
        {
            this.sueldoMaximo = sueldoMaximo;
        }
        
        this.fechaAlta = fechaAlta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) throws Excepciones 
    {
        if(sueldo > sueldoMaximo)
        {
            throw new Excepciones("El sueldo debe ser inferior o igual al sueldo máximo");
        }
        else
        {
            this.sueldo = sueldo;
        }
    }

    public double getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(double sueldoMaximo)throws Excepciones 
    {
        if(sueldoMaximo < sueldo)
        {
            throw new Excepciones("El sueldo máximo debe ser igual o superior al sueldo.");
        }
        else
        {
            this.sueldoMaximo = sueldoMaximo;
        }
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Fecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + ", sueldo=" + sueldo + ", sueldoMaximo=" + sueldoMaximo + ", fechaAlta=" + fechaAlta + '}';
    }

    
    
    
}

