/*
 * BattleField.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Contains main logic for gameplay
 */
package ood_final;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author vikku
 */
public class BattleField extends JPanel {

    private Dimension d;
    private Rebel rebel;
    private Torpedo[] torpedos;
    private Timer timer;
    private Timer torpTimer;
    private Driver driver;
    private String playerName;
    private int torpCounter;
    private int score = 0;
    Random random = new Random();

    /**
     * Battlefield constructor
     * @param driver 
     */
    public BattleField(Driver driver) {
        super();
        this.driver = driver;
    }

    /**
     * method to set up battlefield by creating the rebel and torpedo objects
     * @param name 
     */
    public void fieldSetUp(String name) {

        setFocusable(true);

        this.playerName = name;

        torpCounter = 0;

        d = new Dimension(Config.FIELD_WIDTH, Config.FIELD_HEIGHT);
        setBackground(Color.black);

        rebel = new Rebel(270, 300);
        addKeyListener(rebel);

        torpedos = new Torpedo[Config.TOTAL_TORPS];

        torpTimer = new Timer(Config.TORP_DELAY, new Launcher());
        torpTimer.start();

        score = 0;

        timer = new Timer(Config.DELAY, new GameCycle());
        timer.start();

    }

    @Override
    /**
     * method that gets called every time the timer event fires
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocusInWindow();
        doDrawing(g);
    }

    /**
     * method to draw elements with new coordinates
     * @param g 
     */
    private void doDrawing(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        ImageIcon imageIcon = new ImageIcon("Sprites/gameBackground.png");
        g.drawImage(imageIcon.getImage(), 0, 0, null);

        g.drawString("Player: " + playerName, 10, 20);
        g.drawString("Score: " + String.valueOf(score), 500, 20);

        rebel.draw(g);

        int rebelX = rebel.getCoordX();
        int rebelY = rebel.getCoordY();

        for (int i = 0; i < torpCounter; i++) {
            Torpedo torpedo = torpedos[i];
            torpedo.draw(g);
            int torpX = torpedo.getCoordX();
            int torpY = torpedo.getCoordY();

            if (torpY >= Config.GROUND - Config.TORP_HEIGHT) {
                timer.stop();
                driver.getBoard().saveData(playerName, score);
                driver.gotoHome();

            } else if ((torpX + Config.TORP_WIDTH) >= rebelX && torpX <= (rebelX + Config.REBEL_WIDTH)
                    && (torpY + Config.TORP_HEIGHT) >= rebelY && torpY <= (rebelY + Config.REBEL_HEIGHT)) {
                score++;
                //relaunching the torpedo with a random x coordinate and 0 y coordinate
                torpedo.setCoordX(getInitX());
                torpedo.setCoordY(0);
                System.out.println("Score " + score);
            }
        }

        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * method to update torpedo's coordinates
     */
    public void doGameCycle() {

        for (int i = 0; i < torpCounter; i++) {
            Torpedo torpedo = torpedos[i];
            int x = torpedo.getCoordX();
            int y = torpedo.getCoordY() + 4;
            torpedo.setCoordX(x);
            torpedo.setCoordY(y);
        }

        repaint();
    }

    /**
     * method that fires (creates) the torpedo in random locations 
     */
    private void fireTorpedo() {

        Torpedo torpedo = new Torpedo(getInitX(), 0);
        torpedos[torpCounter] = torpedo;
        torpCounter = torpCounter + 1;
        if (torpCounter == Config.TOTAL_TORPS) {
            torpTimer.stop();
        }

    }

    /**
     * calculates the random x coordinate for the torpedo
     * @return 
     */
    private int getInitX() {
        return (int) (Math.random() * 500);

    }

    /**
     * class that implements action listener for game timer
     */
    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    /**
     * class that implements action listener for torpedo timer
     */
    private class Launcher implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            fireTorpedo();
        }
    }
    
}
