package team_int_Elligence.Controllers;

import java.awt.List;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import team_int_Elligence.Customer;
import team_int_Elligence.CustomerDB;
import team_int_Elligence.Transaction;

public class CustomerController {

	@FXML
	private Button btnConfm;

	@FXML
	private Label greet;

	@FXML
	private ListView<String> listBox;

	@FXML
	private TextField txtAmt;

	@FXML
	private TextField txtcusID;

	@FXML
	private TextField txtBal;

	public String id;
	public String name;
	public double bal;

	@FXML
	public void setBal() {
		// Display Balance
		txtBal.setText(String.valueOf(bal));
	}

	@FXML
	public void setName() {
		// Set Greeting
		greet.setText("Welcome " + name);
	}

	@FXML
	public void getHistory() {
		CustomerDB cdb = new CustomerDB();
		// Search and Display Customer Transactions
		ArrayList<Transaction> tranzacts = cdb.getTransactionHistory(id);
		if (tranzacts != null) {
			ArrayList<String> list = new ArrayList<String>();
			// Header
			list.add("\t\t\t\t\tAccount History\n" + "\t\t\tTime\t\t\t\t\t\tOperation\t\tAmount\t\tBalance\n");
			for (Transaction t : tranzacts) {
				list.add(t.toString());
			}

			ObservableList<String> data = FXCollections.observableList(list);
			// Populate ListView
			listBox.setItems(data);
		}
	}

	// Log Transactions
	private void transact(String id, String operation, double amount, double balance) {
		// TODO Auto-generated method stub

		CustomerDB cdb = new CustomerDB();
		cdb.setTransactionHistory(new Transaction(id, operation, amount, balance));
	}

	@FXML
	public void makeTransfer() {
		Customer c;

		CustomerDB cdb = new CustomerDB();

		// Search if Customer has account with the bank
		c = cdb.get(txtcusID.getText());

		if (c != null) {

			// Retrieve Amount and Current Balance
			double amt = Double.parseDouble(txtAmt.getText());
			double bal = Double.parseDouble(txtBal.getText());

			// Perform check on balance before withdrawing amount
			double newBal = bal - amt;

			if (newBal >= 0) {
				// Customer Object
				Customer me = cdb.get(id);
				me.setBalance(newBal);

				// Update Customer Detail
				boolean result = cdb.update(me);

				if (result == true) {
					transact(id, "TRF/" + c.getFirstname(), amt, newBal);

					// Retrieve Amount and Current Balance of Recipient
					c = cdb.get(txtcusID.getText()); // done again to update balance in case of self transfer
					double cBal = c.getBalance();
					double dep = cBal + amt;

					// Update Customer Object Balance
					c.setBalance(dep);

					// Update Customer Detail
					boolean result2 = cdb.update(c);
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Customer");
					alert.setHeaderText("\"Mo' Money, Mo' Problem\" - Biggie Smalls");

					// Show Confirmation Message
					if (result2 == true) {
						if (id.equalsIgnoreCase(txtcusID.getText())) {
							alert.setContentText("New balance is: " + dep);
							txtBal.setText(String.valueOf(dep));
						}
						else {
							alert.setContentText("New balance is: " + newBal);
							txtBal.setText(String.valueOf(newBal));
						}
						

						// log transaction
						transact(c.getCustomer_id(), "Credit/" + me.getFirstname(), amt, dep);

						// Refresh
						this.getHistory();
					}
					alert.show();

				} else {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Customer");
					alert.setHeaderText("\"Mo' Money, Mo' Problem\" - Biggie Smalls");

					alert.setContentText("Something went wrong!");
					alert.show();
				}
			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Customer");
				alert.setHeaderText("\"Mo' Money, Mo' Problem\" - Biggie Smalls");

				alert.setContentText("Not enough fund in your account to make this transaction");
				alert.show();

			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Customer");
			alert.setHeaderText("\"Mo' Money, Mo' Problem\" - Biggie Smalls");

			alert.setContentText("Customer not registered with the bank");
			alert.show();
		}
	}
}
