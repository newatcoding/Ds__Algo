import java.util.*;
import java.math.*;
public class spiralToMatrix {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);    
        String s=scn.next();
        String[] st=s.split(",");
        int n=(int)Math.sqrt(st.length);
        int[][] ar=new int[n][n];
        int k=0;
        while(k<n){
            for(int i=0;i<n;i++){
                ar[k][i]=Integer.parseInt(st[i+k*n]);
               
            }
            k++;
        }
        
        int[][] ans= detailedInformation(ar, ar.length);
        for(int[] v:ans){
            for(int val:v){
                System.out.print(val+" ");
            }
            System.out.println();

        }
        scn.close();
    }
    public static int[][] detailedInformation(int[][] matrix,int size){
        List<Integer> ans = new ArrayList<Integer>();
 
        if (matrix.length == 0)
            return new int[0][0];
 
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int r = 0, c = 0, di = 0;
 
        // Iterate from 0 to R * C - 1
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
 
            if (0 <= cr && cr < R && 0 <= cc && cc < C
                && !seen[cr][cc]) {
                r = cr;
                c = cc;
            }
            else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        // return ans;
        int[][] ansmat=new int[size][size];
        int i=0;
        while(i<size){
            for(int j=0;j<size;j++){
                ansmat[i][j]=ans.get(j+i*size);
            
            }
            i++;
        }
        
        return ansmat;
    }
}
