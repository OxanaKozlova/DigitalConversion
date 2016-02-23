package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("digitalConversion.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Digital Conversion");


        primaryStage.show();
        FastConversion m = new FastConversion();
        m.inversion();
        HashMap<Integer, Complex> t = m.getFunction();

       // HashMap<Integer, Complex> temp = m.fft(t, -1);
//
//        for(int i = 0; i<temp.size(); i++){
//            System.out.println(temp.get(i));
//        }
//



    }


    public static void main(String[] args) {
        launch(args);
    }
}
