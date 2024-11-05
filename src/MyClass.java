import java.util.*;

class Player {
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    public Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getRuns() {
        return this.runs;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    public String getMatchType() {
        return this.matchType;
    }
}

public class MyClass {

    public static int findPlayerWithLowestRuns(Player[] players, String playerType) {
        int minRuns = Integer.MAX_VALUE;

        for (Player player : players) {
            if (player.getPlayerType().equalsIgnoreCase(playerType)) {
                minRuns = Math.min(minRuns, player.getRuns());
            }
        }

        return minRuns == Integer.MAX_VALUE ? -1 : minRuns;
    }

    public static Player[] findPlayerByMatchType(Player[] players, String matchType) {
        return Arrays.stream(players)
                .filter(player -> player.getMatchType().equalsIgnoreCase(matchType))
                .sorted(Comparator.comparing(Player::getPlayerId).reversed())
                .toArray(Player[]::new);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];

        for (int i = 0; i < 4; i++) {
            int playerId = Integer.parseInt(sc.nextLine());
            String playerName = sc.nextLine();
            int runs = Integer.parseInt(sc.nextLine());
            String playerType = sc.nextLine();
            String matchType = sc.nextLine();

            players[i] = new Player(playerId, playerName, runs, playerType, matchType);
        }

        String playerTypeToSearch = sc.nextLine();
        String matchTypeToSearch = sc.nextLine();

        int lowestRuns = findPlayerWithLowestRuns(players, playerTypeToSearch);
        if (lowestRuns != -1) {
            System.out.println(lowestRuns);
        } else {
            System.out.println("No such player");
        }

        Player[] playersByMatchType = findPlayerByMatchType(players, matchTypeToSearch);
        if (playersByMatchType.length > 0) {
            Arrays.stream(playersByMatchType).forEach(player -> System.out.println(player.getPlayerId()));
        } else {
            System.out.println("No Player with given matchType");
        }

        sc.close();
    }
}
