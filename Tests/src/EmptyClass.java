public class EmptyClass{
		
		@Override
		public boolean equals(Object other) {
			if((other == null)||!(other instanceof EmptyClass)) return false;
			return true;
		}
	}
