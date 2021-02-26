import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Compute extends Design {
	double	area;
	public Compute( String code, double len ) {
		// super class contructor called
		super( code, len );
		area = 0.0;
	}
	void calculate() {
		// calculating area
		if ( code.equalsIgnoreCase( "C" ) ) {
			area = Math.PI * len * len;
		}
		else if ( code.equalsIgnoreCase( "S" ) ) {
			area = len * len;
		}
		else if ( code.equalsIgnoreCase( "T" ) ) {
			// AREA = 0.5 * len * root( 3^2 - (3/2)^2 )			
			area = 0.25 * Math.sqrt( 3 ) * len * len;
		}
	}
	void show() {
		// refering to super class method
		super.show();
		System.out.println( "Area = " + area );
	}
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		// taking inputs
		System.out.print( "Enter shape code: " );
		String code = br.readLine().toUpperCase();
		System.out.print( "Enter shape size: " );
		int len = Integer.parseInt( br.readLine() );
		Compute c = new Compute( code, len );
		c.calculate();
		c.show();
	}
}

/*
 * OUTPUT:
 * 
 * Enter shape code: t
 * Enter shape size: 3
 * 
 * CODE: T
 * Lenght: 3.0
 * Area = 3.897114317029974
 */
