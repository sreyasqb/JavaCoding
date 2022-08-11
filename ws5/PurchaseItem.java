/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws4;

/**
 *
 * @author 20pt33
 */
class PurchaseItem {
    private String name;
    private double unitPrice;
    PurchaseItem(String n,double p){
        name=n;
        unitPrice=p;
    }
    double getPrice(){
        return unitPrice;
    }
    String getName(){
        return name;
    }
    void setPrice(double p){
        unitPrice=p;
    }
    void setName(String s){
        name=s;
    }
    @Override
    public String toString(){
        return name+"@"+unitPrice;
    }
    
}
class WeighedItem extends PurchaseItem{
    private double weight;
    WeighedItem(String n,double p,double w){
        super(n,p);
        weight=w;
    }
    @Override
    double getPrice(){
        return super.getPrice()*weight;
    }
    @Override
    public String toString(){
        return super.toString()+ " "+weight+"Kg "+getPrice();
    }
}
class CountedItem extends PurchaseItem{
    private int quantity;
    CountedItem(String n,double p,int q){
        super(n,p);
        quantity=q;
    }
    @Override
    double getPrice(){
        return super.getPrice()*quantity;
    }
    @Override
    public String toString(){
        return super.toString()+ " "+quantity+" units "+getPrice();
    }
}
