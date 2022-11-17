import java.awt.Color; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class frame implements ActionListener{

    static JFrame check;
    
    static JFrame frame;
    static JButton button;
    static JTextField student_name , student_id,student_number,student_email;
    static JLabel student_name1 , student_id1,student_number1,student_email1;

    /**
     * 
     */
    frame(){

    //.....................................frame.........................................
    frame  = new JFrame("Libary Management System");
    frame.setBackground(Color.BLACK);
    frame.setBounds(400,200,700,500);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.getContentPane().setBackground(Color.BLACK);
  
    //.....................................==............................................
 
    //...................................textField.........................................
 

    student_id = new JTextField();
    student_id.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    student_id.setBounds(100,90,300,28);
    student_id.setBorder(BorderFactory.createEmptyBorder());

    student_number = new JTextField();
    student_number.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    student_number.setBounds(100,144,300,28);
    student_number.setBorder(BorderFactory.createEmptyBorder());
    //.......................................==............................................


    //......................................label..........................................

    JLabel poratLabel = new JLabel("Azmat Ali");
    poratLabel.setFont(new Font("Times New Roman", Font.ITALIC, 30));
    poratLabel.setBounds(500,400,200,50);

    student_id1 = new JLabel("ID Or Email");
    student_id1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    student_id1.setBounds(100,66,216,24);

    student_number1 = new JLabel("Password");
    student_number1.setFont(new Font("Times New Roman", Font.BOLD, 18));
    student_number1.setBounds(100,120,216,24);

    JLabel or = new JLabel(" ---------------------         or         ----------------------");
    or.setFont(new Font("Times New Roman", Font.PLAIN, 15));
    or.setForeground(Color.BLACK);
    or.setBounds(100,210,300,28);

    JLabel nameofsystem = new JLabel("Student Portal");
    nameofsystem.setFont(new Font("Time New Roman",Font.BOLD,20));
    nameofsystem.setBounds(120,0,400,50);
    nameofsystem.setForeground(Color.WHITE);



    //.......................................==...........................................


    //....................................button..........................................
    button = new JButton("Log In");
    button.setFont(new Font("Time New Roman",Font.PLAIN,14));
    button.setBounds(100, 180, 300, 28);
    button.setBackground(Color.BLUE);
    button.setForeground(Color.WHITE);

    button.addActionListener( new ActionListener(){
        String id  = student_id.getText();
        String pass = student_number.getText();

        
        boolean ok   = true;
        @Override
        public void actionPerformed(ActionEvent e){
           server one = new server(id,pass);
        
           try {
            ok =  one.check();
            if(ok){
                new main();
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            System.out.print("not work");
        }
       



        }  
    });
  
    

    JButton create = new JButton("Create Account");
    create.setFont(new Font("Time New Roman",Font.PLAIN,14));
    create.setBounds(170, 245, 150, 28);
    create.setBackground(Color.GREEN);
    create.setForeground(Color.WHITE);
    create.addActionListener(this);
    //.......................................==...........................................

    //......................................addingArea....................................

    //...............................panel.....................................
    JPanel panel = new JPanel();
    panel.setBounds(100,90,500,300);
    panel.setBackground(Color.GRAY);

    JPanel board  = new JPanel();
    board.setBounds(00,00,500,50);
    board.setBackground(Color.darkGray);
    //...............................==........................................

    ImageIcon image = new ImageIcon(getClass().getResource("99999.jpg"));

    JLabel displayfield = new JLabel(image);
    displayfield.setBounds(0,0,100,50);
    board.add(displayfield);

    frame.add(poratLabel);
    frame.add(panel);
    panel.add(student_id);
    panel.add(student_id1);
   board.add(nameofsystem);

    

   

    panel.add(student_number);
    panel.add(student_number1);

    panel.add(button);
    panel.add(or);
    panel.add(create);
    panel.add(board);
}

    public static void main(String[] args) throws Exception{
           new frame();
       //login inferno = new login();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        new sign_in();
        
    }


  
   
}