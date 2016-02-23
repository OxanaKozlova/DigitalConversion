package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("digitalConversion.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Digital Conversion");


        primaryStage.show();
        FastConversion m = new FastConversion();

        ArrayList< Complex> t = m.getFunction();
        ArrayList<Complex> result =  m.fft(t, -1);
        for(int i = 0; i<result.size(); i++){
            System.out.println(result.get(i));
        }



    }


    public static void main(String[] args) {
        launch(args);
    }
}
