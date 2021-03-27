package com.maxus.djaw.gui;

import com.maxus.djaw.DJaw;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.net.URI;

public class GUI {
    public static void main(String[] args) {
        DJaw.DJMessage("GUI SETUP", 0);
        createGUI();
    }

    public static void createGUI(){
        URL iconURL = GUI.class.getResource("/com/maxus/djaw/gui/icon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        DJaw.DJMessage("Loading GUI...", 0);
        //create frame
        JFrame frame = new JFrame("DJaw Menu");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 130);

        JPanel panel = new JPanel();
        JLabel text1 = new JLabel("Sorry, but DJaw currently only supports\ncreating projects by coding them yourself!\n");
        JLabel text2 = new JLabel("Please check our documentation.md,\nto find out how everything works. Thanks!\n");
        panel.add(text1);
        panel.add(text2);
        JPanel panel2 = new JPanel();
        JButton button = new JButton("Got it! Take me to this file!");
        panel2.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/Maxuss/djaw/blob/main/documentation.md"));
                    } catch (IOException | URISyntaxException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        // compiling
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, panel2);
        frame.setVisible(true);
    }
}