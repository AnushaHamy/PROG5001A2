import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 * @author Anusha Hamy
 * @Version 1.0
 */

public class AH_SnakeGame extends JFrame {
    
    private AH_LoginForm loginForm;
    private AH_Snake snake;
    private AH_GameBoard board;

    public AH_SnakeGame(String gameTille) {        
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();     
        
    }
    
    public static void main(String[] args) {    
        
        EventQueue.invokeLater(() -> {
        //create the game with a game title as follow: The Snake Game (C) Your_Name
        AH_LoginForm loginForm = new AH_LoginForm();
        loginForm.setVisible(true);
        loginForm.setTitle("The Snake Game (C) Anusha_Hamy");

        });
    }

     /**
     * load snake to board
     */
    public void setSnake(){
    
    }
    
    /**
     * Get moving directons of snake
     */
    public void setDirection(){
    
    }
    
    
     /**
     * set game over if snake hit the wall
     */
    public void setGameOver(){
    
    }
}
