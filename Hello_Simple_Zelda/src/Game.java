import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    public static int WIDTH = 480, HEIGHT = 480;

    public Game(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //==================================        Main Function

    public static void main(String[] args) {
        //Instantiate the class
        Game game = new Game();
        //new window
        JFrame frame = new JFrame();
        // add the game class to the window
        frame.add(game);
        frame.setTitle("Mini Zelda");
        //Pack, centralize the window, tell it to close the application and show while active
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    //=======================================       Game states

        new Thread(game).start();

    }


    //===================================       Coming from runnable
    @Override
    public void run() {

        while(true) {


            System.out.println("Game loop");
        }
    }

}