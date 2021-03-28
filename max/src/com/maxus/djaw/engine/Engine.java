package com.maxus.djaw.engine;
import com.maxus.djaw.DJaw;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.maxus.djaw.gui.ProjectCreator.createDirectory;


/**
 * <h1>DJaw Engine</h1>
 * <p>Main class for Djaw engine.</p>
 * <h2>Methods:</h2>
 * <li>Start() - starts up engine</li>
 * <li>Stop() - stops the engine and closes the window</li>
 * <h2>Subclasses:</h2>
 *
 * <h3> Enemy:</h3>
 * <p>Main enemy class. Can create mobs and more.<br></p>
 * <h4>Methods:</h4>
 * <li>Create() - creates an enemy</li>
 * <li>Disband() - destroys an enemy</li>
 * <li>Modify() - changes data of enemy</li>
 * <li>Load() - loads an item from file</li>
 *
 * <h3>Item:</h3>
 * <p>Main items class. Can create items and stuff.<br></p>
 * <h4>Methods:</h4>
 * <li>Create() - creates an item</li>
 * <li>Disband() - deletes an item</li>
 * <li>Modify() - modifies data of existing item</li>
 * <li>Load() - loads an item from file</li>
 *
 * <h3>Creation:</h3>
 * <p>Main buildings/creations class. Can create blocks and stuff i think.<br></p>
 * <h4>Methods:</h4>
 * <li>Create() - creates a block</li>
 * <li>Disband() - deletes a block</li>
 * <li>Modify() - modifies data of existing block</li>
 * <li>Load() - loads an item from file</li>
 *
 * <h3>Abilities</h3>
 * <p>Class that gives more interaction to items/buildings stuff</p>
 * <h4>Methods:</h4>
 * <li>Create() - creates an ability</li>
 * <li>Load() - loads an ability from file, and applies it to some mob/building</li>
 * <li>Delete() - deletes an ability</li>
 * <li>Modify() - modifies an ability</li>
 *
 * @see com.maxus.djaw.DJaw
 * @see com.maxus.djaw.gui.GUI
 * @see com.maxus.djaw.gui.ProjectCreator
 * @author maxus
 **/
public class Engine {

    public static final String path = System.getProperty("user.dir");
    public static void main(String[] args){
        DJaw.DJMessage("Pre-initializing engine", 0);
        Start();
    }

    /**
     * <h2>DJaw Engine</h2>
     * Starts up the DJaw Engine
     * @see Engine
     * @return GUI
     **/
    public static void Start(){
        DJaw.DJMessage("Starting engine", 0);
    }
    /**
     * <h2>DJaw Engine</h2>
     * Stops the engine
     * **/
    public static void Stop(){

    }
    /**
     * <h2>DJaw Engine</h2>
     * Main class for items
     * **/
    public static class Item{
        public static void main(String[] args){
            Item.Create("test", "Item Test", "TEst ITEM");
        }
        private static FileWriter file;
        /**
         * <h2>DJawEngine.Item</h2>
         * Creates item in <path>\djaw\items</path> folder, and pastes ImageTexture into <path>\djaw\textures</path>.
         * <br>Item will have a .dji file named with ItemID. ItemID <b>DOES NOT ALLOW SPACES</b>
         * @param ItemID - ID of item. Does not allow spacebars.
         * @param ItemName - Name of item. Allows spacebars.
         * @param ItemDescription - Description of item. Allows spacebars.
         **/
        @SuppressWarnings("unchecked")
        public static void Create(
                String ItemID, String ItemName, String ItemDescription
        )
        {
            // create a new json obj
            JSONObject obj = new JSONObject();
            JSONObject abilities = new JSONObject();

            abilities.put("abilityClass", null);
            abilities.put("creator", null);

            obj.put("itemID", ItemID);
            obj.put("itemDescription", ItemDescription);
            obj.put("itemName", ItemName);
            obj.put("itemAbilities", abilities);

            try {
                File directory = createDirectory(path+"\\djaw\\items\\");
                System.out.println(directory);
                File tmp = new File(directory, ItemID + ".dji");
                tmp.createNewFile();
                DJaw.DJMessage("Created a DJI File!", 0);
                file = new FileWriter(directory+ "\\"+ItemID+".dji");
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
    }
}
