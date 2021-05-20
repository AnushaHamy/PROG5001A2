import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.Image; 
import javax.swing.ImageIcon; 
import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.Timer;

/**
 * @author Anusha Hamy
 * @Version 4.0
 */

public class AH_GameBoard extends JPanel implements ActionListener{    
    
    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    
    private final int ALL_DOTS = 1200;
    private final int DOT_SIZE = 30;
    private final int DELAY = 140;
    
    
     private final int RAND_POS = 29;
    
    int width;
    int height;
    
    private int dots;
    private Timer timer;
    
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    
    Color color;  
    Image img_snake;
    Image img_body;
  
    private int prey_x;
    private int prey_y;
    
    private AH_Snake snake;
    private AH_Prey prey;
    
     
    public AH_GameBoard() {
        addKeyListener(new TAdapter());
        setBackground(color.black);
        setFocusable(true);
        
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));  
        loadPictures();
        initGame();
    }
    
  

    
    @Override
    public void paintComponent(Graphics g) {
     super.paintComponent(g);
     doDrawing(g);
     //prey.doDrawing(g);
   
    }
    
    
    
    /**
     * load the objects from AH_Snake and AH_Prey class
     */
    private void loadPictures(){
    
       prey  = new AH_Prey();
       
       snake = new AH_Snake();
       img_snake = snake.img_snake;
       img_body = snake.img_body;
       
    
    
    }
    
    
    private void checkPrey() {
        
        if ((x[0] == prey_x) && (y[0] == prey_y)) {

            dots++;
            prey.locatePrey();
        }
        
    }
    
    
    /**
     * draw the snake and prey
     */
      private void doDrawing(Graphics g) {
        
        if (inGame) {

            //load prey
            prey.doDrawing(g);
            //snake.paintSnake(g);
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(img_snake, x[z], y[z], this);
                } else {
                    g.drawImage(img_body, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            //gameOver(g);
        }        
    }
    
    /**
     * load the panel to board
     */
     public static void main(String args[]) {
       JFrame frame = new JFrame("My Snake Game");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       AH_GameBoard panel = new AH_GameBoard();
       frame.add(panel);
       
       frame.setSize(500, 500);
       frame.setResizable(false); 
    
       frame.setVisible(true);
    }

    
        /**
     * change the snake and prey
     */
      private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        //AH_Prey prey = new Prey();
        prey.locatePrey();

        timer = new Timer(DELAY,this);
        timer.start();
    }
    
    
    
        // /**
     // * locate the prey in random location
     // */
        // public void locatePrey() {

        // int r = (int) (Math.random() * RAND_POS);
        // prey_x = ((r * DOT_SIZE));

        // r = (int) (Math.random() * RAND_POS);
        // prey_y = ((r * DOT_SIZE));
    // }
    
          @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkPrey();
            checkCollision();
            move();
        }

        repaint();
    }
    
        private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }
    
        private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }
    }
    
    /**
     * control the snake moving directions
     */
      private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
