import java.util.*;

public class ToggleCasesUpperLower {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        char ch=sc.next().charAt(0);
        System.out.printf("%c",ch^(1<<5));
        //System.out.printf("%c",ch|(1<<5));  toLowerCase;
        //System.out.printf("%c",ch&(~(1<<5))); toUpperCase;
    }
    
}
