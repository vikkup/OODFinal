/*
 * Home.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Sets layout for main menu interface
 */
package ood_final;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */
public class Home extends JPanel implements ActionListener {

    //private variables declared
    private Driver driver;
    private Button playButton;
    private Button boardButton;
    private JTextField nameField;
    private JLabel nameLabel;

    /**
     * Constructor which sets up GUI components
     *
     * @param driver
     */
    public Home(Driver driver) {

        super();
        //Sets layout and constraints 
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.driver = driver;

        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Sets positioning, color, and text
        gbc.gridx = 0;
        gbc.gridy = 0;
        nameLabel = new JLabel("Player Name: ");
        nameLabel.setForeground(Color.WHITE);
        this.add(nameLabel, gbc);

        //Sets positioning and text
        gbc.gridx = 1;
        gbc.gridy = 0;
        nameField = new JTextField("");
        this.add(nameField, gbc);

        //Sets positioning, button, and text
        gbc.gridx = 0;
        gbc.gridy = 2;
        playButton = new Button("Play");
        this.add(playButton, gbc);

        //Sets positioning, button, and text
        gbc.gridx = 1;
        gbc.gridy = 2;
        boardButton = new Button("Score Board");
        this.add(boardButton, gbc);

        //Adds actionlistener accordingly 
        playButton.addActionListener(this);
        boardButton.addActionListener(this);

    }

    /**
     * Paints the background image on the main menu
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Grabs the main menu image and draws it appropiatly 
        ImageIcon imageIcon = new ImageIcon("Sprites/mainMenu.png");
        g.drawImage(imageIcon.getImage(), 0, 0, null);
    }

    /**
     * Performs the action of getting the name from button input
     *
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        //Gets the text of the field based on button click
        if (event.getSource() == playButton) {
            String name = nameField.getText();
            //If the text is blank, you may not proceed
            if (name.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a name to play");
                return;
            }
            driver.gotoField(name);
        } else {
            driver.gotoBoard();
        }
    }

}
