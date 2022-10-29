//leetcode-239;
//approach-PriorityQueue
//TC-O(N^2)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> nums[b]-nums[a]);//creating an priority queue in decending order
        int arr[]=new int[nums.length-k+1];//output array
        int index=0;
        for(int i=0;i<nums.length;i++)
        {

            while(!pq.isEmpty()&&pq.peek()<=i-k)//if the top elemnet index exceeds  the window size  then remove
            {
                pq.remove();
            }
            pq.add(i);//adding the index
            if(i>=k-1)//if i exceeds the window size then start putting the max in the array
            {
                arr[index++]=nums[pq.peek()];
            }
        }
        return arr;
        
    }
}
