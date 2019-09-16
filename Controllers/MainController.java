package team_int_Elligence.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team_int_Elligence.Admin;
import team_int_Elligence.AdminDB;
import team_int_Elligence.Banker;
import team_int_Elligence.BankerDB;
import team_int_Elligence.Customer;
import team_int_Elligence.CustomerDB;
import javafx.fxml.Initializable;

public class MainController implements Initializable {

	@FXML
	private TextField txtID;

	@FXML
	private Button btnLogin;

	@FXML
	private PasswordField txtLname;

	@FXML
	void login(ActionEvent event) throws SQLException, IOException {
		String id = txtID.getText();
		String lname = txtLname.getText();

		// perform function based on the first character of the id
		switch (id.charAt(0)) {

		// if its a customer
		case 'c':
			CustomerDB cdb = new CustomerDB();
			Customer c = cdb.login(id, lname);

			//if login credential is valid
			if (c != null) {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("../resources/CusForm.fxml"));
				loader.load();
				Parent root = loader.getRoot();
				CustomerController cc = loader.getController();
				cc.id = c.getCustomer_id();
				cc.name = c.getFirstname();
				cc.bal = c.getBalance();
				cc.setName();
				cc.setBal();
				cc.getHistory();
				stage.setTitle("Customer");
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

			}
			else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Customer");
		        alert.setHeaderText("Customer");
		        alert.setContentText("Incorrect id or password");
		        alert.show();
			}
			break;

		// if its an admin
		case 'a':
			AdminDB adb = new AdminDB();
			Admin a = adb.login(id, lname);

			//if login credential is valid
			if (a != null) {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("../resources/AdminForm.fxml"));
				loader.load();
				Parent root = loader.getRoot();
				AdminController ac = loader.getController();
				stage.setTitle("Admin");
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

			}
			else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Admin");
		        alert.setHeaderText("Admin");
		        alert.setContentText("Incorrect id or password");
		        alert.show();
			}
			break;

		// if its a banker
		case 'b':
			BankerDB bdb = new BankerDB();
			Banker b = bdb.login(id, lname);

			//if login credential is valid
			if (b != null) {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("../resources/BankerForm.fxml"));
				loader.load();
				Parent root = loader.getRoot();
				BankerController bc = loader.getController();
				bc.name = b.getFirstname();
				bc.setName();
				stage.setTitle("Banker");
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

			}
			else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Banker");
		        alert.setHeaderText("Banker");
		        alert.setContentText("Incorrect id or password");
		        alert.show();
			}
			break;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
