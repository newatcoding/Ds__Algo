import java.util.*;

public class balance {
    public static void main(String[] args) {
        String s="{[(][(]))}";
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        char[] ans=s.toCharArray();
        int i=0;
        for(char ch:s.toCharArray()){
            if(ch=='[' || ch=='{' || ch=='('){
                st.push(i);
            }else{
                if(ch==']'){
                    if(s.charAt(st.peek())=='[' ){
                        st.pop();
                    }else{
                        int idx=st.pop();
                        ans[idx]='[';
                    }
                }else if(ch=='}'){
                    if(s.charAt(st.peek())=='{' ){
                        st.pop();
                    }else{
                        int idx=st.pop();
                        ans[idx]='{';
                    }
                }else{
                    if(s.charAt(st.peek())=='(' ){
                        st.pop();
                    }else{
                        int idx=st.pop();
                        ans[idx]='(';
                    }
                }
            }
            i++;
        }

        System.out.println(String.valueOf(ans));
    }
}
