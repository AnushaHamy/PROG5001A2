import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Anusha Hamy
 * @Version 1.0
 */

public class AH_GameBoard extends JPanel {    
    int xcells = 20;    
    int ycells = 20;
    int szcell = 20;      
    Color color;  
    Image img_snake;
    Image img_prey;
    Image img_body;
     
    public AH_GameBoard() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(color.black);
        setFocusable(true);        
    }
    
    /**
     * load prey to board
     */
    public void paintPrey(){
        int width =50;
        int height=50;
        img_prey = new ImageIcon("images/prey.jpg").getImage();
        Dimension size = new Dimension(width, height); 
        setPreferredSize(size);
        
    }
    
    /**
     * load snake to board
     */
    public void paintSnake(){
         int width =100;
         int height=100;
        img_snake = new ImageIcon("images/head.png").getImage();
        img_body = new ImageIcon("images/body.png").getImage();
        Dimension size = new Dimension(width, height); 
        setPreferredSize(size);

    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
             g.setColor(Color.black);
      g.fillRect(10, 10, getWidth(), getHeight());
      
      paintSnake();
      paintPrey();
      
      g.drawImage(img_snake, 300, 150, null); 
      g.drawImage(img_prey, 50, 50, null);
      
      for(int j=0; j<2;j++){
            g.drawImage(img_body,550+(j*300), 150, null);  
        }
   
    }
    
     /**
     * load random apple to board
     */
    public void loadRandomApple(){
    
    }
}
