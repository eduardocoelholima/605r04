import java.util.Arrays;

class StringIntegerArrays {

	public static void main( String args[] ) {
		String aString;
		String bString;
		String cString;
		String dString;
		String eString;

		if ( args.length == 0 )	{
			aString = "2515";
			bString = "2515";
			cString = "ABCDECFG";
			dString = "111sdjksjdskRUWEIRUIUREIRUabcDECFG999wekreoreewoqtwrjt";
			eString = aString + ( bString + cString ) + dString;
		} else {
			aString = "215";
			bString = "13";
			cString = "123ABCDECFGT";
			dString = "123abcDECFG";
			eString = bString + "10293847465" + ( bString + cString ) + dString;
		}

		System.out.println("I.	" +     ( bString.equals(aString) )   );
		System.out.println("II.	" +     ( 0 == cString.compareToIgnoreCase(dString) )   );
		System.out.println("III.	" +     aString.substring(0, 1 )  );
		System.out.println("IV.	" +     aString.substring(aString.length() - 2, aString.length() )  );
		System.out.println("V.	" +     cString.substring( 0, cString.indexOf("C") + 1 ));
		int left  = Integer.parseInt( aString.substring(0, 1 ) );
		int right = Integer.parseInt(  aString.substring(aString.length() - 1, aString.length() ) );
		System.out.println("VI.	" +     dString.substring(left, right ));
		char[] anArray = aString.toCharArray();
		Arrays.sort(anArray);
		System.out.println("VII.	" +     aString.substring(anArray[0] - '0' , anArray[1] - '0' )  );
		anArray = eString.toCharArray();
		Arrays.sort(anArray);
		System.out.println("VIII.	" +     new String(anArray) );
		System.out.println("IX.	" +     eString.matches(".*" + aString + ".*"));
		System.out.println("X.	" +     cString.toUpperCase().matches(".*" + dString.toUpperCase() + ".*"));
	}
}
