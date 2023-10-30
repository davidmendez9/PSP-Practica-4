package Modelo;
import java.util.*;
//////////////////////////////////////////////////////////////////
// Interfaz IFecha: m�todos y constantes para obtener
//                  el d�a, mes y a�o
//

public interface IFecha
{
  public final static int DIA_DEL_MES = Calendar.DAY_OF_MONTH;
  public final static int MES_DEL_ANIO = Calendar.MONTH;
  public final static int ANIO = Calendar.YEAR;
  
  public abstract int dia();
  public abstract int mes();
  public abstract int anio();
}
//////////////////////////////////////////////////////////////////

/*
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
*/