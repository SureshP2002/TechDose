//leetcode-392;
//TC-O(N)

class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for(int i=0;i<t.length()&&j<s.length();i++)//checking upto less than length()
        {
            if(t.charAt(i)==s.charAt(j))j++;//if both  characters are equal means
        }
        return j==s.length();//if j length is equal to s.length() return true;
        
    }
}

/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) 
of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.*/
