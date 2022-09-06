import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
    public static void main(String[] args){

        List<String> l=new ArrayList<String>();
        l.add("Geeks For Geeks");
        l.add("Friends");
        l.add("Dear");
        l.add("Is");
        l.add("Superb");
        Collections.sort(l);
        Collections.shuffle(l);



        Box<String> b1=new Box<String>();
        b1.putItem("hello");
        String p=b1.getItem();
        System.out.println(p);
    }
}
