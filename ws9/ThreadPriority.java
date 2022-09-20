import java.lang.*;

class PrioThread extends Thread {
    public void run()
    {
        try
        {
            if(getId() == 12 || getId() == 13)
            {
                System.out.println("Sleeping...");
                sleep(1000);
            }
            for(int i = 0; i < 5; i++)
            {
                System.out.println(getId() + " - " + currentThread().getPriority());
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

public class ThreadPriority {
    public static void main(String[] args)
    {
        PrioThread p1 = new PrioThread();
        PrioThread p2 = new PrioThread();
        PrioThread p3 = new PrioThread();
        PrioThread p4 = new PrioThread();
        
        p1.setPriority(1);
        p2.setPriority(2);
        p3.setPriority(3);
        p4.setPriority(4);
        
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        
        try
        {
//            System.out.println("Thread 3 and 4 start sleeping");
//            p3.sleep(1000);
//            p4.sleep(1000);
//            System.out.println("Thread 3 and 4 are awake");
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        }catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }        
    }
}
