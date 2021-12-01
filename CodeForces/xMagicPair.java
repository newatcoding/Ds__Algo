import java.util.Scanner;

public class xMagicPair {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        int t=scn.nextInt();
        while(t-->0){
            int a=scn.nextInt();
            int b=scn.nextInt();
            int x=scn.nextInt();
            if(x>a && x>b){
                System.out.println("NO");
                continue;
            }    
            int diff=Math.abs(a-b);
            if()
        }
        scn.close();
    }
}
