//LC-139

class Solution {
    class Trienode{//trie class
        Trienode next[]=new Trienode[26];//child
        int wordend;//wordend
    }
    Trienode root=null;
    public void buildTrie(String word)
    {
        Trienode temp=root;//build trie
        for(char ch:word.toCharArray())
        {
            int pos=ch-'a';
            if(temp.next[pos]==null)temp.next[pos]=new Trienode();
            temp=temp.next[pos];
           
        }
         temp.wordend++;
      
    }
    public boolean checkWord(String s)
    {
       Queue<Integer> q=new LinkedList<>();
       int len=s.length();
       boolean visited[]=new boolean[len];
       q.add(0);
       outter:
       while(!q.isEmpty())//checking word
       {
           int start=q.poll();
           if(visited[start])continue;//if already visited continue
           visited[start]=true;
           Trienode temp=root;
           for(int i=start;i<len;i++)
           {
               int pos=s.charAt(i)-'a';
               temp=temp.next[pos];
               if(temp==null)continue outter;//going to while
               if(temp.wordend>0&&i<len-1)q.add(i+1);//if word found go to while
           }
           if(temp.wordend>0)return true;
           
       }
       return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        root=new Trienode();
        for(int i=0;i<wordDict.size();i++)
        {
            
            buildTrie(wordDict.get(i));
        }
        return checkWord(s);
    }
}
