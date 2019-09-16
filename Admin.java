package team_int_Elligence;

public class Admin {
	private String admin_id;
	private String lastname;
	private String firstname;
	private String access;
	
	public Admin() {}

	public Admin(String admin_id, String lastname, String firstname, String access) {
		this.admin_id = admin_id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.access = access;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
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

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", lastname=" + lastname + ", firstname=" + firstname + ", access="
				+ access + "]";
	}
	
	

}
