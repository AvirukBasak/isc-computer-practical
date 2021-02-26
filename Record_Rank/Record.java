import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Record {
	String[]	name;
	int[]		rnk;
	public Record() {
		// Initialising global variables
		name = new String[5];
		rnk = new int[5];
	}
	void readvalues() {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		for ( int i = 0; i < name.length; i++ ) {
			// Reading the values
			try {
				System.out.print( "Enter name of student " + ( int ) ( i + 1 ) + ": " );
				name[ i ] = br.readLine();
				
				System.out.print( "Enter rank of student " + ( int ) ( i + 1 ) + ": " );
				rnk[ i ] = Integer.parseInt( br.readLine() );
			} catch ( Exception e ) {
				System.out.println( "\nINPUT ERROR! RETRY\n" );
				i--;
				continue;
			}
		}
	}
	void display() {
		// Giving ooutput
		System.out.println( "\nSTUDENT_NAME\tRANK" );
		for ( int i = 0; i < name.length; i++ ) {
			System.out.println( name[i] + "\t" + rnk[i] );
		}
	}
}