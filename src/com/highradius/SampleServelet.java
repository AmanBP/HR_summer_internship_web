package com.highradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import com.highradius.*;

@SuppressWarnings("unused")
@WebServlet("/SampleServelet")
public class SampleServelet extends HttpServlet {
	private static final long serialVersionUID = 123467890L;
	private static String db_url = "jdbc:mysql://localhost:3306/highradius";
	private static String username = "root";
	private static String password = "root";
	private InvoiceJDBC ijdbc;
	
    public SampleServelet() throws SQLException, ClassNotFoundException
    {
        super();
        this.ijdbc = new InvoiceJDBC(db_url,username,password);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{	
			ArrayList<Invoice> array = new ArrayList<Invoice>();
			array = ijdbc.getAllInvoices();
			Response inner_response = new Response();
			int size = array.size();
			inner_response.setNum_inv(size);
			inner_response.setinvoicelist(array);
			Gson gson = new GsonBuilder().setPrettyPrinting().create(); // new Gson()
			String json_out = gson.toJson(inner_response);
			//PrintWriter out = response.getWriter();
			//response.setContentType("application/json");
		    //response.setCharacterEncoding("UTF-8");
			//out.print(json_out);
			//out.flush();
			/*
			Invoice test = new Invoice();
			String iid = request.getParameter("iid");
			System.out.println(iid);
			test = ijdbc.getInvoice(iid);
			String json_out = new Gson().toJson(test);*/
//			PrintWriter out = response.getWriter();
//			response.setContentType("application/json");
//		    response.setCharacterEncoding("UTF-8");
//			out.print(json_out);
//			out.flush();
			//System.out.println(json_out);
			//Forward to jsp if needed.
			request.setAttribute("result",json_out);
			request.getRequestDispatcher("/WEB-INF/SampleServelet.jsp").forward(request, response);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
