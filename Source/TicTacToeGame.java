//import statements, allows for audio and visuals to work
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import sun.audio.*;
public class TicTacToeGame extends JPanel implements MouseListener //responds to mouse clicks
{
    //declaration of variables
    AudioStream W;
    AudioStream L;
    AudioStream NC;
    Image title; 
    Image background;
    Image xImage;
    Image oImage;
    Image XWin;
    Image OWin;
    Image TieScreen;
    Image CreditsScreen;
    Image bg;
    Image Select;
    int screen = 1; 
    int players; 
    static int turn = 1;
    int count = 0;
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static int e1 = 0; // called e since mouse event e is already called
    static int f = 0;
    static int g1 = 0; // same thing here
    static int h = 0;
    static int i = 0;
    public static int games[] = {a,b,c,d,e1,f,g1,h,i}; // rather than using the conventional a, b , c I decided to use an array to make the random ai and the impossible ai work efficiently
    boolean difficulty = true;
    public TicTacToeGame()//constructor method
    {
        addMouseListener(this);
        // load all images
        try // loads image if it doesn't work go to catch statement, essentially if it doesn't load it won't crash
        {
            title = ImageIO.read(new File("Title.png"));  
            xImage = ImageIO.read(new File("X Image.png"));
            oImage = ImageIO.read(new File("O Image.png"));
            XWin = ImageIO.read(new File("X Win.png"));
            OWin = ImageIO.read(new File("O Win.png"));
            TieScreen = ImageIO.read(new File("TieScreen.png"));
            CreditsScreen = ImageIO.read(new File("Credits.png"));
            bg = ImageIO.read(new File("Background.png"));
            Select = ImageIO.read(new File("Player Select.png"));
        }
        catch (IOException e)
        {

        }
    }

    public void paint(Graphics g)// canvas method || runs automatically when run
    {
        if(screen == 1) // title screen
        {
            startScreen(g);
        }
        else if(screen == 2)//tic tac toe board
        {
            drawBoard(g);
        }
        else if(screen == 3) //X win screen
        {
            delay(100000);
            drawXWin(g);
        }
        else if(screen == 4) //O Win Screen
        {
            delay(100000);
            drawOWin(g);
        }
        else if(screen == 5) // Tie Screen
        {
            delay(100000);
            drawTie(g);
        }
        else if(screen == 6) // Select Player Screen
        {
            selectPlayer(g);
        }
        else if(screen == 7) // Credits Screen
        {
            credits(g);
        }
    }

    public void startScreen(Graphics g)
    {
        g.drawImage(title,0,0,null);
    }

