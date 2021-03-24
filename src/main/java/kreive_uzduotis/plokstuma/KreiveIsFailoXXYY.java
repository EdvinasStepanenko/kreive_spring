
	package kreive_uzduotis.plokstuma;
	
	import java.io.BufferedReader; 
	import java.io.IOException; 

	import java.io.FileReader;	
	
	public class KreiveIsFailoXXYY extends KreiveIsFailo {
			
		public KreiveIsFailoXXYY ( String failo_vardas ) {
			
			vardas_failo = failo_vardas;
		}
		
		public Kreive gautiKreive() {
			
			String x_ai = "";
			String y_ai = "";			
			
			try {

				BufferedReader br = new BufferedReader( new FileReader( vardas_failo ) );
				x_ai = br.readLine();
				y_ai = br.readLine();
				
			} catch ( Exception e ) {
				
				e.printStackTrace();
			}
			
			String[] xs = x_ai.split ( "," ); 
			String[] ys = y_ai.split ( "," ); 
			
			Kreive kreive = new Kreive ( xs.length );	
			
			int i = 0;
			
			while ( i < xs.length ) {
				
				kreive.pridetiTaska ( new Taskas ( Double.parseDouble ( xs [ i ] ), Double.parseDouble ( ys [ i ] ) ) );
				i++;
			}
			
			return kreive;
		}
	}