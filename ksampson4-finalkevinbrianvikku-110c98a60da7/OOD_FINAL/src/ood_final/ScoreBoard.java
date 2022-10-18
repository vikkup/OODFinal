/*
 * ScoreBoard.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Loads and saves data from game into a database 
 *              in every gameplay instance
 */
package ood_final;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vikku
 */
public class ScoreBoard extends JPanel implements ActionListener {

    private Driver driver;
    private Button homeButton;
    JTable table;

    /**
     * ScoreBoard constructor 
     * @param driver 
     */
    public ScoreBoard(Driver driver) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        table = new JTable();
        this.add(table);

        this.driver = driver;
        homeButton = new Button("Home");
        homeButton.addActionListener(this);
        this.add(homeButton);
    }

    /**
     * loads data from database (text file)
     */
    public void loadData() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Name");
        model.addColumn("Score");

        table.setModel(model);

        try {
            File file = new File("scores.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            while ((st = br.readLine()) != null) {
                model.addRow(st.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * This method saves the data from the game(name and score) into a score.txt
     *
     * @param playerName
     * @param score
     */
    public void saveData(String playerName, int score) {
        try {
            //Appends to the file
            Writer fileWriter = new FileWriter("scores.txt", true);
            fileWriter.write("\n" + playerName + ", "
                    + String.valueOf(score));
            //writes the content of the buffer to the destination and makes
            //the buffer empty for further data to be stared in
            fileWriter.flush();
            //Closes the stream permenantly 
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Saved...");
    }

    /**
     * when home button is pressed, main menu card shows up
     * @param event 
     */
    public void actionPerformed(ActionEvent event) {
        driver.gotoHome();
    }

}
