import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Part 1: Printing out the seating arrangement of the Cinema room
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 1; i < 8; ++i) {
            System.out.print(i);
            for (int j = 8; j > 0; --j){
                System.out.print("S ");
            }
            System.out.println("");
        }

        // Part 2: Calculating the profit, given the number of rows and seats sold
        Scanner scanner = new Scanner(System.in);
        // Get user input for number of rows
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        //Get user input for number of seats
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        // Instantiate and set variables needed for calculating income
        int income;
        int totalSeats = rows * seats;
        int frontRows = rows / 2; 
        int backRows = rows - frontRows;

        // Calculate income and display results to user
        if (totalSeats <= 60) {
            income = 10 * totalSeats;
        } else {
            income = 10 * seats * frontRows + 8 * seats * backRows;
        }
        System.out.println("Total income:");
        System.out.printf("$%d", income);
    }
}