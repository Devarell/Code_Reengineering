package main;

public class TennisGame2 implements TennisGame {
    private int P1point = 0;
    private int P2point = 0;
    
    private String P1res = "";
    private String P2res = "";
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            P1Score();
        else
            P2Score();
    }

    public void P1Score(){ P1point++; }
    public void P2Score(){ P2point++; }
    
    public void SetP1Score(int number){
        for (int i = 0; i < number; i++) P1Score();
    }
    
    public void SetP2Score(int number){
        for (int i = 0; i < number; i++) P2Score();
    }

    public String getScore() {
        if (isTie()) {
            return getTieScore();
        } else if (isEndGame()) {
            return getEndGameScore();
        } else {
            return getRegularScore();
        }
    }

    private boolean isTie() {
        return P1point == P2point;
    }

    private boolean isEndGame() {
        return P1point >= 4 || P2point >= 4;
    }

    private String getTieScore() {
        if (P1point >= 3)
            return "Deuce";
        
        if (P1point == 0) return "Love-All";
        if (P1point == 1) return "Fifteen-All";
        return "Thirty-All";
    }

    private String getRegularScore() {
        P1res = convertScore(P1point);
        P2res = convertScore(P2point);
        return P1res + "-" + P2res;
    }

    private String getEndGameScore() {
        if (P1point - P2point == 1) return "Advantage player1";
        if (P2point - P1point == 1) return "Advantage player2";
        
        if (P1point - P2point >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String convertScore(int point) {
        if (point == 0) return "Love";
        if (point == 1) return "Fifteen";
        if (point == 2) return "Thirty";
        return "Forty";
    }
}