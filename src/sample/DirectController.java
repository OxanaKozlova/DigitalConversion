package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by Oxana on 17.02.2016.
 */
public class DirectController {

    @FXML
    public LineChart origin;

    @FXML
    public LineChart reverse;

    @FXML
    public LineChart absolute;

    @FXML
    public LineChart phase;

    public  void initialize(){
        origin.getXAxis().setAutoRanging(true);
        origin.getYAxis().setAutoRanging(true);
        XYChart.Series seriesOrigin = new XYChart.Series<>();
        seriesOrigin.setName("Original Function");
        DigitalConversion functionOrigin = new DigitalConversion();
        for(Integer i=0; i<16; i++){
            Double temp = 2*Math.PI/(16)*i;
            temp = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
            seriesOrigin.getData().add(new XYChart.Data<>(temp.toString(), functionOrigin.getFunction(i)));
        }
        origin.getData().add(seriesOrigin);

        absolute.getXAxis().setAutoRanging(true);
        absolute.getYAxis().setAutoRanging(true);
        XYChart.Series seriesAbsolute = new XYChart.Series<>();
        seriesAbsolute.setName("Amplitude Function");
        DigitalConversion function = new DigitalConversion();
        ArrayList<Double> functionAbsolute = function.getAbsolute();
        for(Integer i=0; i<16; i++){
            Double temp = 2*Math.PI/(16)*i;
            temp = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
            seriesAbsolute.getData().add(new XYChart.Data<>(temp.toString(), functionAbsolute.get(i)));
        }
        absolute.getData().add(seriesAbsolute);


        reverse.getXAxis().setAutoRanging(true);
        reverse.getYAxis().setAutoRanging(true);
        XYChart.Series seriesReverse = new XYChart.Series<>();
        seriesReverse.setName("Reverse  Function");
        DigitalConversion reverseConversion = new DigitalConversion();
        ArrayList<Complex> functionReverse = reverseConversion.reverseConversion();
        for(Integer i=0; i<16; i++){
            Double temp = 2*Math.PI/(16)*i;
            temp = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
            seriesReverse.getData().add(new XYChart.Data<>(temp.toString(), functionReverse.get(i).re()));
        }
        reverse.getData().add(seriesReverse);

        phase.getXAxis().setAutoRanging(true);
        phase.getYAxis().setAutoRanging(true);

        XYChart.Series seriesPhase = new XYChart.Series<>();
        seriesPhase.setName("Phase Function");
        DigitalConversion functionPhase = new DigitalConversion();
        ArrayList<Complex> phaseValue = functionPhase.directConversion();
        for(Integer i=0; i<16; i++){
            Double temp = 2*Math.PI/(16)*i;
            temp = new BigDecimal(temp).setScale(2, RoundingMode.UP).doubleValue();
            seriesPhase.getData().add(new XYChart.Data<>(temp.toString(), phaseValue.get(i).phase()));
        }
        phase.getData().add(seriesPhase);
    }

    public void changeScene(ActionEvent event)throws IOException {
        Parent original = FXMLLoader.load(getClass().getResource("fastConversion.fxml"));
        Scene originalScene = new Scene(original);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(originalScene);
        stage.show();
    }
}