    public void drawBoard(Graphics g)
    {
        repaint();
        g.drawImage(bg,0,0,null);

        //draws the board's grid in red
        g.setColor(Color.red); 
        g.fillRect(298,0,4,900);
        g.fillRect(598,0,4,900);
        g.fillRect(0,298,900,4);
        g.fillRect(0,598,900,4);

        //the if block below dictates what image to draw and where to draw it based on the elements values, which are attributed through clicking

        if(players == 1)
        {
            if(games[0] == 1)
            {
                g.drawImage(xImage,0,0,null);
            }
            else if(games[0] == 2)
            {
                g.drawImage(oImage,0,0,null);
            }
            if(games[1] == 1)
            {
                g.drawImage(xImage,302,0,null);
            }
            else if(games[1] == 2)
            {
                g.drawImage(oImage,302,0,null);
            }
            if(games[2] == 1)
            {
                g.drawImage(xImage,602,0,null);
            }
            else if(games[2] == 2)
            {
                g.drawImage(oImage,602,0,null);
            }
            if(games[3] == 1)
            {
                g.drawImage(xImage,0,302,null);
            }
            else if(games[3] == 2)
            {
                g.drawImage(oImage,0,302,null);
            }
            if(games[4] == 1)
            {
                g.drawImage(xImage,302,302,null);
            }
            else if(games[4] == 2)
            {
                g.drawImage(oImage,302,302,null);
            }
            if(games[5] == 1)
            {
                g.drawImage(xImage,602,302,null);
            }
            else if(games[5] == 2)
            {
                g.drawImage(oImage,602,302,null);
            }
            if(games[6] == 1)
            {
                g.drawImage(xImage,0,602,null);
            }
            else if(games[6] == 2)
            {
                g.drawImage(oImage,0,602,null);
            }
            if(games[7] == 1)
            {
                g.drawImage(xImage,302,602,null);
            }
            else if(games[7] == 2)
            {
                g.drawImage(oImage,302,602,null);
            }
            if(games[8] == 1)
            {
                g.drawImage(xImage,602,602,null);
            }
            else if(games[8] == 2)
            {
                g.drawImage(oImage,602,602,null);
            } 
        }
        else
        {
            if(games[0] == 1)
            {
                g.drawImage(xImage,0,0,null);
            }
            else if(games[0] == 2)
            {
                g.drawImage(oImage,0,0,null);
            }
            if(games[1] == 1)
            {
                g.drawImage(xImage,302,0,null);
            }
            else if(games[1] == 2)
            {
                g.drawImage(oImage,302,0,null);
            }
            if(games[2] == 1)
            {
                g.drawImage(xImage,602,0,null);
            }
            else if(games[2] == 2)
            {
                g.drawImage(oImage,602,0,null);
            }
            if(games[3] == 1)
            {
                g.drawImage(xImage,0,302,null);
            }
            else if(games[3] == 2)
            {
                g.drawImage(oImage,0,302,null);
            }
            if(games[4] == 1)
            {
                g.drawImage(xImage,302,302,null);
            }
            else if(games[4] == 2)
            {
                g.drawImage(oImage,302,302,null);
            }
            if(games[5] == 1)
            {
                g.drawImage(xImage,602,302,null);
            }
            else if(games[5] == 2)
            {
                g.drawImage(oImage,602,302,null);
            }
            if(games[6] == 1)
            {
                g.drawImage(xImage,0,602,null);
            }
            else if(games[6] == 2)
            {
                g.drawImage(oImage,0,602,null);
            }
            if(games[7] == 1)
            {
                g.drawImage(xImage,302,602,null);
            }
            else if(games[7] == 2)
            {
                g.drawImage(oImage,302,602,null);
            }
            if(games[8] == 1)
            {
                g.drawImage(xImage,602,602,null);
            }
            else if(games[8] == 2)
            {
                g.drawImage(oImage,602,602,null);
            }
        }
        //constantly checks winner since a game can end before the entire board is full
        checkWinner();

    }

    public void drawXWin(Graphics g)
    {
        try
        {
            W = new AudioStream(new FileInputStream("WIN.wav"));
        }
        catch(IOException eb)
        {
        }
        g.drawImage(XWin,0,0,null);
        AudioPlayer.player.start(W);
    }

    public void drawOWin(Graphics g)
    {
        try
        {
            L = new AudioStream(new FileInputStream("LOSS.wav"));
        }
        catch(IOException ec)
        {
        }
        g.drawImage(OWin,0,0,null);
        AudioPlayer.player.start(L);
    }

    public void drawTie(Graphics g)
    {
        try
        {
            NC = new AudioStream(new FileInputStream("TIE.wav"));
        }
        catch(IOException ed)
        {
        }
        g.drawImage(TieScreen,0,0,null);
        AudioPlayer.player.start(NC);
    }

    public void selectPlayer(Graphics g)
    {
        g.drawImage(Select,0,0,null);
    }

    public void credits(Graphics g)
    {
        g.drawImage(CreditsScreen,0,0,null);
    }

