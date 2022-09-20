import java.util.*; 

class MultiThread extends Thread {
    public int start;
    public int end;
    public int num;
    public int count;
    
    public MultiThread(int s, int e)
    {
        start = s;
        end = e;
        num = -1;
        count = 0;
    }
    public MultiThread(int s, int e, int n, int c)
    {
        start = s;
        end = e;
        num = n;
        count = c;
    }
    
    public void run()
    {
//        System.out.println(
//                "Thread " + Thread.currentThread().getId()
//                + " is running");
        for(int i = start; i <= end; i++)
        {
            int divCount = divisorCount(i);
            if(divCount > count)
            {
                count = divCount;
                num = i;
            }
        }
        System.out.println(start + "\nnum = " + num + "\ncount = " + count + "\n");
    }
    
    public int divisorCount(int n)
    {
        int count = 0;
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                count++;
            }
        }
        
        return count;
    }
    
    public MultiThread merge(MultiThread t)
    {
        int n, c;
        if(count > t.count)
        {
            n = num;
            c = count;
        }
        else
        {
            n = t.num;
            c = t.count;
        }
        MultiThread merged = new MultiThread(start, t.end, n, c);
        
        return merged;
    }
}

public class Q1 {
    public static void main(String[] args)
    {
        int n = 1000;
        Stack<MultiThread> threads = new Stack<MultiThread>();
        MultiThread t;
        
        for(int i = 1; i < n; i += 100)
        {
            t = new MultiThread(i, i + 99);
            t.start();            
            threads.push(t);
        }
                
        while(threads.size() >= 2)
        {
            MultiThread t1 = threads.pop();
            MultiThread t2 = threads.pop();
            try
            {
                t1.join();
                t2.join();
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
            
            threads.push(t1.merge(t2));
        }
        
        System.out.println("The number with highest number of divisors is: " 
                + threads.peek().num + " with " + threads.peek().count 
                + " divisors\n");
        
//        int divCount = 0;
//        int count = 0;
//        int num = -1;
//        for(int i = 1; i <= 1000; i++)
//        {
//            divCount = 0;
//            for(int j = 1; j <= i; j++)
//            {
//                if(i % j == 0)
//                {
//                    divCount++;
//                }
//            }
//            if(divCount > count)
//            {
//                count = divCount;
//                num = i;
//            }
//        }
//        System.out.println("The number with highest number of divisors is: " 
//                + num + " with " + count 
//                + " divisors\n");
    }
}

