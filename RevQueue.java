/*
 * QUESTION: WAP to reverse a queue.
 * Note: Queue used is a String queue
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class RevQueue {
	// Object instances
	String[]	queue;
	int			cap;
	int			front, rear;
	public RevQueue( int cap ) {
		this.cap = cap;
		queue = new String[cap];
		front = 0;
		rear = -1;
	}
	// Pushes data into the queue
	void push( String entry ) {
		try {
			queue[ ++rear ] = entry;
		} catch ( ArrayIndexOutOfBoundsException e ) {
			System.err.println( "Queue Overflow" );
			rear--;
			return;
		}
		System.out.println( "Pushed " + entry );
	}
	// Pops data from queue
	String pop() throws Exception {
		String out = queue[ front ];
		front++;
		if ( front >= rear ) {
			front = 0;
			rear = -1;
		}
		else if ( rear == -1 ) {
			throw new Exception( "Queue Underflow" );
		}
		return out;
	}
	// Reverses the queue
	void reverese() {
		// An empty String
		String tmp = "";
		// Simple reverse algorithm using a third variable
		for ( int i = 0, j = cap - 1; i < cap / 2; i++, j-- ) {
			tmp = queue[ j ];
			queue[ j ] = queue[ i ];
			queue[ i ] = tmp;
		}
	}
	// Prints the queue elements
	void print( String queue[] ) throws Exception {
		if ( rear == -1 )
			throw new Exception( "Queue Underflow" );
		for ( int i = front; i <= rear; i++ ) {
			System.out.print( queue[ i ] + "\t" );
		}
		System.out.println();
	}
	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.print( "Enter queue capacity: " );
		RevQueue queue = new RevQueue( Integer.parseInt( br.readLine() ) );
		do {
			System.out.print( "\nEnter\n1 for new entry\n2 for entry pop\n3 for original queue\n4 for reversed queue\n0 to exit\nEnter: " );
			// Menu drive
			switch ( Integer.parseInt( br.readLine() ) ) {
				case 1:	
					System.out.print( "Queue entry: " );
					try {
						queue.push( br.readLine() );
					} catch ( Exception e ) {
						System.err.println( e );
					}
					break;
				case 2:
					try {
						System.err.println( queue.pop() + " popped" );
					} catch ( Exception e ) {
						System.err.println( e );
					}
					break;
				case 3:
					System.err.print( "Original: " );
					try {
						queue.print( queue.queue );
					} catch ( Exception e ) {
						System.err.println( e );
					}
					break;
				case 4:
					System.err.print( "Reversed: " );
					try {
						queue.reverese();
						queue.print( queue.queue );
					} catch ( Exception e ) {
						System.err.println( e );
					}
					break;
				case 0:
					System.out.println( "Exiting" );
					System.exit( 0 );
				default:
					System.err.println( "Invalid choice, retry" );
			}
		} while ( true );
	}
}

/*
 * 
 * OUTPUT:
 * 
 * Enter queue capacity: 5
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 1
 * Queue entry: a
 * Pushed a
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 1
 * Queue entry: b
 * Pushed b
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 1
 * Queue entry: 12
 * Pushed 12
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 1
 * Queue entry: 13
 * Pushed 13
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 1
 * Queue entry: gta
 * Pushed gta
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 1
 * Queue entry: qw
 * Queue Overflow
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 1
 * Queue entry: th
 * Queue Overflow
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 3
 * Original: a b 12 13 gta
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 4
 * Reversed: gta 13 12 b a
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 3
 * Original: gta 13 12 b a
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 4
 * Reversed: a b 12 13 gta
 * 
 * Enter
 * 1 for new entry
 * 2 for entry pop
 * 3 for original queue
 * 4 for reversed queue
 * 0 to exit
 * Enter: 0
 * Exiting
 */

