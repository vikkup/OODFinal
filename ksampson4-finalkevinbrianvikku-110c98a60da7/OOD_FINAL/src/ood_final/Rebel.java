/*
 * Rebel.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Contains logic for X-Wing movement, grabs X-Wing sprite
 */
package ood_final;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author kevin
 */
public class Rebel extends Avatar implements KeyListener {

    //Private variable declaration 
    private final String imgFile = "Sprites/xwing.png";

    /**
     * Default constructor
     */
    public Rebel() {
        super();
    }

    /**
     * @param x
     * @param y
     */
    public Rebel(int x, int y) {
        super(x, y);
    }

    /**
     *
     * @return imgFile
     */
    public String getImageFile() {
        return imgFile;
    }

    /**
     * Initiates the event corresponding to the key press
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {

        //Retrieves key code
        int key = e.getKeyCode();

        //Determines directional input config if left arrow
        if (key == KeyEvent.VK_LEFT) {

            //Determines how much area is considered in movement
            coordX -= Config.DELTA_X;
            if (coordX < Config.DELTA_X) {
                coordX = Config.DELTA_X;
            }
        }

        //Determines directional input config if right arrow
        if (key == KeyEvent.VK_RIGHT) {

            //Determines how much area is considered in movement
            coordX += Config.DELTA_X;
            if (coordX + width > Config.FIELD_WIDTH) {

                coordX = Config.FIELD_WIDTH - width;
            }
        }
    }

    /**
     * Method for handling key releasing
     *
     * @param event
     */
    public void keyReleased(KeyEvent event) {

    }

    /**
     * Method for handling key typing
     *
     * @param event
     */
    public void keyTyped(KeyEvent event) {

    }
}
