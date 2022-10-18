/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author vikku
 */
public class Torpedo extends Avatar{
    private final String imgFile = "rebel.png";
    
    public Torpedo(){
        super();
    }
    
    public Torpedo(int x, int y){
        super(x, y);
    }
    
    public String getImageFile(){
        return imgFile;
    }
}