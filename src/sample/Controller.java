package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Oxana on 08.02.2016.
 */
public abstract class Controller {
    public void changeScene(ActionEvent event, String stageName)throws IOException {
        Parent original = FXMLLoader.load(getClass().getResource(stageName));
        Scene originalScene = new Scene(original);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(originalScene);
        stage.show();

    }

    public abstract void initialize();
}
