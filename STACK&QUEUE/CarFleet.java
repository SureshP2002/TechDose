//leetcode-853
//TC-O(N)


class Solution {
    public int carFleet(int target, int[] p, int[] speed) {
        int n=speed.length;
        Stack<Double> st=new Stack<>();//creating an stack
        Map<Integer,Double> map=new TreeMap<>();//creating an treee map
        for(int i=0;i<p.length;i++)
        {
            map.put(p[i],((double)(target-p[i])/speed[i]));//finding the time for curent car
            
        }
        Arrays.sort(p);//sorting the array
        st.push(map.get(p[n-1]));//pushing the last cars time into the stack
        for(int i=n-2;i>=0;i--)//traversing from last before car
        {
            if(st.peek()<map.get(p[i]))//if the curr car speed is greater than the prev car(stack);
            {
                st.push(map.get(p[i]));//pushing it into stack
            }
        }
        return st.size();returning the size
        
    }
}
