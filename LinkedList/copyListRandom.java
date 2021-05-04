public class copyListRandom {
    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static  Node copyRandomList(Node head) {
        //add ll in the original
        if(head==null) return head;
        Node temp=head;
        while(temp!=null){
            int val=temp.val;
            Node ntemp=new Node(val);
            ntemp.next=temp.next;
            temp.next=ntemp;
            temp=temp.next.next;
        }
        // random
        temp=head;
        while(temp!=null){
            if(temp.random!=null) temp.next.random=temp.random.next;
             temp=temp.next==null?temp.next:temp.next.next;
        }
        // remove original
        
        temp=head;
        Node newtemp=temp.next;
        Node nhead=temp.next;
        while(temp!=null){
            newtemp=temp.next;
            Node tempnext=newtemp.next;
            Node newtempnext=tempnext==null?null:tempnext.next;
            temp.next=tempnext;
            newtemp.next=newtempnext;
            temp=tempnext;
            newtemp=newtempnext;
        }
        return nhead;
    }
    public static void main(String[] args) {
        
    }
}
