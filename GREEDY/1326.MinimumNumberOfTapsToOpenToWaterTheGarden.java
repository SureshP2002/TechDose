//lc-1326

class Solution {
    public int minTaps(int n, int[] ranges) {
        //creating intervals array
        int intervals[]=new int[n];
        //filling it with -1
        Arrays.fill(intervals,-1);
        //finding max right range for every index
        for(int i=0;i<ranges.length;i++)
        {
            if(ranges[i]==0)continue;
            int left=i-ranges[i]>=0?i-ranges[i]:0;
            int right=i+ranges[i];
            intervals[left]=Math.max(intervals[left],right);
        }
        //if intervals[0]==-1 then tap 1 o cannot be reached
        if(intervals[0]==-1)return -1;
        int count=1;
        int longest=intervals[0];//curr longest is intervals[0];
        int i=0;
        while(longest<n)
        {
            int temp=Integer.MIN_VALUE;
            for(;i<=longest;i++)
            {
                if(intervals[i]==-1)continue;//if intervals[i]==-1 continue
                
                   temp=Math.max(temp,intervals[i]);//finding next max range
                
            }
            if(temp<=longest)return -1;//if nextmax range is below the currmax range return -1(because not posssible);
            longest=temp;//go to nextmax
            count++;//increase count
        }
        return count;
    }
}
