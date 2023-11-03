/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author David
 */
public class Programador extends Empleado implements IFecha {
    
    int sueldoExtra;
    int numeroProgramas; //Num programas realizados

    public Programador(int numero, String nombre, double sueldo, double sueldoMaximo, Fecha fechaAlta,
                      int sueldoExtraMensual, int numeroProgramas) throws Excepciones {
        super(numero, nombre, sueldo, sueldoMaximo, fechaAlta);
        this.sueldoExtra = sueldoExtraMensual;
        this.numeroProgramas = numeroProgramas;
    }

    public double getSueldoExtra() {
        return sueldoExtra;
    }

    public void setSueldoExtra(int sueldoExtra) {
        this.sueldoExtra = sueldoExtra;
    }

    public int getNumeroProgramas() {
        return numeroProgramas;
    }

    public void setNumeroProgramas(int numeroProgramas) {
        this.numeroProgramas = numeroProgramas;
    }

    public int dia()
    {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(DIA_DEL_MES);
    }
    public int mes()
    {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(MES_DEL_ANIO)+1;
    }
    public int anio()
    {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(ANIO);
    }
    
    public boolean cumpleMes()
    {
        if(dia() == this.getFechaAlta().getDia())
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    
}
