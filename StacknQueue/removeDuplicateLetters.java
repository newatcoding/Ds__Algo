import java.util.Scanner;
import java.util.Stack;

public class removeDuplicateLetters {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        boolean[] vis=new boolean[26];
        int[] res=new int[26];

        char[] ch=str.toCharArray();
        for(char c:ch){
            res[c-'a']++;    
        }
        Stack<Character> st=new Stack<>();
        for(char s:ch){
            res[s-'a']--;
            if(vis[s-'a']==true){
                continue;
            }
            while(st.size()>0 && s<st.peek() && res[st.peek()-'a']!=0){  
                vis[st.pop()-'a']=false;
            }
            st.push(s);
            vis[s-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
   
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        System.out.println(sb.toString());
        scn.close();
    }
}
