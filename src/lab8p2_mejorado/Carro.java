
package lab8p2_mejorado;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    private String modelo;
    private String color;
    private double precio;
    private String marca;
    private List<MejorasVisuales> mejorasVisuales;
    private boolean reconstruido;
    private String paisProcedencia;
    private String anioFabricacion;

    public Carro(String modelo, String color, double precio, String marca, List<MejorasVisuales> mejorasVisuales,
                boolean reconstruido, String paisProcedencia, String anioFabricacion) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.marca = marca;
        this.mejorasVisuales = mejorasVisuales;
        this.reconstruido = reconstruido;
        this.paisProcedencia = paisProcedencia;
        this.anioFabricacion = anioFabricacion;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public List<MejorasVisuales> getMejorasVisuales() {
        return mejorasVisuales;
    }

    public void setMejorasVisuales(List<MejorasVisuales> mejorasVisuales) {
        this.mejorasVisuales = mejorasVisuales;
    }

    public boolean isReconstruido() {
        return reconstruido;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public String getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(String anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public List<Carro> getCarros(String nombreJugador) {
        return null;
    }
}

