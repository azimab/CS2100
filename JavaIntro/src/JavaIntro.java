//Azim Abdulmajeeth
//zwf8qy@virginia.edu
//JavaIntro
//None
import java.util.Scanner;
public class JavaIntro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter which method you would like to try (1 = hilo, 2 = rpsls, 3 = fuzzbizz, 4 = countRuns): ");
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("Enter the maximum value that can be guessed: ");
            int max = scan.nextInt();
            System.out.println("Enter the target value to be guessed");
            int target = scan.nextInt();
            int guesses = hilo(max, target);
            System.out.println("It took " + guesses + " guesses to find your target.");
        } else if (choice == 2) {
            System.out.println("Choose rock, paper, scissors, spock, or lizard: ");
            String userChoice = scan.next();
            System.out.println("Choose for the computer: rock, paper, scissors, spock, or lizard: ");
            String computerChoice = scan.next();
            int winner = rpsls(userChoice, computerChoice);
            if (winner == 0) System.out.println("The computer won!");
            else if (winner == 1) System.out.println("You won!");
            else System.out.println("You had the same answer!");
        } else if (choice == 3) {
            System.out.println("Enter value one: ");
            int one = scan.nextInt();
            System.out.println("Enter value two: ");
            int two = scan.nextInt();
            System.out.println("Enter your input: ");
            int input = scan.nextInt();
            String fuzzbizz = fuzzbizz(one, two, input);
            System.out.println(fuzzbizz);
        } else if (choice == 4) {
            System.out.println("Enter the length of your array: ");
            int length = scan.nextInt();
            int array[] = new int[length];
            for (int i = 0; i < length; i++) {
                System.out.println("Enter a value for the array: ");
                array[i] = scan.nextInt();
            }
            System.out.println("Number of runs is " + countRuns(array));
        }
    }

    public static int hilo(int max, int target) {
        int count = 1;
        int guess = (int) (Math.random() * max) + 1;
        if (guess == target) return count;
        int upper = max;
        int lower = 1;
        while (guess != target) {
            if (guess > target) {
                upper = guess - 1;
            }
            else {
                lower = guess + 1;
            }
            guess = (int) (Math.random() * ((upper - lower) + 1)) + lower;
            count++;
        }
        return count;
    }

    public static int rpsls(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) return -1;
        if (computerChoice.equalsIgnoreCase("scissors")) {
            if (userChoice.equalsIgnoreCase("rock")) return 1;
            else if (userChoice.equalsIgnoreCase("spock")) return 1;
            else if (userChoice.equalsIgnoreCase("paper")) return 0;
            else if (userChoice.equalsIgnoreCase("lizard")) return 0;
        }
        else if (computerChoice.equalsIgnoreCase("rock")) {
            if (userChoice.equalsIgnoreCase("spock")) return 1;
            else if (userChoice.equalsIgnoreCase("paper")) return 1;
            else if (userChoice.equalsIgnoreCase("scissors")) return 0;
            else if (userChoice.equalsIgnoreCase("lizard")) return 0;
        }
        else if (computerChoice.equalsIgnoreCase("paper")) {
            if (userChoice.equalsIgnoreCase("lizard")) return 1;
            else if (userChoice.equalsIgnoreCase("scissors")) return 1;
            else if (userChoice.equalsIgnoreCase("rock")) return 0;
            else if (userChoice.equalsIgnoreCase("spock")) return 0;
        }
        else if (computerChoice.equalsIgnoreCase("lizard")) {
            if (userChoice.equalsIgnoreCase("rock")) return 1;
            else if (userChoice.equalsIgnoreCase("scissors")) return 1;
            else if (userChoice.equalsIgnoreCase("paper")) return 0;
            else if (userChoice.equalsIgnoreCase("spock")) return 0;
        }
        else if (computerChoice.equalsIgnoreCase("spock")) {
            if (userChoice.equalsIgnoreCase("lizard")) return 1;
            else if (userChoice.equalsIgnoreCase("paper")) return 1;
            else if (userChoice.equalsIgnoreCase("scissors")) return 0;
            else if (userChoice.equalsIgnoreCase("rock")) return 0;
        }
        return -1;
    }



    public static String fuzzbizz (int one, int two, int input) {
        if (input % one == 0 && input % two == 0) return "fuzzbizz";
        else if (input % one == 0 && input % two != 0) return "fuzz";
        else if (input % one != 0 && input % two == 0) return "bizz";
        else return "none";
    }

    public static int countRuns ( int[] numbers) {
        int count = 0;
        boolean inRun = false;
        for (int i = 1; i < numbers.length; i++) {
            if (inRun) {
                if (numbers[i] != numbers[i - 1]) {
                    inRun = false;
                }
            }
            else if (!inRun) {
                if (numbers[i] == numbers[i-1]) {
                    count++;
                    inRun = true;
                }
            }
        }
        return count;
    }
}