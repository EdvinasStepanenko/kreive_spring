package kreive_uzduotis.kreive;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kreive_uzduotis.plokstuma.Kreive;
import kreive_uzduotis.plokstuma.Kreive3D;
import kreive_uzduotis.plokstuma.Taskas;
import kreive_uzduotis.plokstuma.Taskas3D;

@Controller
public class PageController {

	@RequestMapping(path="/kreive", method={ RequestMethod.GET, RequestMethod.POST })
    public String kreive( 
    		@RequestParam(name="x", required=false, defaultValue="0.0") String x
    		, @RequestParam(name="y", required=false, defaultValue="0.0") String y
    		, @RequestParam(name="z", required=false, defaultValue="0.0") String z
    		, @RequestParam(name="rasti_atstuma", required=false, defaultValue="neskaiciuoti") String skaiciuoti
    		, Model model ) 
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
		KreivesIlgis ki = (KreivesIlgis) context.getBean( "mainspring" );
		String err_msg = "";
		
		try {
			
			Taskas3D taskas3d = new Taskas3D(  0, 0, 0  );			
			
			if ( ( skaiciuoti != null )  && ( skaiciuoti.equals( "skaiciuoti") ) ) {
				
				try {
				
					Double x_sk = Double.parseDouble( x );
					Double y_sk = Double.parseDouble( y );
					Double z_sk = Double.parseDouble( z );
					
					taskas3d = new Taskas3D(  x_sk, y_sk, z_sk  );
												
				} catch ( Exception e ) {
					
					err_msg = "blogai įvestos koordinatės";
				}
			
			} 
			
			ki.skaiciuojamKreivesIlgiWeb();
			
			System.out.println(taskas3d.toString());
			Kreive3D kreive = (Kreive3D) ki.getKreive();
			ArrayList<Double> atstumux_masyvas =  kreive.ilgisX(taskas3d);
			System.out.println("asdf" + atstumux_masyvas);
			kreive.minReiksme(atstumux_masyvas);
		
			model.addAttribute("kreive", kreive );
			model.addAttribute("taskas", taskas3d );
			model.addAttribute("err_msg", err_msg );		
			model.addAttribute("atstumux_masyvas", atstumux_masyvas );		

			
		} catch ( Exception e ) {
			
		}
	
		return "testas";
	}
	

	@RequestMapping(path="/kreives-taskai", method={ RequestMethod.GET, RequestMethod.POST })	
	public @ResponseBody Kreive kreivesTaskai(
			@RequestParam(name="x", required=false, defaultValue="0.0") String x
    		, @RequestParam(name="y", required=false, defaultValue="0.0") String y
    		, @RequestParam(name="z", required=false, defaultValue="0.0") String z
    		) throws IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
		KreivesIlgis ki = (KreivesIlgis) context.getBean( "mainspring" );

		try {
			
			Taskas3D taskas3d = new Taskas3D(  0, 0, 0  );			
						
			Double x_sk = Double.parseDouble( x );
			Double y_sk = Double.parseDouble( y );
			Double z_sk = Double.parseDouble( z );
					
			taskas3d = new Taskas3D(  x_sk, y_sk, z_sk  );						 
			
			ki.skaiciuojamKreivesIlgiWeb();	
		
			Kreive3D kreive = (Kreive3D) ki.getKreive();
			ArrayList<Double> atstumux_masyvas =  kreive.ilgisX(taskas3d);
			System.out.println("asdf" + atstumux_masyvas);
			kreive.minReiksme(atstumux_masyvas);
		
		} catch ( Exception e ) {
			
		}
		return ki.getKreive(); 
	}

	@RequestMapping(path="/labas-ajax")	
	public @ResponseBody String labasAjax() {


		return "Labas Ajax";
	}	

}