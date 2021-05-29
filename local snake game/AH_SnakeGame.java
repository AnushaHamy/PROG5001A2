import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Anusha Hamy
 * @Version 6.0
 */

public class AH_SnakeGame extends JFrame {
    
    private AH_LoginForm loginForm;
    private AH_GameBoard board;
    private JLabel labelname; 
    private JLabel labelimg; 
    private JButton buttonQuit; 
    private ImageIcon imageSnake;

    public AH_SnakeGame() {        
        LayoutManagers();
        setTitle("My Snake Game © Anusha_Hamy");
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        
    }
    
    public static void main(String[] args) {    
        
        EventQueue.invokeLater(() -> {
        
          AH_LoginForm loginForm = new AH_LoginForm();
          loginForm.setVisible(true);
          loginForm.setTitle("The Snake Game © Anusha_Hamy");
          AH_GameBoard board = new AH_GameBoard();
          board.setVisible(true);

        });
    }

    public void LayoutManagers(){
         
        
        labelname = new JLabel("PROG5001:"+ "\n" +" 2021 name: Anusha");//
        imageSnake = new ImageIcon ("images/snake.png");
        labelimg = new JLabel (imageSnake);
        buttonQuit = new JButton("Quit");
        
          buttonQuit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
         {
           System.exit(0);
          }
         });
    
       
        JPanel SnakeGame = new JPanel();
        //create object to use add game to panel and labels;
        AH_GameBoard board = new AH_GameBoard();
      
        // create a new panel with GridBagLayout manager 
        GridBagLayout layout = new GridBagLayout();
        SnakeGame.setLayout(layout);
        
        // use GridBagConstraints to control the grid appearance 
        GridBagConstraints constraints = new GridBagConstraints(); 
        board.setSize(300,300);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth = 6;
        constraints.gridheight= 9;
        constraints.fill = GridBagConstraints.BOTH;
        SnakeGame.add(board, constraints);
        
        constraints.gridx=9;
        constraints.gridy=1;
        constraints.gridheight=1;
        constraints.gridwidth = 2;
        SnakeGame.add(board.hScore,constraints);
        
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 9; 
        constraints.gridy = 2; 
        constraints.weighty = 0.1;
        SnakeGame.add(board.currScore, constraints);
        
        constraints.gridx = 9; 
        constraints.gridy = 3;      
        SnakeGame.add(labelimg, constraints);
        
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 9; 
        constraints.gridy = 5;   
        constraints.gridheight=1;
        constraints.gridwidth = 4;
        SnakeGame.add(labelname, constraints);
        
  
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
}
