//leetcode-49
//TC-O(N)
//approach-hashMap

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      
         if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();//creating hashMap for String and list
        for (String s : strs) {
            char[] ca = s.toCharArray();//convert to char array
            Arrays.sort(ca);//sorting them
            String keyStr = String.valueOf(ca);//bring back string
            if (!map.containsKey(keyStr))//if the keyString is not available the create a new arrayList for them
            {
                map.put(keyStr, new ArrayList<>());//creating arraylist for keystr
            }
            map.get(keyStr).add(s);//adding the string
        }
        return new ArrayList<>(map.values());//returning map values
        
    }
}
