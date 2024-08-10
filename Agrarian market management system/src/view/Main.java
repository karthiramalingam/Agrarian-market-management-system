package view;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
	public static void main(String[] arg) throws ClassNotFoundException,SQLException
	{
		Logic s=new Logic();
		Farmerview f=new Farmerview();
		Userview u=new Userview();
		Scanner sc=new Scanner(System.in);
		int c=0;
		while(c==0) {
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|--- Welcome to Agrarian market management system !! ---  |");
		System.out.println("|                 1 . Admin                               |");
        System.out.println("|                 2 . Farmer                              |");
        System.out.println("|                 3 . user                                |");
        System.out.println("|                 4 . Exit                                |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("Enter the choice : ");
        int choice=sc.nextInt();
        if(choice==1)
        {
        	s.logic();
        	break;
        }
        else if(choice==2)
        {
        	f.logic();
        }
        else if(choice==3)
        {
        	u.logic();
        }
        else if(choice==4)
        {
        	
        }
        else
        {
        	System.out.println("Invaild options");
        }
		}
		
	}
        
	}

