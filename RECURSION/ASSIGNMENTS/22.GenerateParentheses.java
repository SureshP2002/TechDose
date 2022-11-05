//leetcode-22
//approach-backtracking
//method-1


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l=new ArrayList<>();//creating arrayList for adding combinations
        generateParen(l,n,0,0,"");//function call
        return l;
        
    }
    void generateParen(List<String> l,int n,int open ,int close,String currStr)
    {
        if(currStr.length()==2*n)//if currStr size reaches n*2[((()))] add it and return (backtrack)
        {
            l.add(currStr);//adding to list
            return;
        }
        if(open<n)//if open is less than n[((]
        {
            generateParen(l,n,open+1,close,currStr+"(");//recursive call
        }
        if(close<open)//if close paren is less than open paren
        {
            generateParen(l,n,open,close+1,currStr+")");//recursive call
        }
    }
}

//method-2

class Solution {
    List<String> l=new ArrayList<>();//creating an list for storing the ans
    public List<String> generateParenthesis(int n) {
       char arr[]=new char[2*n];//creating an array of size 2*n
        Dfs(arr,0);//calling function
        return l;
        
    }
    void Dfs(char arr[],int pos)
    {
        if(pos==arr.length)//if the pos size is equal to arr size then there is a combination
        {
            if(Valid(arr))//checking if the combination is valid
            {
                l.add(String.valueOf(arr));//adding to list
            }
            return;//backtrack
        }
        
        arr[pos]='(';//first adding opening bracket
        Dfs(arr,pos+1);//recursive call
        arr[pos]=')';//second adding closing bracket
        Dfs(arr,pos+1);//recursive call
       
       
    }
    public boolean Valid(char arr[])
    {
        int bal=0;//checking the arr contains qual no of opening and closing parenthesis
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='(')bal++;//if '(' increases
            else bal--;//if ')' decrease
            if(bal<0)//if bal goes negative then it means closing parenthesis is more ());
            {
                return false;//return false(not valid array)
            }
        }
        return bal==0;
    }
}
