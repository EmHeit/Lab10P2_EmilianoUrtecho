
package lab8p2_mejorado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carro implements Serializable {
    private String modelo;
    private String color;
    private double precio;
    private String marca;
    private List<MejorasVisuales> mejorasVisuales;
    private boolean reconstruido;
    private String paisProcedencia;
    private String anioFabricacion;
    private int horsepower;
    private int velocidadPunta;
    private int tiempo0a60;
    private int tiempo0a100;
    private Circuito circuito;
    

    public Carro(String modelo, String color, double precio, String marca,
                 List<MejorasVisuales> mejorasVisuales, boolean reconstruido,
                 String paisP, String anioFabricacion, int horsepower,
                 int velocidadPunta, int tiempo0a60, int tiempo0a100, Circuito circuito) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.marca = marca;
        this.mejorasVisuales = new ArrayList<>(mejorasVisuales);
        this.reconstruido = reconstruido;
        this.paisProcedencia = paisP;
        this.anioFabricacion = anioFabricacion;
        this.horsepower = horsepower;
        this.velocidadPunta = velocidadPunta;
        this.tiempo0a60 = tiempo0a60;
        this.tiempo0a100 = tiempo0a100;
        this.circuito = circuito;
    }

    Carro(int idCarro, String modeloCarro, int precioCarro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

