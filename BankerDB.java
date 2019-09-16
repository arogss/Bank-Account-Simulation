package team_int_Elligence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankerDB implements DAO<Banker> {

	private Connection con;

	public BankerDB() {
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

	public boolean add(Banker b) {
		String sql = "INSERT INTO Bankers (banker_id, lastname, firstname) VALUES (?, ?, ?)";

		// create statement object
		try {
			PreparedStatement st = this.con.prepareStatement(sql);

			st.setString(1, b.getBanker_id());
			st.setString(2, b.getLastname());
			st.setString(3, b.getFirstname());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean update(Banker b) {
		String query = "UPDATE Bankers SET lastname = ?, firstname = ? where banker_id = ?";

		// create statement object
		try {
			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, b.getLastname());
			st.setString(2, b.getFirstname());
			st.setString(3, b.getBanker_id());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Banker get(String id) {
		String query = "SELECT * FROM Bankers WHERE banker_id = ?";

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Banker b = new Banker();
				b.setBanker_id(rs.getString("banker_id"));
				b.setLastname(rs.getString("lastname"));
				b.setFirstname(rs.getString("firstname"));
				rs.close();
				return b;

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
	public List<Banker> getAll() {
		String query = "SELECT * FROM Bankers ORDER BY banker_id ASC";
		List<Banker> bankers = new ArrayList<>();

		// create statement object
		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Banker b = new Banker();
				b.setBanker_id(rs.getString("banker_id"));
				b.setLastname(rs.getString("lastname"));
				b.setFirstname(rs.getString("firstname"));
				bankers.add(b);
			}
			return bankers;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}

	@Override
	public boolean delete(Banker b) {
		String query = "DELETE FROM Bankers WHERE banker_id = ?";

		try {
			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, b.getBanker_id());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public Banker login(String id, String lname) {
		String query = "SELECT * FROM Bankers WHERE banker_id = ? and lastname = ?";

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, id);
			st.setString(2, lname);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Banker b = new Banker();
				b.setBanker_id(rs.getString("banker_id"));
				b.setLastname(rs.getString("lastname"));
				b.setFirstname(rs.getString("firstname"));
				rs.close();
				return b;

			} else {
				rs.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
}
