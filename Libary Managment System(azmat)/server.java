import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class server {
    public  String id;
    public String pass;
    public static ResultSet rs;
       
   
        server(String id,String pass){
            this.id= id;
            this.pass = pass;
        }

  
    

    public static void selectTable() throws Exception{
        
        Connection connection =  getconnected();
        String str = "SELECT user_name,password FROM az.project;";

        PreparedStatement select = connection.prepareStatement(str);
        rs =  select.executeQuery();
        // while(rs.next()){
           
        //     System.out.println(rs.getString("user_name")+" "+rs.getString("password"));
        // }
    }
    public boolean check() throws Exception{
        Connection connection =  getconnected();
        String str = "SELECT id,pass FROM student.student_database;";

        PreparedStatement select = connection.prepareStatement(str);
        rs =  select.executeQuery();

        System.out.println(id+" "+pass);

        while(rs.next()){
           
            if(rs.getString("ID").equals(id)&&rs.getString("pass").equals(pass)){
                System.out.print(" "+"match"+" ");
                return true;
            }
            System.out.println(rs.getString("ID")+" "+id+" "+pass+" "+rs.getString("pass"));
        }
        return false;

    }
    public static void createTable() throws Exception{
        
        Connection connection =  getconnected();
        String str = "create table az.project( user_name varchar(223), password varchar(223));";

        PreparedStatement create = connection.prepareStatement(str);
        create.executeUpdate();
    }
    public static void InsertTable() throws Exception{
        
        Connection connection =  getconnected();
        String ad = "adsw";
        String str = "insert into az.project(user_name,password) value ('"+ad+"','"+123+"')";

        PreparedStatement create = connection.prepareStatement(str);
        create.executeUpdate();
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
    public static void main(String[] args) throws Exception{
   

        //getconnected();
        //createTable();
       // InsertTable();
        //selectTable();
    }
}
