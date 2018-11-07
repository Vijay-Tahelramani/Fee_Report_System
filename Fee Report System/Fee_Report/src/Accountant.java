import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Accountant extends login{
	
	int task = 0;
	Scanner sb = new Scanner(System.in);
	public Accountant() throws ClassNotFoundException
	{
		System.out.println("\nAccountant Login\n");
		login_type = "accountant";
		super.login_mothod();
			int task_count = 0;
			do {
			login_type = "";
			System.out.println("\nACCOUNTANT SECTION\n");
			System.out.println("Select one of the following: ");
			System.out.println("1. Add Student\n2. View Student\n3. Edit Student\n4. Delete Student\n5. Logout");
			task = sb.nextInt();
			
			if(task == 1) {
				System.out.println("\nEnter Student name: ");
				String name = sb.next();
				System.out.println("\nEnter Student email address: ");
				String email = sb.next();
				System.out.println("\nEnter Student Course: ");
				String course = sb.next();
				System.out.println("\nEnter Student's total fee: ");
				int total_fee = sb.nextInt();
				System.out.println("\nEnter Student's paid fee: ");
				int paid_fee = sb.nextInt();
				System.out.println("\nEnter Student Contact number: ");
				String number = sb.next();
				add_student(name, email, course, total_fee, paid_fee, number);
			}
			else if(task == 2) {
				System.out.println("Enter the name of Student: ");
				String name = sb.next();
				view_Student v = new view_Student();
				v.student_function(name);
			}
			else if(task == 3) {
				Class.forName("org.sqlite.JDBC");
				Connection connection = null;
			      try
			      {
			         // create a database connection
			         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
			         Statement statement = connection.createStatement();
			         ResultSet resultSet = statement.executeQuery("SELECT * from student");
			         if(!resultSet.isBeforeFirst()) {
			        	 System.out.println("No Records Found!!");
			         }
			         else {
			        	 System.out.println("Following Students are available in Databse:-");
			        	 int id = 0;
			           while(resultSet.next())
			           {
			        	   id++;
			        	   System.out.println(id+". "+resultSet.getString("name"));
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
			    System.out.println("Enter the name of student whose account you want to edit: ");
				String name = sb.next();
				edit_student es = new edit_student();
				es.student_function(name);
			}
			else if(task == 4) {
				Class.forName("org.sqlite.JDBC");
				Connection connection = null;
			      try
			      {
			         // create a database connection
			         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
			         Statement statement = connection.createStatement();
			         ResultSet resultSet = statement.executeQuery("SELECT * from student");
			         if(!resultSet.isBeforeFirst()) {
			        	 System.out.println("No Records Found!!");
			         }
			         else {
			        	 System.out.println("Following Students are available in Databse:-");
			        	 int id = 0;
			           while(resultSet.next())
			           {
			        	   id++;
			        	   System.out.println(id+". "+resultSet.getString("name"));
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
			    System.out.println("Enter the name of student whose account you want to delete: ");
				String name = sb.next();
				delete_student d = new delete_student();
				d.student_function(name);
			
				
			}
			else if(task == 5) {
				task_count = 1;
				System.out.println("Logged out Successfully...");
			}else {
				System.out.println("Enter Valid Choice!!");
			}
		}
		while (task_count == 0);
	}
	
	public void add_student(String name,String email,String course,int total_fee,int paid_fee,String number) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
	      try
	      {
	         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
	         Statement statement = connection.createStatement();
	         //String Query1 = "CREATE TABLE student (name String,email String,course String,total_fee integer,paid_fee integer,due_fee integer,number String)";
	         int due_fee = total_fee - paid_fee;
	         System.out.println("I am here");
	        String Query = "INSERT INTO student (name,email,course,total_fee,paid_fee,due_fee,number)values('"+name+"','"+email+"','"+course+"','"+total_fee+"','"+paid_fee+"','"+due_fee+"','"+number+"');";  
	        statement.executeUpdate(Query);
	        System.out.println("Student Added Successfully"); 
	        ResultSet resultSet = statement.executeQuery("SELECT * from student");
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
