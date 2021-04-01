
	package kreive_uzduotis.plokstuma;
	
	import java.io.BufferedReader; 
	import java.lang.Math;	
	import java.util.ArrayList;

	public class Kreive {
	
		public Taskas[] taskai;
		public int kiek_tasku;
		public Double min_atstumas;

		public Kreive() {
			
		}
		
		public Kreive ( int max_tasku ) {
			
			taskai = new Taskas [ max_tasku ];
			kiek_tasku = 0;
		}
		
		public void pridetiTaska ( Taskas taskas ) {
			
			taskai [ kiek_tasku ] = taskas;
			kiek_tasku++;
		}
		
		public double ilgis() {
			
			int i = 0;
			double atstumas = 0;
			
			while ( i < ( kiek_tasku - 1 ) ) {
			
				double x_diff =  taskai [ i ].x  - taskai [ i + 1 ].x;
				double y_diff =  taskai [ i ].y -  taskai [ i + 1 ].y;			
				
				atstumas += Math.sqrt ( x_diff  *  x_diff + y_diff * y_diff );
				i++;
			}
			return atstumas;
		}
		
		public String toString() {
			
			String lentele = 
			
				    "-------------------------------\n" 
				+ "|      x       |       y      |\n"
				+ "-------------------------------\n";
			
			int i = 0;
			
			while ( i < kiek_tasku ) {

				lentele +=	 "|" + String.format ( "%10.3f", taskai [ i ].x ) + "    |" + String.format ( "%10.3f", taskai [ i ].y ) + "    |\n"; 
				i++;
			}
			lentele +=  "-------------------------------\n";
			
			return lentele;
		}
		
		public void minReiksme(ArrayList<Double> masyvas){
			
			min_atstumas = masyvas.get(0);	
			int i = 0;
			
			while ( i < kiek_tasku ) {
			
				if (min_atstumas > masyvas.get(i) ) {
					
					min_atstumas = masyvas.get(i);
					
				}
				i++;	
			}
		}	
		
		public ArrayList<Double> ilgisX ( Taskas taskas ) {
		
			ArrayList<Double> atstumux_masyvas = new ArrayList<Double>();
			
			int i = 0;
			double atstumasx = 0;
			
			while ( i < kiek_tasku ) {
							
				double x_diff =  taskai [ i ].x  - taskas.x;
				double y_diff =  taskai [ i ].y -  taskas.y;			
				
				atstumasx = Math.sqrt (( x_diff * x_diff ) + ( y_diff * y_diff ));
				atstumux_masyvas.add(atstumasx);
				i++;
			}
			return atstumux_masyvas;
		}	
		
		public Taskas[] getTaskai() {
			return taskai;
		}

		public void setTaskai(Taskas[] taskai) {
			this.taskai = taskai;
		}

		public int getKiek_tasku() {
			
			return kiek_tasku;
		}

		public void setKiek_tasku(int kiek_tasku) {
			
			this.kiek_tasku = kiek_tasku;
		}

		public Double getMin_atstumas() {
			return min_atstumas;
		}

		public void setMin_atstumas(Double min_atstumas) {
			this.min_atstumas = min_atstumas;
		}
				
	}