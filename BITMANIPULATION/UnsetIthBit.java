import java.util.*;

public class UnsetIthBit {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int position=sc.nextInt();//gettint position;
        System.out.println(n&(~(1<<position-1)));//Bitwise AND with complemnet of 1 rightShifted by pos-1 times;
    }
    
}
