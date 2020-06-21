package Controllers;

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
    public Button multiplayer;

    public View1() { }

    @FXML
    void singleplayer(ActionEvent event)
    {
        setScene("Single");
    }
    @FXML
    void multiplayer(ActionEvent event)
    {
        setScene("Multi");
    }

    private void setScene(String sMode)
    {
        Parent root = null;
        Stage stage = null;
        if(sMode.equals("Single"))
        {
            stage = (Stage)this.singleplayer.getScene().getWindow();
            try
            {
                root = (Parent)FXMLLoader.load(this.getClass().getResource("../View/view2_pve.fxml"));
            }
            catch (IOException var5)
            {
                var5.printStackTrace();
            }
        }
        else if(sMode.equals("Multi"))
        {
            stage = (Stage)this.multiplayer.getScene().getWindow();
            try
            {
                root = (Parent)FXMLLoader.load(this.getClass().getResource("../View/view5_pvp.fxml"));
            }
            catch (IOException var5)
            {
                var5.printStackTrace();
            }
        }


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
