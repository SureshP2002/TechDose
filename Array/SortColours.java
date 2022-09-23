//leetcode 75;
//TC:O(n);
//Dutch National Flag Algprihtm;

class Solution {
    void swap(int []arr,int i,int j){
        int tem=arr[i];
        arr[i]=arr[j];
        arr[j]=tem;
    }
    public void sortColors(int[] nums) {
        int s=0,m=0,e=nums.length-1;
        while(m<=e){
            if(nums[m]==0){
                swap(nums,s,m);
                s++;
                m++;
            }
            else if(nums[m]==1){
                m++;
            }
            else if(nums[m]==2){
                swap(nums,m,e--);
            }
        }
    }
}
