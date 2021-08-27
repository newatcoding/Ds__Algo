import java.util.Stack;

public class validStackSquences {
    public static void main(String[] args) {
        int[] pushed=new int[]{1,2,3,4,5};
        int[] popped=new int[]{4,5,3,2,1};  // 4,3,5,1,2

        Stack<Integer> st=new Stack<>();
        int c=0;
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(c<popped.length && st.size()>0 && st.peek()==popped[c]){
                st.pop();
                c++;
            }
        }
        System.out.println(st.size()==0);
    }
}
