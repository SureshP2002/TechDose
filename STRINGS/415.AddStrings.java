//school calculting straight approach


class Solution {
    public String addStrings(String num1, String num2) {
     StringBuilder sb=new StringBuilder();
     int a=num1.length();
     int b=num2.length();
     int ans=0;
     int carry=0;
     for(int i=(a>=b)?a-1:b-1;i>=0;i--)
     {
        ans=carry+ans;
        if(a>0)
        {
            a--;
            ans+=(num1.charAt(a)-'0');
            
        }
        if(b>0)
        {
            b--;
            ans+=(num2.charAt(b)-'0');
            
        }
        carry=ans/10;
        sb.append(ans%10);
        ans=0;
     }
     if(carry>0) sb.append(carry);
     return sb.reverse().toString();
    }
}
