//leetcode-3
//TC-O(N)
//approach-hashmap

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();//creating an hashMap
        int max=0;
        int start=0;
        for(int i=0;i<s.length();i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                start=Math.max(start,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-start+1);//finfing maximum length
        }
        return max;
      
    }
}
