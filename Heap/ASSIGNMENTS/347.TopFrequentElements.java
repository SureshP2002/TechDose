//leetcode-347
//approach-priorityQueue


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<>();//creating an hashMap
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);//storing key value
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));//creating an priorityqueue decending order
        pq.addAll(map.keySet());//adding all elemnts from map to queue
        int ans[]=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.poll();//adding elemnts from the queue
        }
        return ans;
    }
}
