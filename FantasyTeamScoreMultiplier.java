import java.util.*;

public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        double[] scores = new double[n];

        System.out.println("Enter player scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        System.out.print("Enter captain index: ");
        int captainIndex = sc.nextInt();

        System.out.print("Enter vice-captain index: ");
        int viceCaptainIndex = sc.nextInt();

        applyMultipliers(scores, captainIndex, viceCaptainIndex);

        System.out.println("Updated scores:");
        System.out.println(Arrays.toString(scores));
    }
}