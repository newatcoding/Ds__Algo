import java.util.Scanner;

public class twoWaterJug {
    
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static int waterjug(int n,int m,int d){
        if (m > n){
            m=m+n;
            n=m-n;
            m=m-n;
        }
        if (d > n) 
            return -1; 
        if ((d % gcd(n,m)) != 0) 
            return -1; 

         return Math.min(pour(n,m,d),pour(m,n,d));   
    }

    static int pour(int fromCap, int toCap, int d){    
        int from = fromCap; 
        int to = 0; 
        int step = 1; 
      
        while (from != d && to != d){ 
            
            int temp = Math.min(from, toCap - to); 
            to   += temp; 
            from -= temp; 
            step++; 
            if (from == d || to == d) 
                break; 
            if (from == 0){ 
                from = fromCap; 
                step++; 
            } 
            if (to == toCap){ 
                to = 0; 
                step++; 
            } 
        } 
        return step; 
    } 
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int m=scn.nextInt();
        int n=scn.nextInt();
        int k=scn.nextInt();
        System.out.println(waterjug(n,m,k));

        scn.close();
    }
}
