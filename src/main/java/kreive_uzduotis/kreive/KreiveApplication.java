package kreive_uzduotis.kreive;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class KreiveApplication {

	public static void main(String[] args) throws IOException {
		// SpringApplication.run(KreiveApplication.class, args);
				ApplicationContext context = new ClassPathXmlApplicationContext( "file:src/beans.xml" );
				KreivesIlgis ki = (KreivesIlgis) context.getBean( "mainspring" );
				ki.sakomLabasSpring();
				ki.viskasViename();

	}

}
