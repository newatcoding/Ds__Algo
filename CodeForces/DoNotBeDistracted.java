import java.util.*;
// import java.io.*;
public class DoNotBeDistracted {
    public static void main(String[] args) throws Exception {
        try{
            Scanner  scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                String str=scn.next();
                int[] arr=new int[26];
                int flag=0;
                for(int i=1;i<n;i++){
                    int idx=str.charAt(i)-'A';
                    int previdx=str.charAt(i-1)-'A';
                    if(arr[idx]!=0){
                        flag=1;
                        break;
                    }
                    if(str.charAt(i-1)!=str.charAt(i))
                        arr[previdx]++;
                }
                if(flag==0){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
            scn.close();
        }catch(Exception e){

        }
       
    }
}
