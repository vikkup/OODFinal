package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Brian
 */
public abstract class Avatar {

    protected Image image;
    protected int coordX;
    protected int coordY;
    protected int width;

    public Avatar(){
        var imageIcon = new ImageIcon(getImageFile());
        image = imageIcon.getImage();
        width = image.getHeight(null);
    }

    public Avatar(int x, int y){
        this();
        coordX = x;
        coordY = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void draw(Graphics g) {
        g.drawImage(image, coordX, coordY, null);
    }

    public abstract String getImageFile();
}