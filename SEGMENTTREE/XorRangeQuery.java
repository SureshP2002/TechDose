//XOR RANGE QUERY
//TC-O(logN)->XOR AND UPDATE
//TC-O(n)


package xorquery;
import java.util.*;


public class XORQuery {
      static int segmentArray[];
    public static int buildSt(int SI,int arr[],int sl,int sr)
    {
        if(sl==sr)return segmentArray[SI]=arr[sl];
        int mid=sl+(sr-sl)/2;
        int leftxor=buildSt(2*SI+1,arr,sl,mid);
        int rightxor=buildSt(2*SI+2,arr,mid+1,sr);
        segmentArray[SI]=leftxor^rightxor;
        return segmentArray[SI];
    }
    public static int xorRange(int SI,int sl,int sr,int left,int right)
    {
        if(right<sl||left>sr)return 0;//returning 0 when index sl and sr not lies int the given range
        if(left<=sl&&sr<=right)return segmentArray[SI];
        int mid=sl+(sr-sl)/2;
        int leftxor=xorRange(2*SI+1,sl,mid,left,right);
        int rightxor=xorRange(2*SI+2,mid+1,sr,left,right);
        return leftxor^rightxor;
    
    }
    public static int Update(int SI,int sl,int sr,int position,int val)
    {
        if(sr<position||sl>position)return segmentArray[SI];
        if(sr==sl&&sl==position)
        {
            return segmentArray[SI]=val;
        }
        int mid=sl+(sr-sl)/2;
        int leftxor=Update(2*SI+1,sl,mid,position,val);
        int rightxor=Update(2*SI+2,mid+1,sr,position,val);
        return segmentArray[SI]=leftxor^rightxor;
        
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
        //fiding XOR between the range;
        System.out.println("xor between the range (0,3):"+ xorRange(0,0,n-1,0,2));
        System.out.println("xor between the range (1,4):"+ xorRange(0,0,n-1,1,4));
        System.out.println("xor between the range (3,5):"+ xorRange(0,0,n-1,3,5));
        //updatingSt
        Update(0,0,n-1,1,10);
        System.out.println("xor between the range (0,3):"+ xorRange(0,0,n-1,0,2));
        System.out.println("xor between the range (1,4):"+ xorRange(0,0,n-1,1,4));
        System.out.println("xor between the range (3,5):"+ xorRange(0,0,n-1,3,5));
        
    }
    
}
