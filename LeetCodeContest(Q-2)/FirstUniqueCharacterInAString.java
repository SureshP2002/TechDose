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
