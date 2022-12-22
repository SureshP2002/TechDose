//MIN RANGE QUERY
//TC-(logN)-Min and update
//TC-o(n)-building



package minrangequery;
import java.util.*;


public class MinrangeQuery {
    static int segmentArray[];
    public static int buildSt(int SI,int arr[],int sl,int sr)
    {
        if(sl==sr)return segmentArray[SI]=arr[sl];
        int mid=sl+(sr-sl)/2;
        int leftMin=buildSt(2*SI+1,arr,sl,mid);
        int rightMin=buildSt(2*SI+2,arr,mid+1,sr);
        segmentArray[SI]=Math.min(leftMin,rightMin);
        return segmentArray[SI];
    }
    public static int minRange(int SI,int sl,int sr,int left,int right)
    {
        if(right<sl||left>sr)return Integer.MAX_VALUE;
        if(left<=sl&&sr<=right)return segmentArray[SI];
        int mid=sl+(sr-sl)/2;
        int leftMin=minRange(2*SI+1,sl,mid,left,right);
        int rightMin=minRange(2*SI+2,mid+1,sr,left,right);
        return Math.min(leftMin,rightMin);
    
    }
    public static int Update(int SI,int sl,int sr,int position,int val)
    {
        if(sr<position||sl>position)return segmentArray[SI];
        if(sr==sl&&sl==position)
        {
            return segmentArray[SI]=val;
        }
        int mid=sl+(sr-sl)/2;
        int leftMin=Update(2*SI+1,sl,mid,position,val);
        int rightMin=Update(2*SI+2,mid+1,sr,position,val);
        return segmentArray[SI]=Math.min(leftMin,rightMin);
        
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
        //fiding min between the range;
        System.out.println("min between the range (0,3):"+ minRange(0,0,n-1,0,3));
        System.out.println("min between the range (1,4):"+ minRange(0,0,n-1,1,4));
        System.out.println("min between the range (3,5):"+ minRange(0,0,n-1,3,5));
        //updatingSt
        Update(0,0,n-1,2,0);
        System.out.println("min between the range (0,3):"+ minRange(0,0,n-1,0,3));
        System.out.println("min between the range (1,4):"+ minRange(0,0,n-1,1,4));
        System.out.println("min between the range (3,5):"+ minRange(0,0,n-1,3,5));
        
  }
    
}
