package Controllers;

import Data.Champion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Fight implements Initializable
{
    @FXML
    public ProgressBar hpbar, enemyhpbar;
    public Label lblChampName1, lblChampName2, lblDmgChamp1, lblDmgChamp2;
    public ImageView ivChamp1, ivChamp2;

    Champion champ1, champ2;
    public Fight(Champion champ1, Champion champ2)
    {
        this.champ1 = champ1;
        this.champ2 = champ2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        hpbar.setStyle("-fx-accent: green");
        enemyhpbar.setStyle("-fx-accent: #E89D6B");
        lblChampName1.setText(champ2.getName());
        lblChampName2.setText(champ1.getName());
        ivChamp1.setImage(new Image(champ2.getIcon()));
        ivChamp2.setImage(new Image(champ1.getIcon()));
    }
}