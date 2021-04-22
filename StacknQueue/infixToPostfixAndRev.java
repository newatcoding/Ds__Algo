import java.util.Scanner;
import java.util.*;

public class infixToPostfixAndRev {
    static int Prec(char ch)
    {
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
       
        case '*':
        case '/':
            return 2;
       
        case '^':
            return 3;
        }
        return -1;
    }
    public static String infToPost(String str){
        String ans="";
        Stack<Character> st=new Stack<>();
        for(char ch : str.toCharArray()){

            if(Character.isLetterOrDigit(ch)){
                ans+=ch;
            }else if(ch=='('){
                st.push('(');
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }else{
                int level=Prec(ch);
                while(!st.isEmpty() && level<=Prec(st.peek())){
                    ans+=st.pop();
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()){
            if(st.peek() == '(')
                return "Invalid Expression";
                ans += st.pop();
         }
      

        return ans;
    }
    
    static boolean isOperand(char x){
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }
    public static String postToInf(String exp){
        Stack<String> s = new Stack<String>();
  
        for (int i = 0; i < exp.length(); i++)
        {
            // Push operands
            if (isOperand(exp.charAt(i))){
                s.push(exp.charAt(i) + "");
            }else{
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push("(" + op2 + exp.charAt(i) +
                        op1 + ")");
            }
        }
    
        return s.peek();
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.next();

        String post=infToPost(str);
        System.out.println(post);
        System.out.println(postToInf(post));

        scn.close();

    }
}
