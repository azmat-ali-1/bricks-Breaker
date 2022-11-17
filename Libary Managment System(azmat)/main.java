import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
public class main {

   static JFrame frame;
   JLabel displayfield;
   ImageIcon image;
   static JTable table;
   JScrollPane st;
    main(){
        frame = new JFrame();
      
        frame.setTitle("Slot booking window");
        frame.setVisible(true);
       
        frame.setSize(900,700);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0,0,199,691);
        frame.add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setBounds(222,35,649,202);
        frame.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.black);
        panel3.setBounds(222,400,649,202);
        frame.add(panel3);

        image  = new ImageIcon(getClass().getResource("dd.jpg"));

        displayfield = new JLabel(image);
        displayfield.setBounds(0,0,900,700);
        frame.add(displayfield);

        JTextField student1 = new JTextField();
        JLabel student2  = new JLabel("Student Name :-");
        
        student2.setForeground(Color.WHITE);
    
        student2.setBounds(23,15,156,28);
        student1.setBounds(23,41,156,28);
        student1.setEditable(false);

        JTextField  UniqeID = new JTextField();
        JLabel ID = new JLabel("Student ID :-");
        ID.setForeground(Color.WHITE);
        ID.setBounds(23,112,156,28);
  
        UniqeID.setBounds(23,137,156,28);

        JTextField codeOfBook1= new JTextField();
        JLabel codebookLabel = new JLabel("Book code 1 :-");
        codebookLabel.setForeground(Color.WHITE);
        codebookLabel.setBounds(23,209,156,28);
        codeOfBook1.setBounds(23,233,156,28);

        JTextField codeOfBook2 = new JTextField();
        JLabel codebookLabel2 = new JLabel("Book code 2 :-");
        codebookLabel2.setForeground(Color.WHITE);
        codebookLabel2.setBounds(23,306,156,28);
        codeOfBook2.setBounds(23,329,156,28);

        JTextField codeOfBook3 = new JTextField();
        JLabel codebookLabel3 = new JLabel("Book code 3 :-");
        codebookLabel3.setForeground(Color.WHITE);
        codebookLabel3.setBounds(23,403,156,28);
        codeOfBook3.setBounds(23,425,156,28);

        JTextField codeOfBook4 = new JTextField();
        JLabel codebookLabel4 = new JLabel("Book code 4 :-");
        codebookLabel4.setForeground(Color.WHITE);
        codebookLabel4.setBounds(23,500,156,28);
        codeOfBook4.setBounds(23,521,156,28);

        JButton submit = new JButton("Submit");
        submit.setBounds(734,620,82,20);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);

        panel.add(student1);
        panel.add(student2);
        panel.add(UniqeID);
        panel.add(ID);
        panel.add(codeOfBook1);
        panel.add(codebookLabel);
        panel.add(codeOfBook2);
        panel.add(codebookLabel2);
        panel.add(codeOfBook3);
        panel.add(codebookLabel3);
        panel.add(codeOfBook4);
        panel.add(codebookLabel4);
        frame.add(submit);

        JButton enter  = new JButton("Enter");
        enter.setBounds(95, 584, 82, 20);
        JButton reset = new JButton("Reset");
        reset.setBounds(95, 640, 82, 20);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.RED);

        panel.add(enter);
        panel.add(reset);

        //table formation :- 
        
        // String [] [] data = {{"1","azmat","2323"},{"2","azmat","2312312"},{"3","azmat","132121"},{"4","azmat","32323"}};
        // String [] col = {"id","name","salary"};

        table = new JTable();
        table.setBounds(0,10,649,202);
        table.setForeground(Color.white);
        table.setBackground(Color.BLACK);
       // table.setFillsViewportHeight(true);
       st = new JScrollPane(table);
       st.setBounds(0,0,649,202);
       st.setVisible(true);
       st.setBackground(Color.black);
      
        panel2.add(st);


        

    }

    public static Connection getconnected() throws Exception{
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

       public static void fill() throws Exception{
        Connection connection = getconnected();
        
        
        String [] col = {"Id","book_name","Branch","Book_number"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table.setModel(model);
        
      


        String q = "select * from student.electrical";
      PreparedStatement select = connection.prepareStatement(q);
        ResultSet rs =  select.executeQuery();
        
        while(rs.next()){
        
            String id  = rs.getString("Id");
            String book_name =rs.getString("book_name");
            String Branch  = rs.getString("Branch");
            String Book_number =rs.getString("Book_number");
            model.addRow(new String[]{id,book_name,Branch,Book_number});

        }


       }
public static void main(String[] args) throws Exception {
       
    new main();
    fill();    
    }
}
