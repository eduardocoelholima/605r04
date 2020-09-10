/**
 * - Check the main() output
 * - Explain what is happening
 */

public class B extends A
{
    public B() { System.out.print("*"); }

    public void methodOne() { System.out.print("B"); }

    public static void main ( String [] args ) {
        A obj = new B();
    }
}
