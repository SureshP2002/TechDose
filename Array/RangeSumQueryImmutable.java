//leetcode-303
//DP
//TC-O(n)

class NumArray {
    int arr[];

    public NumArray(int[] nums) {
        this.arr=nums; int sum=0;
        for(int i=1;i<arr.length;i++)
        {
            arr[i]+=arr[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
       
        
        return  i==0?arr[j]:arr[j]-arr[i-1];
        
        
        
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
