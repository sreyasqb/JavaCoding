/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 20pt35
 */
public class Order {
    List<OrderItem> orders=new ArrayList<OrderItem>();
    void addOrderedItem(OrderItem od){
        orders.add(od);
    }
    int getTotal(){
        int cost=0;
        for (OrderItem od:orders){
            cost+=od.getCost();
        }
        return cost;
    }
    void printOrderedItems(){
        for (OrderItem od:orders){
            od.printItem();
            System.out.println("");
        }
    }
}
