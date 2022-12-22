//COUNT ZEROS
//TC-O(logN)->update and count
//TC-O(N)

package countzerosinrange;
import java.util.*;

public class CountZerosInRange {
     static int segmentArray[];
    public static int buildSt(int SI,int arr[],int sl,int sr)
    {
        if(sl==sr)return segmentArray[SI]=arr[sl]==0?1:0;//when leaf arises the check if arr[val]==0,if 0 make leaf as 1 else 0;
        int mid=sl+(sr-sl)/2;
        int leftcount=buildSt(2*SI+1,arr,sl,mid);
        int rightcount=buildSt(2*SI+2,arr,mid+1,sr);
        segmentArray[SI]=leftcount+rightcount;
        return segmentArray[SI];
    }
    public static int countRange(int SI,int sl,int sr,int left,int right)
    {
        if(right<sl||left>sr)return 0;
        if(left<=sl&&sr<=right)return segmentArray[SI];
        int mid=sl+(sr-sl)/2;
        int leftcount=countRange(2*SI+1,sl,mid,left,right);
        int rightcount=countRange(2*SI+2,mid+1,sr,left,right);
        return leftcount+rightcount;
    
    }
    public static int Update(int SI,int sl,int sr,int position,int val)
    {
        if(sr<position||sl>position)return segmentArray[SI];
        if(sr==sl&&sl==position)
        {
            return segmentArray[SI]=(val==0)?1:0;//when the val is 0 then we updat st zero count 1 or else make it as 0
        }
        int mid=sl+(sr-sl)/2;
        int leftcount=Update(2*SI+1,sl,mid,position,val);
        int rightcount=Update(2*SI+2,mid+1,sr,position,val);
        return segmentArray[SI]=leftcount+rightcount;
        
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
        //fiding zeros between the range;
        System.out.println("countoOfZeros between the range (0,3):"+ countRange(0,0,n-1,0,3));
        System.out.println("countoOfZeros between the range (1,4):"+ countRange(0,0,n-1,1,4));
        System.out.println("countoOfZeros between the range (3,5):"+ countRange(0,0,n-1,3,5));
        //updatingSt
        Update(0,0,n-1,2,0);
        System.out.println("countoOfZeros between the range (0,3):"+ countRange(0,0,n-1,0,3));
        System.out.println("countoOfZeros between the range (1,4):"+ countRange(0,0,n-1,1,4));
        System.out.println("countoOfZeros between the range (3,5):"+ countRange(0,0,n-1,3,5));
        
    }
