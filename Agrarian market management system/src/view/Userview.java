package view;
import java.sql.SQLException;
import java.util.*;
import Model.Bucketlistdb;
import Model.Userdb;
import Model.Orderdb;
import controller.Bucketlist;
import controller.Usercontrol;
import controller.Ordercontrol;
public class Userview {
  Scanner s=new Scanner(System.in);
  Userdb udb=new Userdb();
  Usercontrol u=new Usercontrol();
  Bucketlist b=new Bucketlist();
  Ordercontrol o=new Ordercontrol();
	public void logic() throws ClassNotFoundException, SQLException {
		int c=0;
   		while(c==0) {
   		System.out.println("+---------------------------------+");
		System.out.println("|            1.Login              |");
		System.out.println("|            2.Register           |");
		System.out.println("|            3.Exit               |");
		System.out.println("+---------------------------------+");
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
		u.setName(s.next());
		System.out.println("Enter your email id");
		u.setEmail(s.next());
		System.out.println("Enter your Password");
		u.setPassword(s.next());
		System.out.println("Enter your location");
		u.setLocation(s.next());
		udb.addUser(u);
		
	}
	private void login() throws ClassNotFoundException, SQLException {
		 System.out.println("Enter your email ");
		 String email=s.next();
		 System.out.println("Enter your password ");
		 String password=s.next();
		 if(udb.u_login(email).equals(password))
		 {
			 System.out.println("Successfully login");
			 userdisplay(email);
		 }
		
	}
	public void userdisplay(String email) throws ClassNotFoundException, SQLException {
		 ArrayList<Bucketlist> k=u.display(email);
		 int i=0;
		 System.out.println("+---------------------------------------------------------------------------------+");
		 System.out.printf("|%-5s | %-20s | %-10s | %-10s | %-10s | %-20s", "ID", "Product Name", "Quantity", "Price", "Per KG", "Variety");
		 System.out.println();
		 System.out.println("+---------------------------------------------------------------------------------+");

		 while (i < k.size()) {
		     Bucketlist b = k.get(i);
		     System.out.printf("|%-5s | %-20s | %-10s | %-10s | %-10s | %-20s ",
		                       b.getId(), b.getProductname(), b.getQuantity(), b.getPrice(), b.getPerkg(), b.getVariety());
		     System.out.println();
		     System.out.println("+---------------------------------------------------------------------------------+");
		     i++;
		 }
		 userbuyproduct(email);
		
	}
	public void userbuyproduct(String email) throws ClassNotFoundException, SQLException {
		 System.out.println("----------------------------------------------");
		 System.out.println("If you like to buy then enter 'yes' else 'no' ");
		 System.out.println("----------------------------------------------");
		 String choose=s.next();
		 if(choose.equalsIgnoreCase("yes"))
		 {
			ArrayList<Integer> items=new ArrayList<>();
			System.out.println("------------------------------------------");
			System.out.println("How many products have you choosen to buy ");
			System.out.println("------------------------------------------");
	    	int count=s.nextInt();
	    	System.out.println("Enter the id to proceed");
	    	for(int i=0;i<count;i++)
	    	{
	    		items.add(s.nextInt());
	    	}
	    	ArrayList<Bucketlist> k=u.userbuyproduct(items);
	    	int i=0,quantity=0,id=0;
	    	double price=0,perkg=0,total=0;
	    	while(i<k.size())
	    	{
	    		Bucketlist b=k.get(i);
	    		 id=b.getId();
	    		 quantity=b.getQuantity();
	    		 price=b.getPrice();
	    		 perkg=b.getPerkg();
	    		 System.out.println("How many kg to buy the product");
	    		 int buy=s.nextInt();
	    		 quantity=quantity-buy;
	    		 u.userUpdate(quantity,id);
	    		 total=totalprice(price,perkg,buy);
	    		 System.out.println(total);
	    		 System.out.println(total+" "+" : Successfully to order product");
	    		 i++;
	    	}
	          order(email,total);
	          System.out.println("-----------------------------------");
	     }
		 else
		 {
			 System.out.println("Its ok Have a nice day");
		 }
		 
	}
	
	public void order(String email, double total) throws ClassNotFoundException, SQLException {
		Orderdb o1=new Orderdb();
		int k=u.userorderid(email);
		System.out.println("--------------------------------");
		o.setUserid(k);
		o.setTotal(total);
		o1.order(o);
		display(k);
	}
	public void display(int k) throws ClassNotFoundException, SQLException {
		ArrayList<Ordercontrol>k1=o.display(k);
		int i=0;
		System.out.println("+------------------------------------------------------------+");
		System.out.printf("|%-10s | %-15s | %-15s | %-15s\n", "Order_ID", "Order_Date", "Customer_ID", "Total_Price");
		System.out.println("+--------------------------------------------------------+");
		System.out.println();
		while(i<k1.size())
		{
			Ordercontrol q=k1.get(i);
			System.out.printf("|%-10s | %-15s | %-15s | %-15s\n", q.getId(), q.getDate(), q.getUserid(), q.getTotal());
			System.out.println("+--------------------------------------------------------+");
	       i++;
		}
		
	}
	public double totalprice(double price, double perkg, int buy) {
		System.out.println("total price of the product");
		double total=perkg*buy;
		double total1=0;
		total1+=total;
		return total1;
	}
	
          
}
