import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Integer;

/**
 * Example usage of regular expressions
 *
 * - Practice: find strings that match the pattern and then explain the
 * pattern in natural language
 */
public class RegularExample2
{
	static String[] allPatternsToTest = {
			 "<fill>",
				 "<explanation>",
					".",
			 "<fill>",
				 "<explanation>",
					"0\\d+",
			 "<fill>",
				 "<explanation>",
					"[ab]\\d{3}",
			 "<fill>",
				 "<explanation>",
					"a?\\d{3}",
			 "<fill>",
				 "<explanation>",
					"[2-9]{2}",
			 "<fill>",
				 "<explanation>",
					"[a-z]*",
			"<fill>",
				"<explanation>",
					"(ab)+",
			};

	public static void processStatic()	{
		int index = 0;
		while  ( index < allPatternsToTest.length )	{
			System.out.println("Word to test: -" + allPatternsToTest[index] + "=");
			if  ( Pattern.matches(allPatternsToTest[index + 2 ], allPatternsToTest[index] ) )	{
				System.out.println("This regular expression " + allPatternsToTest[index + 2 ]
					+ " matches the following input: -" + allPatternsToTest[index] + "=");
				System.out.println(" 	verbal explanation: " + allPatternsToTest[index + 1 ]);
			}
			index += 3;
		}
	}
	public static void main(String[] args) {
		processStatic();
	}
}
