package view;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Admindb;
import controller.Admin;
import controller.Bucketlist;
import controller.Farmercontrol;
import controller.Usercontrol;
import controller.Ordercontrol;
public class Logic {
	   Scanner s=new Scanner(System.in);
	   Admindb adb=new Admindb();
	   Admin a=new Admin();
		public void logic() throws ClassNotFoundException, SQLException
		{
			int c=0;
       		while(c==0) {
       		System.out.println("+--------------------------------+");
			System.out.println("|            1.Login             |");
			System.out.println("|            2.Register          |");
			System.out.println("|            3.Exit              |");
			System.out.println("+--------------------------------+");
			System.out.println("Enter the choice :  ");
			int chioce=s.nextInt();
			if(chioce==1)
			{
				login();
				break;
			}
			else if(chioce==2)
			{
				resigeter();
				break;
			}
			else if(chioce==3)
			{
				c=1;
				System.out.println("Successfully Exit");
				break;
			}
			else
			{
				System.out.println("Invalid option");
			}
       		}
		}
		   private void resigeter() throws ClassNotFoundException, SQLException {
			   
			System.out.println("Enter your name : ");
			a.setName(s.next());
			System.out.println("Enter your email : ");
			a.setEmail(s.next());
			System.out.println("Enter your password : ");
			a.setPassword(s.next());
			adb.addAdmin(a);
			
		}
		public void login() throws ClassNotFoundException, SQLException {
			 System.out.println("Enter the email ");
			 String email=s.next();
			 System.out.println("Enter the password ");
			 String password=s.next();
			 if(adb.adLogin(email).equals(password))
			 {
				 System.out.println("Successfully login");
				 view();
				 
			 }
			 
		}
		public void view() throws ClassNotFoundException, SQLException {
			int c=0;
			while(c==0) {
			System.out.println("+----------------------------------------+");
			System.out.println("|          1.Product display             |");
			System.out.println("|          2.User display                |");
			System.out.println("|          3.Orderdetail display         |");
			System.out.println("|          4.Farmerdetail display        |");
			System.out.println("|          5.Admindetail display         |");
			System.out.println("|          6.Insert new Admin            |");
			System.out.println("|          7.Exit                        |");
			System.out.println("+---------------------------------------+");
			System.out.println("Enter your chioce");
			int chioce=s.nextInt();
			switch(chioce)
			{
			   case 1:
			   {
				   admindisplay();
				   break;
			   }
			   case 2:
			   {
				   userdisplay();
				   break;
			   }
			   case 3:
			   {
				   orderdetaildisplay();
				   break;
			   }
			   case 4:
			   {
				   farmerdetaildisplay();
				   break;
			   }
			   case 5:
			   {
				   admindetaildisplay();
				   break;
			   }
			   case 6:
			   {
				   insertadmin();
				   break;
			   }
			   case 7:
			   {
				   c=1;
				   System.out.println("Successfully exit");
				   logic();
				   break;
			   }
			   default:
			   {
				   System.out.println("To check valid option");
				   break;
			   }
			}
			}
			
		}
		public void insertadmin() throws ClassNotFoundException, SQLException {
			System.out.println("Enter the name");
			a.setName(s.next());
			System.out.println("Enter the email");
			a.setEmail(s.next());
			System.out.println("Enter the password");
			a.setPassword(s.next());
			adb.insertadmin(a);
			
		}
		public void admindetaildisplay() throws ClassNotFoundException, SQLException {
			ArrayList<Admin> k=a.admindetaildisplay();
			int i=0;
		    System.out.println("+----+----------------+---------------------+---------------+");
		    System.out.println("| ID |     Name       |        Email        |   Password    |");
		    System.out.println("+----+----------------+---------------------+---------------+");

			while(i<k.size())
			{
				Admin a=k.get(i);

				System.out.printf("| %-2d | %-14s | %-19s | %-13s |\n",
				                a.getId(), a.getName(), a.getEmail(), a.getPassword());
				System.out.println("+----+----------------+---------------------+---------------+");
				i++;
				    }

				    
				}

		public void farmerdetaildisplay() throws ClassNotFoundException, SQLException {
			ArrayList<Farmercontrol> k=a.farmerdetaildisplay();
			int i=0;
			System.out.println("+----+----------------+-----------------------+---------------+----------------+");
			System.out.println("| ID |     Name       |         Email         |   Password    |    Location    |");
			System.out.println("+----+----------------+-----------------------+---------------+----------------+");
			while(i<k.size())
			{
				Farmercontrol f=k.get(i);
				 System.out.printf("| %-2d | %-14s | %-21s | %-13s | %-14s |\n",
				                f.getId(), f.getName(), f.getEmail(), f.getPassword(), f.getLocation());
				 System.out.println("+----+----------------+-----------------------+---------------+----------------+");
				 i++;
				    }
				}

		public void orderdetaildisplay() throws ClassNotFoundException, SQLException {
			ArrayList<Ordercontrol>k=a.orderdetaildisplay();
			int i=0;
			System.out.println("+---------+---------------------+----------+--------------+");
		    System.out.println("| Order ID|     Order Date      | Customer | Total Price  |");
		    System.out.println("+---------+---------------------+----------+--------------+");
			while(i<k.size())
			{
				Ordercontrol al=k.get(i);
				
			      System.out.printf("| %-7d | %-19s | %-8d | $%-12.2f |\n",
			                al.getId(), al.getDate().toString(), al.getUserid(), al.getTotal());
			      System.out.println("+---------+---------------------+----------+--------------+");
			      i++;
			    }

			    
			}
				
		public void userdisplay() throws ClassNotFoundException, SQLException {
			ArrayList<Usercontrol>k=a.userdisplay();
			int i=0;
			System.out.println("+----+------------------+---------------------+------------+-----------------+");
			System.out.println("| ID |       Name       |        Email        |  Password  |     Location    |");
			System.out.println("+----+------------------+---------------------+------------+-----------------+");
			while(i<k.size())
			{
				Usercontrol u=k.get(i);
				    System.out.printf("| %-2d | %-16s | %-19s | %-10s | %-15s |\n",
				            u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getLocation());
				    System.out.println("+----+------------------+---------------------+------------+-----------------+");
				    i++;
				}

				
			}
		public void admindisplay() throws ClassNotFoundException, SQLException {
			ArrayList<Bucketlist> k=a.admindisplay();
			int i=0;
			System.out.println("+--------------------------------------------------------------------------------------------------------+");
			System.out.printf("| %-5s | %-10s | %-20s | %-8s | %-8s | %-10s | %-15s | %-15s |\n",
			        "ID", "Email ID", "Product Name", "Quantity", "Price", "Per Kg", "Variety", "Phone Number");
			System.out.println("+--------------------------------------------------------------------------------------------------------+");
			while(i<k.size())
			{
				Bucketlist b=k.get(i);
				    System.out.printf("| %-5d | %-10d | %-20s | %-8d | %-8.2f | %-10.2f | %-15s | %-15s |\n",
				            b.getId(), b.getEmailid(), b.getProductname(), b.getQuantity(), b.getPrice(),
				            b.getPerkg(), b.getVariety(), b.getPhonenumber());
		    System.out.println("+---------------------------------------------------------------------------------------------------------+");
				    i++;
				}
				
			}
		}
