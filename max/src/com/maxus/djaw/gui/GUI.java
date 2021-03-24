package com.maxus.djaw.gui;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String args[]) {

        //create frame
        JFrame frame = new JFrame("djaw_dev_pre_GUI_0.0.015");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //create menu
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("button1");
        JMenu m2 = new JMenu("button2");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("button3");
        JMenuItem m22 = new JMenuItem("all buttons do not do anything yet");
        m1.add(m11);
        m1.add(m22);

        //create panel
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("text_send_test");
        JTextField tf = new JTextField(10); // accepts 10 chars
        JButton send = new JButton("test2");
        JButton reset = new JButton("editor");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
    }
}