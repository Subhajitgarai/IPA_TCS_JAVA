package IPA29;

import java.util.Scanner;

class Account{
    private int id;
    private double balance;
    private double interestRate;

    public Account(int id, double balance, double interestRate) {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }
}

public class Ipa29 {
    public static double getInterest(Account account, int noOfYears){
        double percentage= (account.getInterestRate()*100) /noOfYears;
        double totalInterest=percentage+account.getInterestRate();
        return totalInterest;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        double bal=sc.nextDouble();
        Double rate=sc.nextDouble();
        Account account=new Account(id,bal,rate);
        double interest = getInterest(account, 1);
        System.out.printf("%.3f",interest);
    }
}
