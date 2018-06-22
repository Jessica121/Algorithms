
public class Pow {
    /*
    if n == 1, return x. if n < 0, return 1 / positive res, put n into positive
    if n % 2 == 0, result == n / 2 multiply each other
    else res add one more self.

    */
    public double myPow(double x, int n) {
        if(n < 0) return 1 / pow(x, -n);
        else return pow(x, n);
    }
    
    private double pow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        double d = pow(x, n / 2);
        if(n % 2 == 0) return d * d;
        else return d * d * x;
    }
}
