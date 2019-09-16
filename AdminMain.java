package team_int_Elligence;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AdminMain extends Application{
	
	public void start(Stage stage ) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/AdminForm.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Admin");
        stage.show();
    }

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		launch(args);
		
	}
}

