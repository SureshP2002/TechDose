//TC-O(n)
//approach-trie


package countdistinctsubstring;
class CountDistinctSubstring {
    public static TrieNode root=null;
    public static int count=0;
 class TrieNode{
     TrieNode next[]=new TrieNode[26];
}
public  static void build(String a)
{
    TrieNode temp=root;
    for(int i=0;i<a.length();i++)
    {
        int pos=a.charAt(i)-'a';
        if(temp.next[pos]==null)
        {
            CountDistinctSubstring obj=new CountDistinctSubstring();
            temp.next[pos]=obj.new TrieNode();
            count=count+1;
        }
        temp=temp.next[pos];
    }
    
}
public static void main(String[] args) {
        String s="abcde"; 
        CountDistinctSubstring obj=new CountDistinctSubstring();
        root=obj.new TrieNode();
        for(int i=0;i<s.length();i++)
        {
            build(s.substring(i));
        }
        System.out.println(count+1);
        
    }
    
}
