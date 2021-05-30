public class BSTtoLL {
    static node head;
    static node tail;
    public static void BSTtoDLL(node root ){
        if (root == null)
            return;
    
        // First convert the left subtree
        if (root.left != null)
            convertBSTtoDLL(root.left);
    
        // Then change left of current root
        // as last node of left subtree
        root.left = tail;
    
        // If tail is not null, then set right
        // of tail as root, else current
        // node is head
        if (tail != null)
            (tail).right = root;
        else
            head = root;
    
        // Update tail
        tail = root;
    
        // Finally, convert right subtree
        if (root.right != null)
            convertBSTtoDLL(root.right);
    }
   

    static Node BSTToSortedLL(Node root, Node head_ref)
    {
        // Base cases
        if(root == null)
            return head_ref;
    
        // Recursively convert right subtree
        head_ref = BSTToSortedLL(root.right, head_ref);
    
        // insert root into linked list
        root.right = head_ref;
    
        // Change left pointer of previous head
        // to point to null
        if (head_ref != null)
            (head_ref).left = null;
    
        // Change head of linked list
        head_ref = root;
    
        // Recursively convert left subtree
        head_ref = BSTToSortedLL(root.left, head_ref);
        return head_ref;
    }

    public static void main(String[] args) {
        
    }
}
