import java.util.ArrayDeque;
import java.util.Deque;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] arr={ 1,3,-1,-3,5,3,6,7};
        int a=0;
        int k=3;
        int[] ans=new int[arr.length-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            while(!dq.isEmpty() && dq.peek()<i-k+1){
                dq.poll();
            }

            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.add(i);
            if(i>=k-1){
                ans[a++]=arr[dq.peekFirst()];
            }
        }
        for(int val:ans){
            System.out.print(val+" ");
        }
        
    }
}
