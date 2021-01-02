import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WPMProgram
{
    final static double SECONDS_CONVERSION = 1000000000.0;
    static String[] words = {"car", "watermelon", "camera", "hole", "grail",
            "scientist", "hours", "duel", "monster", "dragon"};

    public static void main(String[] args) throws InterruptedException
    {
        // Countdown:
        System.out.println("Get Ready!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        // Generate words to type.
        Random rand = new Random();
        for (int i = 0; i < 10; i++)
        {
            System.out.print(words[rand.nextInt(9)] + " ");
        }
        System.out.println();

        // Record the time the words are typed.
        double startTime = LocalTime.now().toNanoOfDay();
        Scanner scan = new Scanner(System.in);
        String typedWords = scan.nextLine();
        double endTime = LocalTime.now().toNanoOfDay();
        double elapsedTime = endTime - startTime;
        double totalSeconds = elapsedTime / SECONDS_CONVERSION;
        int numChars = typedWords.length();

        // Formula to calculate wpm
        int wpm = (int) ((((double) numChars / 5) / totalSeconds) * 60);

        System.out.println("\nYour wpm is " + wpm + "!");
    }

}
