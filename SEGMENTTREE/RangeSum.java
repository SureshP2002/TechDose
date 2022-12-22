//RANGE SUM
//TC-O(LogN)-range and update\
//TC-O(N)


package rangesum;
import java.util.*;


public class RangeSum {
    static int SegmentTree[];//initializing the array
    static int BuildSt(int SI,int arr[],int sl,int sr)
    {
        if(sl==sr)//when leaf node found put the array values
        {
            return SegmentTree[SI]=arr[sl];
        }
        int mid=sl+(sr-sl)/2;//divinding the array
        int leftSide=BuildSt( 2*SI+1,arr,sl,mid);
        int rightSide=BuildSt(2*SI+2,arr,mid+1,sr);
        SegmentTree[SI]=leftSide+rightSide;//storing the rangesum to All index
        return SegmentTree[SI];//returning
    }
    static int RangeSum(int SI,int sl,int sr,int left,int right)
    {
        if(left<=sl&&right>=sr)//fully overlap
        {
           return SegmentTree[SI];
        }
        if(right<sl||left>sr)//no overlap
        {
            return 0;
        }
        int mid=sl+(sr-sl)/2;//partial overlap
        int leftSide=RangeSum(2*SI+1,sl,mid,left,right);
        int RightSide=RangeSum(2*SI+2,mid+1,sr,left,right);
        return leftSide+RightSide;//adding the both side values
    }
    static int Update(int SI,int sl,int sr,int upInd,int newVal)
    {
        if(sr<upInd||sl>upInd)//no overlap
        {
            return SegmentTree[SI];
        }
        if(sl==sr&&sl==upInd)//when leaf node comes and if sr==sl
        {
            return SegmentTree[SI]=newVal;
        }
        int mid=sl+(sr-sl)/2;//finding mid
        int leftSide=Update(2*SI+1,sl,mid,upInd,newVal);
        int RightSide=Update(2*SI+2,mid+1,sr,upInd,newVal);
        SegmentTree[SI]=leftSide+RightSide;//updating the value
        return SegmentTree[SI];//returning the value
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int height=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<height)-1;
        //BuildeSegment tree
        SegmentTree=new int[size];
        int sum=BuildSt(0,arr,0,n-1);
        System.out.println("Sum :"+sum);
        //Range Sum
        System.out.println("Range Sum (0,3) :"+ RangeSum(0,0,n-1,0,3));
        System.out.println("Range Sum (2,4) :"+ RangeSum(0,0,n-1,2,4));
        System.out.println("Range Sum (1,5) :"+ RangeSum(0,0,n-1,1,5));
        
        //update
        sum=Update(0,0,n-1,2,10);
        //get RangeSUm
        System.out.println("Range Sum (0,3) :"+ RangeSum(0,0,n-1,0,3));
        System.out.println("Range Sum (2,4) :"+ RangeSum(0,0,n-1,2,4));
        System.out.println("Range Sum (1,5) :"+ RangeSum(0,0,n-1,1,5));
        
        
    }
    
}
