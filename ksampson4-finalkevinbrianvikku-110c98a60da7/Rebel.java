/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author kevin
 */
public class Rebel extends Avatar implements KeyListener {

    private final String imgFile = "rebel.png";

    public Rebel() {
        super();
    }

    public Rebel(int x, int y) {
        super(x, y);
    }

    public String getImageFile() {
        return imgFile;
    }


    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            coordX -= Config.DELTA_X;
            if (coordX < Config.DELTA_X) {
                coordX = Config.DELTA_X;
            }
        }

        if (key == KeyEvent.VK_RIGHT) {

            coordX += Config.DELTA_X;
            if (coordX >= Config.FIELD_WIDTH - Config.DELTA_X * width) {

                coordX = Config.FIELD_WIDTH - Config.DELTA_X * width;
            }
        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }
}