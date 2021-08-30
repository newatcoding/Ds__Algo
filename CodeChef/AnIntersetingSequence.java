import java.util.Scanner;

public class AnIntersetingSequence {
    
    static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
    public static int getGCDSum(int k){
      
        int sum=0;
        int prev=0;
        for(int i=1;i<2*k+1;i++){
            prev=gcd((k+(i*i)),i*2+1);
            sum+=prev;

        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int k=scn.nextInt();
        System.out.println(getGCDSum(k));
        scn.close();
    }
}
