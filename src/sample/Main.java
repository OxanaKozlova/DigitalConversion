package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("originalFunction.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Digital Conversion");


//
//        NumberAxis x = new NumberAxis();
//        NumberAxis y = new NumberAxis();
//        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
//        numberLineChart.setTitle("Function");
//        XYChart.Series series1 = new XYChart.Series();
//        series1.setName("function");
//
//        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
//
//        for(int i=0; i<16; i++){
//            datas.add(new XYChart.Data(i,Math.sin(i)));
//
//        }
//
//        series1.setData(datas);
//
//        Scene scene = new Scene(new Group(), 600,600);
//        VBox vbox = new VBox();
//        HBox hbox = new HBox();
//        vbox.setLayoutX(20);
//        vbox.setLayoutY(20);
//        hbox.getChildren().addAll(function,amplitude,reverse );
//        vbox.getChildren().addAll(numberLineChart,hbox);
//        numberLineChart.getData().add(series1);
//        ((Group)scene.getRoot()).getChildren().add(vbox);
//        primaryStage.setScene(scene);
       // primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
