public class D2Point {
	double x, y;
	public D2Point() {
		x = 0;
	}
	public D2Point( double nx, double ny ) {
		x = nx;
		y = ny;
	}
	double distance2d( D2Point b ) {
		return Math.sqrt( Math.pow ( ( x - b.x ), 2 ) + Math.pow( ( y - b.y ), 2 ) );
	}
}
