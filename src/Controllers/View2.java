//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decom

package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class View2 {
    public Button select;

    public View2() {
    }

    @FXML
    void select(ActionEvent event) {
        Parent root = null;
        Stage stage = (Stage)this.select.getScene().getWindow();

        try {
            root = (Parent)FXMLLoader.load(this.getClass().getResource("view3_prefightscreen.fxml"));
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
