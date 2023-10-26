/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mendezdavidp04;

import java.util.GregorianCalendar;

/**
 *
 * @author David
 */
public class Analista extends Empleado implements IFecha {
    
    double plusAnual;
    String nombreUsuario; //Nombre de usuario

    public Analista(int numero, String nombre, double sueldo, double sueldoMaximo, Fecha fechaAlta,
                    double plusAnual, String nombreUsuario) throws Excepciones 
    {
        super(numero, nombre, sueldo, sueldoMaximo, fechaAlta);
        this.plusAnual = plusAnual;
        this.nombreUsuario = nombreUsuario;
    }

    public double getPlusAnual() {
        return plusAnual;
    }

    public void setPlusAnual(double plusAnual) {
        this.plusAnual = plusAnual;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
    
    public boolean cumpleAnios()
    {
        if(dia() == this.getFechaAlta().getDia() && mes() == this.getFechaAlta().getMes())
        {
            return true;
        }
        else
        {
            return false;
        }
    }    

    @Override
    public String toString() {
        
        return super.toString() + "Analista{" + "plusAnual=" + plusAnual + ", nombreUsuario=" + nombreUsuario + '}';
    }
      
    
}
