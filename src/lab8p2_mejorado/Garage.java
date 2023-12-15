package lab8p2_mejorado;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Garage {
    private List<Carro> carrosLista;

    public Garage() {
        this.carrosLista = new ArrayList();
    }

    public Garage(List<Carro> carrosLista) {
        this.carrosLista = carrosLista;
    }
    
    public void AgregarCarro(Carro carro){
        carrosLista.add(carro);
    }
    
    public List<Carro> ObtenerCarro(){
        return carrosLista;
    }
    public void VenderCarro(Carro carro){
        if (carrosLista.contains(carro)) {
            carrosLista.remove(carro);
            JOptionPane.showMessageDialog(null, "Ha vendido el carro con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No puede vender este carro");            
        }
    }
}
