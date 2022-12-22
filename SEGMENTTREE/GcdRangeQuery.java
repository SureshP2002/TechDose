//GCD 
//TC-O(logN)->update and gcd
//TC-O(n)->build


package gcdquery;
import java.util.*;

public class GcdQuery {
     static int segmentArray[];
     public static int Gcd(int a,int b)
     {
         return a==0?b:Gcd(b%a,a);
     }
    public static int buildSt(int SI,int arr[],int sl,int sr)
    {
        if(sl==sr)return segmentArray[SI]=arr[sl];
        int mid=sl+(sr-sl)/2;
        int leftGcd=buildSt(2*SI+1,arr,sl,mid);
        int rightGcd=buildSt(2*SI+2,arr,mid+1,sr);
        return segmentArray[SI]=Gcd(leftGcd,rightGcd);
    }
    public static int GcdRange(int SI,int sl,int sr,int left,int right)
    {
        if(sr<left||sl>right)return 0;//returning 0 when index sl and sr not lies int the given range
        if(left<=sl&&sr<=right)return segmentArray[SI];
        int mid=sl+(sr-sl)/2;
        int leftgcd=GcdRange(2*SI+1,sl,mid,left,right);
        int rightgcd=GcdRange(2*SI+2,mid+1,sr,left,right);
        return Gcd(leftgcd,rightgcd);
    
    }
    public static int Update(int SI,int sl,int sr,int position,int val)
    {
        if(sr<position||sl>position)return segmentArray[SI];
        if(sr==sl&&sl==position)
        {
            return segmentArray[SI]=val;
        }
        int mid=sl+(sr-sl)/2;
        int leftGcd=Update(2*SI+1,sl,mid,position,val);
        int rightGcd=Update(2*SI+2,mid+1,sr,position,val);
        return segmentArray[SI]=Gcd(leftGcd,rightGcd);
        
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int heigth=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<heigth)-1;
        segmentArray=new int[size];
        //buildST
        buildSt(0,arr,0,n-1);
        //fiding Gcd between the range;
        System.out.println("Gcd between the range (1,3):"+ GcdRange(0,0,n-1,1,3));
        System.out.println("Gcd between the range (2,4):"+ GcdRange(0,0,n-1,2,4));
        System.out.println("Gcd between the range (0,2):"+ GcdRange(0,0,n-1,0,2));
        //updatingSt
        Update(0,0,n-1,1,30);
        System.out.println("Gcd between the range (1,3):"+ GcdRange(0,0,n-1,1,3));
        System.out.println("Gcd between the range (2,4):"+ GcdRange(0,0,n-1,2,4));
        System.out.println("Gcd between the range (0,2):"+ GcdRange(0,0,n-1,0,2));
    }
    
}
