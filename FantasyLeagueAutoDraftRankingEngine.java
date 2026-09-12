import java.util.*;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        public int compareTo(Player other) {
            if (this.battingAverage < other.battingAverage) {
                return 1;
            } else if (this.battingAverage > other.battingAverage) {
                return -1;
            }
            return 0;
        }
    }

    static String draftAndRank(Player[] players) {

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (Player.isDraftable(players[i].matchesPlayed) ||
                Player.isDraftable(players[i].matchesPlayed, players[i].injured)) {
                count++;
            }
        }

        Player[] draftable = new Player[count];

        int j = 0;

        for (int i = 0; i < players.length; i++) {

            if (Player.isDraftable(players[i].matchesPlayed) ||
                Player.isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[j] = players[i];
                j++;
            }
        }

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result = result + (i + 1) + ". " + draftable[i].name;

            if (i < draftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter matches played: ");
            int matches = sc.nextInt();

            System.out.print("Enter batting average: ");
            double average = sc.nextDouble();

            System.out.print("Is injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            players[i] = new Player(name, matches, average, injured);
        }

        System.out.println(draftAndRank(players));
    }
}