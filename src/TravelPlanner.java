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
        doDistance(input);
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

    static double haversine(double lat1, double lon1, double lat2, double lon2)
    {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return ((int)(rad * c) / 100.0);
    }

    public static void doDistance (Scanner input) {
        System.out.println("Let's calculate how far away you are from home.");
        System.out.println("Whats the latitude of your home?");
        double latHome = input.nextDouble();
        System.out.println("Whats the longitude of your home?");
        double longHome = input.nextDouble();
        System.out.println("Whats the latitude of your destination?");
        double latDestination = input.nextDouble();
        System.out.println("Whats the longitude of your destination?");
        double longDestination = input.nextDouble();
        double distance = haversine(latHome, longHome, latDestination, longDestination);
        System.out.println("Your destination is " + distance + "km away from home!");
    }
}
