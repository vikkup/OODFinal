/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class Home extends JPanel implements ActionListener {

    private Driver driver;
    private Button playButton;
    private Button boardButton;

    public Home(Driver driver){

        super();

        this.driver = driver;

        playButton = new Button("Play");
        boardButton = new Button("Leader Board");

        this.add(playButton);
        this.add(boardButton);

        playButton.addActionListener(this);
        boardButton.addActionListener(this);

    }

     public void actionPerformed(ActionEvent event) {
         if (event.getSource() == playButton){
            driver.gotoField();
         } else {
             driver.gotoBoard();
         }
     }

}