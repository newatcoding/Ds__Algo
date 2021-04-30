public class minimumSumPath3D {
    static int min(int x, int y, int z){
         return (x < y)? ((x < z)? x : z) :
                ((y < z)? y : z);
    }
    static int l =3;
    static int m =3;
    static int n =3;  
    // function to calculate MIN path sum of 3D array
    static int minPathSum(int arr[][][])
    {
        int i, j, k;
        int tSum[][][] =new int[l][m][n];
          
        tSum[0][0][0] = arr[0][0][0];
          
       
        for (i = 1; i < l; i++)
            tSum[i][0][0] = tSum[i-1][0][0] + arr[i][0][0];
          
        
        for (j = 1; j < m; j++)
            tSum[0][j][0] = tSum[0][j-1][0] + arr[0][j][0];
          
        
        for (k = 1; k < n; k++)
            tSum[0][0][k] = tSum[0][0][k-1] + arr[0][0][k];
    
        for (i = 1; i < l; i++)
            for (j = 1; j < m; j++)
            tSum[i][j][0] = min(tSum[i-1][j][0],
                                tSum[i][j-1][0],
                                Integer.MAX_VALUE)
                            + arr[i][j][0];
          
        for (i = 1; i < l; i++)
            for (k = 1; k < n; k++)
            tSum[i][0][k] = min(tSum[i-1][0][k],
                                tSum[i][0][k-1],
                                Integer.MAX_VALUE)
                            + arr[i][0][k];
          
        for (k = 1; k < n; k++)
            for (j = 1; j < m; j++)
            tSum[0][j][k] = min(tSum[0][j][k-1],
                                tSum[0][j-1][k],
                                Integer.MAX_VALUE)
                            + arr[0][j][k];
        for (i = 1; i < l; i++)
            for (j = 1; j < m; j++)
            for (k = 1; k < n; k++)
                tSum[i][j][k] = min(tSum[i-1][j][k],
                                    tSum[i][j-1][k],
                                    tSum[i][j][k-1])
                                + arr[i][j][k];
          
        return tSum[l-1][m-1][n-1];
          
    }
    public static void main (String[] args)
    {
        int arr[][][] = { { {1, 2, 4}, {3, 4, 5}, {5, 2, 1}},
                          { {4, 8, 3}, {5, 2, 1}, {3, 4, 2}},
                          { {2, 4, 1}, {3, 1, 4}, {6, 3, 8}}
                        };
        System.out.println ( minPathSum(arr));
              
    }
}
