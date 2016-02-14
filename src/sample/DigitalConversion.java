package sample;

import java.util.ArrayList;

/**
 * Created by oxana on 6.2.16.
 */
public class DigitalConversion {
    public double getFunction(int argument){
        return (Math.cos(4*Math.PI*argument/16)+Math.sin(2*Math.PI*argument/16));
    }

    private double getReal(int argument, int index){
        return (getFunction(argument)*Math.cos(2*Math.PI*argument*index/16));
    }

    private double getImaginary(int argument, int index){
        return (getFunction(argument)*Math.sin(2*Math.PI*argument*index/16));

    }

    private Complex createCoeff(int index, int sign, int division){
        Complex sum = new Complex(0,0);
        for(int i = 0; i<16; i++){
            sum = sum.plus(new Complex(getReal(i, index), (getImaginary(i, index))*sign));
        }
        Complex coeff = sum.divides(new Complex(division,0));
        return coeff;
    }

    private ArrayList<Complex> getArrayCoeff(int sign, int division){
        ArrayList<Complex> arrayCoeff = new ArrayList<>();
        for(int i = 0; i<16; i++){
            arrayCoeff.add(createCoeff(i, sign, division));
        }
        return arrayCoeff;
    }

    public ArrayList<Complex> directConversion(){
        return getArrayCoeff(-1, 16);
    }

    public ArrayList<Complex> reverseConversion(){
        return getArrayCoeff(1, 1);
    }

    public ArrayList<Double> getAbsolute(ArrayList<Complex> complexArray){
        ArrayList<Double> absoluteArray = new ArrayList<Double>();
        for(int i = 0; i<complexArray.size(); i++){
            absoluteArray.add(complexArray.get(i).abs());
        }
        return absoluteArray;
    }
}
