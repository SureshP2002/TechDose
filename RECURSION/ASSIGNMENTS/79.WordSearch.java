//leetcode-79
//approach-Dfsbacktracking

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][]=new boolean[board.length][board[0].length];//creating an boolean array for filling index with true when(word's character is equal to board charcter)
        for(int i=0;i<board.length;i++)//traversing
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))//checking if first character of the eord is equal ar curr index 
                    
                {
                    if(Dfs(visited,board,word,i,j,0))//checking in all direction  if word exists in the grid
                    {
                        return true;
                    }
                }
            }
        }
        return false;//if word is not found int grid
    }
    boolean Dfs(boolean visited[][],char mat[][],String word,int i,int j,int currLen)
    {
        if(currLen==word.length())//by recursive call when the currLen recahes to word length it means that the word exits
        {
            return true;
        }
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||word.charAt(currLen)!=mat[i][j]||visited[i][j]==true)//invalid conditions
        {
            return false;
        }
        visited[i][j]=true;//keeping curr position as true in boolean array
        boolean left=Dfs(visited,mat,word,i,j+1,currLen+1);//recursive call for left side
        boolean right=Dfs(visited,mat,word,i,j-1,currLen+1);//recursive call for right side
        boolean top=Dfs(visited,mat,word,i-1,j,currLen+1);//recurive call for top 
        boolean down=Dfs(visited,mat,word,i+1,j,currLen+1);//recursive call for down
        visited[i][j]=false;//making the index false in boolean array once the functio returns(backtracks)
        if(left==true||right==true||top==true||down==true)//if anyone side becomes true then return true
        {
            return true;
        }
        else//else no word
        {
            return false;
        }
    }
}
