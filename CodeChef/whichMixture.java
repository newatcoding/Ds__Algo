import java.io.*;

public class whichMixture {
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
                output.write(getans( Integer.parseInt(s[0]),Integer.parseInt(s[1]))+"\n");
                j--;
            }
            output.flush();
        }catch(Exception e){
        }
    }
    public static String getans(int a,int b){
        if(a>0 && b>0){
            return "Solution";
        }else if(b==0){
            return "Solid";
        }else{
            return "Liquid";
        }
    }   
}
