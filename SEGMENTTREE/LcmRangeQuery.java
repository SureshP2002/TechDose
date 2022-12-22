//LCM
//TC-O(logN)-> lcm and update
//TC-O(n)->build


package lcmquery;
import java.util.*;

public class LCMQuery {
   static int segmentArray[];
   public static int Lcm(int a,int b)
   {
       return (a*b)/Gcd(a,b);
   }
   public static int Gcd(int a,int b)
     {
         return a==0?b:Gcd(b%a,a);
     }
    public static int buildSt(int SI,int arr[],int sl,int sr)
    {
        if(sl==sr)return segmentArray[SI]=arr[sl];
        int mid=sl+(sr-sl)/2;
        int leftlcm=buildSt(2*SI+1,arr,sl,mid);
        int rightlcm=buildSt(2*SI+2,arr,mid+1,sr);
        segmentArray[SI]=Lcm(leftlcm,rightlcm);
        return segmentArray[SI];
    }
    public static int lcmRange(int SI,int sl,int sr,int left,int right)
    {
        if(right<sl||left>sr)return 1;//return 1 because least common multiple is upto 1;
        if(left<=sl&&sr<=right)return segmentArray[SI];
        int mid=sl+(sr-sl)/2;
        int leftlcm=lcmRange(2*SI+1,sl,mid,left,right);
        int rightlcm=lcmRange(2*SI+2,mid+1,sr,left,right);
        return Lcm(leftlcm,rightlcm);
    
    }
    public static int Update(int SI,int sl,int sr,int position,int val)
    {
        if(sr<position||sl>position)return segmentArray[SI];
        if(sr==sl&&sl==position)
        {
            return segmentArray[SI]=val;
        }
        int mid=sl+(sr-sl)/2;
        int leftlcm=Update(2*SI+1,sl,mid,position,val);
        int rightlcm=Update(2*SI+2,mid+1,sr,position,val);
        return segmentArray[SI]=Lcm(leftlcm,rightlcm);
        
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
        //fiding lcm between the range;
        System.out.println("lcm between the range (2,5):"+ lcmRange(0,0,n-1,2,5));
        System.out.println("lcm between the range (5,10):"+ lcmRange(0,0,n-1,5,10));
        System.out.println("lcm between the range (0,10):"+ lcmRange(0,0,n-1,0,10));
        //updatingSt
        Update(0,0,n-1,7,Integer.MAX_VALUE);
        System.out.println("lcm between the range (2,5):"+ lcmRange(0,0,n-1,2,5));
        System.out.println("lcm between the range (5,10):"+ lcmRange(0,0,n-1,5,10));
        System.out.println("lcm between the range (0,10):"+ lcmRange(0,0,n-1,0,10));
    }
    
}
