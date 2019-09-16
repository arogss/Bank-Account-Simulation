package team_int_Elligence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BankerMain extends Application{
	
	public void start(Stage stage ) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/BankerForm.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Customer information");
        stage.show();
    }

	public static void main(String[] args){
		launch(args);
	}
}

