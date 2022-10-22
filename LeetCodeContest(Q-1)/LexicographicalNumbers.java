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
/*Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104*/
