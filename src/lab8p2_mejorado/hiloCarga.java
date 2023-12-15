package lab8p2_mejorado;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

    public class hiloCarga extends Thread {

        JProgressBar pb_carga;

        public hiloCarga(JProgressBar pb_carga) {
            this.pb_carga = pb_carga;
        }
        
        @Override
        public void run() {
            int min = 0;
            int max = 10;

            pb_carga.setMinimum(min);
            pb_carga.setMaximum(max - 1);
            pb_carga.setValue(0);
            
            

            for (int i = min; i < max; i++) {
                pb_carga.setValue(i);
                pb_carga.setBackground(Color.red);

                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (pb_carga.getValue() == max - 1) {
                JOptionPane.showMessageDialog(null, "Accion Completada");
                
            }
            if (pb_carga.getValue() == max-1) {
            pb_carga.setValue(0);
        }
            
            
        }
    }