/*
 * QUESTION: Write a program to remove 1st occurance of elements from a
 * 1-Dimensional array
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class IstOccurance {
	// gives -1 if element not found
	static int nextIndex( String[] array, String element, int from ) {
		for ( int i = from; i < array.length; i++ )
			if ( array[ i ].equals( element ) )
				return i;
		return -1;
	}
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		// taking input
		System.out.print( "Enter array size: " );
		int size = Integer.parseInt( br.readLine() );
		String[] array = new String[size];
		String[] removed = new String[size];
		for ( int i = 0; i < size; i++ ) {
			System.out.print( "Enter for index " + i + ": " );
			array[ i ] = br.readLine();
			removed[ i ] = "";
		}
		// removing 1st ocuurence
		for ( int i = 0, j = 0; i < size; i++ ) {
			/*
			 * If the element appears after i ie after current index,
			 * it may or may not be 1st occurence. That is why the
			 * removed array is also checked if the element has once
			 * been removed.
			 */
			if ( nextIndex( array, array[ i ], i + 1 ) != -1 & nextIndex( removed, array[ i ], 0 ) == -1 ) {
				removed[ j++ ] = array[ i ];
				array[ i ] = "";
			}
		}
		// output
		for ( String x : array ) {
			if ( !x.equals( "" ) )
				System.out.print( x + "\t" );
		}
	}
}

/*
 * OUTPUT:
 * 
 * Enter array size: 5
 * Enter for index 0: 1
 * Enter for index 1: 2
 * Enter for index 2: 1
 * Enter for index 3: 3
 * Enter for index 4: 2
 * 1    3    2
 */
