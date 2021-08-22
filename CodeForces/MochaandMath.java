import java.util.Scanner;

public class MochaandMath {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                int[] arr =new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=scn.nextInt();

                }
                int andforall=arr[0];
                for(int i=1;i<n;i++){
                    andforall&=arr[i];
                }
                System.out.println(andforall);
            }
            scn.close();
        }catch(Exception e){
 
        }
    }
}
