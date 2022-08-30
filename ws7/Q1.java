import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Q1 {
    public static void main(String[] args)
    {
        Scanner jin = new Scanner(System.in);    
        String choice = "yes";
       
        System.out.println("Do you want to calculate a sum?(yes/no)");
        choice = jin.nextLine();
       
        while(choice.equalsIgnoreCase("yes"))
        {
            ArrayList<Integer> array = new ArrayList<Integer>();
            int sum = 0;
            int input = -1;
           
            while(input != 0)
            {
                System.out.println("Enter an integer: ");
                try{
                    input = Integer.parseInt(jin.nextLine());
                    try{
                        array.add(input);
                    }catch(InputMismatchException e2){
                        System.out.println(e2);
                        return;
                    }
                }catch(NumberFormatException e){
                    System.out.println(e);
                    return;
                }
            }
           
            for(int i = 0; i < array.size(); i++)
            {
                sum += array.get(i);
            }
           
            System.out.println("The sum is " + sum);
           
            System.out.println("\nDo you want to calculate another sum?(yes/no)");
            choice = jin.nextLine();
        }
        System.out.println("Choice: " + choice);
    }
}

