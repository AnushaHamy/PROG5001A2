import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * @author Anusha Hamy
 * @Version 1.0
 */

public class AH_LoginForm extends JFrame implements ActionListener{
    private JLabel labelUsername;
    private JLabel labelPassword;   
    private JTextField textUsername;
    private JPasswordField fieldPassword;
    private JButton buttonLogin;
    
    private AH_PlayerList playerList;
    
    public AH_LoginForm() {
         //this form implemented according to Vinh's workshop
        labelUsername = new JLabel("Enter username: ");
        labelPassword = new JLabel("Enter password: ");   
        textUsername = new JTextField(20);
        fieldPassword = new JPasswordField(20);
        buttonLogin = new JButton("Login");
        
        JPanel loginPanel = new JPanel();
        
        GridBagLayout layout = new GridBagLayout();
        loginPanel.setLayout(layout);
        GridBagConstraints gridbaglayout = new GridBagConstraints();
        
        int top = 5;
        int left = 5;
        int bottom = 5;
        int right = 5;
        gridbaglayout.insets = new Insets(top, left, bottom, right);
        
        gridbaglayout.gridx = 0;
        gridbaglayout.gridy = 0;
        loginPanel.add(labelUsername, gridbaglayout);

        gridbaglayout.gridx = 0;
        gridbaglayout.gridy = 1;     
        loginPanel.add(labelPassword, gridbaglayout);
         
        gridbaglayout.fill = GridBagConstraints.HORIZONTAL;
        gridbaglayout.gridx = 1;
        gridbaglayout.gridy = 0;
        gridbaglayout.gridwidth = 2;
        loginPanel.add(textUsername, gridbaglayout);
         
        gridbaglayout.fill = GridBagConstraints.HORIZONTAL;
        gridbaglayout.gridx = 1;
        gridbaglayout.gridy = 1;
        gridbaglayout.gridwidth = 2;
        loginPanel.add(fieldPassword, gridbaglayout);
        
        gridbaglayout.gridx = 1;
        gridbaglayout.gridy = 2;
        gridbaglayout.gridwidth = 1;
        loginPanel.add(buttonLogin, gridbaglayout);
                  
        
        setLayout(new FlowLayout());
        add(loginPanel);
        
        pack();
        setLocationRelativeTo(null);
        
        buttonLogin.addActionListener(this); 
        

        
        playerList = new AH_PlayerList();
        try{
            readPlayerFromFile("players.txt");
            
        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(this, "File Not Found");
        
        }
        
        
    }
     
    private void readPlayerFromFile(String fileName)throws FileNotFoundException{
        File file= new File(fileName);
        
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(file);
        
        //Reading each line of the file using scanner class
        while(scnr.hasNextLine()){
        String line = scnr.nextLine();
        Scanner uscanner = new Scanner(line);
        String username = uscanner.next();
        String password = uscanner.next();
        playerList.add(username,password);
        }
        
    }
    
    public void actionPerformed(ActionEvent e){
        String username;
        String password;
        username = textUsername.getText();
        password = fieldPassword.getText();
        
        boolean matched = playerList.matchPlayer(username, password);
        if(matched){
          JOptionPane.showMessageDialog(null, "Login Successful");
          AH_SnakeGame board = new AH_SnakeGame();
          board.setVisible(true);

        }else{
        JOptionPane.showMessageDialog(null, "Username / password does not match");

        }
        
    }
    
    
    public static void main(String[] args) {
       AH_LoginForm logpanel = new AH_LoginForm();
       logpanel.setVisible(true);
    }
}