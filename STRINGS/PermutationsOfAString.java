//Recursion


class Solution {
    static List<String> l;
    public static  List<String> find_permutation(String s) {
        l=new ArrayList<>();
         permut(s,0,s.length()-1);
         Collections.sort(l);
         return l;
    }
    public static  void permut(String s,int left,int right)
    {
        if(left==right)
        {
            if(!l.contains(s)){
            l.add(s);
            }
            return ;
        }
        for(int i=left;i<=right;i++)
        {
            s=swap(s,i,left);
            permut(s,left+1,right);
            s=swap(s,i,left);
        }
        
    }
    public static String swap(String s,int a,int b)
    {
       char arr[]=s.toCharArray();
       char c=arr[a];
       arr[a]=arr[b];
       arr[b]=c;
       return String.valueOf(arr);
    }
    
}
