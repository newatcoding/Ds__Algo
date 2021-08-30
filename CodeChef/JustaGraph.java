import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class JustaGraph {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine().trim());
            while(t-->0){
                int n=Integer.parseInt(br.readLine().trim());
                String[] inp=br.readLine().trim().split(" ");
                HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
                int[] weight=new int[n+1];
                for(int i=0;i<n;i++){
                    weight[i+1]=Integer.parseInt(inp[i]);
                    map.put(weight[i+1]-(i+1), new ArrayList<>());
                }
                for(int i=1;i<=n;i++){
                    map.get(weight[i]-i).add(i);
                }
                for(int val:map.keySet()){
                    System.out.println(map.get(val).size());
                    break;

                }
            }
        }catch(Exception e){

        }
    }
}
