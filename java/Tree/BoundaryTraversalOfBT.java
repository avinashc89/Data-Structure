
class Node { 
    int data; 
    Node left, right; 
  
    Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
  
class BoundaryTraversalOfBT { 
    
    public static int sum =0;
    Node root; 
  
    // A simple function to print leaf nodes of a binary tree 
    void printLeaves(Node node) 
    { 
        if (node != null) { 
            printLeaves(node.left); 
            if (node.left == null && node.right == null) 
                sum=sum+node.data;
                System.out.print(node.data + " "); 
            printLeaves(node.right); 
        } 
    } 
  
    // A function to print all left boundry nodes, except a leaf node. 
    // Print the nodes in TOP DOWN manner \
    // to ensure top down order, print the node 
    // before calling itself for left subtree 

    // do nothing if it is a leaf node, this way we avoid 
    // duplicates in output 
    
    void printBoundaryLeft(Node node) 
    { 
        if (node != null) { 
            if (node.left != null) { 
                sum=sum+node.data;
                System.out.print(node.data + " "); 
                printBoundaryLeft(node.left); 
            } 
            else if (node.right != null) { 
                sum=sum+node.data;
                System.out.print(node.data + " "); 
                printBoundaryLeft(node.right); 
            } 
        } 
    } 
  
    // A function to print all right boundry nodes, except a leaf node 
    // Print the nodes in BOTTOM UP manner 
    void printBoundaryRight(Node node) 
    { 
        if (node != null) { 
            if (node.right != null) { 
                // to ensure bottom up order, first call for right 
                // subtree, then print this node 
                printBoundaryRight(node.right); 
                sum=sum+node.data;
                System.out.print(node.data + " "); 
            } 
            else if (node.left != null) { 
                printBoundaryRight(node.left); 
                sum=sum+node.data;
                System.out.print(node.data + " "); 
            } 
            // do nothing if it is a leaf node, this way we avoid 
            // duplicates in output 
        } 
    } 
  
    // A function to do boundary traversal of a given binary tree 
    void printBoundary(Node node) 
    { 
        if (node != null) { 
            sum=sum+node.data;
            System.out.print(node.data + " "); 
            // Print the left boundary in top-down manner. 
            printBoundaryLeft(node.left); 
  
            // Print all leaf nodes 
            printLeaves(node.left); 
            printLeaves(node.right); 
  
            // Print the right boundary in bottom-up manner 
            printBoundaryRight(node.right); 
            
            
        } 
    } 
  
    // Driver program to test above functions 
    public static void main(String args[]) 
    { 
        BoundaryTraversalOfBT tree = new BoundaryTraversalOfBT(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
        tree.root.right.right = new Node(25); 
        tree.printBoundary(tree.root);
        System.out.println("\n Sum:"+sum);
    } 
} 
