package team_int_Elligence.Controllers;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import team_int_Elligence.Admin;
import team_int_Elligence.AdminDB;
import team_int_Elligence.Banker;
import team_int_Elligence.BankerDB;
import team_int_Elligence.Customer;
import team_int_Elligence.CustomerDB;

public class AdminController {

    @FXML
    private Button btnListAdm;

    @FXML
    private Button btnRetrBnkr;

    @FXML
    private TextField txtadminID;

    @FXML
    private TextField txtFnameAdm;

    @FXML
    private Button btnAddmin;

    @FXML
    private TextField txtLnameAdm;

    @FXML
    private Button btnDelBnkr;

    @FXML
    private ListView<String> listviewAdm;

    @FXML
    private TextField txtFname;

    @FXML
    private TextField txtAccAdm;

    @FXML
    private Button btnUpdtBnkr;

    @FXML
    private TextField txtLnamebnkr;

    @FXML
    private Button btnDel;

    @FXML
    private TextField txtbnkrID;

    @FXML
    private Button btnAddBnkr;

    @FXML
    private Button btnRetr;

    @FXML
    private Button btnDelAdm;

    @FXML
    private Button btnUpdtAdm;

    @FXML
    private Button btnUpdt;

    @FXML
    private Button btnRetrAdm;

    @FXML
    private Button btnListBnkr;

    @FXML
    private TextField txtLname;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnListCus;

    @FXML
    private TextField txtcusID;

    @FXML
    private TextField txtFnamebnkr;

    @FXML
    private TextField txtBal;

    @FXML
    void addAdmin() {
    	Admin a = new Admin();
    	a.setAdmin_id(txtadminID.getText());
    	a.setLastname(txtLnameAdm.getText());
    	a.setFirstname(txtFnameAdm.getText());
    	a.setAccess(txtAccAdm.getText());
    	
    	AdminDB adb = new AdminDB();
    	boolean result = adb.add(a);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Admin");
        alert.setHeaderText("Admin");
        alert.setContentText("Admin added " + result);
        alert.show();

    }

    @FXML
    void updateAdmin() {
    	//Update with the passed in details
    	Admin a = new Admin();
    	a.setAdmin_id(txtadminID.getText());
    	a.setLastname(txtLnameAdm.getText());
    	a.setFirstname(txtFnameAdm.getText());
    	a.setAccess(txtAccAdm.getText());
    	
    	AdminDB adb = new AdminDB();
    	boolean result = adb.update(a);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Admin");
        alert.setHeaderText("Admin");
        alert.setContentText("Admin updated " + result);
        alert.show();

    }

