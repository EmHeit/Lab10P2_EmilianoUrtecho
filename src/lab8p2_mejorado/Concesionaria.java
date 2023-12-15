package lab8p2_mejorado;

import java.util.ArrayList;
import java.util.List;

public class Concesionaria {
    private String nombre;
    private String locacion;
    private List<Carro> carrosVenta;

    public Concesionaria(String nombre, String locacion) {
        this.nombre = nombre;
        this.locacion = locacion;
        this.carrosVenta = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public List<Carro> getCarrosVenta() {
        return carrosVenta;
    }

    public void setCarrosVenta(List<Carro> carrosVenta) {
        this.carrosVenta = carrosVenta;
    }
    
    public List<Carro> CarrosDisponibles(){
        return carrosVenta;
    }
    public void VenderCarro(Carro carro){
        carrosVenta.remove(carro);
    }
}
