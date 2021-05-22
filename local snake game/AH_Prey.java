
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel; 
import javax.swing.ImageIcon; 
import javax.swing.JFrame; 
/**
 * Class Prey represents any prey object.
 *
 * @author Anusha Hamy
 * @version 5.0
 */
public class AH_Prey extends JPanel{
    
       Image img;
        int prey_x;
        int prey_y;
       
       private int dots;
    
       int DOT_SIZE = 40;
      private final int RAND_POS = 14;
      
    /**
     * Constructor for objects of class Prey
     */
    public AH_Prey()
    {
         img = new ImageIcon("images/prey.png").getImage();
    }   
    
    
    /**
     * locate the prey in random location
     */
        public void locatePrey() {
         
            
        int r = (int) (Math.random() * RAND_POS);
        prey_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        prey_y = ((r * DOT_SIZE));
        
        
        
    }
    
    /**
     * load prey random in board
     */
    public void doDrawing(Graphics g){
        
        g.drawImage(img, prey_x, prey_y, this);
        
    
    }
   
    
}


