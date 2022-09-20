public class TicketSeller extends Thread {
    static boolean lock;
    static int ticketsLeft;
    static boolean more;
    
    static void setTicketsLeft(int n)
    {
        lock = false;
        ticketsLeft = n;
        if(n > 0)
        {
            more = true;
        }
        else
        {
            more = false;
        }
    }
    
    static boolean moreLeft()
    {
        return more;
    }
    
    void set()
    {
        lock = true;
    }
    
    void free()
    {
        lock = false;
    }
    
    public void run()
    {
        if(!more)
        {
            System.out.println("No more tickets left :(");
            return;
        }
        while(lock)
        {
            System.out.println("Waiting...");
        }
        set();
        if(ticketsLeft > 0)
        {
            ticketsLeft--;
            System.out.println(ticketsLeft + " tickets remaining");
        }
        else
        {
            more = false;
            System.out.println("No more tickets left!");
        }
        free();
    }
}

class SellTickets
{
    public static void main(String[] args)
    {
        TicketSeller.setTicketsLeft(100);
        TicketSeller t1 = new TicketSeller();
        TicketSeller t2 = new TicketSeller();
        TicketSeller t3 = new TicketSeller();
        
            
        while(TicketSeller.moreLeft())
        {
            System.out.println("***");
            t1.start();
            t2.start();
            t3.start();
            try
            {
                t1.join();
                t2.join();
                t3.join();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
