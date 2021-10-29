import java.io.*;

public class yetAnotherMEXproblem {
    public static void main(String[] args) {
        try{    
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter output = new BufferedWriter( new OutputStreamWriter(System.out));
            int t=Integer.parseInt(br.readLine());
            String[][] str=new String[t][2];
            while(t-->0){
                str[t][0]=br.readLine();
                str[t][1]=br.readLine();
            }
            int j=str.length-1;
            while(j>=0){
                String[] s=str[j][0].trim().split(" ");
                String[] ar=str[j][1].trim().split(" ");
                int n=Integer.parseInt(s[0]);
                int k=Integer.parseInt(s[1]);
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=Integer.parseInt(ar[i]);
                }
                // output.write(getans(n,k,arr)+"\n");
                j--;
            }
            output.flush();
        }catch(Exception e){
        }
    }
    // public static int getans(int n,int k,int[] arr){
    //     // int ans=-1;
    //     // if((a+b+c)<=d){
    //     //     return 1;
    //     // }
    //     // else if(c+a<=d || c+b<=d || a+b<=d){
    //     //     ans=2;
    //     // }
    //     // else{
    //     //     ans=3;
    //     // }
    //     // return ans;
    // }    
}
