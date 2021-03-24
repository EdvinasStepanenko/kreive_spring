	package kreive_uzduotis.plokstuma;

	import java.io.BufferedReader; 
	import java.io.IOException; 
	import java.io.InputStreamReader; 
	
	/**
	* Klasė dialogo su vartotoju konsolėje oranizavimui.
	*/
	public class KonsolesDialogas  {
		
		public BufferedReader reader;												// skaitymo iš konsolės tarpinis objektas.
		
		/**
		* konstruktorius be parametrų, sukuria skaitymo iš failo tarpinį objektą
		*/
		public KonsolesDialogas() {
			
			reader = new BufferedReader ( new InputStreamReader (System.in ) ); 			
		}
		
		/**
		* iš konsolės įvedama teksto eilutė, prieš tai išvedant priminimą ir reikšmę kuri bus gražinama pagal nutylėjimą, paspaudus tik Enter.
		*@param String priminimas
		*@param String nutylint
		*@return String
		*/
		public String ivestiReiksme ( String priminimas, String nutylint ) throws IOException {
		
			System.out.print ( priminimas + " [" + nutylint + "] ? " );	
		
			String reiksme = reader.readLine();
			
			if ( reiksme.length() == 0 ) {
			
				reiksme = nutylint;
			}			
			return reiksme;
		}
	}