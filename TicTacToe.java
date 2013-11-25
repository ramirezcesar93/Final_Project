
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    //CONSTRUCTOR
    public TicTacToe() {
        //Create Window with a 3 by 3 grid
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3, 3));
        for (int i= 0; i <= 8; i++) {
            buttons[i] = new JButton();
            window.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        //Add Buttons To The Window
        window.setVisible(true);
    }

    private int[][] winCombinations = new int[][]{
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //verticle wins
        {0, 4, 8}, {2, 4, 6} //diagonal wins
    };
    private JFrame window = new JFrame("Tic-Tac-Toe");
    private JButton buttons[] = new JButton[9];
    private int winner;
    private int count = 0;
    private String letter = "";
    private boolean win = false;
    private boolean run=true;

    /**
     * Overrides the method for actionListener When an object is clicked,
     * perform an action. a is action event object
     *
     * @param a
     */
    @Override
    public void actionPerformed(ActionEvent a) {
        count++;

        //Calculate whose turn it is
        if (count % 2 == 0) {
            letter = "O";//player2
        } else {
            letter = "X";//player1
        }

        //Write the letter to the button and deactivate it
        JButton pressedButton = (JButton) a.getSource();
        pressedButton.setText(letter);
        pressedButton.setEnabled(false);

        //Determine who won
        for (int i = 0; i <= 7; i++) {
            if (buttons[winCombinations[i][0]].getText().equals(buttons[winCombinations[i][1]].getText())
                    && buttons[winCombinations[i][1]].getText().equals(buttons[winCombinations[i][2]].getText())
                    && !"".equals(buttons[winCombinations[i][0]].getText())) {
                win = true;
            }
        }

        if (win == true) {
            if ("X".equals(letter)) {
                winner=1;//player1
            } else {
                winner=2;//player2
            }
            run=false;
            System.exit(0);
        } else if (count == 9 && win == false) {
            winner=0;
            run =false;
            System.exit(0);
        }
    }
    public int getWinner(){
        return winner;
    }
    public boolean getRun(){
        return run;
    }

}
