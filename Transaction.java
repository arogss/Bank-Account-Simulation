package team_int_Elligence;

import java.sql.Timestamp;

public class Transaction {
	
	private String customerID;
	private String operation;
	private double amount;
	private double balance;
	private Timestamp timestamp;
	
	
	public Transaction() {
		
	}
	
	public Transaction(String customerID, String operation, double amount, double balance) {
		this.customerID = customerID;
		this.operation = operation;
		this.amount = amount;
		this.balance = balance;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


	@Override
	public String toString() {
		return timestamp + "\t\t\t\t" + operation + "\t\t" + amount + "\t\t" + balance;
	}
	
}
