package com.maxus.djaw.examples.djwen.example.djaw;

import com.maxus.djaw.DJaw;
import com.maxus.djaw.engine.Engine;

import java.io.IOException;

// just for example
/**
 * @author maxus
 **/
public class ExampleClass {
    // example
    public static void main(String[] args) throws IOException {
        // generate an item
        // item finishes generating only after closing the window for some reason tho
        Engine.Creation.Create(
                "custom-item", "Custom Item Example",
                "Example", "item"
                );
        // Start everything up
        DJaw.main(args);
    }
    // Does something each time condition met.
    // Requires you to change the in-engine method `Condition`.
    // It can be found at DJaw Class
    // Possible conditions
    // "guiCreated" - on gui creation
    // "windowClosed" - on gui close
    // "onLoad" - on djaw load
    // "onParsing" - on parsing a file
    // "onFileCreation" - on creation of file
    // You can create your own conditions and use them!
    // Just add `case "yourCondition" : -code-`
    public static void Custom(String args){
        DJaw.DJMessage("Custom Condition met!" + args, 0);
    }
}
