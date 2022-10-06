//leetcode-828
//TC-O(N^2)
//Using 2DArrayList;

class Solution {
    public int uniqueLetterString(String s) {
           int len=s.length(),res=0;
        List<List<Integer>> ans=new ArrayList<>();//2dimensional ArrayList
        for(int i=0;i<26;i++)
        {
            ans.add(new ArrayList<>());//adding 26 empty arraylist in 2d list
            ans.get(i).add(-1);//adding initialyy -1;;
        }
        for(int i=0;i<s.length();i++)
        {
            ans.get(s.charAt(i)-'A').add(i);//adding index of chracter to corressponding list;
        }
        for(int i=0;i<26;i++)
        {
            ans.get(i).add(len);//add len  in each list
        }
        
        for(int i=0;i<26;i++)
        {
            for(int j=1;j<ans.get(i).size()-1;j++)
            {
                int left=ans.get(i).get(j)-ans.get(i).get(j-1);
                int right=ans.get(i).get(j+1)-ans.get(i).get(j);
                res+=(left*right);
            }
        }
        return res;
        
        
    }
}
