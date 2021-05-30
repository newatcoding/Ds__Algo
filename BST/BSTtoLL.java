public class BSTtoLL {
    public static void BSTtoDLL(Node root ){
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
    public static void main(String[] args) {
        
    }
}
