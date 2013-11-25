
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class TicTacToeRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String player1;
        String player2;
        TicTacToeGame game = new TicTacToeGame();
        JOptionPane.showMessageDialog(null, "Welcome to TicTacToe!");
        player1 = JOptionPane.showInputDialog("Enter the name for Player 1:");
        player2 = JOptionPane.showInputDialog("Enter the name for Player 2:");
        game.setPlayers(player1, player2);
        JOptionPane.showMessageDialog(null, player1 + " will be X \n" + player2 + " will be O");
        while (game.play) {
            game.playGame();
            game.showWinner();
            game.playAgain();
        }
        game.showHist();
    }

}
