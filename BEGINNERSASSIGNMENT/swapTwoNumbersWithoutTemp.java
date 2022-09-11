package BEGINNERSASSIGNMENT;
import java.util.*;

public class swapTwoNumbersWithoutTemp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        a=a^b;//xor a with b;
        b=a^b;// xor a with b;
        a=a^b;//xor a with b;
        System.out.print(a+" "+b);
    }
    
}
