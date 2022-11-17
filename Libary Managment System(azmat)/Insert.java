import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Insert
 */
public class Insert {
     static int count =0;
     static int semno =1;
    public static void insert() throws Exception{
    
        String [] str  = {"Fundamental English","Mathematics","Chemistry","Physics","Engineering Materials","Engineering Graphics","Environmental Studies","Computer Programming","Electrical Instrumentation","Electrical Technology","Engineering Mechanics","Electricity and Magnetism","Mathematics","Introduction to Photonics","Green Electronics","Data Structures","Digital Circuits","Circuit Theory","Applied Thermodynamics","Electrical Machines","Electrical Measurements","Analogue Circuits","Digital Circuits","Signals and Systems","Numerical and Statistical Methods","Power Systems","Control Systems","Electrical Machines","Digital Signal Processing","Field Theory","Microprocessors","Electrical Power Generation","Power Electronics","Power Systems","Instrumentation","Machine Learning","Control Systems","Electrical Machines","Electrical Drives","Switchgear and Protection","Advanced Power Electronics","Computer Application in Power System","High Voltage Engineering","Illumination and Utility","Utilization of Electrical"};
        for(int i=0;i<str.length;i++){
            Connection connection = getconnected();
            int no = i+1;
            String book = str[i];
            String b = "Electrical";
          
            String b1 = "EE"+semno+"SEM";
            String sql  = "insert into student.electrical(Id,book_name,Branch,Book_number) value ('"+no+"','"+book+"','"+b+"','"+b1+"')";
        PreparedStatement create = connection.prepareStatement(sql);
        create.executeUpdate();
    
        if(i==5){
            semno++;
        }
        else if(i==11){
            semno++;
    }
    else if(i==16){
        semno++;
    }
    else if(i==22){
        semno++;
    }
    else if(i==28){
        semno++;
    }
    else if(i==33){
        semno++;
    }
    else if(i==39){
        semno++;
    }
    
    }
    
    }

    public static Connection getconnected(){
        count++;
        String url = "jdbc:mysql://localhost:3306";
        String username  = "root";
        String password = "Al256282786#";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.print("connected"+" "+count+" ");
            return connection;
            
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("oops not connected");
            e.printStackTrace();
        }
        return null;
       }
    public static void main(String[] args) throws Exception {
         getconnected();
         insert();
        
    }
}