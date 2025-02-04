import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void makeMove(GameBoard board) {
        Scanner scanner = new Scanner(System.in);
        boolean validMove = false;

        while (!validMove) {
            System.out.println(getName() + " (" + getSymbol() + "), enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            validMove = board.makeMove(row, col, getSymbol());

            if (!validMove) {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
