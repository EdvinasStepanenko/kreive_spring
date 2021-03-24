
	package kreive_uzduotis.plokstuma;
	
	import java.io.BufferedReader; 
	import java.io.IOException; 
	import java.io.InputStreamReader; 
	import java.io.FileReader;
	import java.util.ArrayList;
	
	public class Klase {
	
		public BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );
	//	public BufferedReader br = new BufferedReader( new FileReader( vardas_failo ) );
		public Double atstumasx;
		
	public Klase() {
	
	}
	
	public Taskas ivedimas() {
			
		Taskas taskas = new Taskas();
			
		System.out.println( "Labas Java pasauli .." );
		System.out.println( "Skaiciuosim kreives ilgi:" );		
		System.out.println( "Iveskite x ir y:" );
			
		try {
				
			System.out.println ( "\n Iveskite x" );
					
			taskas.x = Double.parseDouble ( reader.readLine() );
					
			System.out.println ( "\n Iveskite y" );
				
			taskas.y = Double.parseDouble ( reader.readLine() );
				
		} catch ( IOException ioe ) {
				
			ioe.printStackTrace();
		}	
			return taskas;
		
	}	
		
	/*public double atstumasX(double a, double b, double xs, double ys) {
		atstumasx = 0.0;
		int i = 0;			
		while ( i < xs.length ) {
			
			Double x = Double.parseDouble ( xs [ i ] );
			Double y = Double.parseDouble ( ys [ i ] );
			
			Double x_diff =  ( x - a );
			Double y_diff =  ( y - b );
			
			atstumasx = Math.sqrt (( x_diff * x_diff ) + ( y_diff * y_diff ));
			
			i++;
			}	
			return atstumasx;
		}*/
		
		
		
	}
	