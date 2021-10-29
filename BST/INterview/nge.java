public class nge {
    public static void main(String[] args) {
        String s="4321";
        char[] ch=s.toCharArray();
        int pvt=ch.length;
        for(int i=ch.length-2;i>=0;i--){
            if(ch[i]<ch[i+1]){
                pvt=i;
                break;
            }
        }
        if(pvt==ch.length){
            System.out.println(s);
            return;
        }

        //pvt point found
        int change=pvt+1;
        for(int i=ch.length-1;i>pvt;i--){
            if(ch[i]>ch[pvt]){
                change=i;
                break;
            }
        }
        // System.out.println(pvt+" "+change);
        //change found 
        char temp=ch[change];
        ch[change]=ch[pvt];
        ch[pvt]=temp;

        //sort after pivot
        
        // System.out.println(String.valueOf(ch));
        //reversing
        
        int j=ch.length-1;
        for(int i=pvt+1;i<j;i++){
            char temp1=ch[i];
            ch[i]=ch[j];
            ch[j]=temp1;
            j--;
        }
        System.out.println(String.valueOf(ch));
    } 
  
}

//5 3 4 9 7 6
//5 3 6 9 4 7
//5 3 6 4 7 9