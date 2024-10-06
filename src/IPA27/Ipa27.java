package IPA27;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Sim2{
    private int id;
    private String company;
    private int balance;
    private double ratePerSecond;
    private String circle;

    public Sim2(int id, String company, int balance, double ratePerSecond, String circle) {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    @Override
    public String toString() {
        return "Sim2{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", balance=" + balance +
                ", ratePerSecond=" + ratePerSecond +
                ", circle='" + circle + '\'' +
                '}';
    }
}
public class Ipa27 {

    public static Sim2[] matchAndSort(Sim2[] sim2s, String search_circle, double search_rate){
        Sim2[] sortedByCond = Arrays.stream(sim2s)
                .filter(sim2 -> sim2.getCircle().equalsIgnoreCase(search_circle) && sim2.getRatePerSecond() < search_rate)
                .sorted(Comparator.comparing(Sim2::getBalance).reversed()).toArray(Sim2[]::new);
        return sortedByCond;

    }
    public static void main(String[] args) {
        Sim2[] sim2s=new Sim2[4];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<4;i++){
            int a=sc.nextInt();
            String b=sc.next();
            int c=sc.nextInt();
            double d=sc.nextDouble();
            String e= sc.next();
            Sim2 sim2=new Sim2(a,b,c,d,e);
            sim2s[i]=sim2;
        }
        String search_circle=sc.next();
        double search_rate=sc.nextDouble();
        Arrays.stream(sim2s).forEach(System.out::println);
        Sim2[] sim2s1 = matchAndSort(sim2s, search_circle, search_rate);
        Arrays.stream(sim2s1).forEach(sim2 -> {
            System.out.println(sim2.getId());
        });

    }
}
