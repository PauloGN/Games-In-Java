import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static int WIDTH = 480, HEIGHT = 480;

    public Game(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //=======================================      Game Core

    public void tick(){

    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //Full screen
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.red);
        g.fillRect(100,100,50,50);

        bs.show();
    }

    private void force60FPS(){
        try {
            Thread.sleep(1000/60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
    }//end Main


    //===================================   Coming from runnable
    @Override
    public void run() {

        while(true) {

            tick();
            render();
            force60FPS();
            System.out.println("Game loop");
        }
    }

}