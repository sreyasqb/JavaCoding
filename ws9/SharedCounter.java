import java.util.*;

class Incrementer extends Thread {
    public static int shared;
    
    static public void initShared()
    {
        shared = 0;
    }
    
    static public void display()
    {
        System.out.println("Shared: " + shared);
    }
    
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            shared++;
        }
    }
}

public class SharedCounter {
    public static void main(String[] args)
    {
        ArrayList<Incrementer> arr = new ArrayList<Incrementer>();
        Incrementer.initShared();

        for(int i = 0; i < 10; i++)
        {
            arr.add(new Incrementer());
            arr.get(i).start();
        }
        
        for(int i = 0; i < 10; i++)
        {
            try
            {
                arr.get(i).join();
                Incrementer.display();
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        
        Incrementer.display();
    }
}
