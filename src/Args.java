import java.util.Vector;

/**
 * Take a look at this code, slightly modified from last lectures's code. If
 * arguments are passed by value, why is anInt changing?
 *
 * - What about the Strings as arguments, why these are the original values
 * not changed if String is an Object (line 23)?
 */
public class  Args {

	int    anInt   = -1;
	String aString = "a";
	int[]  anArray = { 4, 2 };
	Integer anIntObject = -1;

	public void printAnInt() {
		System.out.println("printAnInt: " + anInt);
	}
	public void printAnIntObject() {
		System.out.println("printAnIntObject: " + anIntObject);
	}

	public void increaseAnInt(Args arg )      {
		arg.anInt += 1;
	}
	public void increaseAnIntObject(Args arg )      {
		arg.anIntObject += 1;
	}

	public void testString(String arg )      {
		arg = "b";
//		System.out.printf("arg = %s\n", arg);
	}
	public void testArray(int[] arg )      {
		arg[1] = 3;
	}
	public void testInt(int arg )      {
		arg = 42;
	}
	public void testIntObject(Integer arg )      {
		arg = 42;
	}


	public void testArgs()      {
		System.out.println("testArgs.	" + aString);
		testArgs();
		System.out.println("testArgs.	" + aString);
	}
	public void testString()	{
		System.out.println("testString.	" + aString);
		testString(aString);
		System.out.println("testString.	" + aString);
	}
	public void testArray()	{
		System.out.println("testArray.	" + anArray[0] + ", " + anArray[1]);
		testArray(anArray);
		System.out.println("testArray.	" + anArray[0] + ", " + anArray[1]);
	}
	public void testInt()	{
		System.out.println("testInt.	" + anInt );
		testInt(anInt);
		System.out.println("testInt.	" + anInt );
	}
	public void testIntObject()	{
		System.out.println("testIntObject.	" + anIntObject );
		testIntObject(anIntObject);
		System.out.println("testIntObject.	" + anIntObject );
	}

	public static void main(String args[] )       {

		new Args().testInt();

		new Args().testIntObject();

		Args changingOrNot = new Args();
		Args worker = new Args();
		changingOrNot.printAnInt();
		worker.increaseAnInt(changingOrNot);
		changingOrNot.printAnInt();
		changingOrNot.printAnIntObject();
		worker.increaseAnIntObject(changingOrNot);
		changingOrNot.printAnIntObject();

		new Args().testArray();

		new Args().testString();
	}
}
