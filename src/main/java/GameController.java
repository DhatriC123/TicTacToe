import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final GameBoard board;
    private final List<Player> players;
    private int currentPlayerIndex;

    public GameController(int boardSize, int numPlayers, int numBots) {
        board = new GameBoard(boardSize);
        players = new ArrayList<>();

        // Add human players
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new HumanPlayer("Player " + i, (char) ('X' + i - 1)));
        }

        // Add bots
        for (int i = 1; i <= numBots; i++) {
            players.add(new Bot("Bot " + i, (char) ('A' + i - 1)));
        }

        currentPlayerIndex = 0;
    }

    public void play() {
        boolean gameRunning = true;

        while (gameRunning) {
            board.display();
            Player currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.makeMove(board);

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.display();
                System.out.println(currentPlayer.getName() + " wins!");
                gameRunning = false;
            } else if (board.isFull()) {
                board.display();
                System.out.println("It's a draw!");
                gameRunning = false;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
}
