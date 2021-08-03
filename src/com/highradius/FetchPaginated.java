package com.highradius;
import com.highradius.*;
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
@SuppressWarnings("unused")
@WebServlet("/FetchPaginated")
public class FetchPaginated extends HttpServlet {
    private static final long serialVersionUID = 123467892L;
	private static String db_url = "jdbc:mysql://localhost:3306/highradius";
	private static String username = "root";
	private static String password = "root";
	private InvoiceJDBC ijdbc;
	public FetchPaginated() throws ClassNotFoundException, SQLException {
        super();
		this.ijdbc = new InvoiceJDBC(db_url,username,password);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Invoice> array = new ArrayList<Invoice>();
		int nth = Integer.parseInt(request.getParameter("index"));
		int offset = Integer.parseInt(request.getParameter("offset"));
		try {	
			array = ijdbc.getxoffsetyInv(nth, offset);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String result = gson.toJson(array);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(result);
		out.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
