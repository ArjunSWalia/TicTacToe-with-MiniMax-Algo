import javax.swing.JFrame;


public class Main
{
    public static void main(String...args)
    {
        JFrame frame = new JFrame();
        frame.setBounds(0,0, 900 ,900);// sets boundaries, 900 by 900 frame
        frame.setTitle("Tic Tac Toe || Arjun Walia");
        frame.setResizable(false); //can't resize the window when playing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // if you click x it will close the game
        
        
        TicTacToeGame game = new TicTacToeGame();
        frame.add(game);
        frame.setVisible(true);
    }
}