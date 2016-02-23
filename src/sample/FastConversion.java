package sample;

import java.io.CharArrayReader;
import java.nio.ByteBuffer;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Oxana on 22.02.2016.
 */
public class FastConversion {
    public ArrayList<Complex> getFunction(){
        ArrayList<Complex> array = new ArrayList<>();
//        System.out.println("function");
        for(int i = 0; i<16; i++){
            array.add(new Complex((Math.cos(4*Math.PI*i/16)+Math.sin(2*Math.PI*i/16)),0));
//            System.out.print(array.get(i)+"   ");
        }
        return array ;
    }

    public ArrayList<Complex> fft(ArrayList<Complex> variables, int dir ) {
        if (variables.size() == 1) {
            ArrayList<Complex> temp = new ArrayList<>();
            temp.add(variables.get(0));
            return temp;
        }
//        System.out.println("Variables in fft");
//        for(int i = 0; i<variables.size(); i++){
//            System.out.print(variables.get(i)+"    ");
//        }
        ArrayList< Complex> even = new ArrayList<>();
        ArrayList<Complex> odd = new ArrayList<>();
        for (int i = 0; i < (variables.size() / 2); i++) {
            even.add( variables.get(2*i));
            odd.add(variables.get(2 * i + 1));
        }
        ArrayList<Complex> beven = fft(even, -1);
        ArrayList<Complex> bodd = fft(odd, -1);
        int n = variables.size();
        Complex wn = new Complex(Math.cos(2 * Math.PI / n), dir * Math.sin(2 * Math.PI / n));

        ArrayList<Complex> result = new ArrayList<Complex>();
        Complex w = new Complex(1, 0);
        for (int i = 0; i < n / 2; i++) {
            Complex tempValue = new Complex (bodd.get(i).times(w).re(), bodd.get(i).times(w).im());
            result.add(beven.get(i).plus(tempValue));
            result.add( beven.get(i).minus(tempValue));
            w = w.times(wn);
        }
        return result;
    }

    public ArrayList<Double> getAbsolute(ArrayList<Complex> fftResult){
        ArrayList<Double> absolute = new ArrayList<>();
        for(int i = 0; i<fftResult.size(); i++){
            absolute.add(fftResult.get(i).abs());
        }
        return absolute;
    }
}