    // these return statements cant be values they have to be return tie, or win or loss  
    // this method is used in the intelligent ai, when the bot decides what move to go it creates a scenario with both the x and o, and it determines what move to go
    // based on the score attributed to that move. For example if the bot wants to play in the top left square it will run the algorithm on that move and will determine if its a good move
    // if it negates a win from the human player of it wins. 
    public static int checkrWinner()
    {
        if(games[0]== 1 && games[1] == 1 && games[2] == 1)
        {
            return 0;
        }
        else if(games[3] == 1 && games[4] == 1 && games[5] == 1)
        {
            return 0;
        }
        else if(games[6] == 1 && games[7] == 1 && games[8] == 1)
        {
            return 0;
        }
        else if(games[0] == 1 && games[3] == 1 && games[6] == 1)
        {
            return 0;
        }
        else if(games[1] == 1 && games[4] == 1 && games[7] == 1)
        {
            return 0;
        }
        else if(games[2] == 1 && games[5] == 1 && games[8] == 1)
        {
            return 0;
        }
        else if(games[0] == 1 && games[4] == 1 && games[8] == 1)
        {
            return 0;
        }
        else if(games[2] == 1 && games[4] == 1 && games[6] == 1)
        {
            return 0;
        }

        else if(games[0] == 2 && games[1] == 2 && games[2] == 2)
        {
            return 1;
        }
        else if(games[3] == 2 && games[4] == 2 && games[5] == 2)
        {
            return 1;
        }
        else if(games[6] == 2 && games[7] == 2 && games[8] == 2)
        {
            return 1;
        }
        else if(games[0] == 2 && games[3] == 2 && games[6] == 2)
        {
            return 1;
        }
        else if(games[1] == 2 && games[4] == 2 && games[7] == 2)
        {
            return  1;
        }
        else if(games[2] == 2 && games[5] == 2 && games[8] == 2)
        {
            return 1;
        }
        else if(games[0] == 2 && games[4] == 2 && games[8] == 2)
        {
            return 1;
        }
        else if(games[2] == 2 && games[4] == 2 && games[6] == 2)
        {
            return 1;
        }

        else if(games[0]!= 0 && games[1]!= 0 && games[2]!= 0 && games[3]!= 0 && games[4]!= 0 && games[5]!= 0 && games[6]!= 0 && games[7]!= 0 && games[8]!=0)
        {
            return 2;
        }
        return 3;
    }
    //this method simply checks all the ways someone can win
    public void checkWinner()
    {
        if(games[0]== 1 && games[1] == 1 && games[2] == 1)
        {
            repaint();
            screen = 3; // player 1 wins
        }
        else if(games[3] == 1 && games[4] == 1 && games[5] == 1)
        {
            repaint();
            screen = 3;
        }
        else if(games[6] == 1 && games[7] == 1 && games[8] == 1)
        {
            repaint();
            screen = 3;
        }
        else if(games[0] == 1 && games[3] == 1 && games[6] == 1)
        {
            repaint();
            screen = 3;
        }
        else if(games[1] == 1 && games[4] == 1 && games[7] == 1)
        {
            repaint();
            screen = 3;
        }
        else if(games[2] == 1 && games[5] == 1 && games[8] == 1)
        {
            repaint();
            screen = 3;
        }
        else if(games[0] == 1 && games[4] == 1 && games[8] == 1)
        {
            screen = 3;
        }
        else if(games[2] == 1 && games[4] == 1 && games[6] == 1)
        {
            repaint();
            screen = 3;
        }

        //check if player 2 wins
        else if(games[0] == 2 && games[1] == 2 && games[2] == 2)
        {
            repaint();
            screen = 4; 
        }
        else if(games[3] == 2 && games[4] == 2 && games[5] == 2)
        {
            repaint();
            screen = 4;

        }
        else if(games[6] == 2 && games[7] == 2 && games[8] == 2)
        {
            repaint();
            screen = 4;

        }
        else if(games[0] == 2 && games[3] == 2 && games[6] == 2)
        {
            repaint();
            screen = 4;

        }
        else if(games[1] == 2 && games[4] == 2 && games[7] == 2)
        {
            repaint();
            screen = 4;

        }
        else if(games[2] == 2 && games[5] == 2 && games[8] == 2)
        {
            repaint();
            screen = 4;

        }
        else if(games[0] == 2 && games[4] == 2 && games[8] == 2)
        {
            repaint();
            screen = 4;

        }
        else if(games[2] == 2 && games[4] == 2 && games[6] == 2)
        {
            repaint();
            screen = 4;

        }

        else if(games[0]!= 0 && games[1]!= 0 && games[2]!= 0 && games[3]!= 0 && games[4]!= 0 && games[5]!= 0 && games[6]!= 0 && games[7]!= 0 && games[8]!= 0)
        {
            repaint();
            screen = 5;

        }
    }

