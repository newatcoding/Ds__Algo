
import java.io.*;
import java.util.*;

public class maxNminOfSizeK {
    
    public static int maxMinofSizeK(int[] arr,int n,int k){
        Deque<Integer> S=new LinkedList<>(),G=new LinkedList<>();
        int i=0;
        int sum = 0;
        for( i=0;i<k;i++){    
            while(!S.isEmpty() && arr[S.peek()]>=arr[i]){
                S.removeLast();
            }   
            while(!G.isEmpty() && arr[G.peek()]<=arr[i]){
                G.removeLast();
            }
            S.addLast(i);
            G.addLast(i);
        }

        for(;i<n;i++){
            sum += arr[S.peekFirst()] + arr[G.peekFirst()];

            while ( !S.isEmpty() && S.peekFirst() <= i - k)
                S.removeFirst();
            while ( !G.isEmpty() && G.peekFirst() <= i - k)
                G.removeFirst();
   
            while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i])
                S.removeLast(); 
   
        
            while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i])
                G.removeLast(); 
   
            G.addLast(i);
            S.addLast(i);
        }
        sum += arr[S.peekFirst()] + arr[G.peekFirst()];
        return sum;

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] nk=br.readLine().trim().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        String[] str=br.readLine().trim().split(" ");
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(maxMinofSizeK(arr,n,k));
    }
}
