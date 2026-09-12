import java.util.*;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        String name;
        double cgpa;
        int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 8.0;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        public int compareTo(Candidate other) {

            double score1 = cgpa * 10 + codingScore * 0.5;
            double score2 = other.cgpa * 10 + other.codingScore * 0.5;

            if (score1 < score2) {
                return 1;
            }
            else if (score1 > score2) {
                return -1;
            }

            return 0;
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa) ||
                Candidate.isEligible(candidates[i].cgpa, candidates[i].codingScore)) {

                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];

        int j = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (Candidate.isEligible(candidates[i].cgpa) ||
                Candidate.isEligible(candidates[i].cgpa, candidates[i].codingScore)) {

                shortlisted[j] = candidates[i];
                j++;
            }
        }

        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result = result + (i + 1) + ". " + shortlisted[i].name;

            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(shortlistAndRank(candidates));
    }
}