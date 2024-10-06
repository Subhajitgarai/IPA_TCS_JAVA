package IPA28;

import javax.swing.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class Team{
    private int tId;
    private String tName;
    private String tCountry;
    private int tRun;

    public Team(int tId, String tName, String tCountry, int tRun) {
        this.tId = tId;
        this.tName = tName;
        this.tCountry = tCountry;
        this.tRun = tRun;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettCountry() {
        return tCountry;
    }

    public void settCountry(String tCountry) {
        this.tCountry = tCountry;
    }

    public int gettRun() {
        return tRun;
    }

    public void settRun(int tRun) {
        this.tRun = tRun;
    }

    @Override
    public String toString() {
        return "Team{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", tCountry='" + tCountry + '\'' +
                ", tRun=" + tRun +
                '}';
    }
}
public class Ipa28 {
    public static Team findPlayer(Team[] teams, int run, String country){
        Optional<Team> firstTeam = Arrays.stream(teams).filter(team -> team.gettCountry().equalsIgnoreCase(country) && team.gettRun() > run)
                .findFirst();
        if (firstTeam.isPresent()){
            return firstTeam.get();
        }
        return null;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Team[] teams=new Team[3];
        for (int i=0;i<3;i++){
            int a=sc.nextInt();
            String b=sc.next();
            String c=sc.next();
            int d=sc.nextInt();
            Team team=new Team(a,b,c,d);
            teams[i]=team;
        }
        int run=sc.nextInt();
        String country=sc.next();
        Arrays.stream(teams).forEach(System.out::println);
        Team player = findPlayer(teams, run, country);
        if (player!=null){
            System.out.println("---Player----");
            System.out.println(player);
        }
        else {
            System.out.println("No team is found from the given country and run");
        }

    }
}
