
	package kreive_uzduotis.plokstuma;
	
	import java.io.BufferedReader; 
	import java.io.IOException; 

	import java.io.FileReader;	
	
	public class KreiveIsFailoXYXY extends KreiveIsFailo {
	
		public KreiveIsFailoXYXY ( String failo_vardas ) {
			
			vardas_failo = failo_vardas;
		}
		
		public Kreive gautiKreive() {
			
			String x_ai_y_ai = "";			
			
			try {

				BufferedReader br = new BufferedReader( new FileReader( vardas_failo ) );
				x_ai_y_ai = br.readLine();
				
			} catch ( Exception e ) {
				
				e.printStackTrace();
			}
			
			String[] xs_ys = x_ai_y_ai.split ( "," ); 
			
			Kreive kreive = new Kreive ( xs_ys.length );	
			
			int i = 0;
			
			while ( i < xs_ys.length ) {
				
				kreive.pridetiTaska ( new Taskas ( Double.parseDouble ( xs_ys [ i ] ), Double.parseDouble ( xs_ys [ i + 1 ] ) ) );
				i+=2;
			}
			return kreive;
		}
	}