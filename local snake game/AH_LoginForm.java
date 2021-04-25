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
 * JFrame and LayoutManager.
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
        
        labelUsername = new JLabel("Enter username: ");
        labelPassword = new JLabel("Enter password: ");   
        textUsername = new JTextField(20);
        fieldPassword = new JPasswordField(20);
        buttonLogin = new JButton("Login");
        
        JPanel loginPanel = new JPanel();
        
        GridBagLayout layout = new GridBagLayout();
        loginPanel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        int top = 5;
        int left = 5;
        int bottom = 5;
        int right = 5;
        gbc.insets = new Insets(top, left, bottom, right);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(labelUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;     
        loginPanel.add(labelPassword, gbc);
         
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(textUsername, gbc);
         
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        loginPanel.add(fieldPassword, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        loginPanel.add(buttonLogin, gbc);
                  
        
        setLayout(new FlowLayout());
        add(loginPanel);
        
        pack();
        setLocationRelativeTo(null);
        
        buttonLogin.addActionListener(this); 
        
        //add new players to the list
        //playerList = new AH_PlayerList();
        //playerList.add("Vinh", "122");
        //playerList.add("Atie", "Adm1n");
        
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

        }else{
        JOptionPane.showMessageDialog(null, "Username / password does not match");

        }
        
    }
    
    
    public static void main(String[] args) {
       AH_LoginForm logpanel = new AH_LoginForm();
       logpanel.setVisible(true);
       
       //JFrame frame = new JFrame("Demo Login");
       //frame.add(logpanel);
       //frame.pack();
       //frame.
       //frame.
    }
}