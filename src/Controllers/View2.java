//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decom

package Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Data.Champion;
import Data.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class View2 implements Initializable
{
    @FXML
    public Button select;
    public ComboBox<Champion> cbChamps;
    public Label lblChampionName, lblDmg, lblHP, lblMagic, lblChampTitle;
    public ImageView ivChampPic;
    public ProgressBar pbDmg, pbHP, pbMagic;

    public View2() {}

    private Champion getRandomChamp() throws IOException
    {
        return DataSource.randomChamp();
    }

    @FXML
    void select(ActionEvent event) throws IOException
    {
        Parent root = null;
        Stage stage = (Stage)this.select.getScene().getWindow();
        View3 controller = new View3(cbChamps.getValue(), getRandomChamp(), "PVE");
        try
        {
            FXMLLoader loader = new FXMLLoader((this.getClass().getResource("../View/view3_prefightscreen.fxml")));
            loader.setController(controller);
            root = loader.load();
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
            CrossController.fillComboBox(cbChamps);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void comboChanged(ActionEvent event)
    {
        CrossController.setChamps(cbChamps, lblChampionName, lblChampTitle, lblDmg, lblMagic, lblHP, pbDmg, pbHP, pbMagic, ivChampPic);
    }
}
