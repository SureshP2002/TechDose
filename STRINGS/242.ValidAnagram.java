//lc-242
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length())return false;
       int hash1[]=new int[126];
       int hash2[]=new int[126];
       for(int i=0;i<s.length();i++)
       {
           hash1[s.charAt(i)]++;//finding freq of s1
       }
       for(int i=0;i<t.length();i++)
       {
           hash2[t.charAt(i)]++;//finding freq of s2
       }
       for(int i=0;i<s.length();i++)
       {
           if(hash1[s.charAt(i)]!=hash2[s.charAt(i)])return false;//if both freq not equal
       }
       return true;
    }
}
