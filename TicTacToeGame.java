
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TicTacToeGame {

    private int winner;//store winner
    private int games = 0;//game count
    public boolean play;
    private String player1;
    private String player2;
    private int arrayCount = 0;
    String[] history = new String[100];

    public TicTacToeGame() {
        play = true;
    }

    public void setPlayers(String p1, String p2) {
        player1 = p1;
        player2 = p2;
    }

    public void playGame() {
        games++;
        TicTacToe game = new TicTacToe();
        if (game.getRun() == false) {
            winner = game.getWinner();
        }
    }
    public void showWinner(){
        if (winner == 1) {
                JOptionPane.showMessageDialog(null, player1 + " was the winner!");
                history[arrayCount] = player1;
            } else if (winner == 2) {
                JOptionPane.showMessageDialog(null, player2 + " was the winner!");
                history[arrayCount] = player2;
            } else {
                JOptionPane.showMessageDialog(null, "The game was a tie!");
                history[arrayCount] = "Tied";
            }
    }
    public void playAgain(){
        int num = Integer.parseInt(JOptionPane.showInputDialog("Do you want to play again? Enter 1 for yes 0, 0 for no"));
            if (num == 0) {
                play = false;
            }
    }
    public void showHist(){
        for (int i=0;i<games;i++){
            JOptionPane.showMessageDialog(null, "On game "+ (i+1)+ " the winner was "+ history[i]);
        }
    }

}
