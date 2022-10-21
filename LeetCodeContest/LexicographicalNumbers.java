//leetcode-386
//TC-O(N)

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans= new ArrayList<Integer>();//creating the arrayList
        for(int i=1;i<=n;i++)
        {
            ans.add(i);
        }
        Collections.sort(ans,(a,b)->(Integer.toString(a).compareTo(Integer.toString(b))));//sorting th array based on string value;
        return ans;
        
    }
}
