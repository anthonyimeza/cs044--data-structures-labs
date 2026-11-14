


public class AVLTreeDriver {
    public static void main(String[] args) {
            AVLTree tree = new AVLTree();

            // TODO: Insert test values
            tree.insert(10);
            tree.insert(20);
            tree.insert(30);    //Triggers Left Rotation
            tree.insert(5);
            tree.insert(4);     //Triggers Right Rotation
            tree.insert(8);     //Triggers Left-Right Rotation
            tree.insert(25);    //Triggers Right-Left Rotation

            // TODO: Add more insertions to test all 4 rotation cases -> Finished

            // TODO: Print traversals -> Finished
            System.out.print("Inorder: ");
            tree.inorder();
            //Expected Results: 4, 5, 8, 10, 20, 25, 30

            System.out.print("Preorder: ");
            tree.preorder();
            //Expected Results: 10, 5, 4, 8, 25, 20, 30

            System.out.print("Postorder: ");
            tree.postorder();
            //Expected Results: 4, 8, 5, 20, 30, 25, 10

            // TODO: Add expected results as comments for verification -> Finished
    }
}

