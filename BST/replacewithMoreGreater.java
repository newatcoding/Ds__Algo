public class replacewithMoreGreater {

    static Node root;
    static Node succ;
    BinarySearchTree()
    {
        root = null;
        succ = null;
    }
    Node insert(Node node, int data)
    {
        
        // If the tree is empty, return a new node
        if (node == null)
        {
            node = new Node(data);
        }
    
        // If key is smaller than root's key,
        // go to left subtree and set successor
        // as current node
        if (data < node.data)
        {
            succ = node;
            node.left = insert(node.left, data);
        }
    
        // Go to right subtree
        else if (data > node.data)
            node.right = insert(node.right, data);
            
        return node;
    }
    static void replace(int arr[], int n)
    {
        
    
        // start from right to left
        for(int i = n - 1; i >= 0; i--)
        {
            succ = null;
            
            // Insert current element into BST and
            // find its inorder successor
            root = tree.insert(root, arr[i]);
    
            // Replace element by its inorder
            // successor in BST
            if (succ != null)
                arr[i] = succ.data;
                
            // No inorder successor
            else
                arr[i] = -1;
        }
    }
    public static void main(String[] args) {
        
    }
}
