import java.util.*;

public class IsSetBit {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int position=sc.nextInt();
        if(position==0)
        {
            System.out.println("INVALID POSITION");

        }
        else if((n&(1<<position-1))>0)
        {
            System.out.print("YES");
        }
        else
        {
            System.out.print("NO");
        }
    }
    
}
