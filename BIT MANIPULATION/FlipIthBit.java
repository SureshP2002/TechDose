import java.util.*;

public class FlipIthBit {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int position=sc.nextInt();//getting position
        System.out.println(n^(1<<position-1));

    }
    
}
