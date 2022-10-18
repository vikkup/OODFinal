/*
 * Config.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Sets values for appropriate constants
 */
package ood_final;

/**
 *
 * @author Brian
 */
//Configuration for sizes and arangements 
public interface Config {

    //This sets the Field's size 600x400
    int FIELD_WIDTH = 600;
    int FIELD_HEIGHT = 400;

    //This only allows 3 torpedos
    int TOTAL_TORPS = 3;

    //This sets a ground, so that when a torpedo goes past it will be able to
    //detect the invisible border
    int GROUND = 380;

    //Sets the Width and Height of the torpedo
    int TORP_HEIGHT = 4;
    int TORP_WIDTH = 12;

    //Sets a number to a delay of the torpedoes 
    int TORP_DELAY = 1800;
    int DELAY = 100;

    //Sets the Width and Height of the rebel
    int REBEL_WIDTH = 25;
    int REBEL_HEIGHT = 24;

    //This will provide info on how much right of left the rebel will move
    //on the X-axis
    int DELTA_X = 10;

}
