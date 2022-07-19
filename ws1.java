/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author 20pt18
 */
public class Ws1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(q2());
//        q3();
//        q4();
//        q5();
//        q6();
//        q7();
//        q8();
//        q9();
//        q10();
//        q11();
        q12();
    }
    public static void q1(){
        Scanner inp= new Scanner(System.in);
    }
    public static double q2(){
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter your grade : ");
        String grade=kb.next();
//        System.out.println((int) grade.charAt(0));
        if (grade.charAt(0)=='F'){
            return 0;
        }
//        System.out.println(69-(int) grade.charAt(0));
        if (grade.length()>1){
            if (grade.charAt(1)=='+' && grade.charAt(0)!='A'){
                return 69-(int) grade.charAt(0)+0.3;
            }
            else if(grade.charAt(1)=='-'){
                return 69-(int) grade.charAt(0)-0.3;
            }
            else {
                return -2;
            }
        }
        else {
            return 69-(int) grade.charAt(0);
        }
        
//        System.out.println(grade.charAt(0));
    }
    public static void q3(){
        
        HashMap<Character,String> card= new HashMap<Character,String>();
        card.put('A',"Ace");
        card.put('J', "Jack");
        card.put('Q', "Queen");
        card.put('K', "King");
        card.put('D', "Diamond");
        card.put('H', "Hearts");
        card.put('S', "Spades");
        card.put('C', "Clubs");
        card.put('2', "Two");
        card.put('3', "Three");
        card.put('4', "Four");
        card.put('5', "Five");
        card.put('6', "Six");
        card.put('7', "Seven");
        card.put('8', "Eight");
        card.put('9', "Nine");
        
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter your card : ");
        String inp=kb.next();
        if (inp.length()==3){
            System.out.println("10 of "+card.get(inp.charAt(2)));
        }
        else {
            System.out.println(card.get(inp.charAt(0))+" of "+card.get(inp.charAt(1)));
        } 
    }
    public static void q4(){
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter gallons in tank : ");
        double gal= kb.nextDouble();
        System.out.print("Enter fuel efficieny (miles/gallon) : ");
        double fEff= kb.nextDouble();
        System.out.print("Enter price/gallon :" );
        double ppg= kb.nextDouble();
        System.out.println("Distance : "+(fEff*gal));
        System.out.println("Price per 100 miles :" + (100*ppg)/fEff);   
    }
    public static void q6(){
        Scanner kb=new Scanner(System.in);
        System.out.print("Enter number : ");
        String num=kb.next();
        System.out.println(Integer.parseInt(num,16));
        
    }
    public static void q7(){
        Scanner kb=new Scanner(System.in);
        System.out.print("Enter date : ");
//        String date=kb.next();
        String date="2/17/2003";
        String [] spl =date.split("/");
        System.out.println(Arrays.toString(spl));
        
    }
    public static void q8(){
        Scanner kb=new Scanner(System.in);
        System.out.print("Enter string : ");
        String str=kb.nextLine();
        String [] arr= str.split(" ");
        for (String i:arr){
            System.out.println(i+" : " +(int) i.charAt(0));
        }
    }
    public static void q9(){
        for (int i=1;i<6;i++){
            System.out.println(i + "\t"+ (i+1) + "\t"+Math.pow(i,i+1));
        }
    }
    public static void q10(){
        int [][] mat={
            {4,7,1,8},{3,8,9,5},{1,3,4,5},{8,1,5,6},{0,0,0,0}
        };
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                mat[4][j]+=mat[i][j];
            }
        }
        for (int [] arr:mat){
            System.out.println(Arrays.toString(arr));
        }
        
        
    }
    public static void q11(){
        Scanner kb= new Scanner(System.in);
        System.out.print("Enter 1st number : ");
        int lowLimit= kb.nextInt();
        System.out.print("Enter 1st number : ");
        int upLimit= kb.nextInt();
        
        for (int i=lowLimit;i<=upLimit;i++){
            int j;
            for (j=2;j<(int) Math.sqrt(i) + 1;j++){
                if (i%j==0)
                    break;       
            }
            if (j==(int) Math.sqrt(i)+1){
                System.out.println(i);
            }
        }
    }
    public static void q12(){
        HashMap <String,Integer> runners= new HashMap<String,Integer>();
        runners.put("Verstappen", 319);
        runners.put("Russel", 273);
        runners.put("Hamilton",278);
        runners.put("Leclerc",316);
        runners.put("Checo",300);
        runners.put("Sainz",315);
//        int[] a={1,2,3};
//        System.out.println(Arrays.toString(a));
//    List<Integer> timeArr= runners.values().stream().collect(Collectors.toList());
//    System.out.println(timeArr);
//    Collections.sort(timeArr);
//    System.out.println(timeArr);
       List<Integer> timeArr= new ArrayList<Integer>(runners.values());
       List<String> nameArr= new ArrayList<String>(runners.keySet());
       System.out.println(timeArr);
       int m1=0,m2=0;
       String n1="",n2="";
       for (int i=0;i<timeArr.size();i++){
           if (timeArr.get(i)>m1){
               m2=m1;
               n2=n1;
               m1=timeArr.get(i);
               n1=nameArr.get(i);
           }
           else if (timeArr.get(i)>m2){
               m2=timeArr.get(i);
               n2=nameArr.get(i);
           }
       }
       System.out.println(n1 + " : " + m1);
       System.out.println(n2 + " : " + m2);
        
    }
    
}
