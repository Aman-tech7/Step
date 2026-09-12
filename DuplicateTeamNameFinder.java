import java.util.*;

public class DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {

        for (int i = 0; i < teamNames.length; i++) {

            for (int j = i + 1; j < teamNames.length; j++) {

                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();

        String[] teamNames = new String[n];

        System.out.println("Enter team names:");

        for (int i = 0; i < n; i++) {
            teamNames[i] = sc.next();
        }

        System.out.println(findDuplicateTeam(teamNames));
    }
}