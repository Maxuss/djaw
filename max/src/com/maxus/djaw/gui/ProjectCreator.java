package com.maxus.djaw.gui;

import com.maxus.djaw.DJaw;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import org.json.simple.JSONObject;
import java.io.IOException;


public class ProjectCreator {
    private static String path = System.getProperty("user.dir");
    private static FileWriter file;
    public static void main(String[] args){
        createAnotherWindow();
    }
    @SuppressWarnings("unchecked")
    public static void dump(
            String name, String description, String creator, String ID,
            String packageName, String mainClass, String credits, String website,
            String filename
        ){
        JSONObject obj = new JSONObject();

        obj.put("normalSignature", "classical_unstable");
        obj.put("dunjerCache", false);
        obj.put("djawCache", false);
        obj.put("devjawCache", false);
        obj.put("standardCompiler", "djaw");
        obj.put("mainClass", mainClass);
        obj.put("exceptionClass", null);
        obj.put("modifyInnerCode", false);
        obj.put("standardRunConfig", "windowed");
        obj.put("acceleration", false);
        obj.put("createLocalData", false);
        obj.put("localDataPath", null);
        obj.put("package", packageName);
        obj.put("leaveSignature", false);
        obj.put("logConsole", false);
        obj.put("projectID", ID);
        obj.put("projectName", name);
        obj.put("projectDescription", description);
        obj.put("projectAuthor", creator);
        obj.put("projectCredits", credits);
        obj.put("projectLanguage", "en-US");
        obj.put("projectWebsite", website);

        try {
            File directory = createDirectory(path+"\\projects\\"+filename+"\\");
            System.out.println(directory);
            File tmp = new File(directory, "data.dji");
            tmp.createNewFile();
            DJaw.DJMessage("Created a DJI File!", 0);
            file = new FileWriter(directory+"\\data.dji");
            file.write(obj.toJSONString());
            System.out.println(file);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static File createDirectory(String directoryPath) throws IOException {
        File dir = new File(directoryPath);
        if (dir.exists()) {
            return dir;
        }
        if (dir.mkdirs()) {
            return dir;
        }
        throw new IOException("Failed to create directory '" + dir.getAbsolutePath() + "' for an unknown reason.");
    }
    public static void createAnotherWindow(){
        String pathToIcon = "/com/maxus/djaw/gui/icon.png";
        URL iconURL = GUI.class.getResource(pathToIcon);
        ImageIcon icon = new ImageIcon(iconURL);
        DJaw.DJMessage("Loading GUI...", 0);

        //create frame
        JFrame frame = new JFrame("Create new DJaw project");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 200);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Note: ID should use '-' instead of spaces");
        JTextField name = new JTextField("Name", 20);
        JTextField description = new JTextField("Description", 50);
        JTextField creatorName = new JTextField("Creator(s)", 30);
        JTextField id = new JTextField("project-id", 16);
        JTextField packageName = new JTextField("projects.main.package", 40);
        JTextField mainClass = new JTextField("MainClass", 50);
        JTextField credits = new JTextField("Credits", 80);
        JTextField website = new JTextField("website.com", 40);
        panel.add(name);
        panel.add(description);
        panel.add(creatorName);
        panel.add(id);
        panel.add(packageName);
        panel.add(mainClass);
        panel.add(credits);
        panel.add(website);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JButton button = new JButton("Confirm, and create a project!");
        panel1.add(button);
        panel2.add(label);
        button.addActionListener(e ->{
            String pname = name.getText();
            String pdesc = description.getText();
            String pcn = creatorName.getText();
            String pid = id.getText();
            String ppn = packageName.getText();
            String pmc = mainClass.getText();
            String pc = credits.getText();
            String pw = website.getText();
            dump(pname, pdesc, pcn, pid, ppn, pmc, pc, pw, pid);
            popup("Creation successful!", "You have successfully created a new\n project at '" + path + "\\projects'! Check it out!");
        });

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, panel1);
        frame.getContentPane().add(BorderLayout.NORTH, panel2);
        frame.setVisible(true);

    }

    public static void popup(String title, String message){
        String pathToIcon = "/com/maxus/djaw/gui/icon.png";
        URL iconURL = GUI.class.getResource(pathToIcon);
        ImageIcon icon = new ImageIcon(iconURL);

        JFrame frame = new JFrame(title);
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 100);
        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);
        JPanel panel2 = new JPanel();
        JButton button = new JButton("OK");
        button.addActionListener(evt -> {
            frame.dispose();
        });
        panel.add(label);
        panel2.add(button);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, panel2);
        frame.setVisible(true);
    }
}
