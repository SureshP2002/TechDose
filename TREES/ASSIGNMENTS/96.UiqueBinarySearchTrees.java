//leetcode-96
//Tc-O(N)
//CATALAN NUMBERS

class Solution {
    public int numTrees(int n) {
        //catalan numbers approach because every node can become root if n=4 and by making all node as root then (c0*c3)+(c1*c2)+(c2*c1)+(c3*c0);
        int catalan[]=new int[n+2];
        catalan[0]=1;//if zero node means 1
        catalan[1]=1;//if one node means 1
        for(int i=2;i<n+2;i++)
        {
            for(int j=0;j<i;j++)
            {
                catalan[i]+=catalan[j]*catalan[i-j-1];
            }
        }
        return catalan[n];
    }
}
