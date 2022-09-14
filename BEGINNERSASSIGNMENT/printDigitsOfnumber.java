package BEGINNERSASSIGNMENT;
import java.io.ObjectInputStream.GetField;
import java.util.*;

public class printDigitsOfnumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i=0;
        int arr[]=new int[10];
        while(n>0)
        {
            arr[i++]=n%10;//adding last digit to the array;
            n/=10;
        }
        for(int j=i-1;j>=0;j--)
        {
            System.out.print(arr[j]+" ");//printing from reverse;
        }
        
    }
    
}
