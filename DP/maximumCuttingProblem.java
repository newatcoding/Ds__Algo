import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class maximumCuttingProblem {
    
    public static int maxProd(int n){
        if (n == 0 || n == 1) return 0;
 
        int max_val = 0;
        for (int i = 1; i < n; i++)
        max_val = Math.max(max_val,
                  Math.max(i * (n - i),
                   maxProd(n - i) * i));
 
        return max_val;
    }

    static int maxProdSmart(int n) {
    
    if (n == 2 || n == 3) return (n-1);
 
    int res = 1;
    while (n > 4)
    {
        n -= 3;
         
    
        res *= 3;
    }
  
    return (n * res);
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        Instant t1 = Instant.now();

        //recursion
        System.out.print(maxProd(n)+" ");

        Instant t2 = Instant.now();
        Duration timeElapsed = Duration.between(t1, t2);
        System.out.println(timeElapsed.toNanos() +" ns");

        Instant t4 = Instant.now();

         //smart solution is cut in parts of 3 for maximum
        System.out.print(maxProdSmart(n)+" ");
       
        Instant t3 = Instant.now();
        Duration timeElapsed1 = Duration.between(t4, t3);

        System.out.println(timeElapsed1.toNanos() +" ns");
        scn.close();
    }
}
