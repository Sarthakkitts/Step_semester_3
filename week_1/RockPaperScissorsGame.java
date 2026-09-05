import java.util.Random;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.printf("%-8s %-12s %-14s %s%n", "Round", "Player", "Computer", "Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String computerMove = moves[random.nextInt(moves.length)];
            String result = playRound(playerMoves[i], computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("%-8d %-12s %-14s %s%n", i + 1, playerMoves[i], computerMove, result);
        }

        double winPercentage = wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWon = (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWon ? "Player Wins" : "Computer Wins";
    }
}
