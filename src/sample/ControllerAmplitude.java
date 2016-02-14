package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Oxana on 08.02.2016.
 */
public class ControllerAmplitude extends Controller {

    @FXML
    public LineChart lineChart;

    @Override
    public void initialize(){
        lineChart.getXAxis().setAutoRanging(true);
        lineChart.getYAxis().setAutoRanging(true);

        XYChart.Series series = new XYChart.Series<>();
        series.setName("Amplitude Function");
        DigitalConversion function = new DigitalConversion();


        ArrayList<Complex> direct = function.directConversion();
        ArrayList<Double> absolute = function.getAbsolute(direct);


        for(Integer i=0; i<16; i++){
            Double temp = 2*Math.PI/(16)*i;
            series.getData().add(new XYChart.Data<>(temp.toString(), absolute.get(i)));

        }
        lineChart.getData().add(series);
    }

    @FXML
    private void goToOrigin(ActionEvent event) throws IOException {
        changeScene(event,"originalFunction.fxml" );
    }

    @FXML
    private void goToReverse(ActionEvent event) throws IOException{
        changeScene(event,"reverseConverting.fxml" );
    }
}
