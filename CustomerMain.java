package team_int_Elligence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CustomerMain extends Application{
	
	public void start(Stage stage ) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/CusForm.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customer");
        stage.show();
    }

	public static void main(String[] args){
		launch(args);
	}
}

