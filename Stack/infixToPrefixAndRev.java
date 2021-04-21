import java.util.Scanner;
import java.util.Stack;

public class infixToPrefixAndRev {

    static boolean isalpha(char c)
    {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
        {
        return true;
        }
        return false;
    }
 
    static boolean isdigit(char c)
    {
        if (c >= '0' && c <= '9')
        {
        return true;
        }
        return false;
    }
    
    static boolean isOperator(char c)
    {
        return (!isalpha(c) && !isdigit(c));
    }
 
    static int getPriority(char C)
    {
        if (C == '-' || C == '+')
        return 1;
        else if (C == '*' || C == '/')
        return 2;
        else if (C == '^')
        return 3;
    
        return 0;
    }
    static String reverse(char str[], int start, int end)
    {
    
        // Temporary variable to store character
        char temp;
        while (start < end)
        {
    
        // Swapping the first and last character
        temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        start++;
        end--;
        }
        return String.valueOf(str);
    }
    
    public static String infixToPostfix(char[] infix1)
    {
        System.out.println(infix1);
        String infix = '(' + String.valueOf(infix1) + ')';
    
        int l = infix.length();
        Stack<Character> char_stack = new Stack<>();
        String output="";
    
        for (int i = 0; i < l; i++)
        {
    
        if (isalpha(infix.charAt(i)) || isdigit(infix.charAt(i)))
            output += infix.charAt(i);
    
        else if (infix.charAt(i) == '(')
            char_stack.add('(');
    
      
        else if (infix.charAt(i) == ')')
        {
            while (char_stack.peek() != '(')
            {
            output += char_stack.peek();
            char_stack.pop();
            }
    
            char_stack.pop();
        }
    
        // Operator found
        else {
            if (isOperator(char_stack.peek()))
            {
            while ((getPriority(infix.charAt(i)) <
                    getPriority(char_stack.peek()))
                    || (getPriority(infix.charAt(i)) <=
                        getPriority(char_stack.peek())
                        && infix.charAt(i) == '^'))
            {
                output += char_stack.peek();
                char_stack.pop();
            }
    
         
            char_stack.add(infix.charAt(i));
            }
        }
        }
        return output;
    }
    public static String infToPre(String str){
      
        char[] infix=str.toCharArray();
        int l = infix.length;

        String infix1 = reverse(infix, 0, l - 1);
        infix = infix1.toCharArray();
    
        for (int i = 0; i < l; i++)
        {
    
        if (infix[i] == '(')
        {
            infix[i] = ')';
            i++;
        }
        else if (infix[i] == ')')
        {
            infix[i] = '(';
            i++;
        }
        }
    
        String prefix = infixToPostfix(infix);
    
        // Reverse postfix
        prefix = reverse(prefix.toCharArray(), 0, l-1);
    
        return prefix;
    }

    public static String preToInf(String str){
        Stack<String> stack = new Stack<>();
        int l = str.length();
        for(int i = l - 1; i >= 0; i--)
        {
            char c = str.charAt(i);
            if (isOperator(c))
            {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp =  op1 + c + op2 ;
                stack.push(temp);
            }
            else
            {
           
                stack.push(c + "");
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        // String pre=infToPre(str);

        // System.out.println(pre);
        System.out.println(preToInf(str));

        scn.close();
    }
}
