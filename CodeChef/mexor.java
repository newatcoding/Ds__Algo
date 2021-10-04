import java.io.*;

public class mexor {
    public static void main(String[] args) {
        try{    
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter output = new BufferedWriter( new OutputStreamWriter(System.out));
            int t=Integer.parseInt(br.readLine());
            int[] str=new int[t];
            while(t-->0){
                str[t]=Integer.parseInt(br.readLine());
            }
            int j=str.length-1;
            while(j>=0){
                
                output.write(getans(str[j])+"\n");
                j--;
            }
            output.flush();
        }catch(Exception e){
        }
    }
    public static long getans(int n){
        if(n==0){
            return 1;
           }else if(n==1){
            return 2;
           }else if(n==2){
            return 2;
           }else{
               long ans=1;
               while(2*ans<=n){
                    ans*=2;
               }
               if(ans==n){
                    return (n);
               }else if(n==(2*ans-1)){
                   return n+1;
               }else{
                    return ans;
               }
           }
    }
}
