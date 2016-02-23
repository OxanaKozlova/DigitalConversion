package sample;

import java.nio.ByteBuffer;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Oxana on 22.02.2016.
 */
public class FastConversion {
    public HashMap<Integer, Complex> getFunction(){
        HashMap<Integer,Complex> array = new HashMap<>();
        for(int i = 0; i<16; i++){
            array.put(i, new Complex((Math.cos(4*Math.PI*i/16)+Math.sin(2*Math.PI*i/16)),0));
        }
        return array ;
    }

    public void inversion(){

//        String bin_str = Integer.toBinaryString(12);
//        String firstPart = bin_str.substring(0,2);
//        String secondPart = bin_str.substring(2,4);
//        String newString = secondPart+firstPart;
//
//
//
//        Integer index = Integer.parseInt(newString, 2);
//        System.out.println(index);
        int i = 12;

        String s = new String("aaa");
        s = s.replace('a', 'b');
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.insert(0, i & 1);
            i >>= 1;
        }
        if (sb.length() == 0) sb.append("0");
        System.out.println(sb);

    }

    public HashMap<Integer,Complex> fft(HashMap<Integer,Complex> variables, int dir ) {
        if (variables.size() == 1) {
            HashMap<Integer,Complex> temp = new HashMap<>();
            temp.put(0, variables.get(0));
            return temp;
        }


        HashMap<Integer, Complex> even = new HashMap<>();
        HashMap<Integer, Complex> odd = new HashMap<>();
        for (int i = 0; i < (variables.size() / 2); i++) {
            even.put(2*i, variables.get(2*i));
            odd.put((2*i+1),variables.get(2 * i + 1));
        }
        HashMap<Integer, Complex> beven = fft(even, -1);
        HashMap<Integer, Complex> bodd = fft(odd, -1);
        int n = variables.size();
        Complex wn = new Complex(Math.cos(2 * Math.PI / n), dir * Math.sin(2 * Math.PI / n));

        HashMap<Integer,Complex> result = new HashMap<Integer,Complex>();
        Complex w = new Complex(1, 0);
        //Complex tempValue = new Complex(0, 0);
        for (int i = 0; i < n / 2; i++) {
            Complex tempValue = new Complex (bodd.get(i).times(w).re(), bodd.get(i).times(w).im());
            result.put(i,beven.get(i).plus(tempValue));
            result.put((i+n/2), beven.get(i).minus(tempValue));
            w = w.times(wn);
        }
        return result;
    }
}
