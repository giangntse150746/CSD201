package pkg;
import java.util.*;
import java.util.Queue;

public class IntBSTNode {
	public int key;
	public IntBSTNode left;
        public IntBSTNode right;

	public IntBSTNode(int k) {
		this(k, null, null);
	}

	public IntBSTNode(int k, IntBSTNode l, IntBSTNode r) {
		key = k;
		left = l;
		right = r;
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
	
	public void Preorder(IntBSTNode p)  //N -> L -> R
        {
		if (p != null) {
			visit(p);
			Preorder(p.left);
			Preorder(p.right);
   		}
	}

	public void Inorder(IntBSTNode p)   //L -> N -> R
        {
		if (p != null) {
                        Preorder(p.left);
			visit(p);
			Preorder(p.right);
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
	
	public int CountLeafNode(IntBSTNode p)
        {
            if (p != null)
            {
                int count = 0;
                if (p.left == null && p.right == null)
                    count = 1;
                count += CountLeafNode(p.left);
                count += CountLeafNode(p.right);
                return count;
            }
            return 0;
	}
	
	public int CountNonterminalNodes(IntBSTNode p)      //internal nodes
	{
            if (p != null)
            {
                int count = 0;
                if (p.left != null || p.right != null)
                    count = 1;
                count += CountNonterminalNodes(p.left);
                count += CountNonterminalNodes(p.right);
                return count;
            }
            return 0;
	}
	
	public int GetLevel(int el)
	{
            return HAMNAYLAMRADEGETLEVELVANDUNGDEQUY(root, el, 1);
	}
        private int HAMNAYLAMRADEGETLEVELVANDUNGDEQUY(IntBSTNode p, int el, int level)
        {
            if (p == null) 
                return 0; 
   
            if (p.key == el) 
                return level; 
   
            int downlevel = HAMNAYLAMRADEGETLEVELVANDUNGDEQUY(p.left, el, level + 1); 
            if (downlevel != 0) 
                return downlevel; 
   
            downlevel = HAMNAYLAMRADEGETLEVELVANDUNGDEQUY(p.right, el, level + 1); 
                return downlevel;
        }
        
        public int GetLevelWithIterative(int el) {
                IntBSTNode p = root;
		Queue<IntBSTNode> queue = new LinkedList();
                int level = 1;
		queue.offer(p); // enqueue
		while (!queue.isEmpty( ) && p.key != el) {
			p = queue.poll(); // dequeue
                        level++;    //up level
			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
                            queue.offer(p.right);
                        
                        if (p.left != null && p.right != null)
                            level--;    //if current p has 2 childs, -1 to keep the level right.
		}
            return level;
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

	public void BreathFirst() {
		IntBSTNode p = root;
		Queue<IntBSTNode> queue = new LinkedList();
		queue.offer(p); // enqueue
		while (!queue.isEmpty( )) {
			p = queue.poll(); // dequeue
			visit(p);// traverse
			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
				queue.offer(p.right);
		}
	}

	public IntBSTNode Search(IntBSTNode p, int el) {
		boolean Found = false;
		
		while (p != null && Found == false) {
			if (el == p.key)
				Found = true;
			else {
				if (el < p.key)
					p = p.left;
				else
					p = p.right;
			}
		}
		return p;
	}

	public IntBSTNode Search(int el) {
		return Search(root, el);
	}

	public void deleteByMerging(int el) {
        IntBSTNode tmp;
		IntBSTNode node, p = root, prev = null;
		while (p != null && p.key != el) { // find the node p
			prev = p; // with element el;
			if (p.key < el)
				p = p.right;
			else
				p = p.left;
		}
		node = p;
		if (p != null && p.key == el) {
			if (node.right == null) // node has no right child: its left
				node = node.left; // child (if any) is attached to its
			// parent;
			else if (node.left == null) // node has no left child: its right
				node = node.right; // child is attached to its parent;
			else { // be ready for merging subtrees;
				tmp = node.left; // 1. move left
				while (tmp.right != null)
					// 2. and then right as far as
					tmp = tmp.right; // possible;
				tmp.right = // 3. establish the link between
				node.right; // the rightmost node of the left
				// subtree and the right subtree;
				node = node.left; // 4.
			}
			if (p == root)
				root = node;
			else if (prev.left == p)
				prev.left = node;
			else
				prev.right = node; // 5.
		} else if (root != null)
			System.out.println("key " + el + " is not in the tree");
		else
			System.out.println("the tree is empty");
	}

	public void deleteByCopying(int el) {
        IntBSTNode node;
		IntBSTNode p = root, prev = null;
		while (p != null && p.key != el) { // find the node p
			prev = p; // with element el;
			if (p.key < el)
				p = p.right;
			else
				p = p.left;
		}
		node = p;
		if (p != null && p.key == el) {
			if (node.right == null) // node has no right child;
				node = node.left;
			else if (node.left == null) // no left child for node;
				node = node.right;
			else {
				IntBSTNode tmp = node.left; // node has both children;
				IntBSTNode previous = node; // 1.
				while (tmp.right != null) { // 2. find the rightmost
					previous = tmp; // position in the
					tmp = tmp.right; // left subtree of node;
				}
				node.key = tmp.key; // 3. overwrite the reference
				// of the key being deleted;
				if (previous == node) // if node's left child's
					previous.left = tmp.left; // right subtree is null;
				else
					previous.right = tmp.left; // 4.
			}
			if (p == root)
				root = node;
			else if (prev.left == p)
				prev.left = node;
			else
				prev.right = node;
		} else if (root != null)
			System.out.println("key " + el + " is not in the tree");
		else
			System.out.println("the tree is empty");
	}

    String Preorder(IntBST tree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
