package ima;
/*Connectivity Steps
 *1- Register the driver class
 *2- Create the connection
 *3- create statement object
 *4- Execute the query , execute update
 *5- Close the connection object 	
 */
import java.sql.*;
public class DatabaseConn {
	Connection c;
	Statement s;
	
	public DatabaseConn(){
		try {
	
			Class.forName("com.mysql.jdbc.Driver");			//driver
			//interfaceName:database://url(localhost:port/databasename)
			String url="jdbc:mysql://localhost:3306/project_ims";	
			String uname="root";
			String pass="admin";
			c=DriverManager.getConnection(url,uname,pass);
			s=c.createStatement();				//create statement
		}
		catch(Exception e) {
			e.fillInStackTrace();
		}
	}
}
