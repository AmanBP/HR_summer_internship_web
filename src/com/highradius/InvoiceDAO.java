package com.highradius;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InvoiceDAO {
	public void addInvoice(Invoice invoice) throws SQLException;
	public void removeInvoice(String iid) throws SQLException;
	public Invoice getInvoice(String iid) throws SQLException;
	public ArrayList<Invoice> getAllInvoices() throws SQLException;
	public void editInvoice(String iid, Double amount, String notes) throws SQLException;
	public ArrayList<Invoice> getxoffsetyInv(int nth, int offset) throws SQLException;
}

