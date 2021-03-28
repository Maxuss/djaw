package com.maxus.djaw.gui;

import com.maxus.djaw.DJaw;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

import com.maxus.djaw.parse.DJWParser;
import com.maxus.djaw.parse.DJWParser.Portfolio;

import org.json.simple.JSONObject;
import java.io.IOException;
import java.util.Map;


public class ProjectCreator {
    private static String path = System.getProperty("user.dir");
    private static FileWriter file;
    public static void main(String[] args){
        createAnotherWindow();
    }
    @SuppressWarnings("unchecked")
    public static void dump(
            String name, String description, String creator, String ID,
            String packageName, String mainClass, String credits, String website, String version, String language,
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
        obj.put("projectLanguage", language);
        obj.put("projectWebsite", website);
        obj.put("projectVersion", version);

        try {
            File directory = createDirectory(path+"\\djaw\\projects\\"+filename+"\\");
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
    public static File createDirectory(String directoryPath) throws NullPointerException, IOException {
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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1200, 500);
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Note: ID should use '-' instead of spaces");
        JTextField name = new JTextField("Name(Test Project)", 20);
        JTextField description = new JTextField("Description(some description)", 60);
        JTextField creatorName = new JTextField("Creator(Maksim 'Maxuss' Petrov)", 30);
        JTextField id = new JTextField("id(project-id)", 16);
        JTextField packageName = new JTextField("package(com.example.djaw)", 40);
        JTextField mainClass = new JTextField("main class(MainClass)", 50);
        JTextField credits = new JTextField("credits(My friends)", 80);
        JTextField website = new JTextField("website(example.com)", 40);
        JTextField version = new JTextField("Version(1.0.0.0)", 40);
        JTextField language = new JTextField("Lang(en-US)", 10);
        panel.add(name);
        panel.add(language);
        panel.add(description);
        panel.add(creatorName);
        panel.add(id);
        panel.add(packageName);
        panel.add(mainClass);
        panel.add(credits);
        panel.add(website);
        panel.add(version);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JButton button = new JButton("Confirm, and create a project!");
        JButton button2 = new JButton("Cancel and exit");
        panel1.add(button);
        panel1.add(button2);
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
            String pv = version.getText();
            String pl = language.getText();
            dump(pname, pdesc, pcn, pid, ppn, pmc, pc, pw, pv, pl, pid);
            GUI.popup("Creation successful!", "You have successfully created a new\n project at '" + path + "\\djaw\\projects\\"+pid+"'! Check it out!");
        });
        button2.addActionListener(evt -> {
            frame.dispose();
        });
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, panel1);
        frame.getContentPane().add(BorderLayout.NORTH, panel2);
        frame.setVisible(true);

    }
    public static void showAvailableProjects() throws NullPointerException {
        String pathToIcon = "/com/maxus/djaw/gui/icon.png";
        URL iconURL = GUI.class.getResource(pathToIcon);
        ImageIcon icon = new ImageIcon(iconURL);
        DJaw.DJMessage("Loading GUI...", 0);

        //create frame
        JFrame frame = new JFrame("Create new DJaw project");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 300);
        JPanel panel = new JPanel();
        JPanel _2 = new JPanel();
        StringBuilder foundprojects = new StringBuilder(" ");
        try {
            String[] projects = DJWParser.FindProjects();
            for (String project : projects) {
                foundprojects.append(project).append(", ");
                JButton projectButton = new JButton(project);
                _2.add(projectButton);
                projectButton.addActionListener(e -> {
                    frame.dispose();
                    openFileConfig(project);
                });
            }
        } catch(NullPointerException e) {
            DJaw.DJMessage(e.toString(), 1);
            GUI.popup("ERROR","Projects not found! Create a new project, to see it!");
        }
        String we = "DJaw found these projects under current directory! Click a button to see config of project:\n ";
        JLabel label1 = new JLabel(we);
        panel.add(label1);
        JPanel _3 = new JPanel();
        JButton button = new JButton("OK");
        button.addActionListener(e -> {
            frame.dispose();
        });
        _3.add(button);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, _2);
        frame.getContentPane().add(BorderLayout.SOUTH, _3);
        frame.setVisible(true);
    }

    public static void openFileConfig(String projectName){
        Map map = DJWParser.ConnectData();
        Portfolio data = (Portfolio) map.get(projectName);

        String pathToIcon = "/com/maxus/djaw/gui/icon.png";
        URL iconURL = GUI.class.getResource(pathToIcon);
        ImageIcon icon = new ImageIcon(iconURL);
        DJaw.DJMessage("Loading GUI...", 0);
        //create frame
        JFrame frame = new JFrame(projectName + " config");
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);

        JPanel panel = new JPanel();
        String full = "<html><li>Name: "+data.name+"</li><li>ID: "+data.id+"</li><li>Version: "+data.ver+"</li><li>Description: "+data.description+"</li><li>Creator: "+data.author+"</li><li>Credits: "+data.credits+"</li><li>Language: "+data.language+"</li><li>Website: "+data.website+"</li><li>Standard Compiler: "+data.compiler+"</li><li>Main class:"+data.classname+"</li><li>Main Exceptions class:"+data.eClassname+"</li></html>";
        panel.add(new JLabel(full));
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setVisible(true);
    }
}
