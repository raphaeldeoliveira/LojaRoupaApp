package angelmodas;

import angelmodas.Controller.Controller;

public class AngelModas {
    public static Controller controller;

    public static void main(String[] args) {
        controller = new Controller();
        controller.start();
    }
}
