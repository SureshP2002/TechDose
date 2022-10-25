//approach-stack
package evaluationofpostfixexp;
import java.util.*;
import java.lang.*;

public class EvaluationOfPostFixExp {
    static int EvaluatePostFix(String exp[])
    {
        Stack<Integer> stack=new Stack<>();
        List<String> op=new ArrayList<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");
        op.add("%");
        op.add("^");
        for(int i=0;i<exp.length;i++)
        {
            if(op.contains(exp[i]))
            {
                int val2=stack.pop();
                int val1=stack.pop();
                switch(exp[i])
                {
                    case "+":
                        stack.push(val1+val2);
                        break;
                    case  "-":
                        stack.push(val1-val2);
                        break;
                    case "*":
                        stack.push(val1*val2);
                        break;
                    case "/":
                        stack.push(val1/val2);
                        break;
                    case "%":
                        stack.push(val1%val2);
                        break;
                    default:
                        break;
                }
            }
            else
            {
                stack.push(Integer.parseInt(exp[i]));
            }
        }
        return stack.pop();
    }
 public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     String exp[]=sc.nextLine().split(" ");
     System.out.println(EvaluatePostFix(exp));
       
    }
    
}
