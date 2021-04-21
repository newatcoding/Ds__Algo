import java.util.Scanner;
import java.util.Stack;

public class postfixEvaluation {
    
    public static int postEval(String str){
        Stack<Integer> st=new Stack<>();
	    
	    for(int i=0;i<str.length();i++){
	        char c=str.charAt(i);
	        
	        if(Character.isDigit(c)){
	            st.push(c-'0');
	        }
	        else{
	            int v1=st.pop();
	            int v2=st.pop();
	            switch(c){
	                case '+':
	                    st.push(v2+v1);
	                    break;
	                case '-':
	                    st.push(v2-v1);
	                    break;
	                case '/':
	                    st.push(v2/v1);
	                    break;
	                case '*':
	                    st.push(v2*v1);
	                    break;
	            }
	        }
	    }
	    return st.pop();
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        System.out.println(postEval(str));
        scn.close();
    }
}
