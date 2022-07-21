/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

public class Account {
    double bal;
    String owner;
    String accNo;
    Account(double initBal,String owner,String number){
        this.bal=initBal;
        this.owner=owner;
        this.accNo=number;
    }
    Account(double initBal,String owner){
        this.bal=initBal;
        this.owner=owner;
        
        accNo=String.valueOf((int) Math.round(Math.random()*1000));   
    }
    Account(String owner){
        bal=0;
        accNo=String.valueOf((int) Math.round(Math.random()*1000));
        this.owner=owner;
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
    public static void main(String args[]){
        Account a=new Account("SUSA");
        System.out.println(a.accNo);
        a.deposit(100);
        a.getDeets();
        a.withdraw(50);
        a.getDeets();
    }
    
}
