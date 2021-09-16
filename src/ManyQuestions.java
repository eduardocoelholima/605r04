// search for Better
import java.util.Random;

public class ManyQuestions {
	public static String printFromLowerToLarger(int a, int b)	{
		String rValue = "";
		if ( a < b )	{
			for (int index = a; index < b; index ++ )
				rValue += a + ": " + index + " ";
		} else {
			for (int index = b; index < a; index ++ )
				rValue += b + ": " + index + " ";
		}
		return rValue;

	}

	public static String sumUpFromLowerToLargerBetter(int a, int b)	{
		String rValue = "";
		for (int index = ( a < b ? a : b ); index <  ( a < b ? b : a ); index ++ )
			rValue += ( a < b ? a : b + ": " + index + " ");
		return rValue;
	}

	public static void printBitsRepresentation(int bits[])	{
		for ( int bitPosition = 0; bitPosition < bits.length; bitPosition ++ )	{
			System.out.println(bitPosition + ":	" + bits[bitPosition] );
		}
	}

	public static long convertBitArrayToNumber(boolean useConstantAlgorithm, int bits[])	{
		long theMissingNumber = 0;
		int soManyBitsAreOneAtThisPositionEveryPosition = -1;
		if (  useConstantAlgorithm ) {
			soManyBitsAreOneAtThisPositionEveryPosition = (int)Math.pow(2, bits.length  - 2);
		} else {
			for ( int bitPosition = 0; bitPosition < bits.length; bitPosition ++ )	{
				soManyBitsAreOneAtThisPositionEveryPosition =  ( bits[bitPosition] > soManyBitsAreOneAtThisPositionEveryPosition ) ? bits[bitPosition] : soManyBitsAreOneAtThisPositionEveryPosition;
			}
		}
		for ( int bitPosition = 0; bitPosition < bits.length; bitPosition ++ )	{
			if ( (bits[bitPosition] == ( soManyBitsAreOneAtThisPositionEveryPosition - 1 ) )  && (bits[bitPosition] >= 0 ))  {
				theMissingNumber += (int)Math.pow(2, bitPosition);
			}
		}
		return theMissingNumber;
	}

	public static int[] prepareMissingNumberScenario(int maxNumberOfBitsUsed, long theMissingNumber)	{
		int soManyBitsAreOneAtThisPosition[] = new int[maxNumberOfBitsUsed + 1];
		long maximumNumber = (long)Math.pow(2, maxNumberOfBitsUsed );
		for ( int index = 0; index < maximumNumber; index ++ )	{
			for ( int bitPosition = maxNumberOfBitsUsed; bitPosition  >= 0; bitPosition -- )	{
				if ( (  ( index )  & ( 1 << bitPosition ) ) == ( 1 << bitPosition ) ) {
					soManyBitsAreOneAtThisPosition[bitPosition] ++;
				}
			}
		}
		for ( int bitPosition = maxNumberOfBitsUsed; bitPosition >= 0; bitPosition -- )	{
			if ( (  ( theMissingNumber )  & ( 1 << bitPosition ) ) == ( 1 << bitPosition ) )
				soManyBitsAreOneAtThisPosition[bitPosition] --;
		}
		return soManyBitsAreOneAtThisPosition;
	}

	public static int[] prepareMissingNumberScenarioConstant(int maxNumberOfBitsUsed, long theMissingNumber)	{
		int soManyBitsAreOneAtThisPosition[] = new int[maxNumberOfBitsUsed + 1];
		int soManyBitsAreOneAtThisPositionEveryPosition = (int)Math.pow(2, maxNumberOfBitsUsed - 1);
		for ( int bitPosition = maxNumberOfBitsUsed; bitPosition  >= 0; bitPosition -- )	{
			soManyBitsAreOneAtThisPosition[bitPosition] = soManyBitsAreOneAtThisPositionEveryPosition;
		}
		for ( int bitPosition = maxNumberOfBitsUsed ; bitPosition >= 0; bitPosition -- )	{
			if ( (  ( theMissingNumber )  & ( 1 << bitPosition ) ) == ( 1 << bitPosition ) )
				soManyBitsAreOneAtThisPosition[bitPosition] --;
		}
		return soManyBitsAreOneAtThisPosition;
	}

