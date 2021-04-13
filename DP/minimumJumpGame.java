import java.util.*;
// import java.lang.*;
import java.io.*;

public class minimumJumpGame {
    
    public static  int jump(int[] nums) {
        int a=0;
        int currpath=0;
        int currend=0;
        for(int i=0;i<nums.length-1;i++){
            currpath=Math.max(currpath,i+nums[i]);
            if(i==currend){
                a++;
                currend=currpath;
            }
        }
        
        return a;
    }

    public static boolean canReach(int[] arr, int start) {
        if(arr[start]==0){
            return true;
        }
        
        Queue<Integer> que=new LinkedList<>();
        boolean[] vis=new boolean[arr.length];
        que.add(start);
        vis[start]=true;
        while(!que.isEmpty()){
            int pos=que.remove();
            if(arr[pos]==0){
                return true;
            }
      
            int p1=pos+arr[pos];
            int p2=pos-arr[pos];
            if((p1<arr.length &&arr[p1]==0) || (p2>=0 &&arr[p2]==0)){
                return true;
            }
            if(p1<arr.length && !vis[p1]){
                que.add(p1);
                vis[p1]=true;
            }    
            if(p2>=0 && !vis[p2]){
                vis[p2]=true;
                que.add(p2);
            }  
        }
        
        return false;
    }   
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().trim().split(" ");
        
        int[] jumps=new int[str.length];
        for(int i=0;i<jumps.length;i++){
            jumps[i]=Integer.parseInt(str[i]);
        }
        //moveement from i to any point till i+arr[i];
        System.out.println(jump(jumps)+"  ");

        // movement is i+arr[i] || i-arr[i];
        System.out.print(canReach(jumps,2));

      
    }
}
