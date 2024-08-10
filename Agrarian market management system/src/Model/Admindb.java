package Model;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Admin;

public class Admindb {
	public static void adminUpdate(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        stmt.executeUpdate(query);
		
    }
    public static ResultSet adminQuery(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        ResultSet result=stmt.executeQuery(query);
        return result;
    }
    
    public static String adLogin(String email) throws ClassNotFoundException, SQLException
    {
    	String query="select A_password from admin where A_email= '"+email+"'";
    	ResultSet result=adminQuery(query);
    	while(result.next())
    	{
    		return result.getString(1);
    	}
    	return "";
    }
	
	public void addAdmin(Admin a) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO agricultural.admin (A_name, A_email, A_password) VALUES ('" + a.getName() + "', '" + a.getEmail() + "', '" + a.getPassword() + "')";
        adminUpdate(query);
        System.out.println("Succesfully Registered");
	
		
	}
	public ArrayList<Admin> admindetaildisplay() throws ClassNotFoundException, SQLException {
		
		ArrayList<Admin> k=new ArrayList<Admin>();
		String query="select *from admin";
		ResultSet result=adminQuery(query);
		while(result.next())
		{
			Admin a=new Admin();
			a.setId(result.getInt("A_id"));
			a.setName(result.getString("A_name"));
			a.setEmail(result.getString("A_email"));
			a.setPassword(result.getString("A_password"));
			k.add(a);
		}
		return k;
	}
	public void insertadmin(Admin a) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO agricultural.admin (A_name, A_email, A_password) VALUES ('" + a.getName() + "', '" + a.getEmail() + "', '" + a.getPassword() + "')";
        adminUpdate(query);
        System.out.println("Succesfully Admin to Add");
	}
}
