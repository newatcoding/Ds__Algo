import java.util.*;

public class sortAStack {
   public static void main(String[] args) {
        // int n=5;   
        int[] arr={11 ,2 ,32 , 3,41};
        Stack<Integer> s=createStack(arr);
        s=sort(s);
        printStack(s);
   } 
   public static Stack<Integer> createStack(int[] arr){
        Stack<Integer> s=new Stack<>();
        for(int val:arr){
            s.push(val);
            
        }
        return s;
   } 
   private static void printStack(Stack<Integer> s){
        for(int val:s){
            System.out.print(val+" ");
        }
   }
   public static Stack<Integer> sort(Stack<Integer> s)
	{
		if(s == null || s.isEmpty()) {
		    return s;
		}
		
		Stack<Integer> s1 = new Stack<>();
		Integer topS = null;
		while (!s.isEmpty()) {
		    topS = s.pop();
		    while(!s1.isEmpty() && topS < s1.peek()) {
		            s.push(s1.pop());
		    }
		    s1.push(topS);
		}
		
		return s1;
	}
}
