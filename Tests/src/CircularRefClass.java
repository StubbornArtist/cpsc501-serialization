public class CircularRefClass {

		protected CircularRefClass ref;
		
		public CircularRefClass() {
			ref = this;
		}
		@Override
		public boolean equals(Object other) {
			if((other == null) ||!(other instanceof CircularRefClass)) return false;
			return ref == ((CircularRefClass)other).ref;
		}
		
}
