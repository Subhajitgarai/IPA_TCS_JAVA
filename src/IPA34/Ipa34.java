package IPA34;

import java.util.Arrays;
import java.util.Scanner;

class Player3{
    private int id;
    private String name;
    private String country;
    private int matchesPlayed;
    private int runsScored;

    public Player3(int id, String name, String country, int matchesPlayed, int runsScored) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        return "Player3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", runsScored=" + runsScored +
                '}';
    }
}


public class Ipa34 {

    public  static Player3[] findPlayerName(Player3[] player3s, String country, int run){
        Player3[] players = Arrays.stream(player3s).filter(player3 -> player3.getRunsScored() > run && player3.getCountry().equalsIgnoreCase(country))
                .toArray(Player3[]::new);
        return players;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Player3[] player3s=new Player3[n];
        for (int i=0;i<n;i++){
            int a=sc.nextInt();
            String b=sc.next();
            String c=sc.next();
            int d=sc.nextInt();
            int e=sc.nextInt();
            Player3 player3=new Player3(a,b,c,d,e);
            player3s[i]=player3;
        }
        String country=sc.next();
        int run=sc.nextInt();
        Player3[] playerName = findPlayerName(player3s, country, run);
        if (playerName.length>0){
            Arrays.stream(playerName).forEach(player3 -> {
                System.out.println(player3.getId()+" : "+player3.getName()+" : "+player3.getRunsScored());
            });
        }
        else {
            System.out.println("No Player found");
        }



    }
}
