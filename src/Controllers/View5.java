package Controllers;

import Data.Champion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class View5 implements Initializable
{
    @FXML
    public Button select, select1, btnRPvX;
    public ComboBox<Champion> cbChamps1, cbChamps;
    public Label lblChampionName, lblDmg, lblHP, lblMagic, lblChampTitle, lblChampionName1, lblDmg1, lblHP1, lblMagic1, lblChampTitle1;
    public ImageView ivChampPic, ivChampPic1;
    public ProgressBar pbDmg, pbHP, pbMagic, pbDmg1, pbHP1, pbMagic1;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try {
            CrossController.fillComboBox(cbChamps);
            CrossController.fillComboBox(cbChamps1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void comboChanged(ActionEvent Event)
    {
        CrossController.setChamps(cbChamps, lblChampionName, lblChampTitle, lblDmg, lblMagic, lblHP, pbDmg, pbHP, pbMagic, ivChampPic);
    }

    public void comboChanged1(ActionEvent actionEvent)
    {
        CrossController.setChamps(cbChamps1, lblChampionName1, lblChampTitle1, lblDmg1, lblMagic1, lblHP1, pbDmg1, pbHP1, pbMagic1, ivChampPic1);
    }

    public void select(ActionEvent actionEvent)
    {

    }

    public void returnHome(ActionEvent actionEvent)
    {
        Parent root = null;
        Stage stage = (Stage)btnRPvX.getScene().getWindow();

        try
        {
            FXMLLoader loader = loader = new FXMLLoader(this.getClass().getResource("../View/view1_Homescreen.fxml"));
            root = loader.load();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
