import java.util.Scanner;

public class chessTournament {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                String str=scn.next();
                char[] chess=str.toCharArray();
                int cnt=0;
                int lastIdx=-1;
                int m=0;
                for(char ch:chess){
                    if(ch=='2'){
                        cnt++;
                        lastIdx=m;
                    }
                    m++;
                }
               
                if(cnt==2 || cnt==1){
                    System.out.println("NO");
                    continue;
                }
                System.out.println("YES");
                char[][] ans=new char[n][n];
                for(int i=0;i<n;i++){
                    ans[i][i]='X';
                }
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<n;i++){
                    for(int j=i+1;j<n;j++){

                       
                        if(chess[j]!='1'){
                            ans[i][j]='+';
                            ans[j][i]='-';
                        }else{
                            if(chess[i]=='1'){
                                ans[i][j]='=';
                                ans[j][i]='=';
                            }else{
                                ans[i][j]='-';
                                ans[j][i]='+';
                            }
                        }
                        
                    }
                    // StringBuilder s1=new StringBuilder();
                    // for(int j=0;j<n;j++){
                        
                    //     s1.append(chess[j]);
                    // }
                    // sb.append(String.valueOf(ans[i])+"\n");
                }
                for(int i=0;i<n;i++){
                    if(chess[i]=='2' && i!=lastIdx){
                        ans[lastIdx][i]='+';
                        ans[i][lastIdx]='-';
                        break;
                    }
                }
                for(int i=0;i<n;i++){
                    if(i!=n-1){
                        sb.append(String.valueOf(ans[i])+"\n");
                    }else
                        sb.append(String.valueOf(ans[i]));
                }
                System.out.println(sb.toString());
            }
            scn.close();
        }catch(Exception e){

        }
    }
}
