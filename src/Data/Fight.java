package Data;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Fight implements Initializable
{
    Champion champ1, champ2;
    public Fight(Champion champ1, Champion champ2)
    {
        this.champ1 = champ1;
        this.champ2 = champ2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}