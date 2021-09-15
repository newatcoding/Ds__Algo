public class CountIslands {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}};
        int n=findIslands(grid);
        System.out.println(n);
    }
    public static int findIslands(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    cnt++;
                    
                    selectIsland(grid,i,j);
                }
            }
        }
        return cnt;
    }
    public static void selectIsland(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j>=grid[0].length || j<0){
            return ;
        }
        if(grid[i][j]==0){
            return ;
        }
        grid[i][j]=0;
        selectIsland(grid, i+1, j);
        selectIsland(grid, i, j-1);
        selectIsland(grid, i-1, j);
        selectIsland(grid, i, j+1);

        selectIsland(grid, i+1, j-1);
        selectIsland(grid, i-1, j+1);
        selectIsland(grid, i-1, j-1);
        selectIsland(grid, i+1, j+1);
        return ;


    }
}
