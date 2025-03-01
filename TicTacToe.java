import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Loop to allow multiple rounds of the game
        do {
            char[][] board = new char[3][3];  // 3x3 board for Tic-Tac-Toe
            initializeBoard(board);
            char currentPlayer = 'X';  // Player X starts first
            boolean gameWon = false;
            boolean gameDraw = false;
            
            // Play the game
            for (int i = 0; i < 9; i++) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + ", it's your turn.");
                
                // Get the player's move
                int row, col;
                while (true) {
                    System.out.print("Enter row (0, 1, or 2): ");
                    row = scanner.nextInt();
                    System.out.print("Enter column (0, 1, or 2): ");
                    col = scanner.nextInt();
                    
                    // Check if the move is valid
                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                        board[row][col] = currentPlayer;
                        break;
                    } else {
                        System.out.println("Invalid move! The cell is already occupied or out of bounds. Try again.");
                    }
                }
                
                // Check if the current player wins
                if (checkWin(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                    break;
                }
                
                // Check if it's a draw (board is full)
                if (i == 8) {
                    gameDraw = true;
                }
                
                // Switch player turn
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
            
            if (gameDraw && !gameWon) {
                printBoard(board);
                System.out.println("It's a draw!");
            }
            
            // Ask if players want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  // Consume the leftover newline
        } while (scanner.nextLine().equalsIgnoreCase("yes"));
        
        scanner.close();
        System.out.println("Thank you for playing!");
    }

    // Method to initialize the board with empty spaces
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Method to print the current state of the board
    public static void printBoard(char[][] board) {
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-----------");
        }
    }

    // Method to check if a player has won
    public static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            // Check row
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            // Check column
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}
