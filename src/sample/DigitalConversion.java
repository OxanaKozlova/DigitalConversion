package sample;

import java.util.ArrayList;

/**
 * Created by oxana on 6.2.16.
 */
public class DigitalConversion {
    public double getFunction(int n){
        return (Math.cos(4*Math.PI*n/16)+Math.sin(2*Math.PI*n/16));
    }


    private ArrayList<Complex> getArrayValue(int sign, int division, boolean isReverse){
        ArrayList<Complex> arrayCoeff = new ArrayList<>();
        for(int i = 0; i<16; i++){
            arrayCoeff.add(getSummand(i, sign, division, isReverse));
        }
        return arrayCoeff;
    }

    private Complex getSummand(int index, int sign, int division, boolean isReverse){
        Complex sum = new Complex(0,0);
        ArrayList<Complex> directConversion = new ArrayList<Complex>() ;
        if(isReverse){
             directConversion = directConversion();
            for(int i = 0; i<16; i++){
                sum = sum.plus(directConversion.get(i).times(new Complex(Math.cos(2*Math.PI*i*index/16),sign*Math.sin(2*Math.PI*i*index/16))));
            }
        }
        else{
            for(int i = 0; i<16; i++){
                sum = sum.plus(new Complex(Math.cos(2*Math.PI*i*index/16),sign*Math.sin(2*Math.PI*i*index/16) ).times(getFunction(i)));
            }
        }
        Complex coeff = sum.divides(new Complex(division,0));
        return coeff;

    }

    public ArrayList<Complex> directConversion(){
        return getArrayValue(1, 16,false);
    }
    public ArrayList<Complex> reverseConversion(){
        return getArrayValue(-1, 1,true);
    }

       public ArrayList<Double> getAbsolute(){
        ArrayList<Double> absoluteArray = new ArrayList<Double>();
           ArrayList<Complex> complexArray = directConversion();
        for(int i = 0; i<complexArray.size(); i++){
            absoluteArray.add(complexArray.get(i).abs());
        }
        return absoluteArray;
    }


}
