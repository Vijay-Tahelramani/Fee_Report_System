import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class edit_student extends view_Student {
	
	public void student_function(String name) throws ClassNotFoundException {
		Scanner se = new Scanner(System.in);
		System.out.println("\nEnter Student name: ");
		String Updated_name = se.next();
		System.out.println("\nEnter Student email address: ");
		String email = se.next();
		System.out.println("\nEnter Student Course: ");
		String course = se.next();
		System.out.println("\nEnter Student's total fee: ");
		int total_fee = se.nextInt();
		System.out.println("\nEnter Student's paid fee: ");
		int paid_fee = se.nextInt();
		int due_fee = total_fee-paid_fee;
		System.out.println("\nEnter Student Contact number: ");
		String number = se.next();
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         // create a database connection
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	         String Query = "update student set name='"+Updated_name+"',email='"+email+"',course='"+course+"',total_fee='"+total_fee+"',paid_fee='"+paid_fee+"',due_fee='"+due_fee+"',number='"+number+"' where name='"+name+"';";
	         statement.executeUpdate(Query);
	         System.out.println("Record Successfully Updated...");
	         ResultSet resultSet = statement.executeQuery("SELECT * from student where name='"+Updated_name+"'");
	         if(!resultSet.isBeforeFirst()) {
	        	 System.out.println("No Records Found!!");
	         }
	         else {
	        	 System.out.println("Following Students are available in Databse:-");
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
