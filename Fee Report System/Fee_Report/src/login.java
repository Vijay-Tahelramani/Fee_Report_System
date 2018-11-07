import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class login {

	String user_Name = "";
	String password = "";
	String login_type = "";
	String acc_name = "";
	String acc_pswd = "";
	String st_name = "";
	String st_pswd = "";
	Scanner sa = new Scanner(System.in);
	int login_count = 0;
	
	public void login_mothod() throws ClassNotFoundException 
	{
		do 
		{
			System.out.println("Enter User Name: ");
			user_Name = sa.next();
			System.out.println("Enter Password: ");
			password = sa.next();
			Class.forName("org.sqlite.JDBC");
			Connection connection = null;
		      try
		      {
		         // create a database connection
		         connection = DriverManager.getConnection("jdbc:sqlite:Fee_report.sqlite");
		         Statement statement = connection.createStatement();
		         ResultSet resultSet = statement.executeQuery("SELECT * from accountant where name='"+user_Name+"'");
		           while(resultSet.next())
		           {
		        	   acc_name = resultSet.getString("name");
			           acc_pswd = resultSet.getString("password");
			       }
		           
		           resultSet = statement.executeQuery("SELECT * from students where name='"+user_Name+"'");
		           if(!resultSet.isBeforeFirst() && login_type.equals("student")) {
		        	   System.out.println("No Records Found!!");
		        	   System.out.println("Please Proceed to Sign-Up");
		        	   System.out.println("\nEnter Your Name: ");
		        	   String name = sa.next();
		        	   System.out.println("Enter Email Address: ");
		        	   String email = sa.next();
		        	   System.out.println("Enter Contact Number: ");
		        	   String num = sa.next();
		        	   System.out.println("Enter Password: ");
		        	   String password = sa.next();
		        	String Query = "INSERT INTO students (name,email,number,password)values('"+name+"','"+email+"','"+num+"','"+password+"');";  
		   	        statement.executeUpdate(Query);
		   	        System.out.println("Sign Up Successfull"); 
		   	        System.out.println("Login Now");
		   	        
		        	   
		           }
		           else {
		           while(resultSet.next())
		           {
		        	   st_name = resultSet.getString("name");
			           st_pswd = resultSet.getString("password");
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
		
			if(login_type.equals("admin") && user_Name.equals("admin") && password.equals("1234")) 
			{
				login_count = 1;
			}
			else if(login_type.equals("accountant") && user_Name.equals(acc_name) && password.equals(acc_pswd)) 
				
			{
				login_count = 1;
			}
			else if(login_type.equals("student") && user_Name.equals(st_name) && password.equals(st_pswd)) 
				
			{
				login_count = 1;
			}
			else if(login_type.equals("student")){}
			else
			{
				System.out.println("Incorrect User Name or Password!!");
			}
			
		}while (login_count == 0);
		
		
			
			
	}
}
