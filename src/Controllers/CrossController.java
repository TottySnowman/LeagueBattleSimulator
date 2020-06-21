package Controllers;

import Data.Champion;
import Data.DataSource;
import Data.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;

public class CrossController
{
    public static void fillComboBox(ComboBox cbBox) throws IOException
    {
        ObservableList<Champion> list = convertList();
        cbBox.setItems(list);
        Callback<ListView<Champion>, ListCell<Champion>> factory = lv -> new ListCell<Champion>() {
            @Override
            protected void updateItem(Champion champ, boolean empty) {
                super.updateItem(champ, empty);
                setText(empty ? "" : champ.getName());
            }
        };

        cbBox.setCellFactory(factory);
        cbBox.setButtonCell(factory.call(null));
    }

    private static ObservableList<Champion>  convertList() throws IOException
    {
        List<Champion> l = DataSource.readJson();
        return FXCollections.observableArrayList(l);
    }

    public static void setChamps(ComboBox cbox, Label lblChampionName, Label lblChampTitle, Label lblDmg, Label lblMagic, Label lblHP, ProgressBar pbDmg, ProgressBar pbHP, ProgressBar pbMagic, ImageView ivChampPic)
    {
        //Champion Object
        Champion c = (Champion) cbox.getValue();
        //Sets Label text to Champion name
        lblChampionName.setText(c.getName());
        //Sets ChampTitle
        lblChampTitle.setText(c.getTitle());
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
