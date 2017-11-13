
public class PrimitiveConverter {
	

	public static Object getFromString(String primitive) {
		
		try {
			return Byte.valueOf(primitive);
		}
		catch(NumberFormatException e) {}
		
		try {
			return Short.valueOf(primitive);
		}
		catch(NumberFormatException e) {}
		
		try {
			return Integer.valueOf(primitive);
		}
		catch(NumberFormatException e) {}
		
		try {
			return Double.valueOf(primitive);
		}
		catch(NumberFormatException e) {}
		
		try {
			return Float.valueOf(primitive);
		}
		catch(NumberFormatException e) {}
		
		try {
			return Long.valueOf(primitive);
		}
		catch(NumberFormatException e) {}
										
		if(primitive.length() == 1) {
			return primitive.charAt(0);
		}
		
		else if (primitive.toLowerCase().matches("true|false")) {
			return Boolean.valueOf(primitive.toLowerCase());
		}
		
		throw new RuntimeException(primitive + ", Does not represent a primitive");
	}

}
