//leetcode-140
//approach-recursion backtracking

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res=new ArrayList<>();//creating an string list res for storing the final value
        List<String> curr=new ArrayList<>();//creating an string list curr for storing the current combination of strings
        generateSentence(res,curr,s,wordDict,0);//function call
        return res;
        
    }
    public void generateSentence(List<String> res,List<String> curr,String s,List<String> w,int index)
    {
        for(int i=index+1;i<=s.length();i++)//traversing for index+1 (incase one character means)
        {
            String sub=s.substring(index,i);//finding substring
            if(w.contains(sub))//checking if curr substring is present in the word dictionary
            {
                curr.add(sub);//adding to cuur list
                if(i==s.length())//if i  reaches the s.length() then there is a String combination
                {
                      String ch[]=curr.toArray(String[]::new);//converting curr list to String array
                        res.add(String.join(" ",ch));//joining the String eith space
                }
                else
                {
                    generateSentence(res,curr,s,w,i);//recursive call
                }
                curr.remove(curr.size()-1);//backtracking removing the recently added string
            }
        }
    }
}
