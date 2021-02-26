/*
 * QUESTION
 * 
 * We'll say that a "triple" in a string is a char appearing three times in a
 * row.
 * Return the number of triples in the given string. The triples may overlap.
 * 
 * 
 * countTriple("abcXXXabc") → 1
 * countTriple("xxxabyyyycd") → 3
 * countTriple("a") → 0
 * 
 * Solve the problem with non recursive way aswell as recursive way.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Triples {
	public int countTripleRecursively( String str ) {
		/*
		 * If length is less than 3, this will prevent an exception
		 * Also this acts as the base case
		 */
		if ( str.length() < 3 ) {
			return 0;
		}
		// For 3 successive matches
		else if ( str.charAt( 0 ) == str.charAt( 1 ) & str.charAt( 1 ) == str.charAt( 2 ) ) {
			// Adds 1, calls itself for the rest of the string
			return 1 + countTripleRecursively( str.substring( 1 ) );
		}
		else {
			// Adds nothing, just calls itself
			return countTripleRecursively( str.substring( 1 ) );
		}
	}
	public int countTripleNonRecursively( String str ) {
		int count = 0;
		// If size is less than 3, we must give up
		while ( str.length() >= 3 ) {
			// For 3 successive matches
			if ( str.charAt( 0 ) == str.charAt( 1 ) & str.charAt( 1 ) == str.charAt( 2 ) ) {
				// Just an increment
				count++;
			}
			/*
			 * Replacing original string with
			 * rest of the string that's yet to
			 * be explored ( "scanned" )
			 */
			str = str.substring( 1 );
		}
		return count;
	}
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		Triples t = new Triples();
		int n = 0;
		while ( n++ != 3 ) {
			System.out.print( "Enter a string: " );
			String str = br.readLine();
			System.out.println( "Result from recursion = " + t.countTripleRecursively( str ) );
			System.out.println( "Result from non-recursion = " + t.countTripleNonRecursively( str ) );
		}
	}
}

/*
 * OUTPUT:
 * 
 * Enter a string: abcXXXabc
 * Result from recursion = 1
 * Result from non-recursion = 1
 * 
 * Enter a string: xxxabyyyycd
 * Result from recursion = 3
 * Result from non-recursion = 3
 * 
 * Enter a string: a
 * Result from recursion = 0
 * Result from non-recursion = 0
 */

