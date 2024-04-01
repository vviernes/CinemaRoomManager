import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Configure seating arrangment of Cinema Room
        int[] seatingConfig = getSeatingDimension();
        int totalRows = seatingConfig[0];
        int totalColumns = seatingConfig[1];
        int seatsPurchased = 0;
        int totalSeats = totalRows * totalColumns;
        int earnedIncome = 0;

        // Create 2D Matrix representing the seats
        char[][] seatingArrangement = new char[totalRows][totalColumns];
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++){
                seatingArrangement[i][j] = 'S';
            }
        }

        // Calculate total possible income, given the seating arrangement 
        int possibleIncome = 0;
        int frontRows = totalRows / 2; 
        int backRows =  totalRows - frontRows;
        if (totalSeats <= 60) {
            possibleIncome = 10 * totalRows * totalColumns;
        } else {
            possibleIncome = totalColumns * (10 * frontRows + 8 * backRows);
        }


        // Loop to display Main Menu options
        boolean loopMenu = true;
        while (loopMenu) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 1:
                    printSeating(seatingArrangement);
                    break;
                case 2:
                    int[] purchasedSeat = buyTicket(totalRows, totalColumns, seatingArrangement);
                    seatingArrangement[purchasedSeat[0] - 1][purchasedSeat[1] - 1] = 'B';
                    seatsPurchased += 1; 
                    earnedIncome += purchasedSeat[2];
                    break;
                case 3:
                    displayStats(seatsPurchased, totalSeats, earnedIncome, possibleIncome);
                    break;
                case 0:
                    loopMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            System.out.println(); // Newline
            scanner.close();
        }
    }
        
        // Gets users input to generate the number of row and columns of the Cinema room
        public static int[] getSeatingDimension() {
            Scanner scanner = new Scanner(System.in);
            // Get user input for dimensions of seating arrangment
            System.out.println("Enter the number of rows:");
            int rows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row:");
            int columns = scanner.nextInt();
            scanner.close();
            
            return new int[] {rows, columns};
        }

        // Prints out the seating arrangment of the Cinema room, given the # of rows, columns
        public static void printSeating(char[][] seatingArrangement) {
            int rows = seatingArrangement.length;
            int columns = seatingArrangement[0].length;
            
            System.out.println("Cinema:");
            System.out.print("  "); // Leading spaces for row numbers
            
            // Print column numbers
            for (int j = 0; j < columns; j++) { 
                System.out.print((j + 1) + " ");
            }
            
            System.out.println(); // Newline after printing column headers

            for (int i = 0; i < rows; i++) {
                // Print row number
                System.out.print((i + 1) + " "); 
                for (int j = 0; j < columns; j++) {
                    System.out.print(seatingArrangement[i][j] + " ");
                }
                System.out.println(); // Newline after each row
            }
        }
        // Get user input to purchase a specific seat
        public static int[] buyTicket(int rows, int columns, char[][] seatingArrangement) {
            Scanner scanner = new Scanner(System.in);

            // check availability of seat
            boolean available = false;
            int rowInput = 0;
            int columnInput = 0;
            while (!available) {
                System.out.println("Enter a row number:");
                rowInput = scanner.nextInt();
                //Get user input for number of seats
                System.out.println("Enter a seat number in that row:");
                columnInput = scanner.nextInt();
                if (rowInput < 1 || columnInput < 1 || rowInput - 1 >= rows || columnInput - 1 >= columns) {
                    System.out.println("Wrong input!");
                } else if (seatingArrangement[rowInput - 1][columnInput - 1] == 'B') {
                        System.out.println("That ticket has already been purchased!");
                } else {
                    available = true;
                }
            }
    
            int totalSeats = rows * columns;
            int frontRows = rows / 2;
    
            int cost;
            if (totalSeats <= 60) {
                cost = 10;
            } else {
                if (rowInput <= frontRows){
                    cost = 10;
                } else {
                    cost = 8;
                }
            }
            System.out.printf("Ticket price: $%d", cost);
            System.out.println();
            scanner.close();
            return new int[] {rowInput, columnInput, cost};
        }

        // Output statistics related to purchased tickets and income
        public static void displayStats(int seatsPurchased, int totalSeats, int earnedIncome, int possibleIncome) {
            float seatPercentage = (float) seatsPurchased / totalSeats * 100;
            System.out.printf("Number of purchased tickets: %d\n", seatsPurchased);
            System.out.printf("Percentage: %.2f%%\n", seatPercentage);
            System.out.printf("Current income: $%d\n", earnedIncome);
            System.out.printf("Total income: $%d\n", possibleIncome);
        }
}