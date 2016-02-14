package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerOrigin extends Controller{

    @FXML
    public LineChart lineChart;




    @Override
    public void initialize(){
        lineChart.getXAxis().setAutoRanging(true);
        lineChart.getYAxis().setAutoRanging(true);

        XYChart.Series series = new XYChart.Series<>();
        series.setName("Original Function");
        DigitalConversion function = new DigitalConversion();

        for(Integer i=0; i<32; i++){
            Double temp = 2*Math.PI/(16)*i;
             series.getData().add(new XYChart.Data<>(temp.toString(), function.getFunction(i)));

        }
        lineChart.getData().add(series);
    }

    @FXML
    private void goToAmplitude(ActionEvent event) throws IOException{
        changeScene(event,"amplitude.fxml" );
    }

    @FXML
    private void goToReverse(ActionEvent event) throws IOException{
        changeScene(event,"reverseConverting.fxml" );
    }



}
