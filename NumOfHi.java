/*
 * QUESTION:
 * 
 * Given a string, compute recursively (no loops) the number of times lowercase 
 * "hi" appears in the string.
 *
 * countHi("xxhixx") → 1
 * countHi("xhixhix") → 2
 * countHi("hi") → 1
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NumOfHi {
	public int countHi( String str ) {
		// Base case, indexOf() returns -1 for "hi" not found
		if( str.indexOf( "hi" ) < 0 ) {
			return 0;
		}
		else {
			// sends rest of the string for exploration, adds 1 to the output
			return 1 + countHi(  str.substring( str.indexOf( "hi" ) + 2 ) );
		}
	}
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.print( "Enter a string: " );
		String str = br.readLine();
		// Used anonymous object for fun
		System.out.println( "Count = " + new NumOfHi().countHi( str ));
	}
}

/* OUTPUT:
 *
 * Enter a string: cxbdzdfxz
 * Count = 0
 * 
 * Enter a string: xxhixxhi
 * Count = 2
 * 
 * Enter a string: hixxxhix
 * Count = 2
 */
