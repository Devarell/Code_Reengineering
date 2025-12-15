package main;

public class TennisGame3 implements TennisGame {
    
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String s;
        // Logic check: if both players have less than 4 points and sum is not 6 (Deuce case handled elsewhere)
        if (player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6)) {
            String[] pointsNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = pointsNames[player1Score];
            return (player1Score == player2Score) ? s + "-All" : s + "-" + pointsNames[player2Score];
        } else {
            if (player1Score == player2Score)
                return "Deuce";
            // Determine leading player name
            s = player1Score > player2Score ? player1Name : player2Name;
            // Check if advantage (diff is 1) or win (diff >= 2)
            return ((player1Score - player2Score) * (player1Score - player2Score) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.player1Score += 1;
        else
            this.player2Score += 1;
    }
}