package lk.Demo.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Appinitilizer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        try {
            primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../src/viwe/Customer.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../src/view/DashBord.fxml"))));
        primaryStage.setTitle("CustomerForm");
        primaryStage.centerOnScreen();
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
