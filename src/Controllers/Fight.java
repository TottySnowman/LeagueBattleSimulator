package Controllers;

import Data.Champion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class Fight implements Initializable
{
    @FXML
    public ProgressBar hpbar, enemyhpbar;

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
    }
}