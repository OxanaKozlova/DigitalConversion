package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;

/**
 * Created by Oxana on 17.02.2016.
 */
public class Controller {

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
            seriesAbsolute.getData().add(new XYChart.Data<>(temp.toString(), functionAbsolute.get(i)));
        }
        absolute.getData().add(seriesAbsolute);


        reverse.getXAxis().setAutoRanging(true);
        reverse.getYAxis().setAutoRanging(true);
        XYChart.Series seriesReverse = new XYChart.Series<>();
        seriesReverse.setName("Amplitude Function");
        DigitalConversion reverseConversion = new DigitalConversion();
        ArrayList<Complex> functionReverse = reverseConversion.reverseConversion();
        for(Integer i=0; i<16; i++){
            Double temp = 2*Math.PI/(16)*i;
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
            seriesPhase.getData().add(new XYChart.Data<>(temp.toString(), phaseValue.get(i).phase()));
        }
        phase.getData().add(seriesPhase);
    }
}
