/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws4;

import java.util.Date;

/**
 *
 * @author 20pt33
 */
abstract class Book {
    String title;
    int dayTaken;
    abstract int daysOverdue(int d);
    abstract boolean isOverdue(int d);
    abstract double computeFine(int d);
}
class RegularBook extends Book {
    String title;
    String author;
    int dayTaken;
    RegularBook(String title,String author,int dayTaken){
        this.title=title;
        this.author=author;
        this.dayTaken=dayTaken;
    }
    int daysOverdue(int d){
        return d-(dayTaken+2);
    }
    boolean isOverdue(int d){
        if (daysOverdue(d)<0)
            return false;
        return true;
    }
    double computeFine(int d){
        double days=daysOverdue(d);
        return days<0?0:days*1;
    }
}

class RefBook extends Book {
    String title;
    int dayTaken;
    RefBook(String title,int dayTaken){
        this.title=title;
        this.dayTaken=dayTaken;
        
    }
    int daysOverdue(int d){
        return d-(dayTaken+14);
    }
    boolean isOverdue(int d){
        if (daysOverdue(d)<0)
            return false;
        return true;
    }
    double computeFine(int d){
        double days=daysOverdue(d);
        return days<0?0:days*1;
    }
}

class AudioBook extends Book {
    String title;
    String author;
    int dayTaken;
    AudioBook(String title,String author,int dayTaken){
        this.title=title;
        this.author=author;
        this.dayTaken=dayTaken;
    }
    int daysOverdue(int d){
        return d-(dayTaken+14);
    }
    boolean isOverdue(int d){
        if (daysOverdue(d)<0)
            return false;
        return true;
    }
    double computeFine(int d){
        double days=daysOverdue(d);
        return days<0?0:days*2;
    }
}
