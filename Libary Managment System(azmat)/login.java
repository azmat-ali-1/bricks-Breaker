import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    
public class login  implements ActionListener {

    JFrame one ;
    JTextField name;
    JTextField pass;
    JButton button;
    int count = 0;
    JLabel displayfield;
    ImageIcon image;
    login(){
        one = new JFrame();
        one.setTitle("LOGIN PAGE");
        one.setBounds(600,200,800,450);
        one.setVisible(true);
       // one.getContentPane().setBackground(Color.red);
        one.setResizable(false);
        one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    image  = new ImageIcon(getClass().getResource("143.png"));
                    displayfield = new JLabel(image);
                    displayfield.setBounds(0,0,800,450);
                 

        name  = new JTextField();
        name.setBounds(150,150,100,20);
        one.add(name);

        JLabel ID = new JLabel("ID Number :-");
        ID.setBounds(50 ,150,100,20);
        ID.setVisible(true);
        one.add(ID); 

        pass  = new JTextField();
        pass.setBounds(150,200,100,20);
        one.add(pass);

        JLabel password = new JLabel("Password :-");
        password.setBounds(50,200,100,20);
        password.setVisible(true);
        one.add(password); 

        button = new JButton("log in");
        button.setBounds(100,250,80,20);
        one.add(button);
        button.addActionListener(this);
        one.add(displayfield);

    }
    public static void main(String[] args) {
        login inferno = new login();
        
    }
   
   
   
    @Override
    public void actionPerformed (ActionEvent e) {
        count++;
       String str  = name.getText();
       String str2  = pass.getText();
        if(count>3){
            button.setText("Please leave my server");
        }
        server ob = new server("ghj","gh");
       try {
        if(ob.check()){
            name.setText("pass");
            pass.setText("pass");
            new frame();
            one.dispose();
           }
           else{
                name.setText("error");
                pass.setText("error");
           }
    } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
        
    }
 
   
  
 
  
}
