package sample;

import java.io.CharArrayReader;
import java.nio.ByteBuffer;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Oxana on 22.02.2016.
 */
public class FastConversion {

    int sumCount = 0;
    int mulCount = 0;
    public ArrayList<Complex> getFunction(){
        ArrayList<Complex> array = new ArrayList<>();
        for(int i = 0; i<16; i++){
            array.add(new Complex((Math.cos(4*Math.PI*i/16)+Math.sin(2*Math.PI*i/16)),0));
        }
        return array ;
    }



    public ArrayList<Complex> fft(ArrayList<Complex> variables, int dir ) {
        if (variables.size() == 1) {
            ArrayList<Complex> temp = new ArrayList<>();
            temp.add(variables.get(0));
            return temp;
        }
        ArrayList< Complex> even = new ArrayList<>();
        ArrayList<Complex> odd = new ArrayList<>();
        for (int i = 0; i < (variables.size() / 2); i++) {
            even.add( variables.get(2*i));
            odd.add(variables.get(2 * i + 1));
        }
        ArrayList<Complex> beven = fft(even, dir);
        ArrayList<Complex> bodd = fft(odd, dir);
        int n = variables.size();
        Complex wn = new Complex(Math.cos(2 * Math.PI / n), dir * Math.sin(2 * Math.PI / n));

        ArrayList<Complex> result = new ArrayList<Complex>(n);
        for(int i = 0; i<n; i++){
            result.add(new Complex(0,0));
        }
        Complex w = new Complex(1, 0);
        for (int i = 0; i < n / 2; i++) {
            Complex tempValue = new Complex (bodd.get(i).times(w).re(), bodd.get(i).times(w).im());
            result.set(i,beven.get(i).plus(tempValue));
            result.set((i+n/2), beven.get(i).minus(tempValue));

            w = w.times(wn);

            sumCount ++;
            mulCount++;
        }
        return result;
    }

    public ArrayList<Double> getAbsolute(ArrayList<Complex> fftResult){
        ArrayList<Double> absolute = new ArrayList<>();
        for(int i = 0; i<fftResult.size(); i++){
            absolute.add(fftResult.get(i).abs()/16);
        }
        return absolute;
    }

    int getSumCount(){
        return sumCount;
    }

    int getMulCount(){
        return  mulCount;
    }
}
