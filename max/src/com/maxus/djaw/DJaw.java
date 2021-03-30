package com.maxus.djaw;

import com.maxus.djaw.examples.djwen.example.djaw.ExampleClass;
import com.maxus.djaw.gui.GUI;
import com.maxus.djaw.parse.DJWParser;
import com.maxus.djaw.gui.ProjectCreator;

// main class
public class DJaw {

    // starting
    public static void main(String[] args)  {
        DJMessage("Loading DJAW...", 0);
        Condition("customCondition");
        GUI.createGUI();
        DJWParser.ConnectData();
        ProjectCreator.main(args);
        DJWParser.createConfig();
    }

    /**
    method for debug messages
     0 for debug,
     1 for warn,
     2 for error,
     3 for fatal
    */
    @SuppressWarnings("unused")
    public static void DJMessage(String message, int type /* 0 for debug, 1 for warn, 2 for error, 3 for fatal*/){
        final String reset = "\u001B[0m";
        final String black = "\u001B[30m";
        final String red = "\u001B[31m";
        final String green = "\u001B[32m";
        final String yellow = "\u001B[33m";
        final String blue = "\u001B[34m";
        final String purple = "\u001B[35m";
        final String cyan = "\u001B[36m";
        final String white = "\u001B[37m";
        final String msg_returner;
        switch (type) {
            case 0:
                msg_returner = cyan + "[DJAW] -DEBUG- > " + message + reset;
                break;
            case 1:
                msg_returner = yellow + "[DJAW] -WARNING- > " + message + reset;
                break;
            case 2:
                msg_returner = purple + "[DJAW] -ERROR- > " + message + reset;
                break;
            case 3:
                msg_returner = red + "[DJAW] -FATAL_ERROR- > " + message + reset;
                break;
            default:
                msg_returner = yellow + "[DJAW] > " + message + reset;
                break;
        }
        System.out.println(msg_returner);

    }
    /**
     * Executes certain codes on different conditions<br>
     * Mainly made for project's use
     * @param condition - [str]condition
     * @see DJaw
     * @author maxus
     **/
    public static void Condition(String condition) {
        switch(condition){
            case "guiCreated":
                // on gui creation
            case "windowClosed":
                // on window close
            case "onLoad":
                // on djaw load
            case "onParsing":
                // on parsing a .dji file
            case "onFileCreation":
                // on creating a file
            case "customCondition":
                // custom condition
                ExampleClass.Custom("customCondition");
            default:
                // do nothing
        }
    }

}
