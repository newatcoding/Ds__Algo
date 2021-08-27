import java.util.Scanner;

public class MochaandHiking {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                int[] arr=new int[n+1];
                for(int i=1;i<=n;i++){
                    arr[i]=scn.nextInt();
                }
                if(arr[1]==1){
                    System.out.print((n+1)+" ");
                    for(int i=1;i<=n;i++){
                        System.out.print(i+" ");
                    }
                    System.out.println();
                    continue;
                }
                boolean fnd=false;
                for(int i=1;i<n;i++){
                    if(arr[i]==0 && arr[i+1]==1){
                        
                        for(int j=1;j<=i;j++){
                            System.out.print(j+" ");
                        }
                        System.out.print((n+1)+" ");
                        for(int j=i+1;j<=n;j++){
                            System.out.print(j+" ");
                        }
                        fnd=true;
                    }
                }
                if(!fnd){
                    for(int i=1;i<=n;i++){
                        System.out.print(i+" ");
                    }
                    System.out.print((n+1)+" ");
                }
                System.out.println();
                
            }
            scn.close();
        }catch(Exception e){

        }
    }
}
