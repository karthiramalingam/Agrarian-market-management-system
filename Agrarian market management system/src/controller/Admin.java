package controller;
import java.sql.SQLException;
import java.util.*;
import controller.Bucketlist;
import Model.Bucketlistdb;
import Model.Userdb;
import Model.Orderdb;
import Model.Farmerdb;
import Model.Admindb;
public class Admin{
	private int id;
	private String name,email,password;
	public Admin(){
	     id=0;
	     name="";
	     email="";
	     password="";
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	public ArrayList<Bucketlist> admindisplay() throws ClassNotFoundException, SQLException {
		Bucketlistdb bdb=new Bucketlistdb();
		ArrayList<Bucketlist> k=bdb.admindisplay();
		return k;
	}
	public ArrayList<Usercontrol> userdisplay() throws ClassNotFoundException, SQLException {
		Userdb udb=new Userdb();
		ArrayList<Usercontrol>k=udb.userdisplay();
		return k;
	}
	public ArrayList<Ordercontrol> orderdetaildisplay() throws ClassNotFoundException, SQLException {
		Orderdb odb=new Orderdb();
		ArrayList<Ordercontrol> k=odb.orderdetaildisplay();
		return k;
	}
	public ArrayList<Farmercontrol> farmerdetaildisplay() throws ClassNotFoundException, SQLException {
		Farmerdb fdb=new Farmerdb();
		ArrayList<Farmercontrol> k=fdb.farmerdetaildisplay();
		return k;
	}
	public ArrayList<Admin> admindetaildisplay() throws ClassNotFoundException, SQLException {
		Admindb adb=new Admindb();
		ArrayList<Admin> k=adb.admindetaildisplay();
		return k;
	}
}
