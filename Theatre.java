/*
 * 
 * QUESTION:
 * 
 * WAP to create a ticketing system :
 * 
 * Class : Theatre_Stack
 * 
 * member functions / variables :
 * viewer _code[Max_Size] : array of cinema viewers
 * Max_Size : max storage capacity of the array
 * first : bottom of the stack
 * last : top of the stack
 * 
 * boolean checkStackIfEmpty() : to check whether any ticket has been sold or
 * not
 * boolean checkStackIfFull() : to check whether all seats have been taken
 * void pushBuyTicket( int viewer_code ) : to push a viewer code into the stack
 * void popViewer() : remove the users from the last place
 * 
 * Class : Ticket_Queue
 * 
 * member functions / variables :
 * Cons_code [Max_Size] : array of cinema viewers
 * Max_Size : max storage capacity of the array
 * front : bottom of the stack
 * rear : top of the stack
 * boolean checkQueueIfEmpty() : to check whther any ticket has been sold or not
 * boolean checkQueueIfFull() : to check whether all seats have been taken
 * void pushViewer(int viewer_code):to push a viewer into Ticketing queue
 * void popViewer() : remove the users from the last place
 * 
 * Ask the user to input the viewer code one by one and print the total number
 * of people watching a movie at the end .
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Theatre {
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		//taking input
		System.out.print( "Enter hall capacity: " );
		int cap = Integer.parseInt( br.readLine() );
		Ticket_Queue tQ = new Ticket_Queue( cap );
		Theatre_Stack tS = new Theatre_Stack( cap );
		int in = 0, out = 0;
		// menu drive and some fancy outputs
		do {
			System.out.print( "\nEnter \n1 for new ticket \n2 for hall entry \n3 for checking queue \n4 for checking hall \n5 for hall exit \n0 to leave \nEnter: " );
			switch ( Integer.parseInt( br.readLine() ) ) {
			
				case 1:
					System.out.print( "Enter ticket code: " );
					try {
						tQ.pushViewer( Integer.parseInt( br.readLine() ) );
					} catch ( Exception e ) {
						System.out.println( e );
					}
					break;
				case 2:
					try {
						in = tQ.popViewer();
						tS.pushBuyTicket( in );
						System.out.println( in + " entered hall" );
					} catch ( Exception e ) {
						System.err.println( e );
					}
					break;
				case 3:
					System.out.print( ">> Waiting in queue:\t" );
					try {
						tQ.printQueue();
					} catch ( Exception e ) {
						System.out.println( "None" );
					}
					break;
				case 4:
					System.out.print( ">> People in hall:\t" );
					try {
						tS.printStack();
					} catch ( Exception e ) {
						System.out.println( "None" );
					}
					break;
				case 5:
					try {
						out = tS.popViewer();
						System.out.println( out + " left hall" );
					} catch ( Exception e ) {
						System.err.println( "Hall empty" );
					}
					break;
				case 0:
					System.out.println( ">> Good Bye!" );
					System.exit( 0 );
					
				default:
					System.err.println( "Invalid choice, retry" );
			}
		} while ( true );
	}
}

/*
 * OUTPUT
 * 
 * Enter hall capacity: 7
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 1
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 2
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 3
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 4
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 5
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 6
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 7
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 1
 * Enter ticket code: 8
 * java.lang.Exception: Queue limit reached
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 3
 * >> Waiting in queue: 1 2 3 4 5 6 7
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 2
 * 1 entered hall
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 2
 * 2 entered hall
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 2
 * 3 entered hall
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 2
 * 4 entered hall
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 4
 * >> People in hall: 4 3 2 1
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 5
 * 4 left hall
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 5
 * 3 left hall
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 4
 * >> People in hall: 2 1
 * 
 * Enter
 * 1 for new ticket
 * 2 for hall entry
 * 3 for checking queue
 * 4 for checking hall
 * 5 for hall exit
 * 0 to leave
 * Enter: 0
 * >> Good Bye!
 */

