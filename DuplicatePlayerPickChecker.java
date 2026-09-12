import java.util.*;

public class DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {

        for (int i = 0; i < playerNames.length; i++) {

            for (int j = i + 1; j < playerNames.length; j++) {

                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        System.out.println("Enter player names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.println(findDuplicatePick(names));
    }
}