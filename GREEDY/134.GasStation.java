//lc-134
//approach-greedy


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalcost=0,totalfuel=0;
        //finding total cost and fuel
        for(int i=0;i<gas.length;i++)
        {
            totalcost+=cost[i];
            totalfuel+=gas[i];
        }
        //if fuel less cost return -1
        if(totalfuel<totalcost)return -1;
        int currfuel=0;
        int start=0;
        for(int i=0;i<gas.length;i++)
        {
           currfuel+=gas[i]-cost[i];//--->1-3 --->2-4  --->3-5  --->4-1(here positive hence cycle starts) --->5-2
           if(currfuel<0)           //    =-2     =-2      =-2     =3(positive)
           {
              start=i+1;
              currfuel=0;
           }
        }
        return start;
        
    }
}
