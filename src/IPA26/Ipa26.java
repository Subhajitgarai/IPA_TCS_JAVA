package IPA26;

import java.util.Arrays;
import java.util.Scanner;

class Player2 {
    private int id;
    private String name;
    private int iccRank;
    private int matchesPlayed;
    private int runsScored;

    public Player2(int id, String name, int iccRank, int matchesPlayed, int runsScored) {
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIccRank() {
        return iccRank;
    }

    public void setIccRank(int iccRank) {
        this.iccRank = iccRank;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    @Override
    public String toString() {
        return "Player2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iccRank=" + iccRank +
                ", matchesPlayed=" + matchesPlayed +
                ", runsScored=" + runsScored +
                '}';
    }
}

public class Ipa26 {
    public static Double[] findAverageOfRuns(Player2[] players, int target) {
        Double[] avgRuns = Arrays.stream(players)
                .filter(player -> player.getMatchesPlayed() >= target)
                .map(player -> (double) player.getRunsScored() / (double) player.getMatchesPlayed())
                .toArray(Double[]::new);
        return avgRuns;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player2[] player = new Player2[4];
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            String b = sc.next();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            Player2 player2 = new Player2(a, b, c, d, e);
            player[i] = player2;
        }
        int target = sc.nextInt();
        Arrays.stream(player).forEach(System.out::println);
        Double[] averageOfRuns = findAverageOfRuns(player, target);
        for (int i = 0; i < averageOfRuns.length; i++) {
            if (averageOfRuns[i] >= 80 && averageOfRuns[i] <= 100) {
                System.out.println("Grade A");
            } else if (averageOfRuns[i] >= 50 && averageOfRuns[i] <= 79) {
                System.out.println("Grade B");
            } else {
                System.out.println("Grade C");
            }
        }

    }
}
