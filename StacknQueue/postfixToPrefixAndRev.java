import java.util.*;
// import java.io.*;

public class postfixToPrefixAndRev {

    static boolean isOperator(char x)
    {
 
        switch (x) {
        case '+':
        case '-':
        case '/':
        case '*':
            return true;
        }
        return false;
    }

    public static String postToPre(String str){
       
        Stack<String> s = new Stack<String>();
        for(char ch: str.toCharArray()){
            if(isOperator(ch)){
                String s1=s.pop();
                String s2=s.pop();
                String temp=ch+s2+s1;
                s.push(temp);
            }else{
                s.push(ch+"");
            }
        }

        String ans="";
        for (String i : s)
            ans += i;
        
        return ans;
    }

    public static String preToPost(String pre_exp){
     
        Stack<String> s = new Stack<String>();
 
        
        int length = pre_exp.length();
 
    
        for (int i = length - 1; i >= 0; i--)
        {
      
            if (isOperator(pre_exp.charAt(i)))
            {
         
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
 
         
                String temp = op1 + op2 + pre_exp.charAt(i);
 
          
                s.push(temp);
            }
 
            else {
            
                s.push(pre_exp.charAt(i) + "");
            }
        }
 
        return s.peek();
      
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();

        String pre=postToPre(str);

        System.out.println(pre);
        System.out.println(preToPost(pre));
        scn.close();
    }
}
