/*
 * Avatar.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Takes coordinates and images and draws them appropriatly
 */
package ood_final;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Brian
 */
public abstract class Avatar {

    //Private Variables
    protected Image image;
    protected int coordX;
    protected int coordY;
    protected int width;

    /**
     * Default Constructor that creates the image from a file and makes it an
     * object.
     */
    public Avatar() {
        var imageIcon = new ImageIcon(getImageFile());
        image = imageIcon.getImage();
        width = image.getHeight(null);
    }

    /**
     * Default constructor that initiates X and Y cords
     *
     * @param x
     * @param y
     */
    public Avatar(int x, int y) {
        this();
        coordX = x;
        coordY = y;
    }

    /**
     * This method reads the image and stores it
     *
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     * This method updates the image
     *
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * This method reads in the X cord
     *
     * @return coordX
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * This method updates the X cord
     *
     * @param coordX
     */
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    /**
     * This method reads in the Y cord
     *
     * @return coordY
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     * This method updates the Y cord
     *
     * @param coordY
     */
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    /**
     * This method will draw the image where the x and y cords are selected
     *
     * @param g
     */
    public void draw(Graphics g) {
        g.drawImage(image, coordX, coordY, null);
    }

    /**
     * This gets the ImageFile
     *
     * @return image file
     */
    public abstract String getImageFile();
}
