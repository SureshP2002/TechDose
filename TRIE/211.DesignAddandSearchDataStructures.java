//lc-211

class WordDictionary {
    Trienode root=null;
    class Trienode{//trie class
       Trienode next[]=new Trienode[26];
       int wordend;

    }

    public WordDictionary() {
        root=new Trienode();
        
    }
    
    public void addWord(String word) {
        Trienode temp=root;
        for(char ch:word.toCharArray())//adding word
        {
            int pos=ch-'a';
            if(temp.next[pos]==null)
            {
                temp.next[pos]=new Trienode();
            }
            temp=temp.next[pos];
             
        }
        temp.wordend++;
       
    }
    public boolean isPresent(String word,int index,Trienode temp)
    {
        if(index==word.length())return temp.wordend>0;//if it reaches the end check whether the wordend count greater then 0
        char ch=word.charAt(index);
        if(ch=='.')//if char is '.' check with any char to form word and check if the word is prest in trie
        {
            for(int i=0;i<26;i++)
            {
                if(temp.next[i]!=null&&isPresent(word,index+1,temp.next[i]))return true;
            }
        }
        else if(temp.next[ch-'a']!=null) return isPresent(word,index+1,temp.next[ch-'a']);//if temp.next is not null goto next char
        return false;//if nul return false
    }
    
    public boolean search(String word) {
       return isPresent(word,0,root);
        
        
    }
}
