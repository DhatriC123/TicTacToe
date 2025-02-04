import java.util.Arrays;

public class GameBoard {
    private final char[][] board;
    private final int size;

    public GameBoard(int size) {
        this.size = size;
        board = new char[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], ' ');
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (checkRow(i, symbol) || checkCol(i, symbol)) {
                return true;
            }
        }

        // Check diagonals
        return checkDiagonal(symbol) || checkAntiDiagonal(symbol);
    }

    private boolean checkRow(int row, char symbol) {
        for (int col = 0; col < size; col++) {
            if (board[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, char symbol) {
        for (int row = 0; row < size; row++) {
            if (board[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(char symbol) {
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(char symbol) {
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != symbol) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
                if (j < size - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-".repeat(size * 4 - 1));
            }
        }
    }

    public int getSize() {
        return size;
    }
}
