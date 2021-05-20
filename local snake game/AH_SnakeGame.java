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
 * @Version 4.0
 */

public class AH_SnakeGame extends JFrame {
    
    private AH_LoginForm loginForm;
    //private AH_Snake snake;
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
        //setSize(800,500);
        setResizable(false); 
        pack();
        
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
        labelname = new JLabel("PROG5001:"+ '\n'+" 2021 name: Anusha");//
        imageSnake = new ImageIcon ("images/snake.jpg");
        labelimg = new JLabel (imageSnake);
        buttonQuit = new JButton("Quit");
    
        //AH_SnakeGame Game = new AH_SnakeGame();
        
        //Color color;
        JPanel SnakeGame = new JPanel();
        //add game to panel;
        AH_GameBoard board = new AH_GameBoard();
      
        // create a new panel with GridBagLayout manager 
        GridBagLayout layout = new GridBagLayout();
        SnakeGame.setLayout(layout);
        // use GridBagConstraints to control the grid appearance 
        GridBagConstraints constraints = new GridBagConstraints(); 
        board.setSize(300,300);
        constraints.gridx=0;
        constraints.gridy=0;
        //board.setSize(800,600);
        constraints.gridwidth = 6;
        constraints.gridheight= 9;
        constraints.fill = GridBagConstraints.BOTH;
        SnakeGame.add(board, constraints);
        


        //constraints.fill = GridBagConstraints.VERTICAL;
        //constraints.fill = GridBagConstraints.HORIZONTAL;
         constraints.gridx=9;
         constraints.gridy=1;
        constraints.gridheight=1;
        constraints.gridwidth = 2;
        //constraints.insets = new Insets(0,2,0,0);
        //constraints.anchor = GridBagConstraints.CENTER;
      
        SnakeGame.add(labelTopScore,constraints);
        

        
        //constraints.fill = GridBagConstraints.VERTICAL;
        //constraints.anchor = GridBagConstraints.LINE_START;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 9; 
        constraints.gridy = 2; 
        constraints.gridheight=1;
        constraints.gridwidth = 2;
        //constraints.weightx = 0.2;
        constraints.weighty = 0.1;
        SnakeGame.add(labelCurrentScore, constraints);
        
        //constraints.fill = GridBagConstraints.LAST_LINE_END;
        constraints.gridx = 9; 
        constraints.gridy = 3;      
        SnakeGame.add(labelimg, constraints);
        
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 9; 
        constraints.gridy = 5;   
        constraints.gridheight=1;
        constraints.gridwidth = 4;
        SnakeGame.add(labelname, constraints);
        
        //constraints.fill = GridBagConstraints.VERTICAL;
     
        //constraints.fill = GridBagConstraints.VERTICAL;
        // // //constraints.weightx=50;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 9; 
        constraints.gridy = 8;  
        constraints.gridheight=1;
        constraints.gridwidth = 4;
        SnakeGame.add(buttonQuit, constraints);
        
        //add the panel to this frame 
  
        add(SnakeGame);
        pack();
        
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