    public void mouseClicked(MouseEvent e)
    {

    }
    // this method uses the x and y cooridanates to determine where the human has clicked
    public void mousePressed(MouseEvent e)
    {
        int x = e.getX(); 
        int y = e.getY();
        if(screen == 1) // on the title screen
        {
            if(x>=70 && x<= 390 && y>= 510 && y<=635) 
            {
                screen = 6;
            }
            if(x >= 510 && x<= 830 && y >= 510 && y<=635)
            {
                screen = 2;
                players = 2;
            }
            if(x >= 285 && x<=610 && y>= 705 && y<= 830)
            {
                screen = 7;
            }
        }

        else if(screen == 2 && players == 2) 
        {
            if(x<= 300 && y <300 && games[0] == 0)//clicked on box a
            {
                if(turn == 1)
                {
                    games[0] = 1;
                    turn = 2;
                }
                else
                {
                    games[0] = 2;
                    turn = 1;
                }
            }
            if(x>=300 && x<=600 && y >= 0 && y <=300 && games[1] == 0)
            {
                if(turn == 1)
                {
                    games[1] = 1;
                    turn = 2;
                }
                else
                {
                    games[1] = 2;
                    turn = 1;
                }
            }
            if(x>=600 && x<=900 && y >= 0 && y <=300 && games[2] == 0)
            {
                if(turn == 1)
                {
                    games[2] = 1;
                    turn = 2;
                }
                else
                {
                    games[2] = 2;
                    turn = 1;
                }
            }
            if(x>=0 && x<=300 && y >= 300 && y <=600 && games[3] == 0)
            {
                if(turn == 1)
                {
                    games[3] = 1;
                    turn = 2;
                }
                else
                {
                    games[3] = 2;
                    turn = 1;
                }
            }
            if(x>=300 && x<=600 && y >= 300 && y <=600 && games[4] == 0)
            {
                if(turn == 1)
                {
                    games[4] = 1;
                    turn = 2;
                }
                else
                {
                    games[4] = 2;
                    turn = 1;
                }
            }
            if(x>=600 && x<=900 && y >= 300 && y <=600 && games[5] == 0)
            {
                if(turn == 1)
                {
                    games[5] = 1;
                    turn = 2;
                }
                else
                {
                    games[5] = 2;
                    turn = 1;
                }
            }
            if(x>=0 && x<=300&& y >= 600 && y <=900 && games[6] == 0)
            {
                if(turn == 1)
                {
                    games[6] = 1;
                    turn = 2;
                }
                else
                {
                    games[6] = 2;
                    turn = 1;
                }
            }
            if(x>=300 && x<=600&& y >= 600 && y <=900 && games[7] == 0)
            {
                if(turn == 1)
                {
                    games[7] = 1;
                    turn = 2;
                }
                else
                {
                    games[7] = 2;
                    turn = 1;
                }
            }
            if(x>=600 && x<=900&& y >= 600 && y <=900 && games[8] == 0)
            {
                if(turn == 1)
                {
                    games[8] = 1;
                    turn = 2;
                }
                else
                {
                    games[8] = 2;
                    turn = 1;
                }
            }
        }
        else if(screen == 6)
        {
            if(x<= 90 && x>= 0 && y<= 37 && y>= 0)
            {
                init();
            }
            if(x>= 270 && x<=630 && y>= 372 && y<= 500)
            {
                screen = 2;
                players = 1;
                difficulty = false;

            }
            if(x>= 270 && x<=630 && y>= 565 && y<=693)
            {
                screen = 2;
                players = 1;
                difficulty = true;

            }
        }

        else if(screen == 2 && players == 1 && difficulty == true) 
        {
            if(x<= 300 && y <300 && games[0] == 0)
            {
                if(turn == 1)
                {
                    games[0] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=300 && x<=600 && y >= 0 && y <=300 && games[1] == 0)
            {
                if(turn == 1)
                {
                    games[1] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=600 && x<=900 && y >= 0 && y <=300 && games[2] == 0)
            {
                if(turn == 1)
                {
                    games[2] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=0 && x<=300 && y >= 300 && y <=600 && games[3] == 0)
            {
                if(turn == 1)
                {
                    games[3] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=300 && x<=600 && y >= 300 && y <=600 && games[4] == 0)
            {
                if(turn == 1)
                {
                    games[4] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=600 && x<=900 && y >= 300 && y <=600 && games[5] == 0)
            {
                if(turn == 1)
                {
                    games[5] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=0 && x<=300&& y >= 600 && y <=900 && games[6] == 0)
            {
                if(turn == 1)
                {
                    games[6] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=300 && x<=600&& y >= 600 && y <=900 && games[7] == 0)
            {
                if(turn == 1)
                {
                    games[7] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=600 && x<=900&& y >= 600 && y <=900 && games[8] == 0)
            {
                if(turn == 1)
                {
                    games[8] = 1;
                    repaint();
                    turn = 2;
                }
            }
            repaint();
            boolean result = gameState();
            boolean condition = xresult();
            if(turn == 2 && result == false && screen != 3 && condition == false)
            {
                AiMove();
            }

        }
        else if(screen == 2 && players == 1 && difficulty == false) // on the playing board and 1 player
        {
            if(x<= 300 && y <300 && games[0] == 0)//clicked on box a
            {
                if(turn == 1)
                {
                    games[0] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=300 && x<=600 && y >= 0 && y <=300 && games[1] == 0)
            {
                if(turn == 1)
                {
                    games[1] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=600 && x<=900 && y >= 0 && y <=300 && games[2] == 0)
            {
                if(turn == 1)
                {
                    games[2] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=0 && x<=300 && y >= 300 && y <=600 && games[3] == 0)
            {
                if(turn == 1)
                {
                    games[3] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=300 && x<=600 && y >= 300 && y <=600 && games[4] == 0)
            {
                if(turn == 1)
                {
                    games[4] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=600 && x<=900 && y >= 300 && y <=600 && games[5] == 0)
            {
                if(turn == 1)
                {
                    games[5] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=0 && x<=300&& y >= 600 && y <=900 && games[6] == 0)
            {
                if(turn == 1)
                {
                    games[6] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=300 && x<=600&& y >= 600 && y <=900 && games[7] == 0)
            {
                if(turn == 1)
                {
                    games[7] = 1;
                    repaint();
                    turn = 2;
                }
            }
            if(x>=600 && x<=900&& y >= 600 && y <=900 && games[8] == 0)
            {
                if(turn == 1)
                {
                    games[8] = 1;
                    repaint();
                    turn = 2;
                }
            }
            repaint();
            boolean result = gameState();
            boolean condition = xresult();
            if(turn == 2 && result == false && condition == false)
            {
                computerMoverRand();
            }
        }
        else if(screen == 3)
        {
            if(x<= 730 &&  x>= 160 && y<= 700  && y>=490)
            {
                init();
            }
            else
            {
                AudioPlayer.player.stop(W);
            }
        }
        else if(screen == 4)
        {
            if(x<= 730 &&  x>= 160 && y<= 700  && y>=490)
            {
                init();
            }
            else
            {
                AudioPlayer.player.stop(L);
            }
        }
        else if(screen == 5)
        {
            if(x<= 730 &&  x>= 160 && y<= 700  && y>=490)
            {
                init();
            }
            else
            {
                AudioPlayer.player.stop(NC);
            }
        }
        else if(screen == 7)
        {
            if(x<= 90 && x>= 0 && y<= 37 && y>= 0)
            {
                init();
            }
        }

        repaint();
    }

    public void mouseReleased(MouseEvent e)
    {

    }

    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseExited(MouseEvent e)
    {

    }
    // this method is called if the player chooses the easy difficulty after selecting one player
    // this method simply generates a random number and places an O from the number generated.
    // if the spot generated by the random number is taken, the loop runs again and generates another number
    public void computerMoverRand()
    {
        // change to 1000
        int x = (int)(9 * Math.random() + 0);
        for(int i=0;i<1000; i++)
        {
            if(games[x] == 0)
            {
                games[x] = 2;
                turn = 1;
                break;
            }
            else
            {
                x = (int)(9 * Math.random() + 0);
            }
        }
        turn = 1;
    }

    // the next two methods compose the impossible ai
    public void AiMove()
    {
        int bestScore = Integer.MAX_VALUE; //this variable is set to the max value since it will be redefined to compare each possible move.
        int move = 0;
        for(int i=0; i<9; i++) // this for loop wil run "9" times, essentially goes through the board checking through all possible spaces to put an O in
        {
            if(games[i] == 0 && games[i] != 1) // this if statement checks if a spot is open
            {
                games[i] = 2; // it will temporarily put an o in the first available spot
                int score = computer(games,false); //it then runs the function on the board with the o at that spot
                games[i] = 0; // it then erases that temporary o
                if(score < bestScore) // after the function has been called it returns score, and this if statement will always be true on the first iteration, but after going through the loop it keeps comapring the scores until it fines the best possible one
                {
                    bestScore = score; // instead of bestscore being the smallest integer, it becomes the seemingly best score
                    move = i;
                }
            }
        }
        games[move] = 2; // places the o at the spot with the highest win rate
        turn = 1;
    }

    public static int computer(int num[],boolean turn)
    {
        int result = checkrWinner(); // this calls the other "checkwinner" function, it returns either a 0, 1,2 or 3 which essentially correlates with the values in score, if x wins the result is one if o wins the result is -1 and if it's a tie the result is 0
        int X = 1;
        int O = -1;
        int tie = 0;
        int[] scores = {X,O,tie};
        //this is the terminal state
        if(result!=3) //if the result is a game end state, either a win, loss or a tie
        {
            return scores[result]; 
        }
        //the next two if statements are essentially the AiMove function, they run recursively to find the bestScore, however they shift each time for the next turn
        if(turn) // runs it for the o
        {
            int bestScore = Integer.MAX_VALUE;
            for(int i=0; i<9; i++)
            {
                if(games[i] == 0)
                {
                    games[i] = 2;
                    int score = computer(games,false);
                    games[i] = 0;
                    if(score < bestScore)
                    {
                        bestScore = score; 
                    }
                }
            }
            return bestScore;
        }
        else // aims to find the least optimal score for the x
        {
            int bestScore = Integer.MIN_VALUE;
            for(int i=0; i<9; i++)
            {
                if(games[i] == 0)
                {
                    games[i] = 1;
                    int score = computer(games,true); 
                    games[i] = 0;
                    if(score > bestScore)
                    {
                        bestScore = score; 
                    }
                }
            }
            return bestScore;
        }
    }
    // this function prints a series of numbers to emulate a delay, used before calling a game result screen. 
    public void delay(int n)
    {
        for(int i = 0; i<n;i++)
        {
            System.out.println(i);
        }
    }
    //I had to implement a gamestate function since the bot would run even after the board was full, ultimately creating wrong loss/tie screens
    public boolean gameState()
    {
        int total = 0;
        for(int i = 0; i<9; i++)
        {
            if(games[i] != 0)
            {
                total++;
            }
        }
        if(total == 9)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // this is the initialization function, essentially when this method is called it wipes all of the variables allowing the player to play another game of tic tac toe or simply go back to the first screen
    public void init()
    {
        games[0] = 0;
        games[1] = 0;
        games[2] = 0;
        games[3] = 0;
        games[4] = 0;
        games[5] = 0;
        games[6] = 0;
        games[7] = 0;
        games[8] = 0;
        screen = 1;
        turn = 1;
        AudioPlayer.player.stop(W);
        AudioPlayer.player.stop(L);
        AudioPlayer.player.stop(NC);
    }
    //this function replicates the checkwinner function purely for the human player, and it is called whenever the game is about to end, it ensures that the o does not move
    //after the game is over
    public boolean xresult()
    {
        if(games[0]== 1 && games[1] == 1 && games[2] == 1)
        {
            return true;
        }
        else if(games[3] == 1 && games[4] == 1 && games[5] == 1)
        {
            return true;
        }
        else if(games[6] == 1 && games[7] == 1 && games[8] == 1)
        {
            return true;
        }
        else if(games[0] == 1 && games[3] == 1 && games[6] == 1)
        {
            return true;
        }
        else if(games[1] == 1 && games[4] == 1 && games[7] == 1)
        {
            return true;
        }
        else if(games[2] == 1 && games[5] == 1 && games[8] == 1)
        {
            return true;
        }
        else if(games[0] == 1 && games[4] == 1 && games[8] == 1)
        {
            return true;
        }
        else if(games[2] == 1 && games[4] == 1 && games[6] == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}