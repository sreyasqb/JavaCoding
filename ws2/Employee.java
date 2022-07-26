/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws2;

/**
 *
 * @author 20pt34
 */
public class Employee {
    String name;
    double salary;
    Employee(){
        name="anonymous";
        salary=200.00;
    }
    Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public static void main(String[] args){
        
    }
}
