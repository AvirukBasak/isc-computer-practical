/*
 * 
 * QUESTION:
 * 
 * Often, we hear commercials give out their numbers with phrases. When we press
 * for the phrases on the keypad, we are indirectly translating the phrases
 * into numbers. Now, we want to know what are the actual numbers based on a
 * typical keypad configuration as shown below:
 * 
 * Input Format:
 * 
 * The input contains one phone number string s. You can assume that the input
 * is
 * perfectly formed (dashed separators always provided, number starts with 1,
 * and
 * no illegal characters are given).Thus, you do not need to perform any
 * specific
 * validation checks on the input, in order to make your program simpler.
 * However,
 * please note that the number of dashed separators and their positions in the
 * input phone numbers could be different. For instance, 1-800-ABC-DEFG, 1-800
 * AB-CDEFG, 1-800-ABCDEFG are all possible inputs.
 * 
 * Output Format:
 * 
 * The function must return a string which converts all characters in the phone
 * number to numbers.
 * 
 * Sample Input 1:
 * 1-800-CALL-NOW
 * 
 * Sample Output 1:
 * 1-800-2255-669
 * 
 * Explanation 1:
 * For each letter in the String, Using the phone dial pad, we have a matching:
 * 
 * C-2
 * A-2
 * L-5
 * L-5
 * N-6
 * O-6
 * W-9
 * 
 * Sample Input 2:
 * 1-800-AIRLINE
 * 
 * Sample Output 2:
 * 1-800-2475463
 * 
 * Explanation 2:
 * For each letter in the String, Using the phone dial pad, we have a matching:
 * A-2
 * I-4
 * R-7
 * L-5
 * I-4
 * N-6
 * E-3
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class CommercialPhrase {
	// Reference data stored in array
	final static String[]	codes	= { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.print( "Enter phrase: " );
		String s = br.readLine();
		int j;
		char c = '\u0000';
		// Outer loop traverses String
		for ( int i = 0; i < s.length(); i++ ) {
			c = s.charAt( i );
			// Inner loop traverses reference array 'codes'
			for ( j = 2; j < codes.length; j++ ) {
				/*
				 * This checks if the character exists in a set of
				 * of letters from 'codes'. If not found throught
				 * 'codes', next String s character is brought
				 * into focus
				 */
				if ( codes[ j ].indexOf( c ) == -1 ) {
					continue;
				}
				else {
					/*
					 * If found in 'codes', that position value of
					 * 'codes' replaces the letter.
					 */
					s = s.substring( 0, i ) + j + s.substring( i + 1 );
				}
			}
		}
		System.out.println( "Number: " + s );
	}
}

/*
 * OUTPUT:
 * 
 * Enter phrase: 1-800-CALL-NOW
 * Number: 1-800-2255-669
 * 
 * Enter phrase: 1-800-AIRLINE
 * Number: 1-800-2475463
 */