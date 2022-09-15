package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class SimulationFrame extends JFrame {

    private final JLabel lblNewLabel_1;
    private final JLabel lblNewLabel_4;
    private final JLabel time1;
    private final JLabel time2;
    private final JLabel time3;
    private final ArrayList<JLabel> queuesLabels = new ArrayList<>();


    public SimulationFrame(int numarCozi) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Simulare");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(179, 10, 80, 23);
        contentPane.add(lblNewLabel_2);

        time1 = new JLabel("");
        time1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        time1.setBounds(10, 570, 200, 20);
        contentPane.add(time1);

        time2 = new JLabel("");
        time2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        time2.setBounds(10, 600, 200, 20);
        contentPane.add(time2);

        time3 = new JLabel("");
        time3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        time3.setBounds(10, 630, 200, 20);
        contentPane.add(time3);

        JLabel lblNewLabel = new JLabel("Clienti in asteptare:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel.setBounds(10, 75, 122, 20);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(142, 75, 284, 20);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("Timp simulare:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(10, 45, 100, 20);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(123, 45, 45, 20);
        contentPane.add(lblNewLabel_4);
        int y = 105;
        for (int i = 0; i < numarCozi; i++) {
            JLabel j = new JLabel("Coada" + (i + 1) + ": ");
            j.setFont(new Font("Times New Roman", Font.PLAIN, 15));
            j.setBounds(10, y, 65, 20);
            contentPane.add(j);
            queuesLabels.add(new JLabel(""));
            queuesLabels.get(i).setFont(new Font("Times New Roman", Font.PLAIN, 15));
            queuesLabels.get(i).setBounds(80, y, 350, 20);
            contentPane.add(queuesLabels.get(i));
            y += 30;
        }
    }

    public void setClientiInAsteptare(String a) {
        this.lblNewLabel_1.setText(a);
    }

    public void setTimpSimulare(String a) {
        this.lblNewLabel_4.setText(a);
    }

    public void setareContinutCozi(String a, int i) {
        this.queuesLabels.get(i).setText(a);
    }

    public void setAvgTimeWait(String a) {
        this.time1.setText(a);
    }

    public void setAvgTimeProcess(String a) {
        this.time2.setText(a);
    }

    public void setPeekHour(String a) {
        this.time3.setText(a);
    }


}
