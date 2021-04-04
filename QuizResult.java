import java.io.BufferedReader;
import java.io.InputStreamReader;
public class QuizResult {
	final int	N;
	String[]	key;
	String[][]	answers;
	public QuizResult( int participants ) {
		N = participants;
		answers = new String[N][5];
		key = new String[5];
	}
	// Calculating marks
	int Mark( int participant ) {
		int marks = 0;
		for ( int i = 0; i < 5; i++ ) {
			if ( key[ i ].equalsIgnoreCase( answers[ participant - 1 ][ i ] ) ) {
				marks++;
			}
		}
		return marks;
	}
	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.print( "Enter number of participants: " );
		QuizResult qz = new QuizResult( Integer.parseInt( br.readLine() ) );
		System.out.println();
		System.out.println( "ENTER KEYS\n-------------------------------\n" );
		for ( int i = 0; i < 5; i++ ) {
			System.out.print( "QUESTION " + ( int ) ( i + 1 ) + ": " );
			qz.key[ i ] = br.readLine().toUpperCase();
		}
		System.out.println();
		// Taking input of answers
		System.out.println( "ENTER ANSWERS\n-------------------------------" );
		for ( int i = 0; i < qz.N; i++ ) {			System.out.println( "PARTICIPANT " + ( int ) ( i + 1 ) + "\n" );
			for ( int j = 0; j < 5; j++ ) {
				
				System.out.print( "QUESTION " + ( int ) ( j + 1 ) + ": " );
				qz.answers[ i ][ j ] = br.readLine().toUpperCase();
			}
			System.out.println( "-------------------------------" );
		}
		// Giving out results
		System.out.println( "\nRESULTS\n-------------------------------\n" );
		System.out.print( "\nANSWER KEY: " );
		for ( int i = 0; i < 5; i++ ) {
			System.out.print( qz.key[ i ] + " " );
		}
		System.out.println();
		System.out.println( "QUESTION\t\t1\t2\t3\t4\t5\tMARKS" );
		for ( int i = 0; i < qz.N; i++ ) {
			System.out.print( "PARTICIPANT\t" + ( int ) ( i + 1 ) + ":\t" );
			for ( int j = 0; j < 5; j++ ) {
				System.out.print( qz.answers[ i ][ j ] + "\t" );
			}
			System.out.print( qz.Mark( i + 1 ) );
			System.out.println();
		}
	}
}

/*
 * OUTPUT:
 * 
 * Enter number of participants: 3
 * 
 * ENTER KEYS
 * -------------------------------
 * 
 * QUESTION 1: a
 * QUESTION 2: b
 * QUESTION 3: a
 * QUESTION 4: b
 * QUESTION 5: c
 * 
 * ENTER ANSWERS
 * -------------------------------------------
 * PARTICIPANT 1
 * 
 * QUESTION 1: a
 * QUESTION 2: b
 * QUESTION 3: a
 * QUESTION 4: b
 * QUESTION 5: d
 * -----------------------------------------------
 * PARTICIPANT 2
 * 
 * QUESTION 1: a
 * QUESTION 2: c
 * QUESTION 3: b
 * QUESTION 4: d
 * QUESTION 5: a
 * -----------------------------------------------
 * PARTICIPANT 3
 * 
 * QUESTION 1: b
 * QUESTION 2: a
 * QUESTION 3: d
 * QUESTION 4: c
 * QUESTION 5: a
 * -----------------------------------------------
 * 
 * RESULTS
 * ------------------------------------------------
 * 
 * 
 * ANSWER KEY: A B A B C
 * QUESTION 	  1	2	3	4	5	MARKS
 * PARTICIPANT 1: A	B	A	B	C	5
 * PARTICIPANT 2: A	C	B	D	A	1
 * PARTICIPANT 3: B	A	D	C	A	0
 */
