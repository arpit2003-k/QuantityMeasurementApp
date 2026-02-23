package com.apps.quantitymeasurement;


public class QuantityMeasurementApp {

	//Inner class to represent Feet measurement  
	public static class Feet{
		private final double value;
		
		public Feet(double value) {
          this.value=value;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			//Reference check
			if(this==obj)
			{
				return true;
			}
			
			 if (obj == null)
	                return false;

	            // Type check
	            if (getClass() != obj.getClass())
	                return false;

	            // Cast safely
	            Feet other = (Feet) obj;

	            // Compare double safely
	            return Double.compare(this.value, other.value) == 0;
	        
		}
		
	}
	// Inner class to represent Inch measurement
		public static class Inches {
			private final double value;

			public Inches(double value) {
				this.value = value;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;

				if (obj == null || getClass() != obj.getClass())
					return false;

				Inches inches = (Inches) obj;

				return Double.compare(this.value, inches.value) == 0;
			}
		}

		public static void demonstrateFeetEquality() {
			Feet f1 = new Feet(1.0);
			Feet f2 = new Feet(1.0);
			System.out.println("Feet Equal: " + f1.equals(f2));
		}

		public static void demonstrateInchesEquality() {
			Inches i1 = new Inches(1.0);
			Inches i2 = new Inches(1.0);
			System.out.println("Inches Equal: " + i1.equals(i2));
		}

		public static void main(String[] args) {
			demonstrateFeetEquality();
			demonstrateInchesEquality();
		}

	
	
}