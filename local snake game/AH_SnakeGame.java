import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 * @author Anusha Hamy
 * @Version 1.0
 */

public class AH_SnakeGame extends JFrame {
    
    private AH_LoginForm loginForm;

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

}
