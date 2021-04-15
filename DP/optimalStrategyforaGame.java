import java.io.*;



// (i, j) represents the maximum value the user
// can collect from i'th coin to j'th coin.

// F(i, j) = Max(Vi + min(F(i+2, j), F(i+1, j-1) ), 
//               Vj + min(F(i+1, j-1), F(i, j-2) ))
// As user wants to maximise the number of coins. 

// Base Cases
//     F(i, j) = Vi           If j == i
//     F(i, j) = max(Vi, Vj)  If j == i + 1



public class optimalStrategyforaGame {
    
    static int optimalStrategyOfGame(int arr[], int n)  {
        int table[][] = new int[n][n];
        int gap, i, j, x, y, z;
  
        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {
  
                x = ((i + 2) <= j)
                        ? table[i + 2][j]
                        : 0;
                y = ((i + 1) <= (j - 1))
                        ? table[i + 1][j - 1]
                        : 0;
                z = (i <= (j - 2))
                        ? table[i][j - 2]
                        : 0;
  
                table[i][j] = Math.max(
                    arr[i] + Math.min(x, y),
                    arr[j] + Math.min(y, z));
            }
        }
  
        return table[0][n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().trim().split(" ");
        int[] arr=new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(optimalStrategyOfGame(arr,arr.length));


    }
}
