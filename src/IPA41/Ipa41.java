package IPA41;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class BankAccount{
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
public class Ipa41 {
    public static double withdraw(BankAccount[] bankAccounts, int accNumber, double amount){
        Optional<BankAccount> acc = Arrays.stream(bankAccounts)
                .filter(bankAccount -> bankAccount.getAccountNumber() == accNumber)
                .findFirst();
        if (acc.isPresent()) {
            double bal=acc.get().getBalance();
            if(bal<amount){
                return -1;
            }
            else {
                double newBal=bal-amount;
                acc.get().setBalance(newBal);
                return newBal;
            }
        }
        return -2;
    }
    public static double deposit(BankAccount[] bankAccounts, int accNumber, double amount){
        Optional<BankAccount> acc = Arrays.stream(bankAccounts)
                .filter(bankAccount -> bankAccount.getAccountNumber() == accNumber)
                .findFirst();
        if (acc.isPresent()) {
            double bal=acc.get().getBalance();
                double newBal=bal+amount;
                acc.get().setBalance(newBal);
                return newBal;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankAccount []bankAccounts=new BankAccount[3];
        for(int i=0;i<3;i++){
            bankAccounts[i]=new BankAccount(Integer.parseInt(sc.nextLine()),sc.nextLine(),Double.parseDouble(sc.nextLine()));
        }
        int acc1=Integer.valueOf(sc.nextLine());
        double amount1=Double.valueOf(sc.nextLine());
        int acc2=Integer.valueOf(sc.nextLine());
        double amount2=Double.valueOf(sc.nextLine());
        double withdraw = withdraw(bankAccounts, acc1, amount1);
        if (withdraw==-2){
            System.out.println("Sorry - Account not found");
        } else if (withdraw==-1) {
            System.out.println("Sorry - Insufficient balance");
        }
        else {
            System.out.println(withdraw);
        }
        double deposit = deposit(bankAccounts, acc2, amount2);
        if (deposit==-1){
            System.out.println("Sorry - Account not found");
        }
        else {
            System.out.println(deposit);
        }
    }
}
