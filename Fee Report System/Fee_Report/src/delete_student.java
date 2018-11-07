import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class delete_student extends view_Student{
	
	public void student_function(String name) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         // create a database connection
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	         statement.executeUpdate("delete from student where name='"+name+"'");
	         System.out.println("Record Successfully Deleted");
	         
	         
	         
	      }
	      catch(SQLException e)
	      {  
	    	  System.err.println(e.getMessage());
	      }       
	      finally {         
	            try {
	                  if(connection != null)
	                     connection.close();
	                  }
	            catch(SQLException e) {  // Use SQLException class instead.          
	               System.err.println(e); 
	             }
	      }
	}

}
