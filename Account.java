/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws2;

/**
 *
 * @author 20pt33
 */
public class Account {
    double initBal;
    String owner;
    String accNo;
    Account(double initBal,String owner,String number){
        this.initBal=initBal;
        this.owner=owner;
        this.accNo=number;
    }
    Account(double initBal,String owner){
        this.initBal=initBal;
        this.owner=owner;
        accNo=String.valueOf((int) Math.random()*1000);   
    }
    Account(String owner){
        initBal=0;
        accNo=String.valueOf((int) Math.random()*1000);
        this.owner=owner;
    }
    public static void main(String args[]){
        Account a=new Account("SUSA");
        System.out.println(a.accNo);
    }
}
