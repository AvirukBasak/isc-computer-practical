/*
 * 
 * QUESTION:
 * 
 * Animesh owns a mobile repair shop. He can fix screen, battery and motherboard
 * issues. He being a good technician, is quite famous and a huge number of people 
 * line up to get their phones fixed everyday.
 * 
 * Design a system which generates a token based on a customer’s arrival time
 * and will contain his position in the
 * queue and the issue he has according to the following : S for screen issues,
 * B for battery issues and M for motherboard
 * issues. The system will route the customers to Animesh in the following
 * procedure : For every 3 battery issues there
 * will be 2 screen issues and 1 motherboard issue that’ll be sent to Animesh.
 * 
 * Let B represent Battery queue.
 * Let S represent Screen queue.
 * Let M represent Motherboard queue.
 * 
 * If there are a total of 10 battery issue persons 8 screen issue persons and 5
 * motherboard problems, then the queues
 * will fill up as 3B-2S-1M, 3B-2S-1M, 3B-2S-1M, 1B-2S-1M, 1M,...
 * 
 * Input:
 * Time of arrival :
 * Issue : B/S/M
 * 
 * Output:
 * The token numbers passed to Animesh and solved beside their token number
 * 
 * Example :
 * 
 * 1B issue solved
 * 3B issue solved
 * 4B issue solved
 * 2S issue solved
 * 6S issue solved
 * 5M issue solved
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
// libs.Queue is a custom class design to emulate queue functionality
import Libs.Queue;
public class RepairShop {
	private final Queue	B, S, M;
	public RepairShop() {
		this.B = new Queue();
		this.S = new Queue();
		this.M = new Queue();
	}
	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		char issue = '\u0000';
		String csCode = "";
		RepairShop Rs = new RepairShop();
		do {
			// Menu drive
			System.out.print( "\nEnter \n1 for new customer \n2 to serve a set of customers \n3 to print all queues \n0 to exit \nEnter: " );
			try {
				switch ( Integer.parseInt( br.readLine() ) ) {
				// New customer registration
					case 1:
						System.out.print( "Enter B/S/M: " );
						try {
							issue = br.readLine().charAt( 0 );
						} catch ( Exception e ) {
							System.err.println( e );
							break;
						}
						/* Customer ID generator
						 * The idea is to generate and assign a unique value to each customer
						 * This is done by using the system time in seconds as the ID code
						 * A day has 86,400 seconds and a millisecond has 1/1000 seconds
						 * Each ID shows how many seconds have gone today
						 */
						csCode = Integer.toString( ( int ) ( ( System.currentTimeMillis() / 1000 ) % 86400 ) ) + Character.toUpperCase( issue );
						switch ( issue ) {
							case 'B':
							case 'b':
								Rs.B.push( csCode );
								break;
							case 'S':
							case 's':
								Rs.S.push( csCode );
								break;
							case 'M':
							case 'm':
								Rs.M.push( csCode );
								break;
							default:
								System.err.println( "\n>> Invalid entry for " + issue + ", retry" );
								csCode = "";
								issue = '\u0000';
								break;
						}
						if ( issue != '\u0000' ) {
							System.out.println( "\nNew customer registered with\nPROBLEM: " + Character.toUpperCase( issue ) + "\nTOKEN: " + csCode );
						}
						break;
					// Serve a customer based on given order
					case 2:
						System.out.print( "\nCustomers sent:\nFor battery:\n>>" );
						for ( int i = 0; i < 3; i++ ) {
							try {
								System.out.print( " " + Rs.B.peek() + "    " );
								Rs.B.pop();
							} catch ( Exception e ) {
								System.out.print( "    -" );
							}
						}
						System.out.print( "\nFor screen:\n>>" );
						for ( int i = 0; i < 2; i++ ) {
							try {
								System.out.print( " " + Rs.S.peek() + "    " );
								Rs.S.pop();
							} catch ( Exception e ) {
								System.out.print( "    -" );
							}
						}
						System.out.print( "\nFor motherboard:\n>>" );
						for ( int i = 0; i < 1; i++ ) {
							try {
								System.out.print( " " + Rs.M.peek() + "    " );
								Rs.M.pop();
							} catch ( Exception e ) {
								System.out.print( "    -" );
							}
						}
						System.out.println();
						break;
					// Print the queue of customers
					case 3:
						System.out.print( "\nBattery issues:\n>>" );
						System.out.print( " " );
						try {
							Rs.B.print();
						} catch ( Exception e ) {
							System.out.println( " No customer has battery issues" );
						}
						System.out.print( "Screen issues:\n>> " );
						try {
							Rs.S.print();
						} catch ( Exception e ) {
							System.out.println( " No customer has screen issues" );
						}
						System.out.print( "Motherboard issues:\n>>" );
						System.out.print( " " );
						try {
							Rs.M.print();
						} catch ( Exception e ) {
							System.out.println( " No customer has motherboard issues" );
						}
						break;
					// Exit
					case 0:
						System.out.println( "\nGood Bye!" );
						System.exit( 3 );
					default:
						System.err.println( "\n>> Invalid entry, retry" );
				}
			} catch ( Exception e ) {
				System.err.println( "\n>> " + e + ", Input error occured!" );
			}
		} while ( true );
	}
}

/*
 * 
 * OUTPUT:
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 1
 * Enter B/S/M: b
 * 
 * New customer registered with
 * PROBLEM: B
 * TOKEN: 33575B
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 1
 * Enter B/S/M: s
 * 
 * New customer registered with
 * PROBLEM: S
 * TOKEN: 33577S
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 1
 * Enter B/S/M: m
 * 
 * New customer registered with
 * PROBLEM: M
 * TOKEN: 33666M
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 1
 * Enter B/S/M: b
 * 
 * New customer registered with
 * PROBLEM: B
 * TOKEN: 33667B
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 1
 * Enter B/S/M: s
 * 
 * New customer registered with
 * PROBLEM: S
 * TOKEN: 33669S
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 1
 * Enter B/S/M: s
 * 
 * New customer registered with
 * PROBLEM: S
 * TOKEN: 33670S
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 1
 * Enter B/S/M: m
 * 
 * New customer registered with
 * PROBLEM: M
 * TOKEN: 33676M
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 3
 * 
 * Battery issues:
 * >> 33575B 33667B
 * Screen issues:
 * >> 33577S 33669S 33670S
 * Motherboard issues:
 * >> 33666M 33676M
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 2
 * 
 * Customers sent:
 * For battery:
 * >> 33575B 33667B -
 * For screen:
 * >> 33577S 33669S
 * For motherboard:
 * >> 33666M
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 2
 * 
 * Customers sent:
 * For battery:
 * >> - - -
 * For screen:
 * >> 33670S -
 * For motherboard:
 * >> 33676M
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 2
 * 
 * Customers sent:
 * For battery:
 * >> - - -
 * For screen:
 * >> - -
 * For motherboard:
 * >> -
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 3
 * 
 * Battery issues:
 * >> No customer has battery issues
 * Screen issues:
 * >> No customer has screen issues
 * Motherboard issues:
 * >> No customer has motherboard issues
 * 
 * Enter
 * 1 for new customer
 * 2 to serve a set of customers
 * 3 to print all queues
 * 0 to exit
 * Enter: 0
 * 
 * Good Bye!
 */

