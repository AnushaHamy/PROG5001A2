import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Write a description of class Snake here.
 *
 * @author Anusha Hamy
 * @version 5.0
 */
public class AH_Snake
{
    
    Image img_snake;
    Image img_body;

    /**
     * Constructor for objects of class Snake
     */
    public AH_Snake() {
        // initialise instance variables     
          //img_snake = new ImageIcon("images/head.png").getImage();
          //img_body = new ImageIcon("images/body.png").getImage();
          loadSnake();
    }

    /**
     * load images of the snake
     */
    public void loadSnake(){
           
           
          img_snake = new ImageIcon("images/head.png").getImage();
          img_body = new ImageIcon("images/body.png").getImage();
    
      
    
    }
    

}
