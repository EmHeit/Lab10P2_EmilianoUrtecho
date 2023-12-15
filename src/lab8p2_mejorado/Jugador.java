
package lab8p2_mejorado;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private double DineroBanco;
    private int reputacionCarros;
    private Garage garage;

    public Jugador(double DineroBanco) {
        this.DineroBanco = DineroBanco;
        this.garage = new Garage();
    }

    public int getReputacionCarros() {
        return reputacionCarros;
    }

    public double getDineroBanco() {
        return DineroBanco;
    }

    public void comprarCarro(Carro carro) {
        if (DineroBanco >= carro.getPrecio()) {
            garage.AgregarCarro(carro);
            DineroBanco -= carro.getPrecio();
            JOptionPane.showMessageDialog(null, "Ha comprado el carro con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No puede comprar el carro");
        }
    }

    public void venderCarro(Carro carro) {
        garage.VenderCarro(carro);
        DineroBanco += carro.getPrecio();
        JOptionPane.showMessageDialog(null, "Su Dinero actual es de " + DineroBanco);
    }

    public void puntosReputacion(int reputacion) {
        reputacionCarros += reputacion;
        JOptionPane.showMessageDialog(null, "Usted tiene " + reputacionCarros + " puntos de reputación");
    }

    public void Banco(double sueldo) {
        DineroBanco += sueldo;
        JOptionPane.showMessageDialog(null, "Usted tiene " + DineroBanco + " dinero disponible");
    }

    public void setReputacionPuntos(int reputacionPuntos) {
        this.reputacionCarros = reputacionPuntos;
    }

    public void setDineroBanco(double dineroBanco) {
        this.DineroBanco = dineroBanco;
    }

    public List<Carro> getCarros() {
        return garage.ObtenerCarro();
    }
}

