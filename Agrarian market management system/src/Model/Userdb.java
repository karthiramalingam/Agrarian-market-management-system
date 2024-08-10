package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Bucketlist;
import controller.Usercontrol;

public class Userdb {

	public static void userUpdate(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        stmt.executeUpdate(query);
		
    }
    public static ResultSet userQuery(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        ResultSet result=stmt.executeQuery(query);
        return result;
    }
	
	
	public String u_login(String email) throws ClassNotFoundException, SQLException {
		
		String query="select password from login where email= '"+email+"'";
    	ResultSet result=userQuery(query);
    	while(result.next())
    	{
    		return result.getString(1);
    	}
    	return "";
		
	}
	public void addUser(Usercontrol u) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO agricultural.login (name, email, password, location) VALUES ('" + u.getName() + "', '" + u.getEmail() + "', '" + u.getPassword() + "','"+u.getLocation()+"')";
        userUpdate(query);
        System.out.println("Succesfully Registered");
		
	}
	public int useroderid(String email) throws ClassNotFoundException, SQLException {
		String query="select id from login where email= '"+email+"'";
    	ResultSet result=userQuery(query);
    	int id=0;
    	while(result.next())
    	{
    	     id=result.getInt(1);
    	}
		return id;
	}
	public ArrayList<Usercontrol> userdisplay() throws ClassNotFoundException, SQLException {
		ArrayList<Usercontrol> k=new ArrayList<>();
		String query="select *from login";
		ResultSet result=userQuery(query);
		while(result.next())
		{
			Usercontrol u=new Usercontrol();
			u.setId(result.getInt("id"));
			u.setName(result.getString("name"));
			u.setEmail(result.getString("email"));
			u.setPassword(result.getString("password"));
			u.setLocation(result.getString("location"));
			k.add(u);
		}
		return k;
	}
	
	

}
