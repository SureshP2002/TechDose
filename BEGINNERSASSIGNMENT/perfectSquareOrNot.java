package BEGINNERSASSIGNMENT;
import java.util.*;
import java.math.*;

public class perfectSquareOrNot {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double square=Math.sqrt(n);//finding square root of number;
        double FLOOR=Math.floor(square);//finding floor for square which will give largest closest positive integer that is <= square
        if((square-FLOOR)==0.0)
        {
            System.out.print("PREFECT SQUARE");
        }
        else
        {
            System.out.print("NOT A PERFECT SQUARE");
        }
    }
    
}
