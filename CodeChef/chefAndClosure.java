import java.io.*;

public class chefAndClosure {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String[] s=br.readLine().trim().split(" ");
                String[] inp=br.readLine().trim().split(" ");
                int n=Integer.parseInt(s[0]);
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=Integer.parseInt(inp[i]);
                }
                int big=0;
                int negative=0;
                int one=0;
                boolean notMulti=false;
                for(int i=0;i<n;i++){
                    if(arr[i]>1|| arr[i]<-1){
                        big++;
                        if(big>1){
                            notMulti=true;
                            break;
                        }
                    }
                    else{
                        if(arr[i]==-1 ){
                            negative++;
                        }else if(arr[i]==1){
                             one++;
                        }
                    }
                }
                if(notMulti || (negative>0 && big>0) || (negative>1 && one==0))
                    System.out.println(0);
                else
                    System.out.println(1);
            }
        }catch(Exception e){

        }
    }
}