	public static long findMissingNumber(boolean useConstantAlgorithm, int maxNumberOfBitsUsed, long theMissingNumber)	{
		int soManyBitsAreOneAtThisPosition[];
		if ( useConstantAlgorithm )
			soManyBitsAreOneAtThisPosition = prepareMissingNumberScenarioConstant(maxNumberOfBitsUsed, theMissingNumber);
		else
			soManyBitsAreOneAtThisPosition = prepareMissingNumberScenario(maxNumberOfBitsUsed, theMissingNumber);

		theMissingNumber = convertBitArrayToNumber(useConstantAlgorithm, soManyBitsAreOneAtThisPosition);
		return maxNumberOfBitsUsed == 1 ? 1 : theMissingNumber;
	}

	public static String printBitRepresentation(int a)	{
		String rValue = "";
		for ( int index = 31; index >= 0; index -- )	{
			if ( (  ( a )  & ( 1 << index ) ) == ( 1 << index ) )
				rValue += "1";
			else
				rValue += "0";
		}
		return rValue;
	}

	public static String printBitRepresentationBetter(int aInt)	{
		String rValue = "";
		for ( int index = 31; index >= 0; index -- )	{
			rValue += ( (  ( aInt )  & ( 1 << index ) ) == ( 1 << index ) ) ? "1" : "0";
		}
		return rValue;
	}

	public static int findMaximumBetter(int a, int b)	{
		return a > b ? a : b;
	}

	public static int findMaximumBetter(int a, int b, int c, int d)	{
		return findMaximumBetter(findMaximumBetter(a, b ), findMaximumBetter(c, d ));
	}

	public static int findMaximum(int a, int b, int c, int d)	{
		int rValue;
		int maxAndB = 0;
		int maxCndD = 0;
		if ( a > b )
			maxAndB = a;
		else
			maxAndB = b;
		if ( c > d )
			maxCndD = a;
		else
			maxCndD = b;
		if ( maxAndB > maxCndD )
			rValue = maxAndB;
		else
			rValue = maxCndD;
		return rValue;
	}

	public static String reverseString(String original) {
		String rValue = "";
		for ( int index = original.length(); index > 0; index -- )
			rValue += original.substring(index -1, index);
		return rValue;
	}

	public static String reverseStringBetter(String original) {
		String rValue = "";
		for ( int index = original.length() - 1; index >= 0; index -- )
			rValue += original.charAt(index);
		return rValue;
	}

	public static String reverseStringR(String original) {
		if ( original.length() == 1 ) {
			return original;
		}
		return reverseStringR(original.substring(1)) + original.substring(0, 1);
	}

	public static void main( String[] args ) {
		int a = 5;
		int b = 1;
		int c = 2;
		int d = 1;
		String aString = "abcde";
		long foundThisOneMissing;
		int soManyBits = 31;
		boolean useConstantAlgorithm = false;

		if ( args.length > 0 )
			soManyBits = Integer.parseInt(args[0]);
		useConstantAlgorithm = ( args.length > 1 );
		useConstantAlgorithm = true;

		long thisNumberIsMissing = (long)new Random().nextInt((int)Math.pow(2, soManyBits));
		thisNumberIsMissing += ( thisNumberIsMissing == 0 ) ? 1 : 0;

/*
	System.out.println("printFromLowerToLarger(" + a + "," + b + ") = " + printFromLowerToLarger(a, b ) );
	System.out.println("sumUpFromLowerToLargerBetter(" + a + "," + b + ") = " + sumUpFromLowerToLargerBetter(a, b ) );
	System.out.println("printBitRepresentation(" + a + "):		" + printBitRepresentation(a));
	System.out.println("printBitRepresentationBetter(" + a + "):	" + printBitRepresentation(a));
	System.out.println("findMaximum(" + a + ", " + b + ", " + c + ", " + d + " ) = " + findMaximum(a, b, c, d ) );
	System.out.println("findMaximumBetter(" + a + ", " + b + ", " + c + ", " + d + " ) = " + findMaximumBetter(a, b, c, d ) );
	System.out.println("reverseString(" + aString + ") =	" + reverseString(aString) );
	System.out.println("reverseStringR(" + aString + ") =	" + reverseStringR(aString) );
	System.out.println("reverseStringBetter(" + aString + ") =	" + reverseStringBetter(aString) );
*/
		foundThisOneMissing = findMissingNumber(useConstantAlgorithm, soManyBits, thisNumberIsMissing);
		System.out.print("Missing: " + thisNumberIsMissing + "  findMissingNumber(" + useConstantAlgorithm + ", ");
		System.out.print(soManyBits + ", " + thisNumberIsMissing + ")" );
		System.out.println(" = "  + foundThisOneMissing );
		System.out.println("Found the " + ( (  foundThisOneMissing == thisNumberIsMissing ) ? "correct " : "wrong " ) +  "one missing" );
	}
}
