//lc-421

class Solution {
    class Trienode{
        Trienode next[]=new Trienode[2];//for 0 and 1
    }
    Trienode root=null;
    public void buildTrie(int num)
    {
        Trienode temp=root;
        for(int i=31;i>=0;i--)//traversing from MSB
        {
            int bit=(num>>i)&1;//checking bit 0 or 1
            if(temp.next[bit]==null)//if node not creating (create now)
            {
                temp.next[bit]=new Trienode();
            }
            temp=temp.next[bit];//move to next node
        }
    }
    public int max_xor(int num)
    {
        int ans=0;
        Trienode temp=root;
        for(int i=31;i>=0;i--)//trevrseing from MSB
        {
            int bit=(num>>i)&1;//checking bit 0 or 1
            int newbit=bit==0?1:0;//bit=0?newbit=1|| bit=1?newbit=0
            if(temp.next[newbit]!=null)//finding its opp                  //    0 0 0 1 1-->3
            {                                                             //    1 1 1 0 0-->28
                ans+=(1<<i);//adding to ans                              ans=   1 1 0 0 1-->25
                temp=temp.next[newbit];//moving next bit
            }
            else
            {
                temp=temp.next[bit];//if newbit is null then move with curr bit
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        int max_ans=0;
        int n=nums.length;
        root=new Trienode();//creating root
        for(int i=0;i<nums.length;i++)
        {
            buildTrie(nums[i]);//building trie with nums[i]
            max_ans=Math.max(max_ans,max_xor(nums[i]));
        }
        return max_ans;
        
    }
}
