import java.util.*;
import java.lang.*;

class MultiThread2 extends Thread {
    public int start;
    public int end;
    public int max;
    static ArrayList<Integer> arr;
    
    static public void setArr(ArrayList<Integer> a)
    {
        arr = a;
    }
    
    public MultiThread2(int s, int e)
    {
        start = s;
        end = e;
        max = -1;
    }
    public MultiThread2(int s, int e, int n)
    {
        start = s;
        end = e;
        max = n;
    }
    
    public void run()
    {
        for(int i = start; i <= end; i++)
        {
            if(arr.get(i) > max)
            {
                max = arr.get(i);
            }
        }
        // System.out.println(start + "-" + end + ": " + max);
    }
    
    public MultiThread2 merge(MultiThread2 t)
    {
        int n;
        if(max > t.max)
        {
            n = max;
        }
        else
        {
            n = t.max;
        }
        MultiThread2 merged = new MultiThread2(start, t.end, n);
        
        return merged;
    }
}

public class MaxValue {
    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(54, 62, 3, 100, 64, 86));
        MultiThread2.setArr(arr);
        
        MultiThread2 t1 = new MultiThread2(0, (int)Math.floor(arr.size() / 4));
        t1.start();
        MultiThread2 t2 = new MultiThread2((int)Math.ceil(arr.size() / 4), (int)Math.floor(arr.size() / 2));
        t2.start();
        MultiThread2 t3 = new MultiThread2((int)Math.ceil(arr.size() / 2), (int)Math.floor(arr.size() * 3 / 4));
        t3.start();
        MultiThread2 t4 = new MultiThread2((int)Math.ceil(arr.size() * 3 / 4), arr.size() - 1);
        t4.start();
        
        try
        {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch(InterruptedException ie)
        {
            ie.printStackTrace();
        }
        
        MultiThread2 t = t1.merge(t2).merge(t3.merge(t4));
        System.out.println("The maximum value in the array is: " + t.max);
    }
}
