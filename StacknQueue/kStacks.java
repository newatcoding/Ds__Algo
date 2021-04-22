public class kStacks {
    public static int arr[];   // Array of size n to store actual content to be stored in stacks
    public static int top[];   // Array of size k to store indexes of top elements of stacks
    public static int next[];  // Array of size n to store next entry in all stacks and free list
    public static int n, k;
    public static int free; // To store beginning index of free list

    //constructor to create k stacks in an array of size n
    public static void KStack(int k1, int n1) 
    {
        // Initialize n and k, and allocate memory for all arrays
        k = k1;
        n = n1;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize all stacks as empty
        for (int i = 0; i < k; i++)
            top[i] = -1;

        // Initialize all spaces as free
        free = 0;
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;
        next[n - 1] = -1; // -1 is used to indicate end of free list
    }

    
    public static boolean isFull() 
    {
        return (free == -1);
    }

    // To push an item in stack number 'sn' where sn is from 0 to k-1
    public static void push(int item, int sn) 
    {
        // Overflow check
        if (isFull()) 
        {
            System.out.println("Stack Overflow");
            return;
        }

        int i = free; // Store index of first free slot

        // Update index of free slot to index of next slot in free list
        free = next[i];

        // Update next of top and then top for stack number 'sn'
        next[i] = top[sn];
        top[sn] = i;

        // Put the item in array
        arr[i] = item;
    }

    // To pop an from stack number 'sn' where sn is from 0 to k-1
    public static int pop(int sn) 
    {
        // Underflow check
        if (isEmpty(sn)) 
        {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }

        // Find index of top item in stack number 'sn'
        int i = top[sn];

        top[sn] = next[i]; // Change top to store next of previous top

        // Attach the previous top to the beginning of free list
        next[i] = free;
        free = i;

        // Return the previous top item
        return arr[i];
    }

    // To check whether stack number 'sn' is empty or not
    public static boolean isEmpty(int sn) 
    {
        return (top[sn] == -1);
    }
  
    
  
   
    public static void main(String[] args) 
    {
   
        int k = 3, n = 10;
          
        KStack(k, n);
  
        push(15, 2);
        push(45, 2);
  
        // Let us put some items in stack number 1
        push(17, 1);
        push(49, 1);
        push(39, 1);
  
        // Let us put some items in stack number 0
        push(11, 0);
        push(9, 0);
        push(7, 0);
  
        System.out.println("Popped element from stack 2 is " + pop(2));
        System.out.println("Popped element from stack 1 is " + pop(1));
        System.out.println("Popped element from stack 0 is " + pop(0));
    }
}
