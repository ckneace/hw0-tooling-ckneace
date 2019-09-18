package hangman;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.Set;

public class Main {

//  private static final Logger logger = LoggerFactory.getLogger(Main.class);
  private static Logger logger = LoggerFactory.getLogger(Main.class);

  /**
   * As main runs, it takes the arguments and if the length of the argment is equal to 3
   * Then it reads the arguments and parse it.
   * Otherwise, it's going to ask you to put it in the right format
   *
   * @param args passed in for the classes to run
   */
  public static void main(String[] args) {

    logger.warn("HELLO warning");
    logger.debug("HELLO debugging");
    logger.info("HELLO info");
    logger.trace("HELLO trace");
    logger.error("HELLO error");

    String dictionaryName = "";
    int wordLength = 0;
    int guesses = 0;
    if (args.length == 3) {
      dictionaryName = args[0];
      wordLength = Integer.parseInt(args[1]);
      guesses = Integer.parseInt(args[2]);
    } else {
      System.out.println("Use this format: java [main class name] dictionary wordlength guesses");
    }



  }

  /**
   * Prints out the input and weather or not what the user has guessed is correct.
   *
   * @param contains to let the response know if it has that alphabet
   * @param guess    input of user
   * @param numbers  number of times guessed
   */
  public static void printResponse(boolean contains, char guess, int numbers) {
    if (contains) {
      System.out.println("Yes, there is " + numbers + " " + guess + "\n");
    } else {
      System.out.println("Sorry, there are no " + guess + "'s" + "\n");
    }
  }

  /**
   * print the processor of the game.
   *
   * @param guesses     how many guesses you have left
   * @param usedLetters how many letters you have used
   * @param pattern     what you have so far
   */
  public static void printGame(int guesses, Set<String> usedLetters, String pattern) {

    System.out.println("You have " + guesses + " guesses left");
    StringBuilder sb = new StringBuilder();
    for (Iterator<String> it = usedLetters.iterator(); it.hasNext(); ) {
      String s = it.next();
      sb.append(s);
      sb.append(" ");
    }
    System.out.println("Used letters: " + sb.toString());
    System.out.println("Word: " + pattern);
    System.out.print("Enter guess: ");
  }

  /**
   * You have won.
   *
   * @param correct guessed all correct
   */
  public static void printWon(String correct) {
    System.out.println("You win! " + correct);
    System.exit(0);
  }

  /**
   * You lost.
   *
   * @param correct guessed all wrong
   */
  public static void printLost(String correct) {
    System.out.println("You lose!");
    System.out.println("The word was: " + correct);
    System.exit(0);
  }

}