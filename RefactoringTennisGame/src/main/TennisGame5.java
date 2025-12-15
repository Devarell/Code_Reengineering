package main;

public class TennisGame5 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame5(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else if (playerName.equals("player2"))
            player2Score++;
        else
            throw new IllegalArgumentException("Invalid player name.");
    }

    @Override
    public String getScore() {
        // Logika utama didistribusikan ke metode khusus (mengatasi Long Method)
        if (player1Score == player2Score) {
            return getTieScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return getEndGameScore();
        } else {
            return getRegularScore();
        }
    }

    private String getTieScore() {
        switch (player1Score) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private String getEndGameScore() {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String getRegularScore() {
        return getScoreName(player1Score) + "-" + getScoreName(player2Score);
    }

    private String getScoreName(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }
}