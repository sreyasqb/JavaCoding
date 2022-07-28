/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author 20pt35
 */
public class OrderItem {
    String upc;
    int quantity;
    int price;
    OrderItem(String upc,int quantity,int price){
        this.upc=upc;
        this.quantity=quantity;
        this.price=price;
    }
    int getCost(){
        return price*quantity;
    }
    void printItem(){
        System.out.println("upc : "+upc);
        System.out.println("quantity : "+quantity);
        System.out.println("price : "+price*quantity);
    }
}
