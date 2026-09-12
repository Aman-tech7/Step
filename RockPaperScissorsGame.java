import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String getComputerMove(Random random) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[random.nextInt(3)];
    }

    static String normalizeMove(String move) {
        move = move.trim().toLowerCase();

        if (move.equals("rock") || move.equals("r")) return "Rock";
        if (move.equals("paper") || move.equals("p")) return "Paper";
        if (move.equals("scissors") || move.equals("s")) return "Scissors";

        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            String playerMove;

            while (true) {
                System.out.print("Round " + (i + 1) + " - Enter Rock, Paper or Scissors: ");
                playerMove = normalizeMove(sc.nextLine());

                if (!playerMove.isEmpty()) {
                    break;
                }

                System.out.println("Invalid move. Try again.");
            }

            String computerMove = getComputerMove(random);
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
            System.out.println();
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("----- Final Summary -----");
        System.out.printf("%-8s %-15s %-15s %-18s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-15s %-15s %-18s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win %%: %.1f%%%n", winPercentage);

        sc.close();
    }
}
