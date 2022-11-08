//leetcode-212
//approach-trie+backtracking

class Solution {
    class TrieNode//trienode structure
    {
        TrieNode next[]=new TrieNode[26];//it contains 26 pointers[26]
        String word;//and a word
    }
    public TrieNode buildTrie(String words[])//adding words to trie
    {
       TrieNode root=new TrieNode();//initialy make root node
        for(String w:words)//traversing all words
        {
            TrieNode temp=root;//temporary variable assigned with root
            for(char ch:w.toCharArray())//everycharcter
            {
                int pos=ch-'a';//finding the pos for creatingnode for the character
                if(temp.next[pos]==null)//if node is not already crated for the character
                {
                temp.next[pos]=new TrieNode();//create new node for the curr character
                }
                temp=temp.next[pos];//moving to next charnode
            }
            temp.word=w;//assiging the word at the last created node
            
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        
       TrieNode root=buildTrie(words);//building an trie structure for the given words
       List<String> l=new ArrayList<>();//creating an list
       for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                Dfs(board,root,i,j,l);//sending each character for checking
            }
        }
        return l;
    }
    public void Dfs(char [][]board,TrieNode temp,int row,int col,List<String> l)
    {
         if(row<0||col<0||row>=board.length||col>=board[0].length)//invalid contions 
        {
            return;
        }
        char ch=board[row][col];//taking the character from the board
        if(board[row][col]=='@'||temp.next[ch-'a']==null)//checking if it already visited or there is  no node created
        {
            return;//return back
        }
      
        board[row][col]='@';//making initialy the visited node as "@"
        temp=temp.next[ch-'a'];//going to next charcter
        if(temp.word!=null)//if there forms a word in the node then there will be some word
        {
            l.add(temp.word);//adding it to list
            temp.word=null;//making the curr word to null for avoiding duplicates
        }
         Dfs(board,temp,row+1,col,l);//down
         Dfs(board,temp,row-1,col,l);//up
         Dfs(board,temp,row,col+1,l);//right
         Dfs(board,temp,row,col-1,l);//left
         board[row][col]=ch;//making it again  ch

    }
}
