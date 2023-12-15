package lab8p2_mejorado;

public class MejorasVisuales {
    private String marca;
    private String calificacion;
    private double precio;

    public MejorasVisuales(String marca, String calificacion, double precio) {
        this.marca = marca;
        this.calificacion = calificacion;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
