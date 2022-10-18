/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vikku
 */
public class LeaderBoard extends JPanel implements ActionListener {

    private Driver driver;
    private Button playButton;
    JTable table;
 

    public LeaderBoard(Driver driver) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        table = new JTable();
        this.add(table);

        this.driver = driver;
        playButton = new Button("Home");
        playButton.addActionListener(this);
        this.add(playButton);
    }

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

    public void actionPerformed(ActionEvent event) {
        driver.gotoHome();
    }

}