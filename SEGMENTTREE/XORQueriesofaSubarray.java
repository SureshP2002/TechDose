//leetcode-1310
//TC-O(LogN)

class Solution {
    int Seg[];
    int n;
    public int BuildSt(int SI,int arr[],int sl,int sr)
    {
        if(sl>sr)return 0;
        if(sl==sr)
        {
            return Seg[SI]=arr[sl];
        }
        int mid=sl+(sr-sl)/2;
        int leftSum=BuildSt(SI*2+1,arr,sl,mid);
        int rightSum=BuildSt(SI*2+2,arr,mid+1,sr);
        Seg[SI]=leftSum^rightSum;
        return Seg[SI];
    }
    public int XorSum(int SI,int sl,int sr,int left,int right)
    {
        if(sr<left||sl>right)return 0;
        if(sl>=left&&sr<=right)return Seg[SI];
        int mid=sl+(sr-sl)/2;
        int leftSum=XorSum(2*SI+1,sl,mid,left,right);
        int rightSum=XorSum(2*SI+2,mid+1,sr,left,right);
        return leftSum^rightSum;
        
    }
    public int[] xorQueries(int[] nums, int[][] queries) {
        n=nums.length;
        int heigth=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;
        int size=(1<<heigth)-1;
        Seg=new int[size];
        BuildSt(0,nums,0,n-1);
        int arr[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            arr[i]=XorSum(0,0,n-1,queries[i][0],queries[i][1]);
        }
        return arr;
    }
}
