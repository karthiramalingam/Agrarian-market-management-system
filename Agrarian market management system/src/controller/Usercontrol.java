package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Bucketlistdb;
import Model.Userdb;
public class Usercontrol {
	
	 private int id;
     private String name,email,password,location;
  public Usercontrol()
  {
  	     id=0;
  	     name="";
  	     email="";
  	     password="";
  	     location="";
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
  	public void setLocation(String location)
  	{
  		this.location=location;
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
  	public String getLocation()
  	{
  		return location;
  	}
	public ArrayList<Bucketlist> display(String email) throws ClassNotFoundException, SQLException {
		 Bucketlistdb b=new Bucketlistdb();
		 ArrayList<Bucketlist> k1=b.userdisplay(email);
		return k1;
	}
	public ArrayList<Bucketlist> userbuyproduct(ArrayList<Integer> items) throws ClassNotFoundException, SQLException {
		Bucketlistdb b=new Bucketlistdb();
		ArrayList<Bucketlist> k=b.userbuyproduct(items);
		return k;
	}
	public void userUpdate(int quantity, int id) throws ClassNotFoundException, SQLException {
	  Bucketlistdb b=new Bucketlistdb();
	  b.userUpdate(quantity,id);
	}
	
	public int userorderid(String email) throws ClassNotFoundException, SQLException {
		Userdb udb=new Userdb();
		int k=udb.useroderid(email);
		return k;
	}

	}
	
	
	
	
	
  

