package kreive_uzduotis.kreive;

import java.io.IOException; 
import java.util.ArrayList;

import kreive_uzduotis.plokstuma.*;

public class KreivesIlgis {
	
	protected KreiveIsFailo kreive_is_failo;
	private Kreive kreive;
	
	public KreivesIlgis() {
		
		
	}
	
	public KreivesIlgis (KreiveIsFailo kreive_is_failo ) {
		
		this.kreive_is_failo = kreive_is_failo;
	}
	

	public void sakomLabasSpring() {
		System.out.println("Labas");
	}
	
	public void viskasViename() throws IOException {
		
	//!	Klase klase = new Klase();																				//"prisijungiama" prie "klase" klases
	//!	KonsolesDialogas failo_skaitymas = new KonsolesDialogas();                                              // "prisijungiama" prie konsolesdialogo klases
		//Taskas taskas = this.kreive_is_failo.ivedimas();																		// sukuriamas naujas taskas kuriam bus priskirta X ir Y ivedime
		//!String vardas_failo = failo_skaitymas.ivestiReiksme("kreives tasku failas", "kreives_taskai.csv");		// perskaitomas CSV failas
		//!KreiveIsFailoXXYY kreive_is_failo_xx_yy = new KreiveIsFailoXXYY ( vardas_failo ); 	
		KonsolesDialogas konsoles_dialogas = new KonsolesDialogas();		
		kreive_is_failo.setVardasFailo( konsoles_dialogas.ivestiReiksme (" kreives tasku failas", kreive_is_failo.getVardasFailo() ) );
		Taskas taskas = this.kreive_is_failo.ivedimas();	
		Kreive kreive = this.kreive_is_failo.gautiKreive();		
		
		ArrayList<Double> atstumux_masyvas =  kreive.ilgisX(taskas);
		kreive.minReiksme(atstumux_masyvas);
				
		System.out.println ( "-------------------------------" );
		//System.out.println ( kreive.toString() );
		int i = 0;

		while ( i < kreive.getKiek_tasku() ) {

			System.out.println ( kreive.getTaskai()[ i ].getX() + " " +  kreive.getTaskai()[ i ].getY() +  " "  + ( ( (Taskas3D ) kreive.getTaskai()[ i ]).getZ() )  );

			i++;
		}


		System.out.println ( "Kreives ilgis: " + kreive.ilgis() );
		System.out.println ("ax" + atstumux_masyvas);
		System.out.println ( "Artimiausias taskas yra: " + kreive.min_atstumas );
	}	
	
	public void skaiciuojamKreivesIlgiWeb() throws IOException   {
																										
		kreive = kreive_is_failo.gautiKreive();			
																												
		int i = 0;
		
		while ( i < kreive.getKiek_tasku() ) {
			 
			System.out.println ( kreive.getTaskai()[ i ].getX() + " " +  kreive.getTaskai()[ i ].getY() +  " "  + ( ( (Taskas3D ) kreive.getTaskai()[ i ]).getZ() )  );
			
			i++;
		}
		
		System.out.println ( "Kreives ilgis: " + kreive.ilgis() );											
	}

	public Kreive getKreive() {
		return kreive;
	}

	public void setKreive(Kreive kreive) {
		this.kreive = kreive;
	}
	
}
