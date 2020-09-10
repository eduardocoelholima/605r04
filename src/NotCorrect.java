/**
 * We went over this example during lecture. This will overflow the stack. Why?
 */
public class  NotCorrect	{

  static int counter;
  NotCorrect aNotCorrect =  new NotCorrect(); // hint

  public NotCorrect() {
	 System.out.println("so Many Calls: " + counter++ );
  }
  public static void main(String args[] )	{
	NotCorrect aNotCorrect = new NotCorrect(); 
  }
}
