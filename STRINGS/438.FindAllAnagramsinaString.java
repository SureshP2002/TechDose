//lc-438
//approach-hashing

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
      List<Integer> l=new ArrayList<>();
      if(s.length()<p.length())return l;//if the length of string s is lesser than string p
      int pHash[]=new int[26];//creating hash array for string p
      int sHash[]=new int[26];//creating hash array for string s
      for(int i=0;i<p.length();i++)
      {
          pHash[p.charAt(i)-'a']++;//finding frequencies
          sHash[s.charAt(i)-'a']++;//finding frequencies
      }
      if(Arrays.equals(pHash,sHash))//at first we check both array are equal
      {
          l.add(0);
      }
     int start=0;//from 0
     int end=p.length();//from p.length
        while(end<s.length())
        {
            sHash[s.charAt(start)-'a']--;//remove the start character frequency from the string shash array
            sHash[s.charAt(end)-'a']++;//add the end charcter frequency to the string shash array
            if(Arrays.equals(pHash,sHash))//if both arrays are equal
            {
                l.add(start+1);//add the starting index to the list
            }
            start++;//increment
            end++;
        }
        return l;
        
    }
}
