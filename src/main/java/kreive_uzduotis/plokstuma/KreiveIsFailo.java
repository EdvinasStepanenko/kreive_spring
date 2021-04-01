package kreive_uzduotis.plokstuma;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader; 

public class KreiveIsFailo {
	
	public String vardas_failo;	
	public BufferedReader reader;
	
	public KreiveIsFailo( ) {
		
		reader = new BufferedReader(new InputStreamReader ( System.in ));
		
	}
	
	public KreiveIsFailo ( String failo_vardas ) {
		
		reader = new BufferedReader(new InputStreamReader ( System.in ));
		
		vardas_failo = failo_vardas;
	}	

	public Kreive gautiKreive() {
		
		Kreive kreive = new Kreive();
		
		return kreive;
	}

	public ArrayList<Double> ilgisX ( Taskas taskas ) {
		
		ArrayList<Double> atstumux_masyvas = new ArrayList<Double>();
		System.out.println("Bloga paima");
		return atstumux_masyvas;
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
	
	public void setVardasFailo( String failo_vardas ) {
		
		vardas_failo = failo_vardas;
	}

	public String getVardasFailo() {
		
		return vardas_failo;
	}	
}
