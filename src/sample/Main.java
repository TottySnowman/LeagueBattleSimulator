package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Data.*;

import java.io.IOException;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Homescreen.fxml"));
        primaryStage.setTitle("League Battle Simulator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        DataSource d = new DataSource();
        List<Champion> l = d.readJson();
        for (Champion champion : l) {
            System.out.print(champion.getName() + " " + champion.getTitle() +  " " + champion.getIcon() + "\n");
        }
        launch(args);
    }
}
