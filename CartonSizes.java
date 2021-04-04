/*
 * QUESTION:
 * 
 * A company mamnufactures cartons to fit 6, 12, 24 or 48 boxes (of equal
 * dimensions). Contruct a program to input number of boxes to be packed and
 * output the number of cartons (with capacity) needed for packing.
 * 
 * More preference is given to larger cartons. For boxes less than six, use
 * a six capacity carton.
 * 
 * Example:
 * 
 * INPUT:
 * Total boxes = 726
 * 
 * OUTPUT:
 * 
 * CAP 	CARTONS 	BOXES
 * 
 * 48 	15 		720
 * 6 		1 		6
 * 
 * Total cartons = 16
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CartonSizes {
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		// Taking input
		System.out.print( "Total boxes = " );
		int boxes = Integer.parseInt( br.readLine() );
		System.out.println();
		int cartons = 0;
		int capacity = 48;
		int totalCartons = 0;
		System.out.println( "CAP\tCARTON\tBOXES\n" );
		// calculating carton size and quantity
		while ( boxes != 0 ) {
			if ( boxes >= capacity ) {		
				// no. of cartons
				cartons = boxes / capacity;
				// print result
				System.out.print( capacity + "\t" + cartons + "\t" + ( capacity * cartons ) + "\n" );
				// this is for the output footer
				totalCartons += cartons;
				// remaining cartons which is less than 48
				boxes %= capacity;
			}
			else if ( boxes < 6 ) {
				// when less than 6 boxes remain
				System.out.print( capacity + "\t" + "1" + "\t" + boxes + "\n" );
				totalCartons += 1;
				boxes = 0;
			}
			else {
				/* when boxes are more than 6 but less than current capacity value
				 * an optimum carton capacity is selected
				 */
				capacity /= 2;
			}
		}
		System.out.println( "\nTotal cartons = " + totalCartons );
	}
}

/*
 * OUTPUT:
 * 
 * Total boxes = 729
 * 
 * CAP	CARTON	BOXES
 * 
 * 48   15      720
 * 6    1       6
 * 6    1       3
 * 
 * Total cartons = 17
 */

