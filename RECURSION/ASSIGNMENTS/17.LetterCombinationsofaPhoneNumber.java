//leetcode-17
//approach-recursion

class Solution {
    List<String> l=new ArrayList<>();
    void letterCombi(String options[],String currStr,int num)
    {
        if(num==0)//if num comes to zero then add the currStr
        {
            l.add(currStr);
            return;//backtrack
        }
        String s=options[num%10];//finding last digit(num%10);finidn combinaton for that
        for(int i=0;i<s.length();i++)
        {
            letterCombi(options,s.charAt(i)+currStr,num/10);//recursive call with currChar+currstr and num/10(for new digit)
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();//if not digits return empty list
        int ans=Integer.parseInt(digits);//converting string to number
        String options[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//initializinh the phone keypad
        letterCombi(options,"",ans);//function call
        return l;
        
    }
}
