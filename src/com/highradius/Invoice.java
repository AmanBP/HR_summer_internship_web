package com.highradius;
public class Invoice {
	
	private String iid;
	private String cname;
	private String cnum;
	private double amount;
	private String due_date;
	private String pred_date;
	private String notes;
	
	public Invoice() {
		super();
	}

	public String getiid() {
		return iid;
	}

	public void setiid(String iid) {
		this.iid = iid;
	}

	public String getcname() {
		return cname;
	}

	public void setcname(String cname) {
		this.cname = cname;
	}

	public String getcnum() {
		return cnum;
	}

	public void setcnum(String cnum) {
		this.cnum = cnum;
	}

	public String getdue_date() {
		return due_date;
	}

	public void setdue_date(String due_date) {
		this.due_date = due_date;
	}
	
	public String getpred_date() {
		return pred_date;
	}

	public void setpred_date(String pred_date) {
		this.pred_date = pred_date;
	}

	public String getnotes() {
		return notes;
	}

	public void setnotes(String notes) {
		this.notes = notes;
	}
	
	public double getamount() {
		return amount;
	}
	
	public void setamount(double amount){
		this.amount = amount;
	}
}
