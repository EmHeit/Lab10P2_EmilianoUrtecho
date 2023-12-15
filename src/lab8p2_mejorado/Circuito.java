package lab8p2_mejorado;

import java.io.Serializable;

public class Circuito implements Serializable {
    private double longitud;
    private int cantidadCurvas;
    private String locacion;

    public Circuito(double longitud, int cantidadCurvas, String locacion) {
        this.longitud = longitud;
        this.cantidadCurvas = cantidadCurvas;
        this.locacion = locacion;
    }

    // Getters y Setters

    public double getLongitud() {
        return longitud;
    }

    public int getCantidadCurvas() {
        return cantidadCurvas;
    }

    public String getLocacion() {
        return locacion;
    }
}
