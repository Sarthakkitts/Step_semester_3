public class DuplicatePlayerPickChecker {
    public static void main(String[] args) {
        String[] playerNames = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(playerNames));
    }

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length - 1; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
