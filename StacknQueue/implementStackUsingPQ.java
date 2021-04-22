import java.util.*;
// import java.io.*;

public class implementStackUsingPQ {
    static class QueueStack{
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        private int top;

        public QueueStack(){
            q1=new LinkedList<>();
            q2=new LinkedList<>();
        }

        public void push(int x) {
            q2.add(x);
            top = x;
            while (!q1.isEmpty()) {                
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        
        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int ans=q1.remove();
            if (!q1.isEmpty()) {
                top = q1.peek();
            }
            return ans;
        }
        
        /** Get the top element. */
        public int top() {
            return top;
        }
        
        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    
    public static void main (String[] args) {
        QueueStack obj = new QueueStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        // int param_2 = obj.pop();
        // int param_3 = obj.top();
        // boolean param_4 = obj.empty();
    }
}
