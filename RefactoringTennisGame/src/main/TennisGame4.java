package main;

public class TennisGame4 implements TennisGame {

    private int serverScore;
    private int receiverScore;
    private String serverName;
    private String receiverName;

    public TennisGame4(String player1Name, String player2Name) {
        this.serverName = player1Name;
        this.receiverName = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (serverName.equals(playerName))
            this.serverScore += 1;
        else
            this.receiverScore += 1;
    }

    @Override
    public String getScore() {
        // TEKNIK: Collapse Hierarchy
        // Mengganti Chain of Responsibility yang rumit dengan logika prosedural yang jelas.
        
        // 1. Cek kondisi Deuce
        if (isDeuce()) {
            return "Deuce";
        }

        // 2. Cek kondisi Menang (Win)
        if (serverHasWon()) {
            return "Win for " + serverName;
        }
        if (receiverHasWon()) {
            return "Win for " + receiverName;
        }

        // 3. Cek kondisi Advantage
        if (serverHasAdvantage()) {
            return "Advantage " + serverName;
        }
        if (receiverHasAdvantage()) {
            return "Advantage " + receiverName;
        }

        // 4. Jika belum selesai, tampilkan skor biasa
        return getRegularScore();
    }

    // --- Helper Methods (Private) ---
    // Logika ini dipindahkan dari class-class kecil yang dihapus agar terpusat di sini.

    private boolean isDeuce() {
        return serverScore >= 3 && receiverScore >= 3 && (serverScore == receiverScore);
    }

    private boolean serverHasWon() {
        return serverScore >= 4 && (serverScore - receiverScore) >= 2;
    }

    private boolean receiverHasWon() {
        return receiverScore >= 4 && (receiverScore - serverScore) >= 2;
    }

    private boolean serverHasAdvantage() {
        return serverScore >= 4 && (serverScore - receiverScore) == 1;
    }

    private boolean receiverHasAdvantage() {
        return receiverScore >= 4 && (receiverScore - serverScore) == 1;
    }

    private String getRegularScore() {
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        
        // Menangani skor seri sebelum Deuce (Love-All, Fifteen-All, Thirty-All)
        if (serverScore == receiverScore) {
            return scores[serverScore] + "-All";
        }
        
        return scores[serverScore] + "-" + scores[receiverScore];
    }
}