/*
 * QUESTION:
 * 
 * Accept MX8 as dimensions of a 2dimensional array. Fill up the array with the
 * binary conversion of M no. Of decimal number .Print the column nos. Which
 * are having maximum number of 1’s in it. If the converted binary number is
 * not comprising of 8 bits eg for 8 it is 1000 fill it up with 00001000.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillMatrix {
	
	// Calculates no of 1s in a column
	static int noOf1s( int[][] matrix, int column ) {
	
		int noOf1s = 0;
		for ( int i = 0; i < matrix.length; i++ ) {
			if ( matrix[ i ][ column ] == 1 ) {
				noOf1s++;
			}
		}
		return noOf1s;
	}
	
	public static void main( String[] args ) throws IOException {
	
		String binary = "";
		int decimal = 0, colOfMax1s = 0, noOf1s = 0;
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.print( "Enter 'M': " );
		int M = Integer.parseInt( br.readLine() );
		int[][] matrix = new int[M][8];
		
		for ( int i = 0; i < matrix.length; i++ ) {
			/*
			 * decimal has a range [0, 511]. 511 has 8 1s in it.
			 * That is the biggest number storable in this 'M' 'bytes'
			 * of simulated memory using array 'matrix'.
			 */
			decimal = ( int ) ( Math.random() * 512 );
			
			while ( binary.length() != 8 ) {
				
				// Calculating binary
				binary = decimal % 2 + binary;
				decimal /= 2;
			}
			
			for ( int j = 0; j < matrix[ 0 ].length; j++ ) {
				
				// Filling the matrix with binary
				matrix[ i ][ j ] = binary.charAt( j ) - ( int ) '0';
			}
			binary = "";
		}
		
		// printing the matrix
		System.out.println( "\nGENERATED MATRIX:" );
		for ( int[] element : matrix ) {
			for ( int subElement : element ) {
				System.out.print( "  " + subElement );
			}
			System.out.println();
		}
		
		// finding column of max no. of 1s
		for ( int i = 0; i < matrix[ 0 ].length; i++ ) {
			if ( noOf1s( matrix, i ) > noOf1s ) {
				noOf1s = noOf1s( matrix, i );
				colOfMax1s = i;
			}
		}
		System.out.print( "\nColumn with maximum 1s = " + colOfMax1s );
	}
}

/* OUTPUT:
 * 
 * Enter 'M': 5
 * 
 * GENERATED MATRIX:
 * 1 0 1 0 0 1 1 0
 * 0 0 0 0 0 1 0 1
 * 1 1 0 0 0 1 0 1
 * 0 1 1 0 0 0 0 1
 * 0 0 0 1 1 0 1 1
 * 
 * Column with maximum 1s = 7
 */
