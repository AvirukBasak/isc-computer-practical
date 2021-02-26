public class Rank extends Record {
	int	index;
	public Rank() {
		super();
		index = 0;
	}
	void highest() {
	for ( int i = 1; i < rnk.length; i++ ) {
		if ( rnk[ i ] < rnk[ index ] ) {
			index = i;
			}
		}
	}
	void display() {
		super.display();
		System.out.println( "\nAND THE TOPPER IS: " + name[ index ] );
	}
	public static void main( String[] args ) {
		Rank rnk = new Rank();
		rnk.readvalues();
		rnk.highest();
		rnk.display();
	}
}

/* OUTPUT:
 * 
 * Enter name of student 1: A
 * Enter rank of student 1: 3
 * Enter name of student 2: B
 * Enter rank of student 2: 5
 * Enter name of student 3: C
 * Enter rank of student 3: 1
 * Enter name of student 4: D
 * Enter rank of student 4: 2
 * Enter name of student 5: E
 * Enter rank of student 5: 4
 * 
 * STUDENT_NAME	RANK
 * A			3
 * B			5
 * C			1
 * D			2
 * E			4
 * 
 * AND THE TOPPER IS: C
 */
