import java.io.*;

public class digitaRemoval {
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
                String n=s[0];
                String d=s[1];
                output.write(getans(n,d)+"\n");
                j--;
            }
            output.flush();
        }catch(Exception e){
        }
    }
    public static int getans(String n,String d){
        int ch=d.charAt(0);
        int len=n.length();
        char[] str=n.toCharArray();
        int value=Integer.parseInt(n);
        if(ch=='0'){
             int idx2=len;
             for(int i=0;i<len;i++){
                  if(str[i]=='0'){
                       str[i]='1';
                       idx2=i;
                       break;
                  }
             }
             for(int j=idx2+1;j<len;j++){
                  str[j]='1';
             }
        }else if(ch=='9'){
             if(str[0]=='9'){
                  for(int i=0;i<len;i++){
                       str[i]='0';
                  }
                  return Integer.parseInt("1"+String.valueOf(str))-value;
             }else{
                  int ind=len;
                  for(int i=0;i<len;i++){
                       if(str[i]=='9'){
                         for(int k=i-1;k>=0;k--){
                              if(str[k]<='7'){
                                   str[k]++;
                                   ind=k;
                                    for(int j=ind+1;j<len;j++){
                                           str[j]='0';
                                      }
                                     return Integer.parseInt(String.valueOf(str))-value; 
                              }
                         }
                         
                         for(int j=0;j<len;j++){
                              str[j]='0';
                         }
                         return Integer.parseInt("1"+String.valueOf(str))-value;
                         // String s=;
                         // break fvv;
                       }
                  }
               //    cvv:
               //    for(int j=ind+1;j<len;j++){
               //         str[j]='0';
               //    }
               //    fvv:
             }
        }else{
             int i=0;
             for( i=0;i<len;i++){
                  if(str[i]==ch){
                     str[i]=(char)(str[i]+1);
                    break;
                  }
             }
             for(int j=i+1;j<len;j++){
                  str[j]='0';
             }
             
             return Integer.parseInt(String.valueOf(str))-value;
        }
        return Integer.parseInt(String.valueOf(str))-value;
    }
}
