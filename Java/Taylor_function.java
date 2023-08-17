package Ryd_teulora;
import java.lang.Math;
import java.util.*;

public class Ryd_teulora {

	public static void main(String[] args) {
		
	Scanner in = new Scanner(System.in);
	int k=0;
	double x=0;
		
	x=in.nextDouble();
	
	k=in.nextInt();
		
        if ( k <= 1 ) {
            System.err.println("Invalid argument: " + k );
            System.exit(1);
        }
        
		double Eps = 1 / Math.pow( 10, k + 1 );
		
        double result = 0;
        double step = x;
        int n = 1;
        while( Math.abs( step ) >= Eps ) 
        {
            result += step;
            step = ((step  * x)*x )/( 2*(n*(2*n + 1)));
            n++;
	    }
        String fmt = "%." + Integer.toString(k) + "f\n";
        System.out.printf(fmt,  result );
        System.out.printf(fmt, Math.sinh(x));
        System.exit(0);
		
	}

}