    @FXML
    void getAdmin() {
    	Admin a = new Admin();
    	
    	AdminDB adb = new AdminDB();
    	a = adb.get(txtadminID.getText());
		if (a == null) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Admin");
			alert.setHeaderText("Admin");
			alert.setContentText("No admin with that ID");
			alert.show();
		} else {
			txtLnameAdm.setText(a.getLastname());
			txtFnameAdm.setText(a.getFirstname());
			txtAccAdm.setText(a.getAccess());
		}

    }

    @FXML
	void delAdmin() {
		Admin a = new Admin();
		a.setAdmin_id(txtadminID.getText());

		AdminDB adb = new AdminDB();
		boolean result = adb.delete(a);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Admin");
		alert.setHeaderText("Admin");
		alert.setContentText("Admin deleted " + result);
		alert.show();

	}

    @FXML
    void getAllAdmin() {
		AdminDB adb = new AdminDB();
		ArrayList <String> list = new ArrayList<String>();
		for (Admin a : adb.getAll()) {
			list.add(a.toString());
		}
		
		ObservableList<String> data = FXCollections.observableList(list);
		//Populate the ListView
		listviewAdm.setItems(data);
    }

    @FXML
    void addBanker() {
    	Banker b = new Banker();
    	b.setBanker_id(txtbnkrID.getText());
    	b.setLastname(txtLnamebnkr.getText());
    	b.setFirstname(txtFnamebnkr.getText());
    	
    	BankerDB bdb = new BankerDB();
    	boolean result = bdb.add(b);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Banker");
        alert.setHeaderText("Banker");
        alert.setContentText("Banker added " + result);
        alert.show();

    }

    @FXML
    void updateBanker() {
    	//Update with the passed in details
    	Banker b = new Banker();
    	b.setBanker_id(txtbnkrID.getText());
    	b.setLastname(txtLnamebnkr.getText());
    	b.setFirstname(txtFnamebnkr.getText());
    	
    	BankerDB bdb = new BankerDB();
    	boolean result = bdb.update(b);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Banker");
        alert.setHeaderText("Banker");
        alert.setContentText("Banker updated " + result);
        alert.show();

    }

    @FXML
	void getBanker() {
    	Banker b = new Banker();

    	BankerDB bdb = new BankerDB();
		b = bdb.get(txtbnkrID.getText());
		if (b == null) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Banker");
			alert.setHeaderText("Banker");
			alert.setContentText("No banker with that ID");
			alert.show();
		} else {
			txtLnamebnkr.setText(b.getLastname());
			txtFnamebnkr.setText(b.getFirstname());
		}

	}

    @FXML
    void delBanker() {
    	Banker b = new Banker();
		b.setBanker_id(txtbnkrID.getText());

		BankerDB bdb = new BankerDB();
		boolean result = bdb.delete(b);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Banker");
		alert.setHeaderText("Banker");
		alert.setContentText("Banker deleted " + result);
		alert.show();

    }

    @FXML
    void getAllBankers() {
    	BankerDB bdb = new BankerDB();
		ArrayList <String> list = new ArrayList<String>();
		for (Banker b : bdb.getAll()) {
			list.add(b.toString());
		}
		
		ObservableList<String> data = FXCollections.observableList(list);
		//Populate the ListView
		listviewAdm.setItems(data);

    }

    @FXML
    void addCus() {
    	Customer c = new Customer();
    	c.setCustomer_id(txtcusID.getText());
    	c.setLastname(txtLname.getText());
    	c.setFirstname(txtFname.getText());
    	c.setBalance(Double.parseDouble(txtBal.getText()));
    	
    	CustomerDB cdb = new CustomerDB();
    	boolean result = cdb.add(c);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Customer");
        alert.setHeaderText("Customer");
        alert.setContentText("Customer added " + result);
        alert.show();

    }

    @FXML
    void updateCus() {
    	//Update with the passed in details
    	Customer c = new Customer();
    	c.setCustomer_id(txtcusID.getText());
    	c.setLastname(txtLname.getText());
    	c.setFirstname(txtFname.getText());
    	c.setBalance(Double.parseDouble(txtBal.getText()));
    	
    	CustomerDB cdb = new CustomerDB();
    	boolean result = cdb.update(c);
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Customer");
        alert.setHeaderText("Customer");
        alert.setContentText("Customer updated " + result);
        alert.show();

    }

    @FXML
    void getCus() {
    	Customer c = new Customer();

    	CustomerDB cdb = new CustomerDB();
		c = cdb.get(txtcusID.getText());
		if (c == null) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Customer");
			alert.setHeaderText("Customer");
			alert.setContentText("No customer with that ID");
			alert.show();
		} else {
			txtLname.setText(c.getLastname());
			txtFname.setText(c.getFirstname());
			txtBal.setText(String.valueOf(c.getBalance()));
		}

    }

    @FXML
    void delCus() {
    	Customer c = new Customer();
		c.setCustomer_id(txtcusID.getText());

		CustomerDB cdb = new CustomerDB();
		boolean result = cdb.delete(c);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Customer");
		alert.setHeaderText("Customer");
		alert.setContentText("Customer deleted " + result);
		alert.show();

    }

    @FXML
    void getAllCustomers() {
    	CustomerDB cdb = new CustomerDB();
		ArrayList <String> list = new ArrayList<String>();
		for (Customer c : cdb.getAll()) {
			list.add(c.toString());
		}
		
		ObservableList<String> data = FXCollections.observableList(list);
		//Populate the ListView
		listviewAdm.setItems(data);

    }
    

}
