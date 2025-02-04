import java.util.Scanner;

public class Newtic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the board size: ");
        int boardSize = scanner.nextInt();

        System.out.println("Enter the number of human players: ");
        int numPlayers = scanner.nextInt();

        System.out.println("Enter the number of bots: ");
        int numBots = scanner.nextInt();

        if (numPlayers + numBots > boardSize - 1) {
            System.out.println("Too many players for the given board size. Maximum players allowed: " + (boardSize - 1));
            return;
        }

        GameController game = new GameController(boardSize, numPlayers, numBots);
        game.play();
    }
}
