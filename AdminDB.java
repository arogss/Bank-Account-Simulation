package team_int_Elligence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDB implements DAO<Admin> {

	private Connection con;

	public AdminDB() {
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

	public boolean add(Admin a) {
		String sql = "INSERT INTO Admins (admin_id, lastname, firstname, priority) VALUES (?, ?, ?, ?)";

		// create statement object
		try {
			PreparedStatement st = this.con.prepareStatement(sql);

			st.setString(1, a.getAdmin_id());
			st.setString(2, a.getLastname());
			st.setString(3, a.getFirstname());
			st.setString(4, a.getAccess());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean update(Admin a) {
		String query = "UPDATE Admins SET lastname = ?, firstname = ?, priority = ? where admin_id = ?";

		// create statement object
		try {
			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, a.getLastname());
			st.setString(2, a.getFirstname());
			st.setString(3, a.getAccess());
			st.setString(4, a.getAdmin_id());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Admin get(String id) {
		String query = "SELECT * FROM Admins WHERE admin_id = ?";

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Admin a = new Admin();
				a.setAdmin_id(rs.getString("admin_id"));
				a.setLastname(rs.getString("lastname"));
				a.setFirstname(rs.getString("firstname"));
				a.setAccess(rs.getString("priority"));
				rs.close();
				return a;
				
			}
			else {
				rs.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public List<Admin> getAll() {
		String query = "SELECT * FROM Admins ORDER BY admin_id ASC";
        List<Admin> admins = new ArrayList<>();

		// create statement object
		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Admin a = new Admin();
				a.setAdmin_id(rs.getString("admin_id"));
				a.setLastname(rs.getString("lastname"));
				a.setFirstname(rs.getString("firstname"));
				a.setAccess(rs.getString("priority"));
				admins.add(a);
			}
			return admins;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}


	@Override
	public boolean delete(Admin a) {
		String query = "DELETE FROM Admins WHERE admin_id = ?";

		// create statement object
		try {
			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, a.getAdmin_id());

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public Admin login(String id, String lname) {
		String query = "SELECT * FROM Admins WHERE admin_id = ? and lastname = ?";

		// create statement object
		try {

			PreparedStatement st = this.con.prepareStatement(query);

			st.setString(1, id);
			st.setString(2,  lname);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				Admin a = new Admin();
				a.setAdmin_id(rs.getString("admin_id"));
				a.setLastname(rs.getString("lastname"));
				a.setFirstname(rs.getString("firstname"));
				a.setAccess(rs.getString("priority"));
				rs.close();
				return a;
				
			}
			else {
				rs.close();
				return null;
			}

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}
}