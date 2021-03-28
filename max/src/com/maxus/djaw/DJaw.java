package com.maxus.djaw;

import com.maxus.djaw.examples.djwen.example.djaw.ExampleClass;
import com.maxus.djaw.gui.GUI;
import com.maxus.djaw.parse.DJWParser;
import com.maxus.djaw.engine.Engine;
import com.maxus.djaw.gui.ProjectCreator;

// main class
public class DJaw {

    // starting
    public static void main(String[] args){
        DJMessage("Loading DJAW...", 0);
        Condition("customCondition");
        GUI.createGUI();
        DJWParser.ConnectData();
        ProjectCreator.main(args);
    }

    /**
    method for debug messages
     0 for debug,
     1 for warn,
     2 for error,
     3 for fatal
    */
    public static void DJMessage(String message, int type /* 0 for debug, 1 for warn, 2 for error, 3 for fatal*/){
        String msg_returner;
        switch (type) {
            case 0:
                msg_returner = "[DJAW] -DEBUG- > " + message;
                break;
            case 1:
                msg_returner = "[DJAW] -WARNING- > " + message;
                break;
            case 2:
                msg_returner = "[DJAW] -ERROR- > " + message;
                break;
            case 3:
                msg_returner = "[DJAW] -FATAL_ERROR- > " + message;
                break;
            default:
                msg_returner = "[DJAW] > " + message;
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
