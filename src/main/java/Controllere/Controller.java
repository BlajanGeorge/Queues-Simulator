package Controllere;

import Model.Model;
import SimulationManager.SimulationManager;
import View.View;

import javax.swing.*;
import java.io.IOException;

public class Controller {

    public Controller(View view, Model model) {

        view.getStartSimulare().addActionListener(e -> {
            int valid = 0;
            valid += model.checkNumbers(view.getNumarClienti()) + model.checkNumbers(view.getNumarCozi()) + model.checkNumbers(view.getTimpDeSimulare())
                    + model.checkNumbers(view.getTimpServireMinim()) + model.checkNumbers(view.getTimpServireMaxim()) + model.checkNumbers(view.getTimpSosireMinim())
                    + model.checkNumbers(view.getTimpSosireMaxim());
            if (valid != 0) {
                JOptionPane.showMessageDialog(null,
                        "Date invalide!",
                        "Eroare!",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                SimulationManager gen = null;
                try {
                    gen = new SimulationManager(Integer.parseInt(view.getTimpDeSimulare()), Integer.parseInt(view.getTimpServireMaxim())
                            , Integer.parseInt(view.getTimpServireMinim()), Integer.parseInt(view.getTimpSosireMaxim()), Integer.parseInt(view.getTimpSosireMinim()),
                            Integer.parseInt(view.getNumarCozi()), Integer.parseInt(view.getNumarClienti()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                view.setVisible(false);
                Thread t = new Thread(gen);
                t.start();
            }


        });
    }

}
