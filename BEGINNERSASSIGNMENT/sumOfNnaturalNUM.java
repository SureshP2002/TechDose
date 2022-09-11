package BEGINNERSASSIGNMENT;
import java.util.*;

public class sumOfNnaturalNUM {
    int find(int n)
    {
        if(n==1)return 1;
        else return n+(find(n-1));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sumOfNnaturalNUM s=new sumOfNnaturalNUM();
        int sum=s.find(n);
        System.out.println(sum);
    }
    
}
