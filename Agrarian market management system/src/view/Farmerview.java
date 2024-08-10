package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Bucketlistdb;
import Model.Farmerdb;
import controller.Bucketlist;
import controller.Farmercontrol;
public class Farmerview {
	Scanner s=new Scanner(System.in);
    Farmerdb fdb=new Farmerdb();
    Farmercontrol f=new Farmercontrol();
    Bucketlist b=new Bucketlist();
	public void logic() throws ClassNotFoundException, SQLException {
		
		int c=0;
   		while(c==0) {
   	    System.out.println("+-------------------------------+");
		System.out.println("|            1.Login            |");
		System.out.println("|            2.Register         |");
		System.out.println("|            3.Exit             |");
		System.out.println("+-------------------------------+");
		System.out.println("Enter the choice :  ");
	
		int chioce=s.nextInt();
		switch(chioce)
		{
		     case 1:
		     {
		    	 login();
		    	 break;
		     }
		     case 2:
		     {
		    	 register();
		    	 break;
		     }
		     case 3:
		     {
		    	 c=1;
		    	 System.out.println("Successfully exit");
		    	 break;
		     }
		     default:
		     {
		    	 System.out.println("Invaild options");
		     }
		}
	}
	}

	private void register() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter your name");
		f.setName(s.next());
		System.out.println("Enter your email id");
		f.setEmail(s.next());
		System.out.println("Enter your Password");
		f.setPassword(s.next());
		System.out.println("Enter your location");
		f.setLocation(s.next());
		fdb.addfarmer(f);
		
	}

	private void login() throws ClassNotFoundException, SQLException {
		 System.out.println("Enter your email ");
		 String email=s.next();
		 System.out.println("Enter your password ");
		 String password=s.next();
		 if(fdb.f_login(email).equals(password))
		 {
			 
			 System.out.println("Successfully login");
			 display(email);
			 
		 }
		 else
		 {
			 System.out.println("Login failed");
		 }
		
	}

	public void display(String email) throws ClassNotFoundException, SQLException {
		
		System.out.println("---------------------------------");
		System.out.println("1.Farmer product display");
		System.out.println("2.Price update");
		System.out.println("3.Add products");
		System.out.println("4.Delete products");
		System.out.println("5.Exit");
		System.out.println("Enter the choice : ");
		int chioce =s.nextInt();
		if(chioce==1)
		{
			farmerdisplay(email);
			display(email);
		}
		else if(chioce==2)
		{
		    priceupdate(email);	
		    display(email);
		}
		else if(chioce==3)
		{
			addproduct(email);
			display(email);
		}
		else if(chioce==4)
		{
			deleteproduct(email);
			display(email);
		}
		else if(chioce==5)
		{
			
			System.out.println("Successfuly exit");
			logic();
		}
		else
		{
			System.out.println("Invaild options");
		}
		
		
	}

	public void deleteproduct(String email) throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter your email ");
		String n=s.next();
		int id=fdb.deleteproduct(n);
		b.setEmailid(id);
		Bucketlistdb.deleteproduct(b);
	}

	public void priceupdate(String email) throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter your price");
		b.setPrice(s.nextDouble());
		System.out.println("Enter your perkg");
		b.setPerkg(s.nextDouble());
		int id=fdb.priceupdate(email);
		b.setEmailid(id);
		Bucketlistdb.priceupdate(b);
		
	}

	public void addproduct(String email) throws ClassNotFoundException, SQLException {
        
        
		System.out.println("Enter your productname");
		b.setProductname(s.next());
		System.out.println("Enter your quantity");
		b.setQuantity(s.nextInt());
		System.out.println("Enter your price");
		b.setPrice(s.nextDouble());
		System.out.println("Enter your perkg");
		b.setPerkg(s.nextDouble());
		System.out.println("Enter your variety");
		b.setVariety(s.next());
		System.out.println("Enter the phonenumber");
		s.nextLine();
		b.setPhonenumber(s.next());
		int id=fdb.addproduct(email);
		b.setEmailid(id);
		Bucketlistdb.addproduct(b);
		
	}

	public void farmerdisplay(String email) throws ClassNotFoundException, SQLException {
		
		 ArrayList<Bucketlist> k=f.display(email);
		 int i=0;
		 System.out.printf("%-5s | %-30s | %-20s | %-10s | %-10s | %-10s | %-20s | %-15s%n", "ID", "Email", "Product Name", "Quantity", "Price", "Per KG", "Variety", "Phone Number");
		 System.out.println("---------------------------------------------------------------------------------------------------------------------------");

		 while (i < k.size()) {
		     Bucketlist b = k.get(i);
		     System.out.printf("%-5s | %-30s | %-20s | %-10s | %-10s | %-10s | %-20s | %-15s%n",
		                       b.getId(), b.getEmailid(), b.getProductname(), b.getQuantity(), b.getPrice(), b.getPerkg(), b.getVariety(), b.getPhonenumber());
		     
		     i++;
		 }
	}


	
}
