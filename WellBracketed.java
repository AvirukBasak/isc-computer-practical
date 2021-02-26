/* QUESTION:
 * 
 * In this problem you will be given a word over the alphabet
 * {a,b,...,z, A, B, ...,Z}. We will treat the capital letters {A,B,...,Z} as
 * brackets;. These twenty-six letters form thirteen types of bracket pairs,
 * (A,Z),
 * (B,Y), ...(M,N). In each pair, the first element represents an opening
 * bracket
 * of that type and the second element is the closing bracket of that type. For
 * example, a B opens a bracket which is closed by Y. A well bracketed
 * expression
 * is one in which brackets are opened and closed consistently. In other words,
 * all opening and closing brackets in the expression can be paired up such that
 * every opening bracket has a matching closing bracket to its right. Moreover,
 * if
 * an opening bracket occurs between a matching pair of brackets, then its
 * matching closing bracket also occurs within the same pair of brackets.
 * 
 * For example AabcZBBefYeY is a well bracketed expression. On the other hand
 * AabcBZY is not well-bracketed, because the (B,Y) bracket opens inside the
 * (A,Z)
 * bracket, but closes outside. Similarly, AabcZZA is not well-bracketed as the
 * second Z has no matching opening bracket to its left and the second A has no
 * matching closing bracket to its right. The lower case letters {a,b,...,z} do
 * not
 * represent brackets and may appear anywhere in the input. Your task is to
 * determine whether the given input string is well-bracketed.
 * 
 * Input format
 * 
 * The first line of the input consists of a single integer N indicating the
 * number
 * of letters in the input word. The second line contains N letters drawn from
 * {a,b,...,z, A, B,...,Z}.
 * 
 * Output format
 * 
 * A single line with either a 1 indicating that the given word is
 * well-bracketed
 * or a 0 indicating it is not well-bracketed.
 * 
 * Test data
 * 
 * You may assume that N ≤ 1000000. You also assume that N ≤ 1000 in 50% of the
 * inputs. In this task marks will be assigned for groups of test inputs rather
 * than to single test inputs. For example, one mark may be assigned a group of
 * three test inputs. This means that to score that one mark your program must
 * run
 * correctly on all the three test inputs. Thus, guessing the answer or blindly
 * printing 0 (or 1) is not likely to score many marks.
 * 
 * Example
 * We now illustrate the input and output formats using the above example.
 * 
 * Sample input
 * 12
 * 
 * AabcZBBefYeY
 * 
 * Sample output
 * 1
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
// libs.Stack is a custom class design to emulate stack functionality
import Libs.Stack;
public class WellBracketed {
	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		// Taking in N
		System.out.print( "N = " );
		int N = Integer.parseInt( br.readLine() );
		// Taking input, $ is termination symbol
		System.out.print( "INPUT: " );
		String exp = br.readLine() + "$";
		Stack brackets = new Stack();
		int i = 0;
		char c = exp.charAt( i );
		while ( c != '$' ) {
			c = exp.charAt( i );
			// Opening braces
			if ( c >= 65 & c <= 77 ) {
				brackets.push( c );
			}
			// Closing braces
			else if ( c >= 78 & c <= 90 ) {
				try {
					// The sum of any two bracket pair is always 155
					if ( brackets.peek().toString().charAt( 0 ) + exp.charAt( i ) == 155 ) {
						brackets.pop();
					}
					else {
						break;
					}
				} catch ( Exception e ) {
					// Pushing marker data "@" into Stack for output
					// check
					brackets.push( "@" );
					break;
				}
			}
			i++;
		}
		// Output check
		System.out.println( "OUTPUT = " + ( brackets.isEmpty() ? 1 : 0 ) );
	}
}

/*
 * 
 * OUTPUT:
 * 
 * INPUT: AabcZBBefYeY
 * OUTPUT = 1
 * 
 * INPUT: AabcBZY
 * OUTPUT = 0
 * 
 * INPUT: AabcZZA
 * OUTPUT = 0
 */

