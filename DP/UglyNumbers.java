import java.util.*;

import java.io.*;

class UglyNumbers{

    public static class Num implements Comparable<Num> {
        int val;
        int idx;
        int p;

        public Num(int val, int idx, int p) {
            this.val = val;
            this.idx = idx;
            this.p = p;
        }

        @Override
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }

    public static int findnugly(int n){
        int[] ugly=new int[n];
        int next2=2;
        int next3=3;
        int next5=5;
        int idx2=0;
        int idx3=0;
        int idx5=0;
        int nextugly=1;

        for(int i=1;i<n;i++){
            nextugly=Math.min(next2, Math.min(next3, next5));

            ugly[i]=nextugly;
            if(nextugly==next2){
                idx2++;
                next2=ugly[idx2]*2;
            }
            if(nextugly==next3){
                idx3++;
                next3=ugly[idx3]*3;
            }
            if(nextugly==next5){
                idx5++;
                next5=ugly[idx5]*5;
            }
        }



        return ugly[n-1];
    }

    public static int SuperUgly(int n,int a ,int  b ,int  c){
       
        int[] ugly=new int[n];
        PriorityQueue<Num> pq=new PriorityQueue<Num>();
        pq.add(new Num(a, 1, a));
        pq.add(new Num(b, 1, b));
        pq.add(new Num(c, 1, c));
       
        ugly[0] = 1;
        
        for (int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]) {
                Num nxt = pq.poll();
                pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
            }
        }
        return ugly[n-1];
    }
    public static void main(String[] args) throws IOException {
        Scanner scn=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose your option \n 1. Find nth ugly for 2 3 5  \n 2. find nth ugly for 3 prime no. of your choosing");
        String choice=scn.next();
        switch(choice){
            case "1":
                int n=scn.nextInt();
                System.out.println(findnugly(n));
                break;
            case "2":
                String[] str=br.readLine().trim().split(" ");
                System.out.println(SuperUgly(Integer.valueOf(str[0]),Integer.valueOf(str[1]),Integer.valueOf(str[2]),Integer.valueOf(str[3]))); 
                break;   
            default:
                System.out.println("Wrong option chosen");
                break;
        }
        scn.close();
        //this ugly is for getting 2 3 5 
        

    }
}


