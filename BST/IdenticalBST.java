public class IdenticalBST {
    public static boolean chechIdentical(int[] a,int [] b,int i1,int i2,int min,int max){
        int j,k;

        for( j=i1;j<a.length;j++){
            if(a[j]>min && a[j]<max)
                break;
        }
        for( k=i2;k<a.length;k++){
            if(b[k]>min && b[k]<max)
                break;
        }
        int n =a.length;
        if(j==n && k==n)
            return true;

        if((j==n)^(k==n) || a[j]!=b[k]) 
            return false;
        
        return chechIdentical(a, b, j+1, k+1, a[j], max) &&
                chechIdentical(a, b, j+1, k+1, min, a[j]);
    }
    public static void main(String[] args) {
        
        int[] a=new int[]{8,3,6,1,4,7,10,14,13};
        int[] b =new int[]{8, 10, 14, 3, 6, 4, 1, 7, 13};
        System.out.println(chechIdentical(a,b,0,0,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}
