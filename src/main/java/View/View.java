package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View extends JFrame {

    private final JTextField numarClienti;
    private final JTextField numarCozi;
    private final JTextField timpSimulare;
    private final JTextField timpSosireMinim;
    private final JTextField timpSosireMaxim;
    private final JTextField timpServireMinim;
    private final JTextField timpServireMaxim;
    private final JButton startSimulare;

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 420);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Simulator de cozi");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(62, 10, 182, 27);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Numar clienti:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(53, 74, 102, 25);
        contentPane.add(lblNewLabel_1);

        numarClienti = new JTextField();
        numarClienti.setBounds(173, 78, 71, 19);
        contentPane.add(numarClienti);
        numarClienti.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Numar cozi:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(53, 114, 102, 25);
        contentPane.add(lblNewLabel_1_1);

        numarCozi = new JTextField();
        numarCozi.setColumns(10);
        numarCozi.setBounds(173, 118, 71, 19);
        contentPane.add(numarCozi);

        JLabel lblNewLabel_1_1_1 = new JLabel("Timpul de simulare:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(20, 149, 117, 25);
        contentPane.add(lblNewLabel_1_1_1);

        timpSimulare = new JTextField();
        timpSimulare.setColumns(10);
        timpSimulare.setBounds(173, 153, 71, 19);
        contentPane.add(timpSimulare);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Timpul de sosire minim:");
        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(20, 185, 143, 25);
        contentPane.add(lblNewLabel_1_1_1_1);

        timpSosireMinim = new JTextField();
        timpSosireMinim.setColumns(10);
        timpSosireMinim.setBounds(173, 189, 71, 19);
        contentPane.add(timpSosireMinim);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Timpul de sosire maxim:");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1.setBounds(20, 221, 155, 25);
        contentPane.add(lblNewLabel_1_1_1_1_1);

        timpSosireMaxim = new JTextField();
        timpSosireMaxim.setColumns(10);
        timpSosireMaxim.setBounds(173, 225, 71, 19);
        contentPane.add(timpSosireMaxim);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Timpul de servire minim:");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1_1.setBounds(20, 256, 155, 25);
        contentPane.add(lblNewLabel_1_1_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Timpul de servire maxim:");
        lblNewLabel_1_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1_2.setBounds(20, 291, 155, 25);
        contentPane.add(lblNewLabel_1_1_1_1_1_2);

        timpServireMinim = new JTextField();
        timpServireMinim.setColumns(10);
        timpServireMinim.setBounds(173, 260, 71, 19);
        contentPane.add(timpServireMinim);

        timpServireMaxim = new JTextField();
        timpServireMaxim.setColumns(10);
        timpServireMaxim.setBounds(173, 295, 71, 19);
        contentPane.add(timpServireMaxim);

        startSimulare = new JButton("Start simulare");
        startSimulare.setBounds(86, 346, 114, 27);
        contentPane.add(startSimulare);
    }

    public JButton getStartSimulare() {
        return this.startSimulare;
    }

    public String getNumarClienti() {
        return this.numarClienti.getText();
    }

    public String getNumarCozi() {
        return this.numarCozi.getText();
    }

    public String getTimpDeSimulare() {
        return this.timpSimulare.getText();
    }

    public String getTimpSosireMinim() {
        return this.timpSosireMinim.getText();
    }

    public String getTimpSosireMaxim() {
        return this.timpSosireMaxim.getText();
    }

    public String getTimpServireMinim() {
        return this.timpServireMinim.getText();
    }

    public String getTimpServireMaxim() {
        return this.timpServireMaxim.getText();
    }


}
