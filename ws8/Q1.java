package GenericClasses;

import java.util.*;

class QueueEmpty extends Exception {
    public QueueEmpty(String s)
    {
        super(s);
    }
}

public class PriorityQueueMain
{
    PriorityQueue<Integer> keys;
    Dictionary values;
   
    public PriorityQueueMain()
    {
        keys = new PriorityQueue<Integer>();
        values = new Hashtable();
    }
   
    void insert(int x, String s)
    {
        keys.add(x);
        values.put(x, s);
    }
   
    String next()
    {
        if(keys.peek() != null)
        {
            return (String)values.get(keys.poll());
        }
        else
        {
            try
            {
                throw new QueueEmpty("The queue is empty!");
            }
            catch(QueueEmpty e)
            {
                System.out.println(e.getMessage());
                return "";
            }
        }
    }
}

class Execute
{
    public static void main(String[] args)
    {
        PriorityQueueMain pq = new PriorityQueueMain();
        pq.insert(4, "Four");
        pq.insert(7, "Seven");
        pq.insert(2, "Two");
        pq.insert(8, "Eight");
        pq.insert(9, "Nine");
        System.out.println(pq.next());
        System.out.println(pq.next());
        System.out.println(pq.next());
    }
}
