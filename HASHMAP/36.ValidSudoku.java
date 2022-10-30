//leetcode-36
//TC-O(N)
//approach-hashSet()

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set set=new HashSet<>();//creating the hashset
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')//if it is a number
                {
                    char ch=board[i][j];//taking ths character
                    if(set.contains(ch+"r"+i)||set.contains(ch+"c"+j)||set.contains(ch+"b"+i/3+j/3))//if the char already present in the set then rerturn false
                    {
                        return false;
                    }
                
                set.add(ch+"r"+i);//adding the row for with index
                set.add(ch+"c"+j);//adding the col with index;
                set.add(ch+"b"+i/3+j/3);//adding the block with index
                }
            }
        }
        return true;
    }
}
