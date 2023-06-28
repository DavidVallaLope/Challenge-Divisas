import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DivisasGUI {
    private JPanel mainPanel;
    private JButton submitButton;
    private JTextField moneyField;
    private JComboBox moneyType;
    private JPanel welcomeMessage;
    private JComboBox comboBox1;
    private JLabel moneyValue;
    private DefaultListModel defaultListModel;

    public DivisasGUI() {
        this.defaultListModel = new DefaultListModel<>();
        this.validateMoneyInput();
    }
    public void setMoneyList(String s) {
        this.moneyValue.setText(s);
    }

    public void validateMoneyInput() {
        this.moneyField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = moneyField.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    moneyField.setEditable(true);
                } else if (ke.getKeyChar() == '.' && !isDotInText()){
                    moneyField.setEditable(true);
                } else if (ke.getKeyCode() == 8){
                    moneyField.setEditable(true);
                } else {
                    moneyField.setEditable(false);
                }
            }
        });
    }
    private boolean isDotInText() {
        return this.moneyField.getText().contains(".");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de divisas");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {}
        frame.setContentPane(new DivisasGUI().mainPanel);
        frame.setResizable(false);
        frame.setSize(600,300);
        frame.setMinimumSize(new Dimension(600, 300));
        frame.setMaximumSize(new Dimension(720, Integer.MAX_VALUE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        new DivisasGUI();
    }
}
