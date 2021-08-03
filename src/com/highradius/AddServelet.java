package com.highradius;
import com.highradius.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("unused")
@WebServlet("/AddServelet")
public class AddServelet extends HttpServlet { 
	private static final long serialVersionUID = 123467891L;
	private static String db_url = "jdbc:mysql://localhost:3306/highradius";
	private static String username = "root";
	private static String password = "root";
	private InvoiceJDBC ijdbc;
    public AddServelet() throws ClassNotFoundException, SQLException {
        super();
        this.ijdbc = new InvoiceJDBC(db_url,username,password);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Invoice invoice = new Invoice();
		invoice.setcname(request.getParameter("cname"));
		invoice.setcnum(request.getParameter("cnum"));
		invoice.setiid(request.getParameter("iid"));
		Double amount = Double.valueOf(request.getParameter("amount"));
		invoice.setamount(amount);
		invoice.setdue_date(request.getParameter("ddate"));
		String notes = "";
		if (request.getParameter("notes") != "")
			notes = request.getParameter("notes");
		else
			notes = null;
		invoice.setnotes(notes);
		try {
			ijdbc.addInvoice(invoice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.html").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
