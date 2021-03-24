package com.maxus.djaw;

import com.maxus.djaw.gui.GUI;

// main class
public class DJaw {

    // starting
    public static void main(String[] args){
        DJMessage("Loading DJAW...", 0);
    }

    /*
    method for debug messages
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
}
