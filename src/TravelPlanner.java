import java.util.Scanner;

public class TravelPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        doGreeting(input);
        /*
        int count = input.nextInt();
        double  amount = input.nextDouble();
        String name = input.nextLine(); // get next complete line of input, with spaces
        String firstName = input.nextLine(); // any String without white space
        */
    }
    public static void doGreeting(Scanner input) {
        System.out.println("Welcome to Vacation Planner!");
        System.out.println("What is your name?");
        String name = input.nextLine(); // get next complete line of input
        System.out.println("Nice to meet you " + name + ", where are you traveling to?");
        String destination = input.nextLine(); // get next complete line of input
        System.out.println("Great! " + destination + " sounds like a great trip!");
        doTimeAndBudget(input, destination);
        doTimeConversion(input);
        doMetricConversion(input, destination);
    }

    public static void doTimeAndBudget(Scanner input, String destination) {
        System.out.println("How many days will you be spending in " + destination + "?");
        int days = input.nextInt();
        System.out.println("How many USD will you spend on your trip?");
        int budget = input.nextInt();
        System.out.println("What is the three letter currency symbol of your travel destination?");
        String symbol = input.next();
        System.out.println("How many " + symbol + " are in 1 USD?");
        double rate = input.nextDouble();
        int hours = days * 24;
        int minutes = hours * 60;
        double moneyPerDay = ((int)(budget / (double) days) * 100) / 100.0;
        double budgetInForeignCurrency = budget * rate;

        double dailyBudgetInForeignCurrency = budgetInForeignCurrency / days;
        System.out.println("If you are traveling for " + days + " days, that is the same as " + hours + " hours, or " + minutes + " minutes.");
        System.out.println("If you are going to spend " + budget + ", you can spend up to " + moneyPerDay + " USD per day.");
        System.out.println("Your total budget in " + symbol + " is " + budgetInForeignCurrency + ", or " + dailyBudgetInForeignCurrency + " " + symbol + " per day.");
    }

    public static void doTimeConversion(Scanner input) {
        System.out.println("What is the time difference, in hours, between your home and destination?");
        int timeDiff = input.nextInt();
        int diffCalc = 24 + timeDiff;
        int midnightDiff = (diffCalc > 24) ? (diffCalc - 24) : (24 + timeDiff);
        int noonDiff = 12 + timeDiff;
        System.out.println("When it is midnight at your place, it will be " + midnightDiff + ":00 at midnight your place, and " + noonDiff + ":00 when it is noon at home.");
    }

    public static void doMetricConversion(Scanner input, String destination) {
        System.out.println("How big, in square kilometers, is " + destination + "?");
        double inMiles = ((int)((input.nextDouble() * 0.38610) * 100)) / 100.0;
        System.out.println("That is " + inMiles + " in square miles!");
    }
}
