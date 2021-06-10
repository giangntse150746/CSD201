package Example;


import org.junit.Before;

public class TreeTest {
	IntBST tree;
	IntBST emtyTree;
	// enable to declare more trees
	
	
	@Before
	public void setUp() throws Exception {
		
		emtyTree = new IntBST();
		tree = new IntBST();
		tree.Insert(8);
		tree.Insert(3);
		tree.Insert(10);
		tree.Insert(1);
		tree.Insert(6);
		tree.Insert(14);
		tree.Insert(4);
		tree.Insert(7);
		tree.Insert(13);
	}

        public static void main(String[] args) throws Exception {
            TreeTest test = new TreeTest();
            test.setUp();
            System.out.println("Nodes: " + test.tree.CountNode(test.tree.root));
                    System.out.println("----------");
                    
            System.out.println("Leaves: " + test.tree.CountLeafNode(test.tree.root));
                    System.out.println("----------");
                    
            System.out.println("Internal Nodes: " + test.tree.CountNonterminalNodes(test.tree.root));
                    System.out.println("----------");
                    
            int i = 14;
            System.out.println("Level of Node [" + i + "]: " + test.tree.GetLevel(i));
                    System.out.println("----------");
            
            i = 14;
            System.out.println("Level of Node[" + i + "] but by Iterative: " + test.tree.GetLevelWithIterative(i));
                    System.out.println("\n----------");
                    
            System.out.print("PreOrder List: ");
            test.tree.Preorder(test.tree.root);
                    System.out.println("\n----------");
                    
            System.out.print("InOrder List: ");
            test.tree.Inorder(test.tree.root);
                    System.out.println("\n----------");
                    
            System.out.print("PostOrder List: ");
            test.tree.Postorder(test.tree.root);
                    System.out.println("\n----------");
                    
            System.out.print("BreadthFirst Order List: ");
            test.tree.BreathFirst();
                    System.out.println("\n----------");
    }

}
