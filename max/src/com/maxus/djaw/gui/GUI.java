package com.maxus.djaw.gui;

import com.maxus.djaw.DJaw;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;
import java.net.URI;
import com.maxus.djaw.gui.ProjectCreator;

public class GUI {
    public static final String path = System.getProperty("user.dir");
    public static void main(String[] args) {
        DJaw.DJMessage("GUI SETUP", 0);
        createGUI();
    }

    public static void createGUI(){
        String pathToIcon = "/com/maxus/djaw/gui/icon.png";
        System.out.println(pathToIcon);

        URL iconURL = GUI.class.getResource(pathToIcon);
        ImageIcon icon = new ImageIcon(iconURL);
        DJaw.DJMessage("Loading GUI...", 0);
        //create frame
        JFrame frame = new JFrame("DJaw Menu");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 160);

        JPanel panel = new JPanel();
        JLabel text1 = new JLabel("You can create a simple project formation! But you have to use coding skills for creating a serious project. ");
        JLabel text2 = new JLabel("Please check our documentation to find out on how everything works. Big thanks!");
        panel.add(text1);
        panel.add(text2);
        JPanel panel2 = new JPanel();
        JButton button = new JButton("Got it! Take me to this file!");
        panel2.add(button);
        JPanel panel3 = new JPanel();
        JButton button1 = new JButton("I want to configure a small project!");
        panel3.add(button1);
        button.addActionListener(e -> {
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        try {
                            Desktop.getDesktop().browse(new URI("https://github.com/Maxuss/djaw/blob/main/documentation.md"));
                        } catch (IOException | URISyntaxException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                });
        button1.addActionListener(a ->{
            frame.dispose();
            ProjectCreator.createAnotherWindow();
        });

        // compiling
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, panel2);
        frame.getContentPane().add(BorderLayout.SOUTH, panel3);
        frame.setVisible(true);
    }
}