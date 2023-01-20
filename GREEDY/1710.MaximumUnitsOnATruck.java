//lc-1710
//approach-greedy


class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);//sorting based on max unit per box
        int count=0;
        int ans=0;
        for(int i[]:boxTypes)
        {
            if((count+=i[0])<=truckSize)//if curr size less than trucksize add them
            {
                 ans+=i[0]*i[1];
            }
            else//if trucksize exceeds find tha balance space in truck to put items
            {
                int a=count-truckSize;
                int b=i[0]-a;
                ans+=b*i[1];
                return ans;
            }
        }
        return ans;
    }
}
