public class Car {
    double fEff;
    double fuel;
    Car(double fEff){
        this.fEff=fEff;
        fuel=0;
    }
    public void tank(double value){
        fuel=value;
    }
    public void drive(double dist){
        fuel-=dist/fEff;
    }
    public double getFuelLevel(){
        return fuel;
    }
    public static void main(String argv[]){
        Car c = new Car(29);
        c.tank(20);
        c.drive(100);
        System.out.println(c.getFuelLevel());
    }
}
