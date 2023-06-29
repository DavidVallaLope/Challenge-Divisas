package com.davidval.gui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DivisasGUI {
    private boolean color;
    private JPanel mainContent;
    private JButton submitButton;
    private JLabel tituloField;
    private JComboBox dropToConvert;
    private JLabel moneyResult;
    private JComboBox comboBox1;
    private JTextField moneyField;
    private JLabel moneyValue;

    public DivisasGUI() {
        this.color = true;
        this.changeColor();
        this.buildFrame();
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

    public void buildFrame() {
        JFrame frame = new JFrame("Conversor de divisas");
        frame.setContentPane(this.mainContent);
        System.out.println(UIManager.getLookAndFeel().getName());
        frame.setResizable(false);
        frame.setSize(600,300);
        frame.setMinimumSize(new Dimension(600, 300));
        frame.setMaximumSize(new Dimension(720, Integer.MAX_VALUE));
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
        if (!color) {
            changeColor(new FlatLightLaf());
            this.mainContent.setBackground(new Color(243,243,242));
            color = true;
        } else {
            changeColor(new FlatDarculaLaf());
            this.mainContent.setBackground(new Color(61,63,64));
            color = false;
        }
    }

    public static void main(String[] args) {
        new DivisasGUI();
    }
}
