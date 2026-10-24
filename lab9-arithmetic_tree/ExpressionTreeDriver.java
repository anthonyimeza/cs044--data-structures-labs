

public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Manually build the tree for: ( (3 + 7) * (9 - 4) )
        //
        //         *
        //        / \
        //       +   -
        //      / \ / \
        //     3  7 9  4
        //

        BinaryTreeNode root = new BinaryTreeNode("*");

        BinaryTreeNode nodePlus = new BinaryTreeNode("+");
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");

        // --- TO BE COMPLETED BY STUDENT ---
        // Connect root, nodePlus, and nodeMinus
        root.left = nodePlus;
        root.right = nodeMinus;
        nodePlus.parent = root;

        // Create and connect the leaves (operands)
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        //Define parent for nodes 3 and 7
        node3.parent = nodePlus;
        node7.parent = nodePlus;
        //Define Left and Right nodes for nodePlus
        nodePlus.left = node3;
        nodePlus.right = node7;


        // Connect leaves to their parents (nodePlus and nodeMinus)
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");
        //Define parent for nodes 9 and 4
        node9.parent = nodeMinus;
        node4.parent = nodeMinus;
        //Define left and right nodes for nodeMinus
        nodeMinus.left = node9;
        nodeMinus.right = node4;


        // 2. Perform Traversals
        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();

        System.out.println("\n\n--- Custom Display for the Tree---");
        root.printTree("");
    }
}
