public class longestCommonIncreasingSubsequence {
    static int LCIS(int arr1[], int n, int arr2[], int m){
      
        int table[] = new int[m];
        for (int j = 0; j < m; j++)
            table[j] = 0;
 
        for (int i = 0; i < n; i++){
            int current = 0;
            for (int j = 0; j < m; j++){
               
                if (arr1[i] == arr2[j])
                    if (current + 1 > table[j])
                        table[j] = current + 1;
                if (arr1[i] > arr2[j])
                    if (table[j] > current)
                        current = table[j];
            }
        }
 
        int result = 0;
        for (int i=0; i<m; i++)
            if (table[i] > result)
            result = table[i];
 
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {3, 4, 9, 1};
        int arr2[] = {5, 3, 8, 9, 10, 2, 1};
 
        int n = arr1.length;
        int m = arr2.length;
 
        System.out.println("Length of LCIS is " + LCIS(arr1, n, arr2, m));
    }
}
