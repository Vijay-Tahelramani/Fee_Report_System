import java.util.Scanner;

public class Fee_Report_Status {
	public static void main(String[] args) throws ClassNotFoundException {
		int flag = 0;
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
		System.out.println("Who is Login?");
		System.out.println("1. Admin");
		System.out.println("2. Accountant");
		System.out.println("3. Student");
		num = sc.nextInt(); 
		if(num == 1)
		{
			Admin a = new Admin();
		}
		else if(num == 2)
		{
			Accountant ac = new Accountant();
		}
		else if(num == 3) {
			Student s = new Student();
		}
		else
		{
			System.out.println("Enter Valid Choice!!");
			
		}
		}
		while(flag==0);
		
		
	}

}
