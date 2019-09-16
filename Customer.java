package team_int_Elligence;

public class Customer {
	private String customer_id;
	private String lastname;
	private String firstname;
	private double balance;
	
	public Customer() {
		
	}

	public Customer(String customer_id, String lastname, String firstname, double balance) {
		this.customer_id = customer_id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.balance = balance;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", lastname=" + lastname + ", firstname=" + firstname
				+ ", balance=" + balance + "]";
	}
	
	

}
