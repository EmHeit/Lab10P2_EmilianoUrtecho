package lab8p2_mejorado;

import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class hiloCarrera extends Thread{
       Random random = new Random();
        int rand = random.nextInt(600) + 400;

        JProgressBar carrera;
        JDialog resultado;

        public hiloCarrera(JProgressBar carrera, JDialog resultado) {
            this.carrera= carrera;
            this.resultado = resultado;
        }

       @Override
        public void run() {
            int min = 0;
            int max = 10;

            carrera.setMaximum(min);
            carrera.setMaximum(max - 1);
            carrera.setValue(0);

            for (int i = min; i < max; i++) {
                carrera.setValue(i);

                try {
                    sleep(rand);
                } catch (InterruptedException ex) {
                    JOptionPane.showInputDialog("Error");
                }
            }
            System.out.println(carrera.getValue());
            if (carrera.getValue() == max - 1) {

            }
        }
}
