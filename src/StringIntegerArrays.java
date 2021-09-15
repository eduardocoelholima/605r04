//
// there is no checking if the values for
// 	Cut out of dString from the first digit in aString and the last digit in aString and print it. 
// and other requirements are valid. This hw is bout String operations and not int comparisons.
//

import java.util.Arrays;

class StringIntegerArrays {
//  char[] anArray = aString.toCharArray();
//  Arrays.sort(anArray);
  
  public static void main( String args[] ) {
	String a, b;
	String aString= null;
	String bString= null;
	String cString= null;
	String dString= null;
	String eString= null;
	String fString= null;
	String gString= null;
	String hString= null;
	String iString= null;

	if ( args.length == 1 ) {
		aString = "123425" + "25";
		bString = "12342525";
		cString = "5";
		dString = "25" + "2" + cString;
		eString = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
		fString = "A, B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
		gString = aString + ( bString + cString ) + dString;
		hString = "2525" +  "+" + "2525";
		iString = "2525+2525";
        } else {
		aString = "12342" + new String("" + 5) +  "25";
		bString = "12342525";
		cString = "5";
		dString = "" + "25" + "" + "2" + cString;
		eString = "b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
		fString = "B, C, D, E, F, G, H, I, J, K, *, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z";
		gString = ( ( aString + bString )  + "" + 5 ) + dString;
		hString = "2525" +  "+" + "2525";
		iString = "25" + ( 2 + 5 ) + "+2525";
        }

	System.out.println("I.	" +     ( aString.equals(bString) )   );
	System.out.println("II.	" +     ( aString == bString )   );
	System.out.println("III.	" +     ( aString.equals(dString) )   );
	System.out.println("IV.	" +     ( aString == dString)   );
	System.out.println("V.	" +     ( hString.equals(iString) )   );
	System.out.println("VI.	" +     ( hString == iString)   );
 	System.out.println("VII. " +     dString.substring(
		   Integer.parseInt(aString.substring(0, 1 ))-1,
		   Integer.parseInt(aString.substring(1, 2 ))
	     ) );
	System.out.println("VIII.	" +     eString.substring(fString.indexOf( "*" ), fString.indexOf("*") + 1 ));
 	char[] anArray = bString.replaceAll(" ", "").toCharArray();
	Arrays.sort(anArray);
	System.out.println("IX.	" +     dString.substring(anArray[3] - '0' , anArray[4] - '0' )  );
  }
}
