package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controller.Bucketlist;
import controller.Farmercontrol;

public class Farmerdb {
	Bucketlist b=new Bucketlist();
	public static void farmerUpdate(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        stmt.executeUpdate(query);
		
    }
    public static ResultSet farmerQuery(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        ResultSet result=stmt.executeQuery(query);
        return result;
    }
	public static String f_login(String email) throws ClassNotFoundException, SQLException {
		
		String query="select password from farmer_details where email= '"+email+"'";
    	ResultSet result=farmerQuery(query);
    	while(result.next())
    	{
    		return result.getString(1);
    	}
    	return "";
	}
	public void addfarmer(Farmercontrol f) throws ClassNotFoundException, SQLException  {
		String query = "INSERT INTO agricultural.farmer_details (name, email, password, location) VALUES ('" + f.getName() + "', '" + f.getEmail() + "', '" + f.getPassword() + "','"+f.getLocation()+"')";
        farmerUpdate(query);
        System.out.println("Succesfully Registered");
		
	}
	public ArrayList<Bucketlist> display(String email) throws  SQLException, ClassNotFoundException {
		Bucketlistdb bdb=new Bucketlistdb();
		String query="select id from farmer_details where email = '"+email+"';";
		ResultSet result=farmerQuery(query);
		int id=0;
		while(result.next())
		{
			id=result.getInt("id");
		}
		ArrayList<Bucketlist> items = bdb.display(id);
		return items;
	}
	public int addproduct(String email) throws ClassNotFoundException, SQLException {
		//Bucketlistdb bdb=new Bucketlistdb();
		String query="select id from farmer_details where email = '"+email+"';";
		ResultSet result=farmerQuery(query);
		int id=0;
		while(result.next())
		{
			id=result.getInt("id");
		}
		return id;
	}
	public int priceupdate(String email) throws ClassNotFoundException, SQLException {
		String query="select id from farmer_details where email = '"+email+"';";
		ResultSet result=farmerQuery(query);
		int id=0;
		while(result.next())
		{
			id=result.getInt("id");
		}
		
		return id;
		
	}
	public int deleteproduct(String email) throws ClassNotFoundException, SQLException {
		String query="select id from farmer_details where email = '"+email+"';";
		ResultSet result=farmerQuery(query);
		int id=0;
		while(result.next())
		{
			id=result.getInt("id");
		}
		return id;
	}
	public ArrayList<Farmercontrol> farmerdetaildisplay() throws ClassNotFoundException, SQLException {
		ArrayList<Farmercontrol> k=new ArrayList<>();
		String query="select *from farmer_details";
		ResultSet result=farmerQuery(query);
		while(result.next())
		{
			Farmercontrol f=new Farmercontrol();
			f.setId(result.getInt("id"));
			f.setName(result.getString("name"));
			f.setEmail(result.getString("email"));
			f.setPassword(result.getString("password"));
			f.setLocation(result.getString("location"));
			k.add(f);
			
		}
		return k;
	}
	
	
}
