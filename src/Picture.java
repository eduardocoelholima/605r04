/**
 * This class implements a Picture Game.
 *
 * Lets ask ourselves a few questions.
 * - What does parseArgs() do?
 * - Is extractWord() getting the last remaining word read from the file?
 * - Check startTheGame(String[]) and explain each block of the method.
 * - Check guessedCorrectly(String) and explain each block of the method.
 *
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.util.Vector;
import java.util.Random;


public class Picture {
	private Scanner theInput		= new Scanner(System.in);
	private String theOriginalWordToGuess;
	private String theWordToGuess;
	private String theWordShownToTheUser	= null;
	private int soManyGuesses 		= 0;
	private int soManyCorrectGuesses 	= 0;
	final private int MAX_GUESSES 		= 3;
	final private Vector<String> pickAWordFromHere = new Vector<String>();
	Vector<String> thePicture		= new Vector<String>();
	final String DOT = ".";
	static Random randomNumberGenerator 	= new Random();

	private void printTheWords()	{
		for ( int index = 0; index < pickAWordFromHere.size(); index ++ )	{
			System.out.println(index  + "/" + pickAWordFromHere.size() + ":	" + pickAWordFromHere.elementAt(index) );
		}
	}

	private void printThePicture()	{
		int lengthOfWord = theWordToGuess.length();
		int printEverXthWord = ( lengthOfWord - soManyCorrectGuesses) + 1;

		int globalCharCounter = 1;
		for ( int index = 0; index <  thePicture.size(); index ++ )	{
			System.out.print("       ");
			for ( int xOuter = 0; xOuter < thePicture.elementAt(index).length(); xOuter++ )	{
				if ( globalCharCounter++ % printEverXthWord == 0 )
					System.out.print(thePicture.elementAt(index).charAt(xOuter) );
				else
					System.out.print(DOT);
			}
			System.out.println();
		}
	}

	private void fillTheWordsVector(Scanner theWords)	{
		while ( theWords.hasNext() )
			pickAWordFromHere.add(theWords.next());
	}

	private void fillThePicture(Scanner thePictureInput)	{
		while ( thePictureInput.hasNextLine() )	{
			thePicture.add( thePictureInput.nextLine() );

		}
	}

	private void parseArgs(String[] args)	{
		try {
			for ( int index = 0; index < args.length; index ++ )	{
				if ( args[index].equals("-words") )	{
					Scanner theWords = new Scanner(new File( args[index+1]) );
					fillTheWordsVector(theWords);
					theWords.close();
				} else if ( args[index].equals("-picture") )	{
					Scanner thePicture = new Scanner(new File( args[index+1]) );
					fillThePicture(thePicture);
					thePicture.close();
				}
			}
		} catch (Exception e )	{
			System.err.println("Arguments could not be parsed.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	private int createRandomNumber(int bound )	{
		return randomNumberGenerator.nextInt(bound);
	}

	private boolean areThereAnyWordsLeft()	{
		boolean rValue;
		if ( ( rValue = ( pickAWordFromHere.size() == 0 ) ) )	{
			System.out.println("No more words left to guess");
			System.out.println("I hope you enjoyed the game, bye!");
		}
		return !rValue;
	}

	private String extractWord()	{
		String randomWord = null;
		int thisWord = 0;
		if ( pickAWordFromHere.size() > 1 )	{
			thisWord = createRandomNumber(pickAWordFromHere.size() - 1 );
		}
		randomWord =  pickAWordFromHere.elementAt(thisWord);
		pickAWordFromHere.remove(thisWord);
		theWordShownToTheUser = randomWord.replaceAll(DOT, DOT);
		soManyCorrectGuesses = 0;
		return randomWord;
	}

	private boolean guessedCorrectly(String theGuess)	{
		int positionOfChar;

		// what does positionOfChar being negative signals?
		boolean correctGuess  = ( ( positionOfChar = theWordToGuess.indexOf(theGuess) )  >= 0 );

		// is this block executed if the user type a letter a second time?
		// (assuming the letter only appears once)
		if ( correctGuess )	{
			char[] theWordAsArray = theWordShownToTheUser.toCharArray();
			int index = 0;
			boolean unmodified = true;

			// what is this loop going over? hint: array of something
			// what is the while stopping condition?
			while ( unmodified && ( index < theWordAsArray.length ) )	{

				// what does the condition below tests?
				if (  theWordToGuess.charAt(index) == theWordToGuess.charAt(positionOfChar) )	{
					unmodified = false;

					//what does these three lines below does?
					theWordAsArray[index] = theWordToGuess.charAt(positionOfChar);
					String replacedWithDot = theWordToGuess.substring( positionOfChar, positionOfChar + 1 );
					theWordToGuess = theWordToGuess.replaceFirst(replacedWithDot, DOT );
				}
				index ++;
			}
			theWordShownToTheUser = new String(theWordAsArray);
		}
		return  correctGuess;
	}

	private boolean notDone()	{
		return   ( (soManyGuesses >= MAX_GUESSES ) || ( theWordShownToTheUser.indexOf(".") < 0 ) );
	}

	private void printPicture()	{
		for ( int line = 0; line < thePicture.size(); line ++ )	{
			System.out.println(thePicture.elementAt(line));
		}
	}

	private void printWord()	{
		System.out.println(soManyGuesses + ": " + theWordShownToTheUser );
	}

	private void startTheGame(String[] args)	{
		parseArgs(args);
		String guess = null;

		while ( areThereAnyWordsLeft() )	{
			theWordToGuess = extractWord();
			theOriginalWordToGuess = theWordToGuess;
			soManyGuesses = 0;
			do {
				printThePicture();
				printWord();

//				- What is if ( theInput.hasNext() ) testing?
				if ( theInput.hasNext() )
					guess = theInput.next();
				else {
					System.err.println("Can not read input. Bye ");
					System.exit(2);
				}

//				*   - What is if ( ! guessedCorrectly(guess) ) testing?
				if ( ! guessedCorrectly(guess) )
					soManyGuesses ++;
				else
					soManyCorrectGuesses++;

//				*   - What is if ( theWordShownToTheUser.indexOf(DOT) < 0 ) testing?
				if ( theWordShownToTheUser.indexOf(DOT) < 0 )	{
					printThePicture();
					System.out.println("The word was: " +  theOriginalWordToGuess + "\n\n");
				}

//				*   - What is if (soManyGuesses >= MAX_GUESSES ) testing?
				if (soManyGuesses >= MAX_GUESSES )
					System.out.println("You failed guessing the word!");
			} while ( ! notDone() );
		}

	}

	public static void main( String[] args ) {
		new Picture().startTheGame(args);
	}
}
