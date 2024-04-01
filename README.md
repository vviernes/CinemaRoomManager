# Cinema Room Manager

## Overview
Cinema Room Manager is a Java-based CLI app that simulates the process of booking seats in a movie theater. It provides a console interface for users to interact with, allowing them to view seating arrangements, purchase tickets, and review statistics related to the cinema's business. This appl models a simple ticket booking system, using fundamental principles of programming, such as loops, conditionals, arrays, and user input handling.

## Features
- **Dynamic Seating Arrangement**: Users can input the dimensions of the cinema room (rows and columns), and the application dynamically generates a seating plan.
- **Seat Selection and Booking**: Users can choose and purchase tickets by selecting specific seats within the cinema. The system updates the seating arrangement to reflect purchased seats.
- **Visual Display of Seats**: The app displays the current state of the cinema's seating arrangement, distinguishing between available and purchased seats.
- **Income and Statistics**: It calculates and displays statistics including the number of tickets purchased, the percentage of seats sold, current income, and potential total income based on the seating configuration.
- **Interactive Menu**: The application features an interactive menu that allows users to navigate through different options such as viewing the seating arrangement, purchasing tickets, viewing statistics, or exiting the application.

## How to Run Locally

1. **Prerequisites**: Ensure you have Java Development Kit (JDK) installed on your system.
2. **Clone or Download**: Clone or download the source code from the repository.
3. **Compilation**: Navigate to the directory containing the `Cinema.java` file and compile it using
    ```
    javac Cinema.java
    ```
4. **Running the app**: After compilation, run it using
    ```
    java Cinema
    ```
5. **Follow the prompts**: The app will prompt you to enter the number of rows and seats per row. Follow subsequent prompts to interact with the cinema booking system.


## Summary of Skills Learned
- **Basic Java Syntax**: Understanding and applying Java syntax for variables, loops, conditionals, and methods.
- **Array Manipulation**: Creating and manipulating arrays and 2D arrays to model real-world data.
- **User Input Handling**: Using the Scanner class to handle user input and implementing validation checks to ensure robustness.
- **Modular Programming**: Structuring code into methods to perform specific tasks, improving readability and maintainability.

## Ideas for Future Improvements

- **Save and Load Seating Arrangement**: Add functionality to save the current state of the cinema's seating arrangement to a file and load it when the program starts. This introduces file I/O operations in Java, teaching how to read from and write to files.

- **Enhanced Validation Checks**: Improve the robustness of user inputs throughout the application. Ensure that inputs such as the row and seat numbers are within the valid range and handle non-integer inputs gracefully, preventing the application from crashing.

- **Refactor Code for Readability and Maintenance**: Begin refactoring the code to make it more readable and maintainable. This could involve breaking down large methods into smaller, more focused methods, using more descriptive variable names, and adding comments to explain complex sections of code.

- **Interactive Seat Selection**: Instead of entering row and seat numbers, allow users to enter a single command to list all available seats and then choose one from the list by entering its corresponding number. This improvement enhances user experience and introduces array traversal and manipulation techniques.
