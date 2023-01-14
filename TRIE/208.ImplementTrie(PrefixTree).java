//LC-208


class Trie {
    Trienode root=null;
    class Trienode{//trie class
        Trienode next[]=new Trienode[26];//every node 26 pointer
        int wordEnd;//wordend pointer
        int pc;//prefix count

    }
    public Trie() {
        root=new Trienode();//creating root
       
     
    }
    
    public void insert(String word) {
        Trienode temp=root;
        for(char ch:word.toCharArray())//inserting words
        {
            int pos=ch-'a';
            if(temp.next[pos]==null)
            {
                temp.next[pos]=new Trienode();
                
            }
            temp.pc++;
            temp=temp.next[pos];

        }
        temp.wordEnd++;
        
    }
    
    public boolean search(String word) {
        Trienode temp=root;
        for(char ch:word.toCharArray())//searching words
        {
            int pos=ch-'a';
            if(temp.next[pos]==null)return false;
            temp=temp.next[pos];
        }
        return temp.wordEnd>=1;
    }
    
    public boolean startsWith(String prefix) {
        Trienode temp=root;
        for(char ch:prefix.toCharArray())//checking prefix
        {
            int pos=ch-'a';
            if(temp.next[pos]==null)return false;
            temp=temp.next[pos];
        }
        return  true;
    }
}
