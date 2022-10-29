//leetcode -1882
//aaproach-priorityQueue


class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free=new PriorityQueue<>((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);//sorting ascending based on weight if weight equal means sort ascending based on index
        PriorityQueue<int[]> used=new PriorityQueue<>((a,b)->a[2]!=b[2]?a[2]-b[2]:(a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));//sort ascending based on tasks if task are equal then see sort based on weigth and it also equals then sort based on index
        int n=servers.length;
        int m=tasks.length;
        for(int i=0;i<n;i++)
        {
            free.add(new int[]{servers[i],i,0});//adding the tasks into free
        }
        int arr[]=new int[m];
        for(int i=0;i<m;i++)
        {
            int time=tasks[i];
            while(!used.isEmpty()&&used.peek()[2]<=i)//if used task time is less than the curr time i
            {
                free.add(used.poll());//it means there is free tasks
            }
            if(free.isEmpty())//if there is no free tasks
            {
                int curr[]=used.poll();
                arr[i]=curr[1];//add the top index
                curr[2]+=time;//increment the time for tha task time
                used.add(curr);//add new tasks to used
                
            }
            else
            {
                int curr[]=free.poll();//if there is a free tasks
                arr[i]=curr[1];
                curr[2]=i+time;//updating time
                used.add(curr);//adding it to used
            }
        }
        return arr;
        
    }
}
