import java.util.*;
public class MaxNodeLevel
{
    
    
    public static boolean win(Node root, Node n) { //N is the first move by opponent
        int sizeParent = countNodes(n.parent, n); //size of parent component
        int sizeLeft = countNodes(n.left, n);   //size of left subtree component
        int sizeRight = countNodes(n.right, n); //size of right subtree component

        int myScore = Math.max(Math.max(sizeParent, sizeLeft), sizeRight); //I take the biggest component
        int treeSize = 1 + sizeParent + sizeLeft + sizeRight;
        int opponentScore = treeSize - myScore; //opponent takes remaining nodes
        System.out.print("my best score is " + myScore + "/" + treeSize + ". ");
        if(myScore > opponentScore) {
            Node bestmove = myScore == sizeParent ? n.parent: myScore == sizeLeft ? n.left : n.right;
            System.out.println("my first move on " + bestmove.data);
        }
        return myScore > opponentScore;
    }

    private static int countNodes(Node node, Node ignore) {
        if(node == null) return 0;
        int count = 1;
        if(node.parent != ignore) {
            count += countNodes(node.parent, node);
        }
        if(node.left != ignore) {
            count += countNodes(node.left, node);
        }
        if(node.right != ignore) {
            count += countNodes(node.right, node);
        }
        return count;
    }


    /* A binary tree Node has data, pointer 
to left child and a pointer to right 
child */
    static class Node 
    { 
        int data; 
        Node left; 
        Node right; 
        Node parent;
    } 

    /* Helper function that allocates a new node with the 
given data and NULL left and right pointers. */
    static Node newNode(int data) 
    { 
        Node node = new Node(); 
        node.data = data; 
        node.left = null; 
        node.right = null; 
        return(node); 
    } 

    // function to find the level 
    // having maximum number of Nodes 
    static int maxNodeLevel(Node root) 
    { 
        if (root == null) 
            return -1; 

        Queue<Node> q = new LinkedList<Node> (); 
        q.add(root); 

        // Current level 
        int level = 0; 
        // Maximum Nodes at same level 
        int max = 1; 
        // Level having maximum Nodes 
        int level_no = 0; 

        while (q.size()>0) 
        { 
            if (q.size() > max) 
            { 
                max = q.size(); 
                level_no = level; 
            } 
            int count = q.size();
            //remove all the current node in the queue
            while (count > 0) 
            { 
                Node Node = q.peek(); 
                q.remove(); 
                if (Node.left != null) 
                    q.add(Node.left); 
                if (Node.right != null) 
                    q.add(Node.right); 
                count--;
            } 
            // Increment for next level 
            level++; 
        } 
        return level_no; 
    } 
    
   public  static void printGivenLevel (Node root ,int level) 
    { 
        if (root == null || level < 0) 
            return; 
        if (level == 0) 
            System.out.print(root.data + " "); 
        else 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
   
   public static int countOfNode(Node root) 
   {
       if (root==null) return 0;
       else  
       {
//           int count =1;
//           if(root.left!=null)
//               count = count+countOfNode(root.left);
//           if(root.right!=null)
//               count = count+countOfNode(root.right);
//           return count;
           return 1+countOfNode(root.left)+countOfNode(root.right);
       }
   }

   public static int countOfLeafNode(Node root) 
   {
       if (root==null) return 0;
       else 
       {
           if(root.left ==null && root.right ==null)
               return 1;
       }
      return countOfLeafNode(root.left)+countOfLeafNode(root.right);
   }
   
   public static Node postOrderFirst(Node root)
   {
       if(root == null) return null;
       Node curr = root;
       while(curr.left!=null)
       {
           curr = curr.left;
       }
       if(curr.right==null)
       {   
           return curr;
       }
       else
       {
           return postOrderFirst(curr.right);
       }
   }
   static int count = 0; 
   
   public static void postOrderFirst1(Node root, int n )
   {
       if (root ==null )
           return;
       postOrderFirst1(root.left, n);
       postOrderFirst1(root.right, n);
     
       count++;
       if(count == n )
           System.out.println(root.data);
     
   }
   
   static Node postOrderNext(Node n)
   {
       if(n == null) return null;
       Node parent = n.parent;
       if(parent!=null)
       {
           if(parent.right == n || parent.right ==null)
           {   
               return parent;
           }
           else if(parent.right!=null)
           {
               return postOrderFirst(parent.right);
           }
       }

       return null;    
   }
   
   
   
   /** Split BST
 * @param root
 * @param V
 * @return
 */
public Node[] splitBST(Node root, int V) {
       Node[] res = new Node[2];
       if (root == null) return res;
       if (root.data <= V) {
           res[0] = root;
           Node[] rightRes = splitBST(root.right, V);
           root.right = rightRes[0];
           res[1] = rightRes[1];
       } else {
           res[1] = root;
           Node[] leftRes = splitBST(root.left, V);
           root.left = leftRes[1];
           res[0] = leftRes[0];
       }
       return res;
   }

    // Driver program to test above 
    public static void main(String[] args) 
    { 
        // binary tree formation 
        Node root = newNode(2);              /*    2            */
        root.left    = newNode(1);          /*    / \           */
        root.right   = newNode(3);          /*    1   3         */
        root.left.left = newNode(4);        /*   / \   \       */
        root.left.right = newNode(6);       /*  4   6   8       */
        root.right.right = newNode(8);      /*     /            */
        root.left.right.left = newNode(5);  /*    5             */
        
        root.left.parent = root;
        root.right.parent = root;
        root.left.left.parent =root.left;
        root.left.right.parent =root.left;
        root.right.right.parent =  root.right;
        root.left.right.left.parent =  root.left.right;
//        int l = maxNodeLevel(root);
//        System.out.println("Level having maximum number of Nodes : " + l); 
//        printGivenLevel(root,l);
 //       System.out.println(countOfNode(root));
    //    postOrderFirst1(root,2);
        Node n = root.left.right;
       System.out.println(countNodes(n.left, n));
        
     //   System.out.println(postOrderNext(root.right.right).data);
    } 

}
