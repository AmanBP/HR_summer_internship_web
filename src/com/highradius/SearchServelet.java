package com.highradius;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.*;
@SuppressWarnings("unused")
@WebServlet("/SearchServelet")
public class SearchServelet extends HttpServlet {
	private static final long serialVersionUID = 123467892L;

	private static String db_url = "jdbc:mysql://localhost:3306/highradius";
	private static String username = "root";
	private static String password = "root";
	private InvoiceJDBC ijdbc;
    public SearchServelet() throws ClassNotFoundException, SQLException {
        super();
        this.ijdbc = new InvoiceJDBC(db_url,username,password);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iid = request.getParameter("iid");
		Invoice invoice = new Invoice();
		try {
			invoice = ijdbc.getInvoice(iid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(invoice == null)
		{
			String result = "None";
			PrintWriter out = response.getWriter();
			response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
			out.print(result);
			out.flush();
		}
		else
		{
			Gson gson = new Gson();
			String json_out = gson.toJson(invoice);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
			out.print(json_out);
			out.flush();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
