
	package kreive_uzduotis.plokstuma;
	
	import java.io.BufferedReader; 
	import java.io.IOException; 

	import java.io.FileReader;	
	
	public class KreiveIsFailoXYZ extends KreiveIsFailo {
	
		public KreiveIsFailoXYZ ( String failo_vardas ) {
			super();
			vardas_failo = failo_vardas;
			
		}
		public Taskas ivedimas() {
			
			Taskas3D taskas = new Taskas3D();
				
			System.out.println( "Labas Java pasauli .." );
			System.out.println( "Skaiciuosim kreives ilgi:" );		
			System.out.println( "Iveskite x ir y:" );
				
			try {
					
				System.out.println ( "\n Iveskite x" );
						
				taskas.x = Double.parseDouble ( reader.readLine() );
						
				System.out.println ( "\n Iveskite y" );
					
				taskas.y = Double.parseDouble ( reader.readLine() );
				
				System.out.println ( "\n Iveskite z" );
				
				taskas.z = Double.parseDouble ( reader.readLine() );
								
			} catch ( IOException ioe ) {
					
				ioe.printStackTrace();
			}	
				return taskas;
			
		}	
		
		public Kreive gautiKreive() {
			
			Kreive3D kreive = new Kreive3D();
						
			try {
				
				String x_y_z = "";		
				
				BufferedReader br = new BufferedReader( new FileReader( vardas_failo ) );
				
				int kreives_tasku_skaicius = Integer.parseInt(br.readLine());
							
				kreive = new Kreive3D ( kreives_tasku_skaicius );	
				
				int i = 0;
				
				while ( ( x_y_z = br.readLine() ) != null ) {
					
					String[] xs_ys_zs = x_y_z.split ( "," ); 
					
					kreive.pridetiTaska ( new Taskas3D ( 
							Double.parseDouble ( xs_ys_zs [ 0 ] )
							, Double.parseDouble ( xs_ys_zs [ 1 ] )
							, Double.parseDouble ( xs_ys_zs [ 2 ] ) 
					) );
					
				}
			
				} catch ( Exception e ) {
					
					e.printStackTrace();
				}
				
				return kreive;
		}
		
	}