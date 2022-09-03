package day4NumberTheory;
import java.util.*;

public class FactorsOfnumbers {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> factors=new ArrayList<>();//creating an list for storing elements;
        for(int i=1;i*i<=n;i++)//iterating through root n times;
        {
            if(n%i==0)//checking if n is divisible by i;
            {
                factors.add(i);//adding that i to list;
                if((i*i)!=n)//checking for root n to n/2;
                {
                    factors.add(n/i);//adding it to list
                }
            }
        }
        Collections.sort(factors);//sorting the list
        System.out.print(factors);
    }
    
}
