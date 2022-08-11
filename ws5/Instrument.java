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
interface Instrument{
    void play();
    String what();
    void adjust();
}

class Wind implements Instrument{
    public void play(){
        System.out.println("WINDDYY");
    }
    public String what(){
        return "WINDWHAT";
    }
    public void adjust(){
        System.out.println("wind adjust");
    }
}
class Percussion implements Instrument{
    public void play(){
        System.out.println("Percussion");
    }
    public String what(){
        return "PercussionWHAT";
    }
    public void adjust(){
        System.out.println("Percussion adjust");
    }
}
class Stringed implements Instrument{
    public void play(){
        System.out.println("Stringed");
    }
    public String what(){
        return "StringedWHAT";
    }
    public void adjust(){
        System.out.println("Stringed adjust");
    }
}
class WoodWind extends Wind{
    public void play(){
        System.out.println("WoodWInd");
    }
    public String what(){
        return "WoodWindWHat";
    }
    
}
class Brass extends Wind{
    public void play(){
        System.out.println("BrassWInd");
    }
    public String what(){
        return "BrassWHat";
    }
    
}


