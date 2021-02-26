public class Design {
	String	code;
	double	len;
	public Design( String code, double len ) {
		this.code = code;
		this.len = len;
	}
	void show() {
		// givint output
		System.out.println( "\nCODE: " + code );
		System.out.println( "Length: " + len );
	}
}