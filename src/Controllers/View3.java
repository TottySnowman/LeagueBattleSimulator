//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Controllers;

import Data.Champion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class View3 implements Initializable
{
    @FXML
    public Label lblChamp1,lblChamp2;
    public ImageView ivChamp1, ivChamp2;
    public Button btnReturn, btnFight, btnRPvX;
    public Champion champ1, champ2;
    public String sMode;

    public View3(Champion champ1, Champion champ2, String sMode)
    {
        if(champ1 == null || champ2 == null)
        {

        }
        else
        {
            this.champ1 = champ1;
            this.champ2 = champ2;
            this.sMode = sMode;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        lblChamp1.setText(champ1.getName());
        Image imgChamp1 = new Image(champ1.getIcon());
        ivChamp1.setImage(imgChamp1);

        lblChamp2.setText(champ2.getName());
        Image imgChamp2 = new Image(champ2.getIcon());
        ivChamp2.setImage(imgChamp2);

        btnFight.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                String sAction = "fPVE";
                if(sMode.equals("PVP"))
                {
                    sAction = "fPVP";
                }
                try
                {
                    setScene(btnFight, sAction);
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }
        });

        btnReturn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    setScene(btnReturn, sMode);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setScene(Button btnName, String sAction) throws IOException
    {
        Parent root = null;
        Stage stage = (Stage)btnName.getScene().getWindow();
        FXMLLoader loader = null;
        Fight fight = new Fight(champ1, champ2);
        switch(sAction)
        {
            case "PVE":
                loader = new FXMLLoader(this.getClass().getResource("../View/view2_pve.fxml"));
                break;

            case "PVP":
                loader = new FXMLLoader(this.getClass().getResource("../View/view5_pvp.fxml"));
                break;

            case "fPVE":
                loader = new FXMLLoader(this.getClass().getResource("../View/view6_fightscreenpve.fxml"));
                loader.setController(fight);
                break;

            case "fPVP":
                loader = new FXMLLoader(this.getClass().getResource("../View/view7_fightscreenpvp.fxml"));
                loader.setController(fight);
                break;
        }
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
