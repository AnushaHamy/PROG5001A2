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
 * @Version 5.0
 */

public class AH_GameBoard extends JPanel implements ActionListener{    
    
    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    
    private final int ALL_DOTS = 1200;
    private final int DELAY = 140;
    
    
    
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
    private boolean inGame = false;
    private boolean gamePaused = false;
    
    Color color;  
    Image img_head;
    Image img_body;
    Image img_prey;
  
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
   
    }
    
    
    
    /**
     * load the objects from AH_Snake and AH_Prey class
     */
    private void loadPictures(){
    
       prey  = new AH_Prey();
       img_prey =prey.img;
       
       snake = new AH_Snake();
       img_head = snake.img_snake;
       img_body = snake.img_body;
       
    
    
    }
    
    
    private void checkPrey() {
        
        if ((x[0] == prey.prey_x) && (y[0] == prey.prey_y)) {

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
             g.drawImage(img_prey, prey.prey_x, prey.prey_y, this);
            
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(img_head, x[z], y[z], this);
                } else {
                    g.drawImage(img_body, x[z], y[z], this);
                }
            }
            gamePaused=true;
            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
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
       
    
       frame.setVisible(true);
    }

    
        /**
     * change the snake and prey
     */
      private void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 40 - z * 1;
            y[z] = 40;
        }
        
        //AH_Prey prey = new Prey();
        prey.locatePrey();

        timer = new Timer(DELAY,this);
        timer.start();
    }
    
    
    
       
    
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
            x[0] -= prey.DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += prey.DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= prey.DOT_SIZE;
        }

        if (downDirection) {
            y[0] += prey.DOT_SIZE;
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
     * game over
     */
        private void gameOver(Graphics g) {
         
             if (gamePaused=!gamePaused){
             String msg_2 = "Press Space Bar to Start the Game!!";
             Font small = new Font("Helvetica", Font.BOLD, 16);
             FontMetrics metr = getFontMetrics(small);
             g.setColor(Color.white);
             g.setFont(small);
             g.drawString(msg_2, (B_WIDTH - metr.stringWidth(msg_2)) / 2, B_HEIGHT / 2);
             gamePaused=false;
            
            }else {
              String msg_3 = "Game Over";
              Font small = new Font("Helvetica", Font.BOLD, 14);
              FontMetrics metr = getFontMetrics(small);
        
              g.setColor(Color.white);
              g.setFont(small);
              g.drawString(msg_3, (B_WIDTH - metr.stringWidth(msg_3)) / 2, B_HEIGHT / 2);
            
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
            
                 if(key == KeyEvent.VK_SPACE){
                
                     if (inGame) {//If the game is over, press the space bar to restart the game
                     gamePaused = false;
                     inGame = false;

                      
                    } else {
                     inGame = !inGame;//If the game is not over, press the space to pause, press the space again to resume
                     gamePaused=true;
                    }
                 
                }
        }
    }
}
