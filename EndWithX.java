/*
 * QUESTION:
 * 
 * Given a string, compute recursively a new string where all the lower case 'x'
 * chars have been moved to the end of the string.
 * 
 * endX("xxre") → "rexx"
 * endX("xxhixx") → "hixxxx"
 * endX("xhixhix") → "hihixxx"
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class EndWithX {
	private int	index;
	public EndWithX( int length ) {
		index = length;
	}
	public String endX( String str ) {
		// Set index within String bounds
		if ( index == str.length() ) {
			index--;
		}
		/*
		 * When starting index is receeded
		 * nothing is done, except to return str
		 */
		if ( index == -1 ) {}
		else if ( str.charAt( index ) == 'x' ) {
			// Exclude x from String, put it at the end
			str = str.substring( 0, index ) + str.substring( index + 1 ) + 'x';
			index--;
			str = endX( str );
		}
		else {
			index--;
			str = endX( str );
		}
		return str;
	}
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.print( "Enter expression: " );
		String str = br.readLine();
		EndWithX mte = new EndWithX( str.length() );
		System.out.println( mte.endX( str ) );
	}
}

/*
 * OUTPUT:
 * 
 * Enter expression: xex
 * exx
 * 
 * Enter expression: hixhixhix
 * hihihixxx
 * 
 * Enter expression: xxhixx
 * hixxxx
 */

