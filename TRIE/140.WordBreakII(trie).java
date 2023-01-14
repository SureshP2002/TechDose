//LC-140


class Solution {
    class Trienode{//trie class
        Trienode next[]=new Trienode[26];//child
        boolean isEnd=false;
    }
    Trienode root=null;
    public List<String> res=new ArrayList<>();
    public void buildTrie(String word)
    {
        Trienode temp=root;
        for(char ch:word.toCharArray())//building trie with dictionary wordss
        {
            int pos=ch-'a';
            if(temp.next[pos]==null)temp.next[pos]=new Trienode();
            temp=temp.next[pos];
        }
        temp.isEnd=true;
    }
    public void solve(String s)
    {
        int len=s.length();
        Queue<String[]> q=new LinkedList<>();
        q.add(new String[]{"","0"});
        outter:
        while(!q.isEmpty())
        {
            String[] arr=q.poll();
            int start=Integer.parseInt(arr[1]);//taking index
            Trienode temp=root;
            for(int i=start;i<len;i++)
            {
                int pos=s.charAt(i)-'a';
                temp=temp.next[pos];
                if(temp==null)continue outter;
                if(temp.isEnd&&i<len-1)q.add(new String[]{arr[0]+" "+s.substring(start,i+1),(i+1)+""});//adding for next index
            }
             if(temp.isEnd==true)
            {
                String t=arr[0]+" "+s.substring(start);//adding words of sequence
                res.add(t.substring(1));
            }
           
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        root=new Trienode();
        for(int i=0;i<wordDict.size();i++)
        {
            buildTrie(wordDict.get(i));
        }
        solve(s);
        return res;
    }
 
}
