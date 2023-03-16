package College_Inventory_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author Amit kumar
 */
public class MySqlConnect {
    Connection conn;
public static Connection ConnecrDb(){
  try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/IMS", "root", "");
     return conn;
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null,e);
    }
    return null;
}
    
}
