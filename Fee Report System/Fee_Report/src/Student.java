import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student extends login{
	public Student() throws ClassNotFoundException {
		System.out.println("\nStudent Login\n");
		login_type = "student";
		super.login_mothod();
		System.out.println("\nSTUDENT SECTION\n");
		int option_count = 0;
		do {
			System.out.println("1. Check Your Due\n2. Logout");
			Scanner ss = new Scanner(System.in);
			int option = 0;
			option = ss.nextInt();
			if(option == 1) {
				option_count = 1;
				int due_fee = 0;
				Class.forName("org.sqlite.JDBC");
				Connection connection = null;
			      try
			      {
			         // create a database connection
			         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
			         Statement statement = connection.createStatement();
			         ResultSet resultSet = statement.executeQuery("SELECT * from student where name='"+user_Name+"'");
			         if(!resultSet.isBeforeFirst()) {
			        	 System.out.println("You don't have any due to pay...");
			         }
			         else {
			           while(resultSet.next())
			           {
			        	      due_fee = resultSet.getInt("due_fee");
			           }
			           System.out.println("You have $"+due_fee+" due to pay");
			           
			           
			           
			           int choice_count=0;
			          
			           do {
			        	   System.out.println("\n1. Proceed to Pay\n2. Exit");
			        	   int choice = 0;
			        	   choice = ss.nextInt();
			        	   if (choice == 1) {
			        		   System.out.println("How much amount you want to pay: ");
			        		   int due_pay = ss.nextInt();
			        		   due_fee = due_fee-due_pay;
			        		   System.out.println("Enter Your Card Details: ");
			        		   String card = ss.next();
			        		   System.out.println("Enter 4-digit Pin: ");
			        		   String pin = ss.next();
			        		   System.out.println("Processing.....");
			        		   String Query = "update student set due_fee='"+due_fee+"' where name='"+user_Name+"'";
			        		   statement.executeUpdate(Query);
			        		   System.out.println("Payment Received Successfully.");
			        		   System.out.println("You have $"+due_fee+" left to pay");
			        		   
			        		   
			        		   
			        	   }
			        	   else if(choice == 2) {
			        		   choice_count = 1;
			        	   }
			        	   else {
			        		   
			        	   }
			           }  
			           while(choice_count==0);
			           
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
			else if(option == 2) {
				option_count=1;
				System.out.println("Successfully Logged out!!");
			}
		}
		while(option_count==0);
		
		
		/*Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	        // String Query1 = "CREATE TABLE students (name String,email String,number String,password String)";
	        String Query = "INSERT INTO studnets (name,email,number,password)values('"+name+"','"+email+"','"+num+"','"+password+"');";  
	        statement.executeUpdate(Query);
	        System.out.println("Accountant Added Successfully"); 
	        /*ResultSet resultSet = statement.executeQuery("SELECT * from accountant");
	        if(!resultSet.isBeforeFirst()) {
	        	 System.out.println("No Records Found!!");
	         }
	        else {
	           while(resultSet.next())
	           {
	              System.out.println("name = " + resultSet.getString("name"));
	              System.out.println("email = " + resultSet.getString("email"));
	              System.out.println("Contact Number = " + resultSet.getString("number"));
	              System.out.println("password = " + resultSet.getString("password"));
	              
	           }
	        }*/
	         
	     /* }
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
	      }*/
	
		
	}
}
