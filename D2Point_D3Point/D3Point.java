import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class D3Point extends D2Point {
	double	z;
	public D3Point() {
		z = 0;
	}
	public D3Point( double nz ) {
		z = nz;
	}
	double distance( D3Point b ) {
		return Math.sqrt( Math.pow( ( x - b.x ), 2 ) + Math.pow( ( y - b.y ), 2 ) + Math.pow( ( z - b.z ), 2 ) );
	}
	public static void main( String[] args ) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		// 1st point input
		System.out.print( "Enter x1: " );
		double x = Integer.parseInt( br.readLine() );
		System.out.print( "Enter y1: " );
		double y = Integer.parseInt( br.readLine() );
		System.out.print( "Enter z1: " );
		double z = Integer.parseInt( br.readLine() );
		// Creating 1st point
		D3Point d3Point1 = new D3Point( z );
		d3Point1.x = x;
		d3Point1.y = y;
		// 2nd point input
		System.out.print( "\nEnter x2: " );
		x = Integer.parseInt( br.readLine() );
		System.out.print( "Enter y2: " );
		y = Integer.parseInt( br.readLine() );
		System.out.print( "Enter z2: " );
		z = Integer.parseInt( br.readLine() );
		// Creating 2nd point
		D3Point d3Point2 = new D3Point( z );
		d3Point2.x = x;
		d3Point2.y = y;
		// Output
		System.out.print( "\nSpacial (x,y,z) distance: " + d3Point1.distance( d3Point2 ) );
	}
}

/*
 * OUTPUT:
 * 
 * Enter x1: 3
 * Enter y1: 4
 * Enter z1: 5
 * 
 * Enter x2: 0
 * Enter y2: 0
 * Enter z2: 0
 * 
 * Spacial (x,y,z) distance: 7.0710678118654755
 * 
 */
