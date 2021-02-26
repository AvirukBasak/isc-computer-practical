/*
 * QESTION:
 * WAP to convert numbers b/w any bases
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AnyBase2Base {
	
	static String fromDecimal( final int number, int baseOutput, boolean print ) {
	
		// converts to any base from decimal
		int num = number;
		String result = "";
		while ( num != 0 ) {
			/*
			 * The 'if true' code adds proper hex letters. The to char
			 * cast at 'if false' section ensures int value isn't
			 * returned by the ternery statement since int is prioritized
			 * over char.
			 */
			result = ( ( num % baseOutput > 9 ) ? ( char ) ( num % baseOutput + 55 ) : ( char ) ( num % baseOutput + '0' ) ) + result;
			num /= baseOutput;
		}
		if ( print ) {
			System.out.println( "\nDecimal " + number + " to base " + baseOutput + " = " + result );
		}
		return result;
	}
	
	static int toDecimal( String number, int baseInput, boolean print ) {
	
		// converts from any base to decimal
		int result = 0;
		int digit = 0;
		
		// exctracting digits from rear
		for ( int i = number.length() - 1; i >= 0; i-- ) {
			// This code converts hex alphabets to numbers
			digit = Character.isLetter( number.charAt( i ) ) ? ( int ) ( number.charAt( i ) - 55 ) : ( int ) ( number.charAt( i ) - '0' );
			result += digit * ( int ) Math.pow( baseInput, number.length() - 1 - i );
		}
		if ( print ) {
			System.out.println( "\nBase " + baseInput + " to Decimal = " + result );
		}
		return result;
	}
	
	public static void main( String[] args ) throws IOException {
	
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		while ( true ) {
			// taking input base
			System.out.print( "\nEnter input base: " );
			int baseInput = Integer.parseInt( br.readLine() );
			// taking number input
			System.out.print( "Input base " + baseInput + " number: " );
			String number = br.readLine();
			// taking output base
			System.out.print( "Enter output base: " );
			int baseOutput = Integer.parseInt( br.readLine() );
			
			if ( baseInput == baseOutput ) {
				System.out.print( "Input is already at base " + baseInput );
			}
			else if ( baseInput == 10 ) {
				fromDecimal( Integer.parseInt( number ), baseOutput, true );
			}
			else if ( baseOutput == 10 ) {
				toDecimal( number, baseInput, true );
			}
			else {
				// this piece of code literally allows you to convert
				// b/w any bases, eg base 13 to 20!
				String result = fromDecimal( toDecimal( number, baseInput, false ), baseOutput, false );
				System.out.println( "\nBase " + baseInput + " " + number + " to base " + baseOutput + " = " + result );
			}
			System.out.print( "\nExit? (Y/N): " );
			if ( br.readLine().equalsIgnoreCase( "y" ) ) {
				break;
			}
		}
	}
}

/*
 * OUTPUT:
 * 
 * Enter input base: 16
 * Input base 16 number: A0
 * Enter output base: 10
 * 
 * Base 16 to Decimal = 160
 * 
 * Enter input base: 8
 * Input base 8 number: 10
 * Enter output base: 10
 * 
 * Base 8 to Decimal = 8
 * 
 * Enter input base: 16
 * Input base 16 number: A0
 * Enter output base: 2
 * 
 * Base 16 A0 to base 2 = 10100000
 */
