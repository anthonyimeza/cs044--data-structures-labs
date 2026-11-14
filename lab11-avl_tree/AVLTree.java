// TODO: Implement the AVLNode class -> Finished
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        // TODO: Initialize key, height, left, and right -> Finished
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node -> Finished
    int height(AVLNode N) {     //Check for node height
        if (N == null)
            return 0;
        return N.height;
    }

    // TODO: Return maximum of two integers -> Finished
    int max(int a, int b) {     //Finds which height is larger
        if (a > b)
            return a;
        return b;
    }

    // TODO: Compute balance factor -> Finished
    int getBalance(AVLNode N) {     //Figures out what is the balance factor
        if (N == null)
            return 0;
        return height(N.left) - (height(N.right));
    }

    // TODO: Right rotation -> Finished
    AVLNode rightRotate(AVLNode y) {    //Left-Left Imbalance
        AVLNode x = y.left;
        AVLNode midSubtree = x.right;

        //Rotation
        x.right = y;
        y.left = midSubtree;
        //Updates Heights
        y.height = 1 + max(height(y.left), height(y.right));
        x.height = 1 + max(height(x.left), height(x.right));
        //Returns new root
        return x;
    }

    // TODO: Left rotation -> Finished
    AVLNode leftRotate(AVLNode x) {     //Right-Right Imbalance
        AVLNode y = x.right;
        AVLNode midSubtree = y.left;

        //Rotation
        y.left = x;
        x.right = midSubtree;
        //Update the Heights
        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));
        //Returns new root
        return y;
    }

    // TODO: Left-Right rotation -> Finished
    AVLNode leftRightRotate(AVLNode z) {    //Left-Right Rotation (Zig-Zag; Left subtree then Right tree goes inward)
        z.left = leftRotate(z.left);    //Fixes child subtree first
        return rightRotate(z);          //Fixes main node

    }

    // TODO: Right-Left rotation -> Finished
    AVLNode rightLeftRotate(AVLNode y) {    //Right-Left Rotation (Zig-Zag; Right Subtree then Left Tree goes inward)
        y.right = rightRotate(y.right);     //Fixes Child subtree first
        return leftRotate(y);               //Fixes main node
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing -> Finished
    private AVLNode insert(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);    //Base Case: found insertion spot
        } else if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        //Updates Height
        node.height = 1 + max(height(node.left), height(node.right));

        //Checks balance factor
        int balance = getBalance(node);

        //Left-Left case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        //Left-right case
        if (balance > 1 && key > node.left.key) {
            return leftRightRotate(node);
        }
        //Right-Right case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        //Right-Left case
        if (balance < -1 && key < node.right.key) {
            return rightLeftRotate(node);
        }


        //If all checks are passed (balanced), return node
        return node;
    }

    // TODO: Traversal methods -> Finished
    public void inorder() {
        inorder(root);
        System.out.println();
    }
    //Left -> Root -> Right
    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);                 //Left Subtree
            System.out.print(node.key + " ");   //Print the subtree
            inorder(node.right);                //Right Subtree

        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }
    //Root -> Left -> Right
    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }
    //Left -> Right -> Root
    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}