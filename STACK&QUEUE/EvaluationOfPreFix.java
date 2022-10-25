//appraoch-stack;

package evaluationofprefix;
import java.util.*;

public class EvaluationOfPreFix {
    static int EvaluatePreFix(String exp[])
    {
        Stack<Integer> stack=new Stack<>();
        List<String> op=new ArrayList<>();
        op.add("+");
        op.add("-");
        op.add("*");
        op.add("/");
        op.add("%");
        op.add("^");
        for(int i=exp.length-1;i>=0;i--)
        {
            if(op.contains(exp[i]))
            {
                int val1=stack.pop();
                int val2=stack.pop();
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
       System.out.println(EvaluatePreFix(exp));
       
    }
    
}
