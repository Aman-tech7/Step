import java.util.Scanner;

public class BankTransactionReferenceGenerator {
    static String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() < 3)
            return reference;

        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14)
            return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i)))
                return "Invalid: bank code must be 3 letters";
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i)))
                return "Invalid: body must contain only digits";
        }

        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String seq = reference.substring(9);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bank).append("] DATE: ")
              .append(date.substring(0, 2)).append("/")
              .append(date.substring(2, 4)).append("/")
              .append(date.substring(4, 6))
              .append(" | SEQ: ").append(seq);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String normalized = normalizeReference(sc.nextLine());
        System.out.println(validateAndFormat(normalized));
        sc.close();
    }
}
