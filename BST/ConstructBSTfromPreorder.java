// import java.util.*;
public class ConstructBSTfromPreorder {
    //root -[left]-[right]
    //left<root && right>root;
    public static int m;
    public static int[] tree;
    public static void createTree(int[] arr,int i,int j){
        if(m>arr.length || i>j){
            return ;
        }
        tree[m++]=arr[i];
        if(i==j){
            return ;
        }
        int line=i+1;
        while(arr[i]>arr[line]){
            line++;
        }
        //left
        createTree(arr, i+1, line-1);
        //right
        createTree(arr, line, j);
    }
    public static void printtree(int n){
        for(int i=0;i<n;i++){
            System.out.print(tree[i]+" ");

        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        m=0;
      
        int[] arr=new int[]{10,5,1,7,40,50};
        tree=new int[arr.length];
        createTree(arr,0,arr.length-1);
        printtree(arr.length);
    }
}
