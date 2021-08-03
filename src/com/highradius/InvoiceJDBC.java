package com.highradius;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
@SuppressWarnings("unused")

public class InvoiceJDBC implements InvoiceDAO {

	private Connection connection;
	public InvoiceJDBC(String url, String user,String password) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		this.connection = DriverManager.getConnection(url,user,password);
	}
	
	public void addInvoice(Invoice invoice) throws SQLException {
		String query = "insert into invdata(cname,cnum,iid,amount,duedate,notes)" + "values(?,?,?,?,?,?)";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1,invoice.getcname());
		ps.setString(2,invoice.getcnum());
		ps.setString(3,invoice.getiid());
		ps.setDouble(4,invoice.getamount());
		ps.setString(5,invoice.getdue_date());
		ps.setString(6,invoice.getnotes());
		ps.executeUpdate();

	}

	public void removeInvoice(String iid) throws SQLException {
		String query = "Delete from invdata where iid = ?";
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, iid);
		ps.executeUpdate();
		
	}

	public Invoice getInvoice(String iid) throws SQLException {
		ArrayList<Invoice> array = getAllInvoices();
		for (Invoice invoice : array) {
			if(invoice.getiid().equals(iid)) {
				return invoice;
			}
		}
		return null;
	}

	public ArrayList<Invoice> getAllInvoices() throws SQLException {
		ArrayList<Invoice> array = new ArrayList<Invoice>();
		ResultSet result = this.connection.prepareStatement("select * from invdata").executeQuery();
		while(result.next()) {
			Invoice invoice = new Invoice();
			invoice.setcname(result.getString("cname"));
			invoice.setcnum(result.getString("cnum"));
			invoice.setiid(result.getString("iid"));
			invoice.setamount(result.getDouble("amount"));
			invoice.setdue_date(result.getString("duedate"));
			invoice.setpred_date(result.getString("preddate"));
			invoice.setnotes(result.getString("notes"));
			array.add(invoice);
		}
		result.close();
		return array;
	}
	
	public void editInvoice(String iid, Double amount, String notes) throws SQLException{
			String query = "update invdata SET amount=?,notes=? where iid=?";
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setString(2, notes);
			ps.setString(3,iid);
			ps.executeUpdate();
	}
	
	public ArrayList<Invoice> getxoffsetyInv(int nth, int offset) throws SQLException{
			String query = "Select * from invdata LIMIT ?,?;";
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setInt(1,nth);
			ps.setInt(2,offset);
			ResultSet result = ps.executeQuery();
			ArrayList<Invoice> array = new ArrayList<Invoice>();
			while(result.next()) {
				Invoice invoice = new Invoice();
				invoice.setcname(result.getString("cname"));
				invoice.setcnum(result.getString("cnum"));
				invoice.setiid(result.getString("iid"));
				invoice.setamount(result.getDouble("amount"));
				invoice.setdue_date(result.getString("duedate"));
				invoice.setpred_date(result.getString("preddate"));
				invoice.setnotes(result.getString("notes"));
				array.add(invoice);
			}
			result.close();
			return array;
	}
}
