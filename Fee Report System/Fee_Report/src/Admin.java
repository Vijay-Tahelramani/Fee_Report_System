import java.util.Scanner;
import java.sql.*;
public class Admin extends login{

	int task = 0;
	Scanner sb = new Scanner(System.in);
	String name="";
	String password="";
	String email="";
	String num="";
	public void Account(String name,String password,String email,String num) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	         //String Query1 = "CREATE TABLE accountant (id INTEGER,name String,email String,number String,password String)";
	        String Query = "INSERT INTO accountant (name,email,number,password)values('"+name+"','"+email+"','"+num+"','"+password+"');";  
	        statement.executeUpdate(Query);
	        System.out.println("Accountant Added Successfully"); 
	        ResultSet resultSet = statement.executeQuery("SELECT * from accountant");
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
	public void Account() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         // create a database connection
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery("SELECT * from accountant");
	         if(!resultSet.isBeforeFirst()) {
	        	 System.out.println("No Records Found!!");
	         }
	         else {
	           while(resultSet.next())
	           {
	              // iterate & read the result set
	              System.out.println("name = " + resultSet.getString("name"));
	              System.out.println("email = " + resultSet.getString("email"));
	              System.out.println("Contact Number = " + resultSet.getString("number"));
	              System.out.println("password = " + resultSet.getString("password"));
	              
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
	public void edit_account(String name) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery("SELECT * from accountant where name='"+name+"'");
	         if(!resultSet.isBeforeFirst()) {
	        	 System.out.println("No Records Found!!");
	         }
	         else{
	        	 
	        	 while(resultSet.next())
	           {
	              System.out.println("name = " + resultSet.getString("name"));
	              System.out.println("email = " + resultSet.getString("email"));
	              System.out.println("Contact Number = " + resultSet.getString("number"));
	              System.out.println("password = " + resultSet.getString("password"));
	              
	           }
	        	 int option_count = 0;
	        	 String Query = "";
	           do {
	        	   System.out.println("\n1.Update Selected Record \n2. Delete Selected Account\n3. Exit");
		        	 int option = sb.nextInt();
		        	 
		        	 
	        	   if(option == 1) {
	        		   option_count = 1;
		        	   System.out.println("Enter the following information: ");
		        	   System.out.println("\nEnter Name: ");
		        	   String Updated_name = sb.next();
		        	   System.out.println("Enter Email Address: ");
		        	   email = sb.next();
		        	   System.out.println("Enter Contact Number: ");
		        	   num = sb.next();
		        	   System.out.println("Enter Password: ");
		        	   password = sb.next();
		        	   
		        	   Query = "update accountant set name='"+Updated_name+"',email='"+email+"',number='"+num+"',password='"+password+"' where name='"+name+"';";
		        	   System.out.println(Query);
		        	   statement.executeUpdate(Query);
		        	   System.out.println("\nAccount Updated Successfully.\n");
		        	   ResultSet rs = statement.executeQuery("SELECT * from accountant where name='"+Updated_name+"';");
		        	   if(!resultSet.isBeforeFirst()) {}
		        	   else {
		        	   while(rs.next())
			           {
			              // iterate & read the result set
			              System.out.println("name = " + resultSet.getString("name"));
			              System.out.println("email = " + resultSet.getString("email"));
			              System.out.println("Contact Number = " + resultSet.getString("number"));
			              System.out.println("password = " + resultSet.getString("password"));
			              
			           }
		        	   }
			         
			      
		        	   
		           }
		           else if(option == 2) {
		        	   option_count = 1;
		        	   Query = "delete from accountant where name='"+name+"';";
		        	   statement.executeUpdate(Query);
		        	   System.out.println("Record Deleted Succesfully");
		        	   
		           }
		           else if(option == 3) {
		        	   option_count = 1;
		        	   System.out.println("Going back to main menu");
		           }
		           else {
		        	   System.out.println("Enter Valid Entry");
		           }
	           }
	           while(option_count==0);
	           
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
	public Admin() throws ClassNotFoundException
	{
		System.out.println("\nAdmin Login\n");
		login_type = "admin";
		super.login_mothod();
			int task_count = 0;
		do {
			login_type = "";
			System.out.println("\nADMIN SECTION\n");
			System.out.println("Select one of the following: ");
			System.out.println("1. Add Accountant\n2. View all Accountants\n3. Manage Accountant\n4. Logout");
			task = sb.nextInt();
			
			if(task == 1) {
				System.out.println("PLease Enter Following Details..");
				System.out.println("\nEnrer Name: ");
				name = sb.next();
				System.out.println("\nEnter Email Address: ");
				email = sb.next();
				System.out.println("\nEnter Contact Number: ");
				num = sb.next();
				System.out.println("\nCreate Password: ");
				password = sb.next();
				Account(name,password,email,num);
			}
			else if(task == 2) {
				Account();
			}else if(task == 3) {
				System.out.println("Enter name of Accountant: ");
				name = sb.next();
				edit_account(name);
				
			}
			else if(task == 4){
				task_count = 1;
				System.out.println("Logged out Successfully");
			}
			else {
				System.out.println("Enter Valid Choice!!");
			}
		}
		while (task_count == 0);
	}
}
