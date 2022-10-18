package finalproject;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @author Brian
*/
public class Driver extends JFrame  {

    private BattleField battleField;
    private Home home;
    private LeaderBoard board;
    private JPanel cards;
    private CardLayout cardLayout;

    final private String FIELD = "field";
    final private String HOME = "home";
    final private String BOARD = "board";

     final private String TITLE = "Star Wars";


    public Driver() {

        initUI();
    }

    private void initUI() {

        cardLayout = new CardLayout();

        cards = new JPanel(cardLayout);
        this.add(cards);

        battleField = new BattleField(this);
        home = new Home(this);
        board = new LeaderBoard(this);

        cards.add(battleField,FIELD);
        cards.add(home, HOME);
        cards.add(board, BOARD);

        cardLayout.show(cards,HOME);

        setTitle(TITLE);
        setSize(Config.FIELD_WIDTH, Config.FIELD_HEIGHT);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void gotoHome(){
        cardLayout.show(cards, HOME);
    }

    public void gotoField(){
        battleField.fieldSetUp();
        cardLayout.show(cards, FIELD);
    }

    public void gotoBoard(){
        board.loadData();
        cardLayout.show(cards, BOARD);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new Driver();
            ex.setVisible(true);
        });
    }
}