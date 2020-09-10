
import java.util.Scanner;

/**
 * Scanner example
 *
 * - change the delimiter to read comma separated string values
 * - now change the delimiter to remove spaces between entries in the string
 *
 */
public class Scanner3 {
	public static void main( String[] args ) {
		Scanner sc  = new Scanner("one , two , three,four")
				.useDelimiter(" ");
		System.out.printf("> ");
		while ( sc.hasNext() )	{
			String line = sc.next();
			System.out.printf("-%s-%n", line );
			System.out.printf("> ");
		}
		sc.close();
	}
}


