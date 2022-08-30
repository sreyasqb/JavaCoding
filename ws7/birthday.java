import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class WrongMonthException extends Exception {
    public WrongMonthException(String s){
        super(s);
    }
}
class WrongDayException extends Exception {
    public WrongDayException(String s){
        super(s);
    }
}

public class BirthDay {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        System.out.print("Enter the birthday : ");
        String bday=kb.next();
        try {
            int day = Integer.parseInt(bday.substring(0, 2));
            int month = Integer.parseInt(bday.substring(2, 4));
            int year = Integer.parseInt(bday.substring(4, 8));
            List<Integer> days= Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31);
            try{
                if (!(month<=12 && month>0)){
                    throw new WrongMonthException("Invalid month entry");
                }
                if (!(day>0 && day<=days.get(month-1))){
                    throw new WrongDayException("Day cannot be this value");
                }
                System.out.println("Month of birth : "+month+"\nDay of birth : "+day+"\nYear of birth : "+year);
            }
            catch(WrongMonthException e){
                System.out.println(e);
            }
            catch(WrongDayException e){
                System.out.println(e);
            }
        }catch(Exception e){
            System.out.println("Invalid input");
        }



    }
}
