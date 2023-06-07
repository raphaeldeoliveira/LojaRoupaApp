package lojaapp;

import lojaapp.Controller.Controller;

public class LojaApp {
    public static Controller controller;
    
    public static void main(String[] args) {
        
        Controller controller = new Controller();
        controller.start();
        
        // Janela j1 = new Janela();
        // j1.setVisible(true);
        
    }
    
}
