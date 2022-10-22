//leetcode-387
//approach-HashMap
//TC-O(N)


class Solution {
    public int firstUniqChar(String s) {
      Map<Character,Integer> map=new HashMap<>();//creating an HashMap
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);//adding the frequency 
        }
        for(int i=0;i<s.length();i++)
        {
            if(map.get(s.charAt(i))==1)return i;//if the frequency is 1 return i
        }
        return -1;
        
    }
}
/*Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
