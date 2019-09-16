package team_int_Elligence;

public class Banker {
	private String banker_id;
	private String lastname;
	private String firstname;
	
	public Banker() {}

	public Banker(String banker_id, String lastname, String firstname) {
		this.banker_id = banker_id;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public String getBanker_id() {
		return banker_id;
	}

	public void setBanker_id(String banker_id) {
		this.banker_id = banker_id;
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

	@Override
	public String toString() {
		return "Banker [banker_id=" + banker_id + ", lastname=" + lastname + ", firstname=" + firstname + "]";
	}
	
	

}
