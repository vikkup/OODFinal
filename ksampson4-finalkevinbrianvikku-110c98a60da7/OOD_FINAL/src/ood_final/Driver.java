/*
 * Driver.java
 * Author: Kevin, Brian, Vikku
 * Date: December 3, 2020
 * Course: CSC2620
 * Description: Contains the main class and lays out the menu
 */
package ood_final;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Brian
 */
public class Driver extends JFrame {

    //Private Variables
    private BattleField battleField;
    private Home home;
    private ScoreBoard board;
    private JPanel cards;
    private CardLayout cardLayout;

    final private String FIELD = "field";
    final private String HOME = "home";
    final private String BOARD = "board";
    final private String TITLE = "X Wing Defender";

    /**
     * Default constructor that initializes the intitUI
     */
    public Driver() {

        initUI();
    }

    /**
     * This method creates a cardlayout that allows the user to pick between
     * home, battlefield(the game), and the scoreboard.
     */
    private void initUI() {

        cardLayout = new CardLayout();

        cards = new JPanel(cardLayout);
        this.add(cards);

        //It also creates instances of home, battlefield, and home
        battleField = new BattleField(this);
        home = new Home(this);
        board = new ScoreBoard(this);

        //Adds the cards to the layout
        cards.add(battleField, FIELD);
        cards.add(home, HOME);
        cards.add(board, BOARD);

        //Displays the layout 
        cardLayout.show(cards, HOME);

        //Sets the title
        setTitle(TITLE);

        //Initializes the height and width
        setSize(Config.FIELD_WIDTH, Config.FIELD_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Displays the home on the cardlayout
     */
    public void gotoHome() {
        cardLayout.show(cards, HOME);
    }

    /**
     * Sets the the field up(torpedo timers and rebels) and displays on the
     * cardlayout
     *
     * @param name
     */
    public void gotoField(String name) {
        battleField.fieldSetUp(name);
        cardLayout.show(cards, FIELD);
    }

    /**
     * Load the scoreboard and display it on the cardlayout
     */
    public void gotoBoard() {
        board.loadData();
        cardLayout.show(cards, BOARD);
    }

    /**
     * Gets the information on the scoreboard
     *
     * @return board
     */
    public ScoreBoard getBoard() {
        return board;
    }

    /**
     * Main that updates the GUI
     *
     * @param args
     */
    public static void main(String[] args) {

        //Processes all the GUI event processes 
        EventQueue.invokeLater(() -> {

            var ex = new Driver();
            ex.setVisible(true);
        });
    }
}
