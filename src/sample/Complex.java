package sample;

/**
 * Created by oxana on 6.2.16.
 */
public class Complex {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    public Complex(double real, double imag)
    {
        re = real;
        im = imag;
    }



    public String toString()
    {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    public double abs()
    { return Math.hypot(re, im); }  // Math.sqrt(re*re + im*im)
    public double phase()
    { return Math.atan2(im, re); }  // between -pi and pi

    public Complex sqrt()
    {
        Complex a = this;             // invoking object
        double r = Math.sqrt(this.abs());
        double theta = this.phase()/2;
        return new Complex(r*Math.cos(theta), r*Math.sin(theta));
    }

    public Complex log()
    {
        Complex a = this;             // invoking object
        double x = Math.log(this.abs());
        double y = this.phase();
        return new Complex(x, y);
    }

    public Complex plus(Complex b)
    {
        Complex a = this;
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex b)
    {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex b)
    {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    public Complex times(double alpha)
    {  return new Complex(alpha * re, alpha * im); }

    public Complex conjugate() {  return new Complex(re, -im); }

    public Complex reciprocal()
    {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    public double re() { return re; }
    public double im() { return im; }

    public Complex divides(Complex b)
    {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    public Complex exp()
    {  return new Complex(Math.exp(re) * Math.cos(im),
            Math.exp(re) * Math.sin(im));  }

    public Complex sin()
    {  return new Complex(Math.sin(re) * Math.cosh(im),
            Math.cos(re) * Math.sinh(im)); }

    public Complex cos()
    {  return new Complex(Math.cos(re) * Math.cosh(im),
            -Math.sin(re) * Math.sinh(im)); }

    public Complex tan()
    { return sin().divides(cos()); }

    public static Complex plus(Complex a, Complex b)
    {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    public static Complex neg(Complex z)
    {
        return new Complex(-z.re(), -z.im());
    }
}
