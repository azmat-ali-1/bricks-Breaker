
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class sign_in implements ActionListener {

    static JFrame check;
    
    static JFrame frame;
    static JButton button;
    static JTextField student_name , student_id,student_pass,student_eemail;
    static JLabel student_name1 , student_id1,student_pass1,student_eemail1;

    static String id;
    static String name;
    static String email;
    static String pass;

    sign_in(){

    //.....................................frame.........................................
    frame  = new JFrame("Student Portal");
    frame.setBackground(Color.BLACK);
    frame.setBounds(400,200,700,500);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    //.....................................==............................................
 
    //...................................textField.........................................
    student_name = new JTextField();
    student_name.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    student_name.setBounds(283,130,325,28);

    student_id = new JTextField();
    student_id.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    student_id.setBounds(283,85,325,28);

    student_eemail = new JTextField();
    student_eemail.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    student_eemail.setBounds(283,175,325,28);

    student_pass = new JTextField();
    student_pass.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    student_pass.setBounds(283,220,325,28);

    //.......................................==............................................


    //......................................label..........................................

    JLabel poratLabel = new JLabel("Registration");
    poratLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    poratLabel.setBounds(250,10,200,50);

    student_id1 = new JLabel("ID : -");
    student_id1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    student_id1.setBounds(65,85,216,24);

    student_name1= new JLabel("Student Name : -");
    student_name1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    student_name1.setBounds(65,130,216,24);

    student_eemail1 = new JLabel("Eemail : -");
    student_eemail1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    student_eemail1.setBounds(65,175,216,24);

    student_pass1 = new JLabel("Password : -");
    student_pass1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    student_pass1.setBounds(65,220,216,24);
    //.......................................==...........................................
    //....................................button..........................................
    button = new JButton("Sign In");
    button.setFont(new Font("Time New Roman",Font.PLAIN,14));
    button.setBounds(460, 294, 148, 25);
    button.addActionListener(this);
    button.setVisible(true);
    //.......................................==...........................................


    
    //......................................addingArea....................................
    frame.add(poratLabel);

    frame.add(student_id);
    frame.add(student_id1);

    frame.add(student_name);
    frame.add(student_name1);

    frame.add(student_eemail);
    frame.add(student_eemail1);

    frame.add(student_pass);
    frame.add(student_pass1);

    frame.add(button);
   //.....................................==..............................................
   
   


    }
    
    public static Connection getconnected(){
        String url = "jdbc:mysql://localhost:3306";
        String username  = "root";
        String password = "Al256282786#";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.print("connected");
            return connection;
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("oops not connected");
            e.printStackTrace();
        }
        return null;
       }
   
       public static void InsertTable() throws Exception{
        
        Connection connection =  getconnected();
       
        String str = "insert into student.student_database(ID,student_name,Email,pass) value ('"+id+"','"+name+"','"+email+"','"+pass+"')";

        PreparedStatement create = connection.prepareStatement(str);
        create.executeUpdate();
    }
    public static void main(String[] args) {

        new sign_in();
         getconnected();
    }


   
    @Override
    public void actionPerformed(ActionEvent e) {
    
      
        String str = "";
     
        boolean right  = true;
        final JLabel extra = new JLabel();
        extra.setBounds(283,255,250,20);
        extra.setForeground(Color.RED);
        name = student_name.getText();
        id = student_id.getText();
        pass = student_pass.getText();
        email  = student_eemail.getText();


        String  p  = extra.getText();
       

        boolean idname = false;
        boolean emailpass = false;

        if(id.equals("")||name.equals("")){
            
            idname =  true;
        }

        String com = "@gmail.com";
        int count = com.length()-1;
        int i = email.length()-1;
        if(email.equals("") || pass.equals("")||email.length()<com.length()||pass.length()<10){
         
            emailpass =true;
        }

        while(count-->0&&i-->0){
            if(com.charAt(count)!=email.charAt(i)){
              
                emailpass = true;
                break;
            }
        }
         
        
        
        if(idname&&emailpass){
            str = "Invalid";
        }

        else if(emailpass){

                str  = "Invalid email and Mobile pass";
        }
           
        else if(idname){
           str  = "Invalid ID and Name";
        }

        else{
           
            checker az = new checker(name,id,pass,email);
           // right  = az.getValue();

            if(right){
                try {
                    InsertTable();
                    System.out.print("kaff");
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                   
                }
                str = "succesfull";
            } 
            else if(!right){
                str = "Already present";
            }
        }

    
        extra.setText(str);
        frame.add(extra);

      
       
    }
}
