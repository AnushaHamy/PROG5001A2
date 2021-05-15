import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Anusha Hamy
 * @Version 1.0
 */

public class AH_SnakeGame extends JFrame {
    
    private AH_LoginForm loginForm;
    private AH_Snake snake;
    private AH_GameBoard board;
    private JLabel labelTopScore; 
    private JLabel labelCurrentScore; 
    private JLabel labelname; 
    private JLabel labelimg; 
    private JButton buttonQuit; 
    private ImageIcon imageSnake;

    public AH_SnakeGame() {        
        LayoutManagers();
        setTitle("My Snake Game © Anusha_Hamy");
        setResizable(false);    
        
    }
    
    public static void main(String[] args) {    
        
        EventQueue.invokeLater(() -> {
          //create the game with a game title as follow: The Snake Game (C) Your_Name
          AH_LoginForm loginForm = new AH_LoginForm();
          loginForm.setVisible(true);
          loginForm.setTitle("The Snake Game © Anusha_Hamy");
          AH_GameBoard board = new AH_GameBoard();
          board.setVisible(true);

        });
    }

    public void LayoutManagers(){
    
               
        labelTopScore = new JLabel("Top Player's Score "); 
        labelCurrentScore = new JLabel("Current Players Score ");
        labelname = new JLabel("PROG5001: 2021"+ '\n'+"Name: Anusha");
        imageSnake = new ImageIcon ("images/snake.jpg");
        labelimg = new JLabel (imageSnake);
        buttonQuit = new JButton("Quit");
        
        
        
        //add game to panel;
        AH_GameBoard board = new AH_GameBoard();
        
        // create a new panel with GridBagLayout manager 
        JPanel SnakeGame = new JPanel(new GridBagLayout()); 
        
        // use GridBagConstraints to control the grid appearance 
        GridBagConstraints constraints = new GridBagConstraints(); 
        
        // add components to the panel 
        
        board.setSize(400,300);
        constraints.gridx=1;
        constraints.gridy=1;
        SnakeGame.add(board, constraints);
        
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx=10;
        constraints.ipady=1;
        constraints.gridx = 2; 
        constraints.gridy = 0;      
        SnakeGame.add(labelTopScore, constraints);
        
        constraints.fill = GridBagConstraints.VERTICAL;
        //constraints.weightx=50;
        constraints.gridx = 2; 
        constraints.gridy = 2;      
        SnakeGame.add(labelCurrentScore, constraints);
        
        constraints.fill = GridBagConstraints.VERTICAL;
        //constraints.weightx=20;
        //constraints.gridwidth=40;
        constraints.gridx = 2; 
        constraints.gridy = 1;      
        SnakeGame.add(labelimg, constraints);
        
        constraints.fill = GridBagConstraints.VERTICAL;
        //constraints.weightx=20;
        //constraints.gridwidth=40;
        constraints.gridx = 2; 
        constraints.gridy = 3;      
        SnakeGame.add(labelname, constraints);
        
        
        
        constraints.fill = GridBagConstraints.VERTICAL;
        //constraints.weightx=50;
        constraints.gridx = 2; 
        constraints.gridy = 4;      
        SnakeGame.add(buttonQuit, constraints);
        
        // add the panel to this frame 
        add(SnakeGame); 
        //SnakeGame.setSize(180,160);
        pack(); 
        setLocationRelativeTo(null); 
        
        
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
