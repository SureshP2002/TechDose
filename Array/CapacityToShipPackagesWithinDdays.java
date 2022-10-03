//leetcode -1011;
//TC -O(NlogN);
//APPROACH-Binary Search;

class Solution {
    public int shipWithinDays(int[] w, int D) {
        int left=0;
        int right=0;
        for(int i:w)
        {
            left=Math.max(left,i);
            right+=i;
        }
        while(left<right)
        {
            int mid=left+(right-left)/2;
            int days=1,curr=0;
            for(int i:w)
            {
                if(curr+i>mid)
                {
                    curr=0;
                    days++;
                }
                curr+=i;
            }
            if(days>D)left=mid+1;
            else  right=mid;
            
        }
        return left;
    }
}
