import java.util.*;

public class SetIthBit {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int position=sc.nextInt();//getting position;
        System.out.println(n|(1<<position-1));//taking bitwise OR with N and 1 rightshifted by position -1times
    }
    
}
