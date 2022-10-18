/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author vikku
 */
public class BattleField extends JPanel {

    private Dimension d;
    private Rebel rebel;
    private Torpedo[] torpedos;
    private Timer timer;
    private Driver driver;
    
    private int score = 0;
    Random random = new Random();

    public BattleField(Driver driver) {
        super();
        this.driver = driver;
        //fieldSetUp();
    }

    public void fieldSetUp() {

        setFocusable(true);
        d = new Dimension(Config.FIELD_WIDTH, Config.FIELD_HEIGHT);
        setBackground(Color.black);

        rebel = new Rebel(270, 280);
        addKeyListener(rebel);
        
        torpedos = new Torpedo[5];

        for (int i = 0; i < Config.TOTAL_TORPS; i++) {
            
            int initY = (int)(Math.random() * 10)*10;
            Torpedo torpedo = new Torpedo ((i * 60)+10, initY);
            torpedos[i] = torpedo;
        }

        timer = new Timer(Config.DELAY, new GameCycle());
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.requestFocusInWindow();
        doDrawing(g);
    }

   private void doDrawing(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);
        g.drawString("Score: "+String.valueOf(score), 100, 100);

        rebel.draw(g);

        int rebelX = rebel.getCoordX();
        int rebelY = rebel.getCoordY();

        for (int i = 0; i < Config.TOTAL_TORPS; i++) {
            Torpedo torpedo = torpedos[i];
            torpedo.draw(g);
            int torpX = torpedo.getCoordX();
            int torpY = torpedo.getCoordY();

            if (torpY >= Config.GROUND - Config.TORP_HEIGHT){
                System.out.println("Game Over! ");
                timer.stop();
                driver.gotoHome();
            } else if (((torpX+Config.TORP_WIDTH) >= rebelX) && (torpX <= (rebelX + Config.REBEL_WIDTH))
                        && (torpY+Config.TORP_HEIGHT) >= rebelY){ 
                 score++;
                 torpedo.setCoordY(0);
                 System.out.println("Score "+score);
             }
        }

        Toolkit.getDefaultToolkit().sync();
    }

    public void doGameCycle() {

        for (int i = 0; i < Config.TOTAL_TORPS; i++) {
            Torpedo torpedo = torpedos[i];
            int x = torpedo.getCoordX();
            int y = torpedo.getCoordY() + 4;
            torpedo.setCoordX(x);
            torpedo.setCoordY(y);
        }

        repaint();
    }
    
    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

}