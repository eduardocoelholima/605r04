/**
 * QuestionMark solution
 *
 * - go over each method
 * - drawing a binary tree helps read the ? operator (try for the 3rd and 4th
 * methods)
 */
public class QuestionMark {
	public static boolean aGreaterB( int a, int b )	{
		return ( a > b );

//		boolean rValue = false;
//
//		if ( a > b )
//			rValue = true;
//		else
//			rValue = false;
//		return rValue;
	}

	public static int findMaximum( int a, int b )	{
		return ( a > b ? a : b );

//		int rValue;
//		if ( a > b )
//			rValue = a;
//		else
//			rValue = b;
//		return rValue;
	}

	public static int findMaximum( int a, int b, int c, int d )	{
		return    a > b    ?    c > d    ?    (c>a?c:a) :    (d>a?d:a)
							:    c > d    ?    (c>b?c:b) :    (d>b?d:b);

//		int rValue;
//		int maxAndB = 0;
//		int maxCndD = 0;
//
//		if ( a > b )
//			maxAndB = a;
//		else
//			maxAndB = b;
//		if ( c > d )
//			maxCndD = c;
//		else
//			maxCndD = d;
//		if ( maxAndB > maxCndD )
//			rValue = maxAndB;
//		else
//			rValue = maxCndD;
//		return rValue;
	}

	public static int leftToRight( int a, int b )	{
		return  a != 0 ? b != 0 ? a/b : -1 : 0;

//		int rValue;
//		if ( a != 0 ) {
//			if ( b != 0 )
//				rValue = a/b;
//			else
//				rValue = -1;
//		}
//		else {
//			rValue = 0;
//		}
//		return rValue;
	}

	public static void main( String[] args ) {
		int a = 5;
		int b = 1;
		int c = 2;
		int d = 1;
		System.out.println("aGreaterB(" + a + "," + b + ") = " +
				aGreaterB( a, b ) );
		System.out.println("findMaximum(" + a + "," + b + ") = " +
				findMaximum( a, b ) );
		System.out.println("findMaximum(" + a + ", " + b + ", " + c + ", " + d + ") = " +
				findMaximum( a, b, c, d ) );
		a = 0;
		b = 0;
		System.out.println("leftToRight(" + a++ + "," + b++ + ") = " +
				leftToRight( a, b ) );
		System.out.println("leftToRight(" + --a + "," + b + ") = " +
				leftToRight( a, b ) );
	}
}
