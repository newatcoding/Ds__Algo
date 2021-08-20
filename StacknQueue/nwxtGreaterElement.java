import java.util.Stack;

public class nwxtGreaterElement {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,3};
        
        int[] ans1=nge(arr);

        //circular array
        int[] ans2=nge2(arr);

        for(int val: ans1){
            System.out.print(val+" ");
        }
        System.out.println(" ");
        for(int val: ans2){
            System.out.print(val+" ");
        }
    }
    public static int[] nge(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                int idx=st.pop();
                ans[idx]=arr[i];
            }
            st.push(i);
        }
        return ans;
    }   
    public static int[] nge2(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for(int i1=0;i1<arr.length*2;i1++){
            int i=i1%arr.length;
            if(i1>=arr.length){
                while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                    int idx=st.pop();
                    ans[idx]=arr[i];
                }
                if(i==st.peek()){
                    break;
                }
            }else{
                while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                    int idx=st.pop();
                    ans[idx]=arr[i];
                }
                st.push(i);
            }
           
        }
        return ans;
    }
}
