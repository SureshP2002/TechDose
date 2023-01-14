//lc-763
//approach-greedy

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }
        int max=0;
        int prev=-1;
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            max=Math.max(max,map.get(s.charAt(i)));
            if(max==i)
            {
                l.add(i-prev);
                prev=max;

            }
        }
        return l;
    }
}
