import java.util.Random;

public class Bot extends Player {
    private final Random random = new Random();

    public Bot(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void makeMove(GameBoard board) {
        boolean validMove = false;

        while (!validMove) {
            int row = random.nextInt(board.getSize());
            int col = random.nextInt(board.getSize());
            validMove = board.makeMove(row, col, getSymbol());
        }

        System.out.println(getName() + " placed at a random position.");
    }
}
