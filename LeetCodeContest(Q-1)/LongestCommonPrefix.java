//leetcode-14
//TC-O(N)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        for(int i=0;i<strs[0].length();i++)
        {
            if(strs[0].length()==0)return "";
            char ch=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if(i>strs[j].length()-1||strs[j].charAt(i)!=ch)return s;
            }
            s+=ch;
        }
        return s;
    }
}
