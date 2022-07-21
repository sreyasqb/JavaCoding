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
public class Triangle {
    double x,y,z;
    double area;
    String color;
    Triangle(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
        area=0;
        color="red";
    }
    void setColor(String c){
        color=c;
    }
    double findArea(){
        double s=(x+y+z)/2;
        area=Math.sqrt(s*(s-x)*(s-y)*(s-z));
        return area;
    }
    boolean isTriangle(){
        if (x+y>z)
            return true;
        return false;
    }
    boolean isRight(){
        if (x*x+y*y==z*z)
            return true;
        return false;
    }
    boolean isIsosceles(){
        if ((x==y || y==z || x==z) &&  (x+y>z))
            return true;
        return false;
    }
    boolean isScalene(){
        if (x!=y && y!=z && z!=x && x+y>z)
            return true;
        return false;
    }
    boolean isEquilateral(){
        if ((x==y && y==z && x==z) &&  (x+y>z))
            return true;
        return false;
    }
    public static void main(String[] args){
        Triangle t=new Triangle(3,4,5);
        System.out.println(t.isRight());
        System.out.println(t.isIsosceles());
        System.out.println(t.findArea());
        System.out.println(t.isTriangle());
        System.out.println(t.isScalene());
        System.out.println(t.isEquilateral());
    }
}
