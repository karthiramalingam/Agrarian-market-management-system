package controller;

import java.util.ArrayList;

public class Bucketlist {
	   private int id,emailid,quantity;
	   private double price,perkg;
	   private String productname,variety,phonenumber;
       public Bucketlist()
       {
    	   id=0;
    	   emailid=0;
    	   quantity=0;
    	   price=0;
    	   perkg=0;
    	   productname="";
    	   variety="";
    	   phonenumber="";
       }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmailid() {
		return emailid;
	}
	public void setEmailid(int emailid) {
		this.emailid = emailid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPerkg() {
		return perkg;
	}
	public void setPerkg(double perkg) {
		this.perkg = perkg;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
}
