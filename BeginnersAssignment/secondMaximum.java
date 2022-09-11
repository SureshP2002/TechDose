package BeginnersAssignment;
import java.util.*;

public class secondMaximum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int firstMax=Integer.MIN_VALUE;//keeping the firstMAximum to intgerMinimum value;
        int SecondMax=Integer.MIN_VALUE;//keeping the secondmax to integerMinimum value;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>firstMax)//checking if the current elemnt is greater that firstmax;
            {
                
                SecondMax=firstMax;//updating secondMAx with firstMax;
                firstMax=arr[i];//keeping firstMax to current elemnt;
            }
            else if(arr[i]>=SecondMax&&arr[i]<firstMax)//checking if current element is greater than secondMAx and less than first max; 
            {
                SecondMax=arr[i];//updating secondMax to current element;
            }

        }
        System.out.print(SecondMax);
    }
    
}
