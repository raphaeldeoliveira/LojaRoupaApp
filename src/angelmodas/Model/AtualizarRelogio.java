package angelmodas.Model;

import static angelmodas.AngelModas.controller;
import java.time.LocalTime;

public class AtualizarRelogio extends Thread {

    public void run() {
        while (true) {
            // Obter a hora atual
            LocalTime horaAtual = LocalTime.now();

            // Obter os componentes individuais da hora atual
            int hora = horaAtual.getHour();
            int minuto = horaAtual.getMinute();
            int segundo = horaAtual.getSecond();
            
            controller.atualizarRelogio(hora, minuto, segundo);
            
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
}
