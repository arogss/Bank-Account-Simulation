package team_int_Elligence.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import team_int_Elligence.Customer;
import team_int_Elligence.CustomerDB;
import team_int_Elligence.Transaction;

public class BankerController {

    @FXML
    private Button btnVDet;

    @FXML
    private TextField txtFname;

    @FXML
    private Button btnWthdr;

    @FXML
    private Label greet;
    
    public String name;

    @FXML
    private TextField txtcusID;

    @FXML
    private TextField txtOper;

    @FXML
    private TextField txtLname;

    @FXML
    private TextField txtBal;

    @FXML
    private Button btnDepo;
    
    
    @FXML
    public void setName() {
    	//Set Greeting 
    	greet.setText("Welcome "+ name);
    }

    @FXML
	private void viewDetails() {
    	//Create Customer Object with the needed CustomerID
		CustomerDB cdb = new CustomerDB();
		//Search DB
		Customer d = cdb.get(txtcusID.getText());

		if (d == null) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Customer");
			alert.setHeaderText("Customer");
			alert.setContentText("no customer with that id");
			alert.show();
		} else {
			txtLname.setText(d.getLastname());
			txtFname.setText(d.getFirstname());
			txtBal.setText(String.valueOf(d.getBalance()));
		}

	}

	@FXML
	private void deposit() {
		//Retrieve Amount and Current Balance
		double amt = Double.parseDouble(txtOper.getText());
		this.viewDetails();
		double bal = Double.parseDouble(txtBal.getText());
		double dep = bal + amt;

		//Create Customer Object
		Customer c = new Customer();
		c.setCustomer_id(txtcusID.getText());
		c.setLastname(txtLname.getText());
		c.setFirstname(txtFname.getText());
		c.setBalance(dep);

		//Update Customer Detail
		CustomerDB cdb = new CustomerDB();
		boolean result = cdb.update(c);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Customer");
		alert.setHeaderText("\"Mo' Money, Mo' Problem\" - Biggie Smalls");

		//Show Confirmation Message
		if (result == true) {
			alert.setContentText("New balance is: " + dep);
			txtBal.setText(String.valueOf(dep));
			
			//log transaction
			transact(txtcusID.getText(), "credit_Bnkr", amt, dep);
		} else {
			alert.setContentText("Deposit " + result);
		}
		alert.show();
	}

	//Log Transactions
	private void transact(String id, String operation, double amount, double balance) {
		// TODO Auto-generated method stub
		
		CustomerDB cdb = new CustomerDB();
		cdb.setTransactionHistory(new Transaction(id, operation, amount, balance));
	}

	@FXML
	private void withdraw() {
		//Retrieve Amount and Current Balance
				double amt = Double.parseDouble(txtOper.getText());
				this.viewDetails();
				double bal = Double.parseDouble(txtBal.getText());

				//Perform check on balance after withdrawing amount
				double newBal = bal - amt;

				if (newBal >= 0) {
					//Customer Object
					Customer c = new Customer();
					c.setCustomer_id(txtcusID.getText());
					c.setLastname(txtLname.getText());
					c.setFirstname(txtFname.getText());
					c.setBalance(newBal);

					//Update Customer Detail
					CustomerDB cdb = new CustomerDB();
					boolean result = cdb.update(c);
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Customer");
					alert.setHeaderText("\"Mo' Money, Mo' Problem\" - Biggie Smalls");
					
					if (result == true) {
						alert.setContentText("New balance is: " + newBal);
						txtBal.setText(String.valueOf(newBal));
						
						//log transaction
						transact(txtcusID.getText(), "debit_Bnkr", amt, newBal);
					} else {
						alert.setContentText("Withdarw " + result);
					}
					alert.show();
				} else {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Customer");
					alert.setHeaderText("Mo' Money Mo' Problem - Biggie Smalls");
					alert.setContentText("Amount exceeds available balance");
					alert.show();
				}

	}

}
