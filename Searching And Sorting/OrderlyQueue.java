import java.util.*;

public class OrderlyQueue {
    public static void main(String[] args) {
        String s="baaca";
        int k=1;
        System.out.println(ans1(s,k));            //O(n^2); if k==1 & O(nlogn ) if k>=2
        System.out.println(ans2(s,k));         //O(n) Based on Preprocessing of KMP also known as booth's algorithm    i dont know
        System.out.println(ans3(s,k));          //anything between O(n) to O(n^2)
    }
    public static String ans1(String s,int k){
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
    public static String ans2(String S,int K){
      
        int len=S.length();
        
        if(len==0)return S;
        
        // Double S
        S=S+S;
        char[]cs=S.toCharArray();
        
        if(K>=2){
            int[]cnt=new int[26];
            for(int i=0;i<len;i++)cnt[cs[i]-'a']++;
            StringBuilder str=new StringBuilder(len);
            for(int i=0;i<26;i++){
                int n=cnt[i];
                for(int j=0;j<n;j++)str.append((char)(i+'a'));
            }
            return str.toString();
        }
        char[] res=new char[len*2];
        res[0]=cs[0];
        int[] arr=new int[len*2];//prefix function
        arr[0]=-1;
        
        int x=0;
        
        for(int i=1;i<len*2;i++){
            while(x>=0&&res[arr[x]+1]>cs[i])x=arr[x];
            res[x+1]=cs[i];
            
            //update arr
            if(x>=0){
                int k=arr[x];
                while(k>=0&&res[k+1]!=cs[i])k=arr[k];
                if(res[k+1]==cs[i])k++;
                arr[x+1]=k;
            }
            
            x++;
        }
        
        return new String(res,0,len);
       
    }
    public static String ans3(String s,int k){
        if (k == 1) {
            String ans = s;
            char ch=s.charAt(0);
            for (int i = 1; i < s.length(); ++i) {
               if(s.charAt(i)<ch){
                   ch=s.charAt(i);
               }
            }
            ArrayList<Integer> al=new ArrayList<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==ch){
                    al.add(i);
                }
            }
            for (int i :al) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
