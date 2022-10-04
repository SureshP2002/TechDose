//leetcode-54
//Spiral Matrix


class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        int top=0;
        int bottom=m.length-1;
        int left=0;
        int right=m[0].length-1;
        List<Integer> ans=new ArrayList<Integer>();
        while(left<=right&&top<=bottom)
        {
            
            for(int i=left;i<=right;i++)
            {
                ans.add(m[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                ans.add(m[i][right]);
            }
            right--;
            if(top>bottom)break;
            for(int i=right;i>=left;i--)
            {
                ans.add(m[bottom][i]);
            }
            bottom--;
            if(left>right)break;
           for(int i=bottom;i>=top;i--)
            {
                ans.add(m[i][left]);
            }
            left++;
            
            }
        return ans;
    }
}
