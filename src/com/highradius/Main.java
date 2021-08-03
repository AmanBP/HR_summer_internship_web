package com.highradius;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.google.gson.Gson;
@SuppressWarnings("unused")
public class Main {
	public static void printijdbc(Invoice invoice) {
		String output = "iID: " + invoice.getiid() + "\n" +
				"cname: " + invoice.getcname() + "\n" +
				"cnum: " + invoice.getcnum() + "\n" +
				"amount: " + invoice.getamount() + "\n" +
				"due_date: " + invoice.getdue_date() + "\n" +
				"pred_date: " + invoice.getpred_date() + "\n" +
				"notes: " + invoice.getnotes() + "\n";
		System.out.println(output);
	}
	public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/highradius";
		String user = "root";
		String password = "root";
		InvoiceJDBC ijdbc = new InvoiceJDBC(url, user, password);
		Invoice inv = new Invoice();
		ArrayList<Invoice> array = new ArrayList<Invoice>();
		int nth = 0;
		int offset = 3;
		try {
			array = ijdbc.getxoffsetyInv(nth, offset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i=0;i<array.size();i++)
		{
			printijdbc(array.get(i));
		}
	}
}