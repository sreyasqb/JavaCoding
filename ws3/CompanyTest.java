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
 * @author 20PT33
 */
public class CompanyTest {
    public static void main(String[] args){
        Company company=new Company(20);
        
        for (int i=0;i<3;i++){
            Clerk clerk=new Clerk(20+i,200*i+10,i);
            company.addClerk(clerk);
        }
        for (int i=0;i<10;i++){
            Director director=new Director(20+i,200*i+10,i*2.5);
            company.addDirector(director);
        }
        company.printCompany();
//        Employee e=new Employee(5,10);
//        e.display();
        System.out.println(company.employees.size());
    }
}
class Employee{
    int age;
    int salary;
    Employee(int age,int salary){
        this.age=age;
        this.salary=salary;
    }
    void increaseSalary(double rate){
        salary=(int)(salary+salary*rate);
    }
    boolean checkRetirement(){
        return age>65?true:false;
    }
    void paySalary(){
        System.out.println("salary : "+salary);
    }
    void display(){
        System.out.println("age : "+age+" salary : "+salary);
    }
    
}
class Clerk extends Employee{
    int illDays;
    Clerk(int age,int salary,int illDays){
        super(age,salary);
        this.illDays=illDays;
    }
    void addIllDays(){
        illDays+=1;
    }
    int getIllDays(){
        return illDays;
    }
    void display(){
        super.display();
        System.out.println("illDays : "+illDays);
        
    }
}
class Director extends Employee{
    double gratification;
    Director(int age,int salary,double gratification){
        super(age,salary);
        this.gratification=gratification;     
    }
    void payGratification(){
        System.out.println("gratification : "+gratification);
    }
    void display(){
        super.display();
        System.out.println("gratification : "+gratification);
    }
}
class Company {
    int numberOfEmployees;
    int profit;
    int maxSize;
    List<Employee> employees;
    Company(int maxSize){
        this.maxSize=maxSize;
        employees=new ArrayList<Employee>();
    }
    void addClerk(Clerk c){
        
        if (employees.size()<maxSize){
            employees.add(c);
            System.out.println("added clerk");
        }
    }
    void addDirector(Director d){
        if (employees.size()<maxSize){
            employees.add(d);
            System.out.println("added director");
        }
    }
    void printCompany(){
        employees.forEach((e)->e.display());
    }
}
