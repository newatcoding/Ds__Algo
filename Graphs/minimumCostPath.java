import java.util.*;

public class minimumCostPath {
    public static void main(String[] args) {
        int[][] dp={{9,4,9,9},{6,7,6,4},
        {8,3,3,7},{7,4,9,10}};
        System.out.print(minimumCost(dp,dp.length,dp[0].length));
    }
    public static class Cell{
        int x;
        int y;
        int dist;

        Cell(int x,int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    public static boolean inside(int i,int j,int n, int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }
    public static int minimumCost(int[][] grid,int n ,int m){
        
        PriorityQueue<Cell> pq=new PriorityQueue<Cell>(n*m,(a,b)->{
            if(a.dist<b.dist){
                return -1;
            }else if(a.dist>b.dist){
                return 1;
            }else{
                return 0;
            }
        });
        pq.add(new Cell(0,0,0));
        int[][] dist=new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            Cell curr=pq.poll();
            for(int i=0;i<4;i++){
                int r=curr.x+dx[i];
                int c=curr.y+dy[i];
                if(inside(r, c, n, m)){
                    if(dist[r][c]>grid[r][c]+dist[curr.x][curr.y]){
                        if(dist[r][c]!=Integer.MAX_VALUE){
                            Cell adj=new Cell(r,c,dist[r][c]);
                            pq.remove(adj);
                        }
                        dist[r][c]=dist[curr.x][curr.y]+grid[r][c];
                        pq.add(new Cell(r,c,dist[r][c]));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
