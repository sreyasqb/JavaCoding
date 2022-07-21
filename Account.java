/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author 20pt33
 */
public class Account {
    double bal;
    String owner;
    String accNo;
    static int numAccounts;
    Account(double initBal,String owner,String number){
        this.bal=initBal;
        this.owner=owner;
        this.accNo=number;
        numAccounts+=1;
    }
    Account(double initBal,String owner){
        this.bal=initBal;
        this.owner=owner;
        numAccounts+=1;
        accNo=String.valueOf((int) Math.round(Math.random()*1000));   
    }
    Account(String owner){
        bal=0;
        accNo=String.valueOf((int) Math.round(Math.random()*1000));
        this.owner=owner;
        numAccounts+=1;
    }
    public void deposit(double value){
        bal+=value;
    }
    public void withdraw(double value){
        if (bal-value>0)
            bal-=value;
        else
            System.out.println("Not enough balance");
    }
    public void getDeets(){
        System.out.println("Owner : "+owner);
        System.out.println("AccNo : "+accNo);
        System.out.println("Balance : "+bal);
    }
    public static int getNumAccounts(){
        return numAccounts;
    }
    public static void main(String args[]){
        Account a=new Account("SUSA");
        Account b=new Account("BSA");
        System.out.println(a.accNo);
        a.deposit(100);
        a.getDeets();
        a.withdraw(50);
        a.getDeets();
        System.out.println(Account.getNumAccounts());
    }
    
}
