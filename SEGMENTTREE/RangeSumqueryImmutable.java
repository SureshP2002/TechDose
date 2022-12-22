//leetcode-303
//TC_O(logN)

class NumArray {
    int seg[];
    int nums[];
    public int BuildSt(int SI,int nums[],int sl,int sr)
    {
        if(sr==sl)
        {
            return seg[SI]=nums[sl];
        }
        int mid=sl+(sr-sl)/2;
        int leftSide=BuildSt(2*SI+1,nums,sl,mid);
        int rightSide=BuildSt(2*SI+2,nums,mid+1,sr);
        seg[SI]=leftSide+rightSide;
        return seg[SI];
    }

    public NumArray(int[] num) {
       int heigth=(int)Math.ceil(Math.log10(num.length)/Math.log10(2))+1;
       int size=(1<<heigth)-1;
       seg=new int[size];
       nums=num;
       BuildSt(0,nums,0,nums.length-1);
    }
    public int Range(int SI,int sl,int sr,int left,int right)
    {
         if(sr<left||sl>right)return 0;
        if(left<=sl&&sr<=right)
        {
            return seg[SI];
        }
       
        int mid=sl+(sr-sl)/2;
        int lefts=Range(2*SI+1,sl,mid,left,right);
        int rights=Range(2*SI+2,mid+1,sr,left,right);
        return lefts+rights;
    }
    
    public int sumRange(int i, int j) {
        return Range(0,0,nums.length-1,i,j);
        
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
