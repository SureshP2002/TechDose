//LC-2185

class Solution {
    Trienode root=null;
    class Trienode{//class trie
        Trienode next[]=new Trienode[26];//child 26
        int pc;
    }

    public void buildTrie(String word)
    {
        Trienode temp=root;
        for(char ch:word.toCharArray())//adding words in trie
        {
            int pos=ch-'a';
            if(temp.next[pos]==null)temp.next[pos]=new Trienode();
            temp=temp.next[pos];
            temp.pc++;
        }
    }
    public int CountPrefix(String pre)
    {
        Trienode temp=root;
        int count=0;
        for(char ch:pre.toCharArray())//counting prefix
        {
            if(temp.next[ch-'a']==null)return 0;//if next is null return 0
            temp=temp.next[ch-'a'];

            
        }
        return temp.pc;//if prefix is found return the count
    }
    public int prefixCount(String[] words, String pref) {
        root=new Trienode();
        for(int i=0;i<words.length;i++)
        {
            buildTrie(words[i]);//sending words
        }
   
        return  CountPrefix(pref);
    }
}
