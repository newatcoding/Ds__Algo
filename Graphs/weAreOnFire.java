import java.util.LinkedList;
import java.util.*;

public class weAreOnFire {
    static int[][] mat=new int[1001][1001];
    static int[][] visited=new int[1001][1001];
    static int n,m,ans,cnt;
    static int[][] v={{-1,0},{1,0},{0,1},{0,-1}};

    static class Pair{
        int first;
        int second;

        Pair(int x,int y){
            this.first=x;
            this.second=y;
        }
    }
    static boolean isvalid(int a,int b){
        if(a>=1&&a<=n&&b>=1&&b<=m)
            return true;
        else
            return false;
    }
    
    static void bfs(int x,int y){
        visited[x][y]=1;
        mat[x][y]=0;
        Queue<Pair> q=new LinkedList<>();
        
        q.add(new Pair(x,y));
        int xx,yy;
        while(!q.isEmpty()){
            Pair p=q.peek();
            xx=p.first;
            yy=p.second;
            q.poll();
            for(int i=0;i<v.length;i++){
                int X=xx+v[i][0];
                int Y=yy+v[i][1];
                if(isvalid(X,Y)&&visited[X][Y]==0&&mat[X][Y]==1){
                    q.add(new Pair(X,Y));
                    visited[X][Y]=1;
                    cnt+=1;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int q=scn.nextInt();
        ans=0;
        cnt=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                mat[i][j]=scn.nextInt();
                if(mat[i][j]==1)
                    ans+=1;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(q-->0){
            int x=scn.nextInt();
            int  y=scn.nextInt();
            if(mat[x][y]==1&&visited[x][y]==0){
                cnt=1;
                bfs(x,y);
                ans-=cnt;
            }
            
            sb.append(ans+" ");
            // System.out.print(ans + " ");
        }
        System.out.println(sb.toString());
        scn.close();
}

}