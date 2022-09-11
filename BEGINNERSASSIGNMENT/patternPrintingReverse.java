package BEGINNERSASSIGNMENT;
import java.util.*;
import java.util.Scanner;

public class patternPrintingReverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=n-i+1;j>=1;j--)
            {
                System.out.print(j);

            }
            System.out.println();
        }
    }
    
}
