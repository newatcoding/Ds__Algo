import java.io.*;

public class differentString {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String[] s=br.readLine().trim().split(" ");
                
                int n=Integer.parseInt(s[0]);
                String[] inp=new String[n];
                for(int i=0;i<n;i++){
                    inp[i]=br.readLine().trim();
                }
                StringBuilder sb=new StringBuilder(n);
                for(int i=0;i<n;i++){
                    char ch=inp[i].charAt(i);
                    if(ch=='0'){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                }
                System.out.println(sb.toString());
            }
        }catch(Exception e){

        }
    }
}
