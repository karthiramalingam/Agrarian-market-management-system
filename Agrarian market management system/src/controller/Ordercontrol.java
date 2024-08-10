package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Model.Orderdb;
public class Ordercontrol {
	     private int id,userid;
	     private double total;
         private Date date;
		
		public Ordercontrol()
         {
        	 
         }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		 public double getTotal() {
				return total;
		}
		public void setTotal(double total) {
				this.total = total;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public ArrayList<Ordercontrol> display(int k) throws ClassNotFoundException, SQLException {
			Orderdb odb=new Orderdb();
			ArrayList<Ordercontrol>k1=odb.display(k);
			return k1;
		}
	
		
}
