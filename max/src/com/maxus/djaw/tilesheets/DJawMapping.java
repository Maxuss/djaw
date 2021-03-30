package com.maxus.djaw.tilesheets;

import com.maxus.djaw.DJaw;

import com.maxus.djaw.gui.GUI;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

import static com.maxus.djaw.gui.ProjectCreator.createDirectory;


@SuppressWarnings("all")
public class DJawMapping {
    public static final String path = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        TileMap tiles = new TileMap();
        tiles.changeSize(50, 30);
        Map coords = tiles.getCoords(145, 15);
        System.out.println(coords.get("x"));
        System.out.println(coords.get("y"));

        String pathToIcon = "/com/maxus/djaw/gui/icon.png";
        System.out.println(pathToIcon);

        URL iconURL = GUI.class.getResource(pathToIcon);
        ImageIcon icon = new ImageIcon(iconURL);
        JFrame frame = new JFrame("Test");
        frame = TileMap.setupGUIGrid(frame);
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(780, 160);
        frame.setVisible(true);
    }
    /**
     * Main class for mapping
     * @author maxus
    **/
    @SuppressWarnings("unused")
    public static class TileMap{
        // main variables
        public static int sizeX;
        public static int sizeY;
        public static boolean resizable;
        public static String texture;
        public static boolean includeHitboxes;
        public static JSONObject hitboxes;
        public static String id;
        public static JSONObject Structures;
        public static Map OccupiedTiles;
        public static Map tiles;

        // main methods
        public static int getSizeX(){ return sizeX; }
        public static int getSizeY(){ return sizeY; }
        public static boolean isResizable(){ return resizable; }
        public static String getTexture(){ return texture; }
        public static boolean isHitboxed(){ return includeHitboxes; }
        public static JSONObject getHitboxes(){ return hitboxes; }
        public static String getId(){ return id; }
        public static JSONObject getStructures(){ return Structures; }
        public static Map getTiles(){ return tiles; }

        // specific methods
        public static void changeSize(int newX, int newY){
            sizeX = newX;
            sizeY = newY;
        }

        public static void applyTextureSheet(String texturePath){
            texture = path + texturePath;
            DJaw.DJMessage("Applying TextureSheet patches to TileMap " + id, 0);
        }

        public static void addStructures(JSONObject structures){
            Structures = structures;
            DJaw.DJMessage("Applying StructSheet patches to TileMap " + id, 0);
        }
        @SuppressWarnings("unchecked")
        public static Map getCoords(int x, int y){
            Map coordsIndex = new TreeMap();

            if(x>sizeX){
                coordsIndex.put("x", sizeX);
            } else {
                coordsIndex.put("x", x);
            }
            if(y>sizeY){
                coordsIndex.put("y", sizeY);
            } else{
                coordsIndex.put("y", y);
            }
            return coordsIndex;
        }



        public static JButton createTileButton(Tile tile) {
            DJaw.DJMessage("Loading Button...", 0);
            try {
                String paths = tile.getIMGPath();
                System.out.println(paths);
                URL pathss = GUI.class.getResource(paths);
                ImageIcon icon = new ImageIcon(pathss);
                return new JButton(tile.getName(), icon);

            } catch(NullPointerException e){
                DJaw.DJMessage(e.toString(), 1);
                URL pathss = GUI.class.getResource("/com/maxus/djaw/gui/icon.png");
                ImageIcon icon = new ImageIcon(pathss);
                return new JButton(tile.getName(), icon);
            }

        };

        public static JFrame setupGUIGrid(JFrame mainFrame) throws IOException {
            for (int i = 0; i < sizeY; i++) {
                JPanel line = new JPanel();
                mainFrame.getContentPane().add(line);
                for (int aa = 0; aa < sizeX; aa++) {
                    String aas = String.valueOf(new Integer(aa));
                    Tile tmp = new Tile("filler");
                    tmp.$reinit(aas, "\\djaw\\tiles\\" + tmp.tiletype + ".png");
                    JButton temp = createTileButton(tmp);
                    line.add(temp);
                }
                mainFrame.getContentPane().add(line);
            }
            return mainFrame;
        }
    }

    public static class Tile {
        public static final String path = System.getProperty("user.dir");
        public static String tiletype;
        public static String tilename; // id
        File directory = createDirectory(path+"\\djaw\\tiles\\");
        public static String tileIMGPath = path + tilename; // path to img

        public Tile(String tileType) throws IOException {
            tiletype = tileType;
            tileIMGPath = path + tilename;
        }

        public static String getName(){ return tilename; };
        public static String getIMGPath(){ return tileIMGPath;}


        /**
         * Reinitialize a tile
         * @param tileName new tile id
         * @param tilesIMGPath new tile path FROM CURRENT FILE!
         **/
        public static void $reinit(String tileName, String tilesIMGPath){
            tilename = tileName;
            tileIMGPath = path + tilesIMGPath;
        }
    }
}
