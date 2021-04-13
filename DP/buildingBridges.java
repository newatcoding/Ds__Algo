import java.util.*;

import java.io.*;

public class buildingBridges {
    static class Pair {
        int n;
        int s;
        public Pair(int a,int b){
            n=a;
            s=b;
        }  
    }
   
    static int maxBridges(Pair[] values, int n){
        int[] lis=new int[n];
        for (int i=0; i<n; i++)
            lis[i] = 1;
      
        for (int i=1; i<n; i++)
            for (int j=0; j<i; j++)
                if (values[i].n >= values[j].n 
                    && lis[i] < 1 + lis[j])
                    lis[i] = 1 + lis[j];
            
            
        int max = lis[0];
        for (int i=1; i<n; i++)
            if (max < lis[i])
                max = lis[i];
   
        return max;        
    }
    public static void main(String[] args ) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().trim().split(" ");
        String[] str1=br.readLine().trim().split(" ");
        
        Pair[] arr=new Pair[str.length];
        for(int i=0;i<str.length;i++){
            Pair temp=new Pair(Integer.parseInt(str[i]),Integer.parseInt(str1[i]));
            arr[i]=temp;
        }
        Arrays.sort(arr,new Comparator<Pair>(){
            @Override
            public  int  compare(Pair x,Pair y){
                if(x.s==y.s){
                    return x.n-y.n;
                }
                return x.s-y.s;
            }
        });
        System.out.println(maxBridges(arr, arr.length));

    }
}
