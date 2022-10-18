/*
 * Torpedo.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Gets the file for torpedo
 */
package ood_final;

/**
 *
 * @author vikku
 */
public class Torpedo extends Avatar {

    //Private variable declaration
    private final String imgFile = "Sprites/torpedo.png";

    /**
     * Default constructor
     */
    public Torpedo() {
        super();
    }

    /**
     * @param x
     * @param y
     */
    public Torpedo(int x, int y) {
        super(x, y);
    }

    /**
     * @return imgFile
     */
    public String getImageFile() {
        return imgFile;
    }
}
