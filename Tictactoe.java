 package tictactoeRep;

import java.util.Scanner;

public class Tictactoe {

    public static void main(String[] args) {
        String[][] arr = new String[3][3];
        initializeBoard(arr); // Initialize the board with empty spaces
    //    String modifiedPlayer=" ";
        
        boolean gameOver = false;
        String currentPlayer = "X";
        
        while (!gameOver) {
            displayBoard(arr); // Display the board
            playerMove(arr, currentPlayer); // Current player makes a move

            if (checkWin(arr, currentPlayer)) {
                displayBoard(arr);
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isFull(arr)) {
                displayBoard(arr);
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = currentPlayer.equals("X") ? "O" : "X"; // Switch player
            }
        }
    }

    // Initialize the board with empty spaces
    static void initializeBoard(String[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = " "; // Use empty string to represent unoccupied cells
            }
        }
    }

    // Display the current state of the board
    static void displayBoard(String[][] arr) {
        System.out.println("  1   2   3");
        System.out.println("  ------------");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + arr[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("  ------------");
        }
    }

    // Check if the board is full
    static boolean isFull(String[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].equals(" ")) { // Check for empty spaces
                    return false;
                }
            }
        }
        return true;
    }

    // Handle player's move
    static void playerMove(String[][] arr, String player ) {
    	   
        Scanner sc = new Scanner(System.in);
        boolean validMove = false;
        while (!validMove) {
            System.out.println("Player " + player + ", enter your move (row and column, e.g., 1 2):");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            int wert=sc.nextInt() ;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && (arr[row][col].equals(" ")||arr[row][col].charAt(1)-'0'<wert)) {
                validMove = true;
                //  modifiedPlayer=player+wert;
                arr[row][col] = player+wert; // Assign the player's symbol to the selected cell
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Check if the player has won
    static boolean checkWin(String[][] arr, String player) {
        // Get the first letter of the player's string
        String firstLetter = String.valueOf(player.charAt(0));

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((String.valueOf(arr[i][0].charAt(0)).equals(player) &&
                 String.valueOf(arr[i][1].charAt(0)).equals(firstLetter) &&
                 String.valueOf(arr[i][2].charAt(0)).equals(firstLetter)) || // Check row
                (String.valueOf(arr[0][i].charAt(0)).equals(firstLetter) &&
                 String.valueOf(arr[1][i].charAt(0)).equals(firstLetter) &&
                 String.valueOf(arr[2][i].charAt(0)).equals(firstLetter))) { // Check column
                return true;
            }
        }
        // Check diagonals
        if ((String.valueOf(arr[0][0].charAt(0)).equals(firstLetter) &&
             String.valueOf(arr[1][1].charAt(0)).equals(firstLetter) &&
             String.valueOf(arr[2][2].charAt(0)).equals(firstLetter)) || // Main diagonal
            (String.valueOf(arr[0][2].charAt(0)).equals(firstLetter) &&
             String.valueOf(arr[1][1].charAt(0)).equals(firstLetter) &&
             String.valueOf(arr[2][0].charAt(0)).equals(firstLetter))) { // Anti-diagonal
            return true;
        }
        return false;
    }

}
