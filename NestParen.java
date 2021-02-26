/*
 * QUESTION:
 * 
 * Given a string, return true if it is a nesting of zero or more pairs of
 * parenthesis, like ; ‘(())” or “((()))” Suggestion: check the first and last
 * chars, and then recur on what’s inside them.
 * 
 * nestParen(“(())”) → true
 * nestParen(“((()))”) → true
 * nestParen(“(((x))”) → false
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
public class NestParen {
    public static void main( String[] args ) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        // Taking input, &+$ for loop termination
        System.out.print( "INPUT: " );
        String exp = br.readLine();
        int trackBraces = 0;
        int index = 0;
        char c;
        /* Termination "expression". The probability of presence of exactly "&+$"
         * at the end of an entered string is (1/96!) or 10 ^(-146) percent
         * That is almost zero.
         */
        while ( index < exp.length() ) {
            c = exp.charAt( index );
            // Opening braces
            if ( c == '(' ) {
                trackBraces ++;
            }
            // Closing braces
            else if ( c == ')' ) {
                trackBraces --;
                /* Pushing marker element for Output check block
                System.err.print( "NOTE: " + c );
                trackBraces ++; */
            }
            index ++;
        }
        // Output check
        System.out.println( "OUTPUT = " + ( trackBraces == 0 ) );
    }
}

/*
 * OUTPUT:
 * 
 * INPUT: (((((((((()))))))))) 
 * OUTPUT = true
 * 
 * INPUT: (X+Y(v))+(z)+(X 
 * OUTPUT = false
 * 
 * INPUT: (((x)) 
 * OUTPUT = false
 * 
 */
