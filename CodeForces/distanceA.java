import java.util.*;

//round 117
public class distanceA {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int x=scn.nextInt();
            int y=scn.nextInt();
            int dist=Math.abs(x-0)+Math.abs(y-0);
            if(dist%2!=0){
                System.out.println("-1 -1");
                continue;
            }
           
            int a1=x%2==0?x/2:(x+1)/2;
            int a2=y%2==0?y/2:(y-1)/2;
            System.out.println(a1+" "+a2);
        }
        scn.close();
    }
}
