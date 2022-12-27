//KTH ZERO

package kthzeroinanarray;
import java.util.*;


public class KthZeroInAnArray {
    static int Seg_array[];
    public static int BuildSt(int SI,int sl,int sr,int arr[])
    {
        if(sl==sr)//when leaf arises
        {
            if(arr[sl]==0)return Seg_array[SI]=1;//f curr arr val is 0 then put 1 in seg array
            else return Seg_array[SI]=0;//else put 0 in seg array
        }
        int mid=sl+(sr-sl)/2;//finindg mid
        int left=BuildSt(2*SI+1,sl,mid,arr);//left call
        int right=BuildSt(2*SI+2,mid+1,sr,arr);//right call
        return Seg_array[SI]=left+right;//adding leftzero +right zero
    }
    public static int ZeroInRange(int SI,int sl,int sr,int k)
    {
        if(Seg_array[SI]<k)return -1;//if cur seg array value less k return -1 beacuse noOfZero <k
        if(sl==sr)return sl;//if leaf arises then the index is found
        int mid=sl+(sr-sl)/2;
        if(Seg_array[2*SI+1]>=k)return ZeroInRange(2*SI+1,sl,mid,k);//if leftZero >=k then lweftcall
        else return ZeroInRange(2*SI+2,mid+1,sr,k-Seg_array[2*SI+1]);//if leftZero < then rightcall
    }
    public static int UpdateTree(int SI,int sl,int sr,int pos,int val)
    {
        if(sl==sr&&sl==pos)
        {
          return Seg_array[SI]=val==0?1:0;//if leaf arises the val==0 then put 1 else put 0
        }
        if(sl>pos||sr<pos)return Seg_array[SI];//if pos is not equal to sl and sr return same segarray
         int mid=sl+(sr-sl)/2;
         int left=UpdateTree(2*SI+1,sl,mid,pos,val);//leftcall
         int right=UpdateTree(2*SI+2,mid+1,sr,pos,val);//rightcall
         return Seg_array[SI]=left+right;//returning seg array equal to left+right;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int heigth=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;//finding heigth
        int size=(1<<heigth)-1;//finding the size of seg array
        Seg_array=new int[size];//creatating seg array
        BuildSt(0,0,n-1,arr);//building segment tree
        for(int i=0;i<q;i++)
        {
            int operation=sc.nextInt();
            if(operation==1)
            {
                int key=sc.nextInt();
                int ans=ZeroInRange(0,0,n-1,key);//finding zero 
                if(ans==-1)System.out.println("NO");
                else System.out.println(ans);
                
            }
            else
            {
                int pos=sc.nextInt();
                int val=sc.nextInt();
                UpdateTree(0,0,n-1,pos,val);//update call
            }
        }
        
    }
}
