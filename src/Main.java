import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] board = new String[8][8];
        boardHeader(); // Board header (column labels)

        // Create the board with alternating "  " (empty) and "###" (occupied) squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = "     ";  // empty square
                } else {
                    board[i][j] = "###";  // occupied square
                }
            }
        }

        // Starting position white (1st row) - White pawns (2nd row)
        for (int i = 0; i < 8; i++) {
            board[1][i] = Piece.pawn(); // White pawns
        }

        // Starting position black (6th row) - Black pawns (7th row)
        for (int i = 0; i < 8; i++) {
            board[6][i] = Piece.Bpawn(); // Black pawns
        }

        // Black pieces (7th row)
        board[7][0] = Piece.Brook();   // Black rook
        board[7][1] = Piece.Bhorse();  // Black knight
        board[7][2] = Piece.Bbishop(); // Black bishop
        board[7][3] = Piece.Bqueen();  // Black queen
        board[7][4] = Piece.Bking();   // Black king
        board[7][5] = Piece.Bbishop(); // Black bishop
        board[7][6] = Piece.Bhorse();  // Black knight
        board[7][7] = Piece.Brook();   // Black rook

        // White pieces (0th row)
        board[0][0] = Piece.rook();   // White rook
        board[0][1] = Piece.horse();  // White knight
        board[0][2] = Piece.bishop(); // White bishop
        board[0][3] = Piece.queen();  // White queen
        board[0][4] = Piece.king();   // White king
        board[0][5] = Piece.bishop(); // White bishop
        board[0][6] = Piece.horse();  // White knight
        board[0][7] = Piece.rook();   // White rook

        // Print the board with row numbers and column labels

        boolean start = true;

        while (start) {
            printBoard(board);
           /* for (int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(i+j%2==0){
                       board[i][j]="   ";
                    }
                    else{
                        board[i][j]="##";
                    }
                }
            }*/
            playChess(board);
        }
    }

    // Method to print the board header (column labels)
    private static void boardHeader() {
        System.out.println("    A     B     C     D     E     F     G     H  ");
        System.out.println("  -------------------------------");
    }

    private static void printBoard(String[][] board) {
        for (int i = 7; i >= 0; i--) {
            System.out.print(8 - i + " ");  // Print row numbers from 8 to 1
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");  // Print each square in the row
            }
            System.out.println();  // Move to the next line after each row
        }
    }

    private static void playChess(String[][] board) {
        // Add game logic here if needed
        System.out.println("Chess is being played...");
        System.out.println("Which piece would you like to move? (e.g. 8 A for the current location and then the destination)");
        System.out.println("Which row (1-8)?");

        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        if (row >= 1 && row <= 8) {
            row = 8 - row;  // Convert input to 0-based index
        } else {
            System.out.println("Invalid row number!");
            return;
        }

        System.out.println("Which column (A-H)?");
        String column = scan.next().toUpperCase();  // Convert to upper case
        int columnIndex = -1;

        // Map the column letter to index
        switch (column) {
            case "A": columnIndex = 0; break;
            case "B": columnIndex = 1; break;
            case "C": columnIndex = 2; break;
            case "D": columnIndex = 3; break;
            case "E": columnIndex = 4; break;
            case "F": columnIndex = 5; break;
            case "G": columnIndex = 6; break;
            case "H": columnIndex = 7; break;
            default:
                System.out.println("Invalid column!");
                return;
        }

        System.out.println("Select the row for the move (1-8):");
        int row2 = scan.nextInt();
        if (row2 >= 1 && row2 <= 8) {
            row2 = 8 - row2; // Convert to 0-based index
        } else {
            System.out.println("Invalid row number!");
            return;
        }

        System.out.println("Select the column for the move (A-H):");
        String column2 = scan.next().toUpperCase();
        int column2Index = -1;

        switch (column2) {
            case "A": column2Index = 0; break;
            case "B": column2Index = 1; break;
            case "C": column2Index = 2; break;
            case "D": column2Index = 3; break;
            case "E": column2Index = 4; break;
            case "F": column2Index = 5; break;
            case "G": column2Index = 6; break;
            case "H": column2Index = 7; break;
            default:
                System.out.println("Invalid column!");
                return;


        }

        // Move the piece
        board[row2][column2Index] = board[row][columnIndex];
        board[row][columnIndex] = "     ";  // Empty the original square

        // Print the updated board
        if(row+columnIndex%2==0){
            board[row][columnIndex]="  ";;
        }else {
            board[row][columnIndex]="##";;
        }

        System.out.println("Would you like to continue? Press any key to continue or -1 to quit.");
        int exitCheck = scan.nextInt();
        if (exitCheck == -1) {

            return;
        }

        // printBoard(board);
    }
}
