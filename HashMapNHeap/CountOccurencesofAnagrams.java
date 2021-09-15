import java.util.Arrays;

public class CountOccurencesofAnagrams {
    public static void main(String[] args) {
        String txt="forxxorfxdofr";
        String pat="for";
        int[] text=new int[26];
        int[] pattern=new int[26];
        for(char ch:pat.toCharArray()){
            pattern[ch-'a']++;
        }
        for(int i=0;i<pat.length();i++){
            text[txt.charAt(i)-'a']++;
        }
        int ans=0;
        if(Arrays.equals(text, pattern)){
            ans++;
        }
        int k=0;
        for(int i=pat.length();i<txt.length();i++){
            text[txt.charAt(k)-'a']--;
            text[txt.charAt(i)-'a']++;
            k++;
            if(Arrays.equals(text, pattern)){
                ans++;
            }
        }

        System.out.println(ans);

    } 
}
