//lc-621

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int hash[]=new int[26];
        int max=Integer.MIN_VALUE;
        for(char ch:tasks)
        {
            hash[ch-'A']++;
            max=Math.max(hash[ch-'A'],max);
        }
        int group=(max-1)*(n+1);//Axx Axx Axx Axx Axx Axx-->18 but last time may or may it come so(max-1)*(n+1)-->15
                                                                                                                //Axx Axx Axx Axx Axx
         
        int last=0;//finding last gruop elemenst
        for(int i:hash)
        {
            if(i==max)last++;
        }
        return Math.max(tasks.length,(max-1)*(n+1)+last);
        
    }
}
