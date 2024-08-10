package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;

import controller.Bucketlist;
import controller.Ordercontrol;

public class Orderdb {
	public static void orderUpdate(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        stmt.executeUpdate(query);
		
    }
    public static ResultSet orderQuery(String query) throws ClassNotFoundException, SQLException
    {
        Statement stmt=(Databaseconnectivity.getConnection()).createStatement();
        ResultSet result=stmt.executeQuery(query);
        return result;
    }
	public void order(Ordercontrol o) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO orders (order_date, customer_id, total_price) VALUES ('" + java.sql.Date.valueOf(LocalDate.now()) + "', '" + o.getUserid() + "', " + o.getTotal() + ")";
       orderUpdate(query);
	}
	public ArrayList<Ordercontrol> display(int k2) throws ClassNotFoundException, SQLException {
		ArrayList<Ordercontrol> k = new ArrayList<>();
		String query = "SELECT * FROM orders WHERE customer_id = '" + k2 + "' ORDER BY order_id DESC LIMIT 1";
		ResultSet result=orderQuery(query);
		while(result.next())
		{
			Ordercontrol al=new Ordercontrol();
			al.setId(result.getInt("order_id"));
			al.setDate(result.getDate("order_date"));
			al.setUserid(result.getInt("customer_id"));
			al.setTotal(result.getDouble("total_price"));
			k.add(al);
		}
		return k;
	}
	public ArrayList<Ordercontrol> orderdetaildisplay() throws ClassNotFoundException, SQLException {
		ArrayList<Ordercontrol> k=new ArrayList<>();
		String query="select *from orders";
		ResultSet result=orderQuery(query);
		while(result.next())
		{
			Ordercontrol al=new Ordercontrol();
			al.setId(result.getInt("order_id"));
			al.setDate(result.getDate("order_date"));
			al.setUserid(result.getInt("customer_id"));
			al.setTotal(result.getDouble("total_price"));
			k.add(al);
		}
		return k;
	}
	

}
