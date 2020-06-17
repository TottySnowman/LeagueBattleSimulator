//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decom

package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Data.Champion;
import Data.DataSource;
import Data.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;


public class View2 implements Initializable
{
    public Button select;
    @FXML
    public ComboBox<Champion> cbChamps;
    @FXML
    public Label lblChampionName;
    @FXML
    public ImageView ivChampPic;
    @FXML
    public ProgressBar pbDmg;
    @FXML
    public ProgressBar pbHP;
    @FXML
    public ProgressBar pbMagic;
    @FXML
    public Label lblDmg;
    @FXML
    public Label lblHP;
    @FXML
    public Label lblMagic;


    public View2() throws IOException
    {

    }

    private ObservableList<Champion> fillDropdown() throws IOException
    {
        DataSource d = new DataSource();
        List<Champion> l = d.readJson();
        ObservableList<Champion> oList = FXCollections.observableArrayList(l);
        return oList;
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

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            ObservableList<Champion> list = fillDropdown();
            cbChamps.setItems(list);
            Callback<ListView<Champion>, ListCell<Champion>> factory = lv -> new ListCell<Champion>() {
                @Override
                protected void updateItem(Champion champ, boolean empty) {
                    super.updateItem(champ, empty);
                    setText(empty ? "" : champ.getName());
                }
            };


            cbChamps.setCellFactory(factory);
            cbChamps.setButtonCell(factory.call(null));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void comboChanged(ActionEvent event)
    {
        //Champion Object
        Champion c = cbChamps.getValue();
        //Sets Label text to Champion name
        lblChampionName.setText(c.getName());
        //Gets the Icon URL
        String sPicLink = c.getIcon();
        //ImageObject
        Image img = new Image(sPicLink);
        ivChampPic.setImage(img);

        Stats s = c.getStats();
        lblDmg.setText(Double.toString(s.getAttackdamage()));
        lblHP.setText(Double.toString(s.getHp()));
        lblMagic.setText(Double.toString(s.getSpellblock()));
        pbDmg.setProgress((s.getAttackdamage() * 0.01));
        pbHP.setProgress((s.getHp() * 0.001));
        pbMagic.setProgress((s.getSpellblock() * 0.01));
    }
}
