package call_center;

import java.sql.*;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.*;
import java.io.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sound.midi.SysexMessage;
class JDBC{
    public static void main(String args[]){
        try{
            //Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creating a connection 

            String url="jdbc:mysql://localhost:3306/callcenter";
            String username="root";
            String password="senbonzakura!112";

            Connection con = DriverManager.getConnection(url,username,password);
            
            
            if(con.isClosed()){
                System.out.println("Connection is Closed");

            }
            else{
                System.out.println("Connection Created....");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

public class InputJDBC {

    public static void main(String[] args){
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");

            //Creating a connection 

            String url="jdbc:mysql://localhost:3306/callcenter";
            String username="root";
            String password="senbonzakura!112";

            Connection con = DriverManager.getConnection(url,username,password);

            // Creating a query 
            
            String q =  "insert into table1(From_number,Start_time,End_time,Duration) values(?,?,?,?)";

            //get the preparedstatement object

            PreparedStatement pstmt = con.prepareStatement(q);

            //Creating the Dynamic Input statements 
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            
            System.out.print("Enter the Caller Phone No: ");
            String number = br.readLine();

            System.out.println("Enter the Start time of the call: ");
            String start = br.readLine();
            Timestamp startTimestamp = Timestamp.valueOf(start);
            

            
            System.out.println("Enter the End time of the call: ");
            String end = br.readLine();
            Timestamp endTimestamp = Timestamp.valueOf(end);
            

            System.out.println("Enter the duration of the call: ");
            String dur = br.readLine();
            int foo = Integer.parseInt(dur);



            pstmt.setString(1, number);
            pstmt.setTimestamp(2, startTimestamp);
            pstmt.setTimestamp(3, endTimestamp);
            pstmt.setInt(4, foo);

            pstmt.executeUpdate();



} catch (Exception e) {
        
            e.printStackTrace();
        }
        

        
    }

    
}
