package com.davidval.gui;

import com.davidval.business.Temperatura;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;

public class TemperaturaGUI {
    private JButton convertirButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel mainContent;
    private JCheckBox nightCheckBox;
    private JLabel tempField;
    private boolean color;
    private Temperatura temp;

    TemperaturaGUI(boolean flag) {
        this.temp = new Temperatura();
        this.color = flag;
        this.changeColor();
        this.setDropToConvert();
        this.buildFrame();
        this.validateMoneyInput();

        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp.setFromTemperatura(comboBox1.getSelectedItem().toString());
                temp.setToTemperatura(comboBox2.getSelectedItem().toString());
                temp.setFromValue(Double.parseDouble(textField1.getText().toString()));
                tempField.setText(String.format("%.2f",temp.getToValue()));
            }
        });
        nightCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });
    }

    public void setDropToConvert() {
        this.comboBox1.setModel(new DefaultComboBoxModel(Temperatura.Temperaturas.values()));
        this.comboBox2.setModel(new DefaultComboBoxModel(Temperatura.Temperaturas.values()));
    }

    public void buildFrame() {
        JFrame frame = new JFrame("Conversor de divisas");

        frame.setContentPane(this.mainContent);
        frame.setResizable(false);
        frame.setSize(500,300);
        frame.setMinimumSize(new Dimension(500, 300));
        frame.setMaximumSize(new Dimension(500, Integer.MAX_VALUE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

    private void changeColor(FlatLaf flatLaf) {
        try {
            UIManager.setLookAndFeel(flatLaf);
            SwingUtilities.updateComponentTreeUI(this.mainContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeColor() {
        if (color) {
            changeColor(new FlatLightLaf());
            this.mainContent.setBackground(new Color(243,243,242));

        } else {
            changeColor(new FlatDarculaLaf());
            this.mainContent.setBackground(new Color(61,63,64));
        }
        color = !color;
    }

    public void validateMoneyInput() {
        this.textField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textField1.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textField1.setEditable(true);
                } else if (ke.getKeyChar() == '.' && !isDotInText()){
                    textField1.setEditable(true);
                } else if (ke.getKeyCode() == 8){
                    textField1.setEditable(true);
                } else {
                    textField1.setEditable(false);
                }
            }
        });
    }
    private boolean isDotInText() {
        return this.textField1.getText().contains(".");
    }

    public static void main(String[] args) {
        new TemperaturaGUI(true);
    }
}
