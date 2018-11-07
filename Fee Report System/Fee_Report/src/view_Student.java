import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class view_Student {

	public void student_function(String name) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         // create a database connection
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery("SELECT * from student where name='"+name+"'");
	         if(!resultSet.isBeforeFirst()) {
	        	 System.out.println("No Records Found!!");
	         }
	         else {
	           while(resultSet.next())
	           {
	        	   System.out.println("name = " + resultSet.getString("name"));
		              System.out.println("email = " + resultSet.getString("email"));
		              System.out.println("course = " + resultSet.getString("course"));
		              System.out.println("Total_Fee = " + resultSet.getInt("total_fee"));
		              System.out.println("Paid_fee = " + resultSet.getInt("paid_fee"));
		              System.out.println("Due_fee = " + resultSet.getInt("due_fee"));
		              System.out.println("Contact Number = " + resultSet.getString("number"));
	              
	           }
	         }
	         
	         
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
