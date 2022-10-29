//leetcode-451
//approach-priorityqueue
//TC-(O^2)

class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();//creating hashMap
        for(char ch:s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);//storing key value pair
            
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b) ->map.get(b)-map.get(a));//creating an priority queue for charcters in decending order
        pq.addAll(map.keySet());//adding all key charcter to queue
        String ans="";
        while(!pq.isEmpty())
        {
            char ch=pq.poll();//removing top charcter
            for(int i=0;i<map.get(ch);i++)//top character's value times
            {
                ans+=ch;//append to string
                
            }
        }
        return ans;
        
    }
}
