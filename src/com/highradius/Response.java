package com.highradius;
import java.util.ArrayList;
import com.highradius.*;
@SuppressWarnings("unused")

public class Response {
	private int num_inv;
	private ArrayList<Invoice> invoicelist;
	
	public int getNum_inv() {
		return num_inv;
	}
	public void setNum_inv(int num_inv) {
		this.num_inv = num_inv;
	}
	public ArrayList<Invoice> getinvoicelist(){
		return invoicelist;
	}
	public void setinvoicelist(ArrayList<Invoice> invoicelist){
		this.invoicelist = invoicelist;
	}
}
