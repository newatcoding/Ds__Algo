import java.io.*;
import java.util.HashMap;

public class equalDIfference {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String[] s=br.readLine().trim().split(" ");
                String[] inp=br.readLine().trim().split(" ");
                int n=Integer.parseInt(s[0]);
                if(n<=2){
                     System.out.println(0);
                     continue;
                }
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=Integer.parseInt(inp[i]);
                }
                HashMap<Integer,Integer> map=new HashMap<>();
                // int max=-1;
                int freq=0;
                for(int i=0;i<n;i++){
                    map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                    if(map.get(arr[i])>freq){
                        // max=arr[i];
                        freq=map.get(arr[i]);
                    }
                }
                System.out.println(n-(freq>1?freq:2));
                
            }
        }catch(Exception e){

        }
    }
}
