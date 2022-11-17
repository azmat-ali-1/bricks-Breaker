import java.awt.Color;

import javax.swing.*;
public class registor{

    registor(){

        JFrame page = new JFrame();
        page.setTitle("Registration Page");
        page.setSize(375,600);
        page.setVisible(true);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.getContentPane().setBackground(Color.magenta);



        JLabel emailJLabel = new JLabel("Email");
        emailJLabel.setBounds(0,20,50,10); 
        page.add(emailJLabel);



        JLabel usernameJLabel  =new JLabel("Username");
        usernameJLabel.setBounds(0,20,50,10);
        page.add(usernameJLabel);



        JLabel passwJLabel = new JLabel("Password");
        passwJLabel.setBounds(20,20,80,34);
        page.add(passwJLabel);



        JTextField email    = new JTextField();
        JTextField username = new JTextField();
        JTextField password = new JTextField();
        
        JButton button = new JButton("Register");
        button.setBackground(Color.cyan);


    }
    public static void main(String[] args) {
       new registor();
       
    }
}
