import java.util.Scanner;

//round 117
public class specialPermutation {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int n=scn.nextInt();
            int a=scn.nextInt();
            int b=scn.nextInt();
            int half=n/2;
            if(n-a+1<half ||(n-a+1==half && b>a ) || b<half ||(b==half && a<b)){
                System.out.println("-1");
                continue;
            }    
            int[] ans=new int[n];
            int val=n;
            for(int i=0;i<half-1;i++){
                if(val==b){
                    val--;
                    
                }
                ans[i]=val;
                val--;
            }
            ans[half-1]=a;
            int v2=1;
            boolean wrong=false;
            for(int i=half;i<n-1;i++){
                if(v2==a){
                    v2++;
                }
                if(v2==val+1){
                    wrong=true;
                    break;
                }
                ans[i]=v2;
                v2++;
            }
            ans[n-1]=b;
            if(wrong){
                System.out.println("-1");
                continue;
            }
            for(int i=0;i<n;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
        scn.close();
    }
}
