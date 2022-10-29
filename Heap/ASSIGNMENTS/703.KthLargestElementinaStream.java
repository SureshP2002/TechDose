//leetcode-703
//approach-priorityQueue


class KthLargest {
   
    PriorityQueue<Integer> pq;//priority queue
    int k;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>((a,b) -> a-b);//min heap
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);//adding elements
            
        }
        this.k=k;
    }
    
    public int add(int val) {
         pq.add(val);//adding the current value
            while(pq.size()>k)//poll untill the queue size comes for k
            {
                pq.poll();
            }
        return pq.peek();//return top
        
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
