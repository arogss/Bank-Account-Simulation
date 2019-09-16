package team_int_Elligence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB implements DAO<Customer> {

	private Connection con;

	public CustomerDB() {
		try {
			String username = "n01304773";
			String password = "oracle";
			String url = "jdbc:oracle:thin:@calvin.humber.ca:1521:grok";

			// create a connection
			this.con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public boolean add(Customer c) {
		String sql = "INSERT INTO Customers (customerid, lastname, firstname, balance) VALUES (?, ?, ?, ?)";

		// create statement object
		try {
			PreparedStatement st = this.con.prepareStatement(sql);

			st.setString(1, c.getCustomer_id());
			st.setString(2, c.getLastname());
			st.setString(3, c.getFirstname());
			st.setDouble(4, c.getBalance());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean update(Customer c) {
		String query = "UPDATE Customers SET lastname = ?, firstname = ?, balance = ? where customerid = ?";

		// create statement object
		try {
			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, c.getLastname());
			st.setString(2, c.getFirstname());
			st.setDouble(3, c.getBalance());
			st.setString(4, c.getCustomer_id());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Customer get(String id) {
		String query = "SELECT * FROM Customers WHERE customerid = ?";

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Customer c = new Customer();
				c.setCustomer_id(rs.getString("customerid"));
				c.setLastname(rs.getString("lastname"));
				c.setFirstname(rs.getString("firstname"));
				c.setBalance(rs.getDouble("balance"));

				return c;

			} else {
				rs.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public List<Customer> getAll() {
		String query = "SELECT * FROM Customers ORDER BY customerid ASC";
		List<Customer> customers = new ArrayList<>();

		// create statement object
		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Customer c = new Customer();
				c.setCustomer_id(rs.getString("customerid"));
				c.setLastname(rs.getString("lastname"));
				c.setFirstname(rs.getString("firstname"));
				c.setBalance(rs.getDouble("balance"));
				customers.add(c);
			}
			return customers;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}

	@Override
	public boolean delete(Customer c) {
		String query = "DELETE FROM Customers WHERE customerid = ?";

		try {
			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, c.getCustomer_id());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public Customer login(String id, String lastname) {
		String query = "SELECT * FROM Customers WHERE customerid = ? and lastname = ?";

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, id);
			st.setString(2, lastname);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Customer c = new Customer();
				c.setCustomer_id(rs.getString("customerid"));
				c.setLastname(rs.getString("lastname"));
				c.setFirstname(rs.getString("firstname"));
				c.setBalance(rs.getDouble("balance"));

				return c;

			} else {
				rs.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	public boolean setTransactionHistory(Transaction t) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Transactions (customerid, operation, amount, balance) VALUES (?, ?, ?, ?)";

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, t.getCustomerID());
			st.setString(2, t.getOperation());
			st.setDouble(3, t.getAmount());
			st.setDouble(4, t.getBalance());
			
			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public ArrayList<Transaction> getTransactionHistory(String id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM transactions WHERE customerid = ? ORDER BY time ASC";
		ArrayList<Transaction> transactions = new ArrayList<>();

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Transaction t = new Transaction();
				t.setCustomerID(rs.getString("customerid"));
				t.setOperation(rs.getString("operation"));
				t.setAmount(rs.getDouble("amount"));
				t.setBalance(rs.getDouble("balance"));
				t.setTimestamp(rs.getTimestamp("time"));
				transactions.add(t);
			}
			return transactions;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
}
