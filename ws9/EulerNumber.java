class SeriesSum extends Thread{
    boolean even;
    int n;
    double value;
    
    SeriesSum(boolean eve, int n)
    {
        even = eve;
        value = 0;
        this.n = n;
    }
    
    double fact(double n)
    {
        double f = 1;
        for(int i = 2; i <= n; i++)
        {
            f *= i;
        }
        
        return f;
    }
    
    public void run()
    {
        if(even)
        {
            for(int i = 0; i < n; i++)
            {
                value += 1 / fact(2 * i);
            }
        }
        else
        {
            for(int i = 0; i < n; i++)
            {
                value += 1 / fact(2 * i + 1);
            }
        }
    }
    
    double getValue()
    {
        return value;
    }
}

public class EulerNumber{
    public double e;
    
    public void computeE(int n)
    {
        SeriesSum even = new SeriesSum(true, n);
        SeriesSum odd = new SeriesSum(false, n);
        
        even.start();
        odd.start();
        
        try
        {
            even.join();
            odd.join();
        }catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }        
        e = even.getValue() + odd.getValue();
        System.out.println(e);
    }
}

class EulerMain
{
    public static void main(String[] args)
    {
        EulerNumber E = new EulerNumber();
        E.computeE(500);
    }
}
