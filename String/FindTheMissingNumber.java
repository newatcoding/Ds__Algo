public class FindTheMissingNumber {
    public static void main(String[] args) {
        String str="9899100102";
        
        System.out.println(missingNumber(str));
    }
    public static int missingNumber(String str){
        FindTheMissingNumber o=new FindTheMissingNumber();
        for (int m = 1; m <= 6; ++m) {
          
            int n = o.getValue(str, 0, m);
            if (n == -1) {
                break;
            }
 
            int missingNo = -1;
 
        
            boolean fail = false;
 
            for (int i = m; i != str.length(); i += 1 + Math.log10(n)) {
             
                if ((missingNo == -1)
                        && (o.getValue(str, i, (int) (1 + Math.log10(n + 2))) == n + 2)) {
                    missingNo = n + 1;
                    n += 2;
                }
                else if (o.getValue(str, i, (int) (1 + Math.log10(n + 1))) == n + 1) {
                    n++;
                } else {
                    fail = true;
                    break;
                }
            }
 
            if (!fail) {
                return missingNo;
            }
        }
        return -1;
    }
    private  int getValue(String str, int i, int m) {
        if (i + m > str.length()) {
            return -1;
        }
 
        // Find value at index i and length m.
        int value = 0;
        for (int j = 0; j < m; j++) {
            int c = str.charAt(i + j) - '0';
            if (c < 0 || c > 9) {
                return -1;
            }
            value = value * 10 + c;
        }
        return value;
    }

}
