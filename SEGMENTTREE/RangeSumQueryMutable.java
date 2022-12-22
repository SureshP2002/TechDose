//leetcode-307
//TC_O(logN)


class NumArray {
   int seg[];
   int n;
   public int buildSt(int SI,int nums[],int sl,int sr)
   {
      
       if(sl==sr)//if leaf node comes then add the curr array value in segment array
       {
           return seg[SI]=nums[sl];
       }
       int mid=sl+(sr-sl)/2;//find mid
       int left=buildSt(2*SI+1,nums,sl,mid);//left call with 2*i+1;
       int right=buildSt(2*SI+2,nums,mid+1,sr);//right call wiht 2*i+2;
       seg[SI]=left+right;//storing the total sum of left and right;
       return seg[SI];
   }
    public NumArray(int[] num) {
        n = num.length;
        int heigth=(int)Math.ceil(Math.log10(n)/Math.log10(2))+1;//first finding heigth
        int size=(1<<heigth)-1;//the finding the segmentation arrays size
        seg=new int[size];
         buildSt(0,num,0,n-1);//building

    }
    public int UpdateSt(int SI,int sl,int sr,int pos,int val)
    {
        if(sr<pos||sl>pos)return seg[SI];//no overlap means return same value
        if(sl==sr&&sl==pos)
        {
            return seg[SI]=val;//if leaf node comes the update value
        }
        int mid=sl+(sr-sl)/2;//finding mid
        int left=UpdateSt(2*SI+1,sl,mid,pos,val);//left call
        int right=UpdateSt(2*SI+2,mid+1,sr,pos,val);//right call
        seg[SI]=left+right;//storing value
        return seg[SI];
    }
    
    public void update(int index, int val) {
        UpdateSt(0,0,n-1,index,val);//function call
    }
    public int rangeSum(int SI,int sl,int sr,int left,int right)
    {
        if(sr<left||sl>right)return 0;//no overlap
        if(left<=sl&&sr<=right)return seg[SI];//full overlap
        int mid=sl+(sr-sl)/2;//partiial overlap
        int leftSum=rangeSum(2*SI+1,sl,mid,left,right);
        int rightSum=rangeSum(2*SI+2,mid+1,sr,left,right);
        return leftSum+rightSum;//returning the sum
    }
    
    public int sumRange(int left, int right) {
        return rangeSum(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
