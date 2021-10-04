import java.io.*;

public class threeBoxes {
    public static void main(String[] args) {
        try{    
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter output = new BufferedWriter( new OutputStreamWriter(System.out));
            int t=Integer.parseInt(br.readLine());
            String[] str=new String[t];
            while(t-->0){
                str[t]=br.readLine();
            }
            int j=str.length-1;
            while(j>=0){
                String[] s=str[j].trim().split(" ");
                output.write(getans( Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]))+"\n");
                j--;
            }
            output.flush();
        }catch(Exception e){
        }
    }
    public static int getans(int a,int b,int c,int d){
        int ans=-1;
        if((a+b+c)<=d){
            return 1;
        }
        else if(c+a<=d || c+b<=d || a+b<=d){
            ans=2;
        }
        else{
            ans=3;
        }
        return ans;
    }    
}
