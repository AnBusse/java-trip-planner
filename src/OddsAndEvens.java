import java.util.Random;
import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isValidAnswer = false;

        System.out.println("Let’s play a game called “Odds and Evens\"");
        System.out.println("What's your name?");
        String name = input.nextLine();
        boolean isOdd = false;

        while (!isValidAnswer) {
            System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
            String userInput = input.next();
            if (userInput.equals("O")) {
                isOdd = true;
                isValidAnswer = true;
            } else if (userInput.equals("E")) {
                isOdd = false;
                isValidAnswer = true;
            } else {
                System.out.println("Invalid answer, please try again!");
            }
        }
        System.out.println("You've chosen " + (isOdd ? "Odd" : "Even") + " that means the computer is " + (!isOdd ? "Odd" : "Even"));
        System.out.println("---------------------------------------");
        playGame(isOdd);
    }

    public static void playGame (boolean isOdd) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many “fingers” do you put out?");
        int userNumber = input.nextInt();
        Random rand = new Random();
        int computerNumber = rand.nextInt(6);
        System.out.println("The computer plays number " + computerNumber);
        System.out.println("---------------------------------------");
        int sum = userNumber + computerNumber;
        System.out.println(userNumber + " + " + computerNumber + " = " + sum);
        boolean isEven = sum % 2 == 0;

        System.out.println("The sum is " + (isEven ? "even" : "odd"));
        System.out.println("---------------------------------------");
        String whoWon = "The computer won!";

        if ((isOdd && !isEven) || (!isOdd && isEven)) {
            whoWon = "Congratulations, you won!";
        }
        System.out.println(whoWon);
    }
}
