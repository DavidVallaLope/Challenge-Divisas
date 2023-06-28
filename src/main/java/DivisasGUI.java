import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class DivisasGUI {
    private JPanel mainPanel;
    private JButton submitButton;
    private JList moneyList;
    private JTextField moneyField;
    private JComboBox moneyType;
    private JPanel welcomeMessage;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de divisas");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {}
        frame.setContentPane(new DivisasGUI().mainPanel);
        frame.setResizable(false);
        frame.setSize(720,300);
        frame.setMinimumSize(new Dimension(720, 300));
        frame.setMaximumSize(new Dimension(720, Integer.MAX_VALUE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
