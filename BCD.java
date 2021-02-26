/*
 * QUESTION:
 * 
 * Decimal - 25.32
 * BCD – 0010 0101 . 0011 0010
 * 
 * Class name : BCD
 * 
 * Member functions -
 * input() : take a decimal number as input
 * display() : to display the BCD number
 * convert() : to convert a number to its BCD equivalent
 * 
 * Member variable -
 * double n : the decimal number to be taken as input
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BCD {
	
	void input() {
	
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.print( "Enter number: " );
		
		/*
		 * Handling both java.io.IOException and
		 * java.lang.NumberFormatException
		 */
		try {
			this.n = Double.parseDouble( br.readLine() );
			
		} catch ( Exception e ) {
			
			System.err.println( e );
		}
	}
	
	void display() {
	
		System.out.println( convert() );
	}
	
	String convert() {
	
		int d;
		char c;
		String binary = "";
		String result = "";
		String n = Double.toString( this.n );
		
		for ( int i = 0; i < n.length(); i++ ) {
			
			c = n.charAt( i );
			if ( Character.isDigit( c ) ) {
				
				d = c - (int)'0';
				while ( d != 0 ) {
					
					binary = Integer.toString( d % 2 ) + binary;
					d /= 2;
				}
				
				if ( binary.length() < 4 ) {
					
					for ( int j = 0; j <= 4 - binary.length(); j++ ) {
						
						binary = "0" + binary;
					}
				}
				
				result += binary + " ";
				binary = "";
			}
			else {
				
				result += c + " ";
			}
		}
		
		return result;
	}
	
	double n;
	
	public static void main( String[] args ) {
	
		// Creation object and calling methods
		BCD object = new BCD();
		object.input();
		object.convert();
		object.display();
	}
	
}

/* OUTPUT:
 * 
 * Enter number: 25.32
 * 0010 0101 . 0011 0010 
 */
