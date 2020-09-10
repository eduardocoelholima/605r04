
import java.util.Scanner;

/**
 * Scanner examples
 *
 * - Change code below to read Floats instead
 * - Change code below to read Strings instead
 *
 */
public class Scanner2 {
	public static void main( String[] args ) {
		Scanner sc  = new Scanner( System.in);
		System.out.printf("> ");
		while ( sc.hasNext() )	{
			String aInteger = sc.next();
			System.out.printf("-%s-%n", aInteger );
			System.out.printf("> ");
		}
		sc.close();
	}
}


