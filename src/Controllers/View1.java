package Controllers;

import Data.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class View1 {
    public Button singleplayer;

    public View1() {
    }

    @FXML
    void singleplayer(ActionEvent event)
    {
        Parent root = null;
        Stage stage = (Stage)this.singleplayer.getScene().getWindow();
        try
        {
            root = (Parent)FXMLLoader.load(this.getClass().getResource("view2_championselectpve.fxml"));
        }
        catch (IOException var5)
        {
            var5.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
