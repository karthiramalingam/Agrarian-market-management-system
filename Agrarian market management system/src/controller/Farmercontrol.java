package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Farmerdb;
import controller.Bucketlist;

public class Farmercontrol {
	       private int id;
	       private String name,email,password,location;
        public Farmercontrol()
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
				 Farmerdb fdb=new Farmerdb();
				 ArrayList<Bucketlist> k1=fdb.display(email);
				return k1;
			}
			
        
}
