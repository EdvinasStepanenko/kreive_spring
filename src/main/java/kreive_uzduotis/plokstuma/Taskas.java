
	package kreive_uzduotis.plokstuma;
	
	import java.io.*;

	public class Taskas {
		
		public double x;
		public double y;
		
		public Taskas() {
		}
		
		public Taskas( double x_koord, double y_koord ) {
			
			x = x_koord;
			y = y_koord;
		}		
		

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}	
		
	}