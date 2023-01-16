//DSUF Method

class Solution {
    int arr[];
    public int find(int x)
    {
        if(arr[x]==x)return x;
        return arr[x]=find(arr[x]);
    }
    public void union(int x,int y)
    {
        int ind1=find(x);//find parent
        int ind2=find(y);//find parent
        if(ind1==ind2)//if both parent same no operation
            return;
        else if(arr[ind1]<arr[ind2])//if parent of ind1 les than parent of ind2 update parent of ind2 to ind1
            arr[ind2]=ind1;
        else//if parent of ind2 les than parent of ind1 update parent of ind1 to ind2
            arr[ind1]=ind2;

    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        arr=new int[26];//creating an parent array
        for(int i=0;i<26;i++)arr[i]=i;
        for(int i=0;i<s1.length();i++)
        {
            union(s1.charAt(i)-'a',s2.charAt(i)-'a');//finding union for each char 
        }
        String ans="";
        for(int i=0;i<baseStr.length();i++)
        {
            ans+=(char)(find(baseStr.charAt(i)-'a')+'a');//now finding base str parent and addinga ans
        }
        return ans;
    }
}
