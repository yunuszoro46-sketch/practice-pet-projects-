import java.util.Scanner;

public class Sudoku {
    private static final int SIZE = 9;

    private static int[][] board = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };


    private static boolean[][] fixed = new boolean[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mark original non-zero elements as fixed
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] != 0) {
                    fixed[r][c] = true;
                }
            }
        }

        System.out.println("===================================");
        System.out.println("        WELCOME TO SUDOKU!         ");
        System.out.println("===================================");
        System.out.println("Rules:");
        System.out.println("- Enter Row (1-9), Column (1-9), and Value (1-9).");
        System.out.println("- Enter 0 as the value to clear an entered move.");
        System.out.println("- You cannot overwrite initial numbers.");

        while (true) {
            printBoard();

    
            if (isBoardFilled()) {
                System.out.println("\n🎉 CONGRATULATIONS! You solved the Sudoku puzzle! 🎉");
                break;
            }

            System.out.print("\nEnter move (Row Col Value): ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Invalid input! Please enter integers only.");
                scanner.next(); // Clear bad input
                continue;
            }
            int row = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Invalid input! Please enter integers only.");
                scanner.next(); // Clear bad input
                continue;
            }
            int col = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Invalid input! Please enter integers only.");
                scanner.next(); // Clear bad input
                continue;
            }
            int num = scanner.nextInt();


            row--;
            col--;

     
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || num < 0 || num > 9) {
                System.out.println("Invalid range! Row and Col must be 1-9, Value 0-9.");
                continue;
            }

   
            if (fixed[row][col]) {
                System.out.printf("cell [%d, %d] is an original number and cannot be changed!\n", row + 1, col + 1);
                continue;
            }

     
            if (num == 0) {
                board[row][col] = 0;
                System.out.printf("Cell [%d, %d] cleared.\n", row + 1, col + 1);
                continue;
            }

            if (isValidMove(row, col, num)) {
                board[row][col] = num;
                System.out.println("Move accepted!");
            } else {
                System.out.printf("Invalid move! Number %d already exists in the row, column, or 3x3 block.\n", num);
            }
        }

        scanner.close();
    }


    private static void printBoard() {
        System.out.println("\n    1 2 3   4 5 6   7 8 9");
        System.out.println("  +-------+-------+-------+");

        for (int row = 0; row < SIZE; row++) {
            System.out.printf("%d | ", row + 1);
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[row][col] + " ");
                }

                if ((col + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();

            if ((row + 1) % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }
        }
    }


    private static boolean isValidMove(int row, int col, int num) {
        // Check row
        for (int i = 0; i < SIZE; i++) {
            if (i != col && board[row][i] == num) {
                return false;
            }
        }


        for (int i = 0; i < SIZE; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }

 
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if ((r != row || c != col) && board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }


    private static boolean isBoardFilled() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
