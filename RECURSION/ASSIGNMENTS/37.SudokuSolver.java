//leetcode-37
//approach-recursion(backtrack)

class Solution {
    char res[][]=new char[9][9];//creating an result matrix for adding final answer
    public void solveSudoku(char[][] board) {
        buildsudoku(board,0,0);//funtion call
        board=res;//assigning back the result to board
        
    }
    public boolean buildsudoku(char board[][],int row,int col)
    {
        if(col==9)//if col reaches 9 then we need to move for next row and check
        {
            return buildsudoku(board,row+1,0);//recursive call
        }
        if(row==9)//if row reaches 9 then we  reached the end of the matrix
        {
            res=board;//add it to result
            return true;//return true;
        }
        if(board[row][col]!='.')//if number already present skip it
        {
            return buildsudoku(board,row,col+1);.//recursive call with col+1
        }
        for(char i='1';i<='9';i++)//'1' to  '9'
        {
            if(!isValid(board,row,col,i))//checking if current i is valid to that place
            {
                continue;//(if not valid then continue for next i(char))
            }
            board[row][col]=i;//if valid then add i to curr row|col
            if(buildsudoku(board,row,col+1))//function call for next col+1
            {
                return true;
            }
            board[row][col]='.';//backtrack
        }
        return false;
    }
    public boolean isValid(char board[][],int row,int col,char ch)
    {
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==ch)return false;//if any element in the curr row is equal to ch then return false
            if(board[i][col]==ch)return false;//if any element in the curr col is equal to ch then return false;
            if(board[(row/3)*3+i/3][(col/3)*3+i%3]==ch)return false;//if any elemnt in the curr box is equal to ch then return false;
        }
        return true;//if no duplicates then return true
    }
}
