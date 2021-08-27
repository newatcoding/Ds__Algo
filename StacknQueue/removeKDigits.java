import java.util.ArrayDeque;
import java.util.Deque;

public class removeKDigits {
    public static void main(String[] args) {
        String num="10000000100";
        int k=2;
        Deque<Character> dq=new ArrayDeque<>();
        for(char ch:num.toCharArray()){
            while(dq.size()>0 && k>0 && dq.peekLast()>ch){
                dq.pollLast();
                k--;
            }
            dq.addLast(ch);
        }
        while(k-->0){
            dq.pollLast();
        }
        StringBuilder sb=new StringBuilder();
        boolean zeroAllowed=false;
        while(dq.size()>0){
            char ch=dq.pollFirst();
            if(ch=='0'&& !zeroAllowed){
                continue;
            }
            if(ch!='0' && !zeroAllowed){
                zeroAllowed=true;
            }
            sb.append(ch);
        }
        if(sb.length()==0){
            sb.append(0);
        }
        System.out.println(sb.toString());
    }   
}
