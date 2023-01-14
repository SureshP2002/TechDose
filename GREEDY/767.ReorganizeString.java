//lc-767
//approach-greedy


class Solution {
    public String reorganizeString(String s) {
        int hash[]=new int[26];
        int max=Integer.MIN_VALUE;
        int letter=-1;;
        for(int i=0;i<s.length();i++)
        {
            hash[s.charAt(i)-'a']++;//finding frequency
        }
        for(int i=0;i<26;i++)
        {
            if(hash[i]>max)
            {
                max=hash[i];//finding max
                letter=i;//max freq letter
            }
        }
        if(max>(s.length()+1)/2)return "";//if max=4 && s.length()==3-->(3+1)/2==2 so not possible to fill the all char 
        char res[]=new char[s.length()];
        int index=0;
        while(hash[letter]-->0)
        {
            res[index]=(char)(letter+'a');//filling the max ocuur char first in the array
            index+=2;
        }
        for(int i=0;i<26;i++)
        {
            while(hash[i]-->0)
            {
                if(index>=s.length())index=1;//if index reches end then start from odd index (if max char or not completely filled)
                res[index]=(char)(i+'a');//adding char
                index+=2;
                

            }
        }
        return String.valueOf(res);
    }
}
