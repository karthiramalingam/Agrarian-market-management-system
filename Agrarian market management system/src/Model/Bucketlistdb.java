package Model;
import Model.Farmerdb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Bucketlist;

public class Bucketlistdb {
    
	public static void bucketlistUpdate(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        stmt.executeUpdate(query);
		
    }
    public static ResultSet bucketlistQuery(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        ResultSet result=stmt.executeQuery(query);
        return result;
    }
	public ArrayList<Bucketlist> display(int id) throws ClassNotFoundException, SQLException {
		ArrayList<Bucketlist> k = new ArrayList<Bucketlist>();
		String query="select * from bucketlist where email_id = "+id;
		ResultSet result=bucketlistQuery(query);
		while(result.next())
		{
			Bucketlist al=new Bucketlist();
			al.setId(result.getInt("id"));
			al.setEmailid(result.getInt("email_id"));
			al.setProductname(result.getString("product_name"));
			al.setQuantity(result.getInt("quantity"));
			al.setPrice(result.getDouble("price"));
			al.setPerkg(result.getDouble("per_kg"));
			al.setVariety(result.getString("variety"));
			al.setPhonenumber(result.getString("phone_number"));
			k.add(al);
		} 
		return k;
	}
	public static void addproduct(Bucketlist b) throws ClassNotFoundException, SQLException {
		String query = "insert into bucketlist (email_id, product_name, quantity, price, per_kg, variety, phone_number) values ('" + b.getEmailid() + "', '" + 
                b.getProductname() + "', " + b.getQuantity() + ", " + b.getPrice() + ", " +  b.getPerkg() + ", '" + b.getVariety() + "', '" + b.getPhonenumber() + "')";
		bucketlistUpdate(query);
		System.out.println("Successfully Added the product");

		
	}
	public static void priceupdate(Bucketlist b) throws ClassNotFoundException, SQLException {
		String query = "UPDATE bucketlist SET price = '" + b.getPrice() + "', per_kg = '" + b.getPerkg() + "' WHERE email_id = " + b.getEmailid() ;
		bucketlistUpdate(query);
		System.out.println("Update Successfully Price");
		
	}
	public static void deleteproduct(Bucketlist b) throws ClassNotFoundException, SQLException {
		String query="delete from bucketlist where email_id= "+b.getEmailid();
		bucketlistUpdate(query);
		System.out.println("Delete the Record");
		
	}
	public ArrayList<Bucketlist> userdisplay(String email) throws ClassNotFoundException, SQLException {
		ArrayList<Bucketlist> k = new ArrayList<Bucketlist>();
		String query="select * from bucketlist";
		ResultSet result=bucketlistQuery(query);
		while(result.next())
		{
			Bucketlist al=new Bucketlist();
			al.setId(result.getInt("id"));
			al.setProductname(result.getString("product_name"));
			al.setQuantity(result.getInt("quantity"));
			al.setPrice(result.getDouble("price"));
			al.setPerkg(result.getDouble("per_kg"));
			al.setVariety(result.getString("variety"));
			k.add(al);
		}
		return k;
	}
	public ArrayList<Bucketlist> userbuyproduct(ArrayList<Integer> items) throws ClassNotFoundException, SQLException {
		ArrayList<Bucketlist>k=new ArrayList<Bucketlist>();
		for(int i:items)
		{
			String query="select id,quantity,price,per_kg from bucketlist where id="+i;
			ResultSet result=bucketlistQuery(query);
			while(result.next())
			{
				Bucketlist b=new Bucketlist();
				b.setId(result.getInt("id"));
				b.setQuantity(result.getInt("quantity"));
				b.setPrice(result.getDouble("price"));
				b.setPerkg(result.getDouble("per_kg"));
				k.add(b);
				
			}
			
		}
		return k;
		
	}
	public void userUpdate(int quantity, int id) throws ClassNotFoundException, SQLException {
		String query = "UPDATE bucketlist SET quantity = '" + quantity + "' WHERE id = " + id;
		bucketlistUpdate(query);
		
	}
	public ArrayList<Bucketlist> admindisplay() throws ClassNotFoundException, SQLException {
		   ArrayList<Bucketlist>k=new ArrayList<Bucketlist>();
		   String query="select *from bucketlist";
		   ResultSet result=bucketlistQuery(query);
		   while(result.next())
		   {
			   Bucketlist b=new Bucketlist();
			   b.setId(result.getInt("id"));
			   b.setEmailid(result.getInt("email_id"));
			   b.setProductname(result.getString("product_name"));
			   b.setQuantity(result.getInt("quantity"));
			   b.setPrice(result.getDouble("price"));
			   b.setPerkg(result.getDouble("per_kg"));
			   b.setVariety(result.getString("variety"));
			   b.setPhonenumber(result.getString("phone_number"));
			   k.add(b);
			   
		   }
		return k;
	}

	
	

}
