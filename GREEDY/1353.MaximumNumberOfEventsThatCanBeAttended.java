//lc-1353
//approach-greedy

class Solution {
    public int maxEvents(int[][] events) {
        //priorityQueue
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        //sorting the array based on less start value
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int ans=0;
        int i=0;
        int n=events.length;
        for(int d=1;d<=100000;d++)
        {
            while(!pq.isEmpty()&&pq.peek()<d)//if curr start less prev finsihed remove that
                       pq.poll();
            while(i<n&&events[i][0]==d)
                       pq.offer(events[i++][1]);//if start ==d add its finish day
            if(!pq.isEmpty()){
                pq.poll();//poll that because on work completed
                ++ans;
            }
        }
        return ans;
    }
}
