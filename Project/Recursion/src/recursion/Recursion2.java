
package recursion;

import pkg.Queue;
import pkg.IntBSTNode;
/**
 *
 * @author Team of Giang, Cuong, Phuc
 */
public class Recursion2 {
/**  
    Describe a way to use recursion to compute the sum of all the elements in
    an n × n (two-dimensional) array of integers.
 */
    static int sum(int[][] a, int n)
    {
      //base case
      if (n == 1)
        return a[0][0];

      //start edges number at zero
      int edges = 0;

      //sum up edges
      for (int i = 0; i < n; i++)
        edges += a[i][n - 1] + a[n - 1][i];
      
      //bottom right corner was added twice, needs to be subtracted
      //inclusion-exclusion principal
      edges -= a[n - 1][n - 1];

      //return statement has the recursive call back to sum
      return edges + sum(a, n - 1);
    }
    
/** 
    Describe a recursive algorithm to compute the integer part of the base-two
    logarithm of n using only addition and integer division.
 */
    static int Log2n(int n) 
    {
        return (n > 1) ? 1 + Log2n(n / 2) : 0;
    }
    
/**
 *  Design algorithms for the following operations for a binary tree T :
 *  - preorderNext(p): Return the position visited after p in a preorder traversal
 *  of T (or null if p is the last node visited).
 *  - inorderNext(p): Return the position visited after p in an inorder traversal
 *  of T (or null if p is the last node visited).
 *  - postorderNext(p): Return the position visited after p in an postorder traversal
 *  of T (or null if p is the last node visited).
 *  What are the worst-case running times of your algorithms?
 */
    
    
/**
 * 
 * @main 
 */ 
    public static void main(String[] args) throws Exception
    {
//        int array[][] = {{1,1,1},{2,2,2},{3,3,3}};
//        System.out.println(sum(array, 3));
//
//        int n = 23;
//        System.out.println(Log2n(n));
        IntBST Tree = new IntBST();
        IntBSTNode p = Tree.root;
        Queue<IntBSTNode> Q = new Queue<>();
        Tree = Tree.setUp();
        System.out.println(Tree.root);
        Tree.nextPreOrder(10);
        
        
    }

}

class IntBST {
	IntBSTNode root;

	public IntBST() {
		root = null;
	}
	

	public void visit(IntBSTNode p) {
		if (p != null) {
			System.out.print(p.key + " ");
		}
	}
	
	public void Preorder(IntBSTNode p, Queue<IntBSTNode> Q)  //N -> L -> R
        {
		if (p != null) {
                        Q.enqueue(p);
			Preorder(p.left, Q);
			Preorder(p.right, Q);
   		}
	}
        
        public IntBSTNode nextPreOrder(int key)
        {
            Queue<IntBSTNode> Q = new Queue<>();
                Preorder(root, Q);      //go through tree with PreOrder
            if (Q.isEmpty()) {
                System.out.println("<Empty List!>");
                return null;
            }
            
            IntBSTNode isExist = null;
            while (!Q.isEmpty())
            {
                if (Q.front().key == key) {
                    isExist = Q.dequeue();
                    if (Q.front() != null)
                        System.out.println("Next Node of [" + key + "]: " + Q.dequeue().key);
                    else
                        System.out.println("This is the last node!");
                }
                else
                    Q.dequeue();
            }
            if (isExist == null)
                System.out.println("<Non-Exist!>");
            return isExist;
        }

	public void Inorder(IntBSTNode p, Queue<IntBSTNode> Q)   //L -> N -> R
        {
		if (p != null) {
                        Inorder(p.left, Q);
			Q.enqueue(p);
			Inorder(p.right, Q);
   		}
	}
	
	public void Postorder(IntBSTNode p) //L -> R -> N
        {

	}

	public int CountNode(IntBSTNode p)
	{
            if (p != null)
                return CountNode(p.left) + CountNode(p.right) + 1;
            return 0;
	}
        
        public IntBST setUp() throws Exception
        {
		IntBST tree = new IntBST();
		tree.Insert(8);
		tree.Insert(3);
		tree.Insert(10);
		tree.Insert(1);
		tree.Insert(6);
		tree.Insert(14);
		tree.Insert(4);
		tree.Insert(7);
		tree.Insert(13);
                return tree;
	}
        
        public void Insert(int el) {
		IntBSTNode p = root;
		IntBSTNode parent = null;
		while (p != null) {
			parent = p;
			if (p.key > el)
				p = p.left;
			else
				p = p.right;
		}
		if (root == null)
			root = new IntBSTNode(el, null, null);
		else {
			if (parent.key > el)
				parent.left = new IntBSTNode(el, null, null);
			else
				parent.right = new IntBSTNode(el, null, null);
		}
	}
}
