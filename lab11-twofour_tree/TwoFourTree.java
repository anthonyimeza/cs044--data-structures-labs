
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic -> Finished
        // 1. Create a new right node
            TwoFourNode rightChild = new TwoFourNode();
        // 2. Promote middle key to parent
            int promotedKey = node.keys.get(2);
        // 3. Move keys and children appropriately
            rightChild.keys.add(node.keys.get(3));
            node.keys.subList(2, node.keys.size()).clear();     //Removing everything from index 2 to the end of the list (both indices 2 and 3)

            //Internal Node Logic
            if (!node.isLeaf()) {
                //Move rightmost children to
                rightChild.children.add(node.children.get(3));
                rightChild.children.add(node.children.get(4));
                //Update parent pointers to point toward the new parent (rightChild)
                rightChild.children.get(0).parent = rightChild;
                rightChild.children.get(1).parent = rightChild;

                node.children.subList(3, node.children.size()).clear();     //Keeps indices 0, 1, 2; Cuts the rest
            }
        // 4. Update parent pointers
            if (node.parent == null) {
                TwoFourNode newRoot = new TwoFourNode();
                //Promoted key is now the new root; Establishes children
                newRoot.keys.add(promotedKey);
                newRoot.children.add(node);
                newRoot.children.add(rightChild);
                //Update parent pointers
                node.parent = newRoot;
                rightChild.parent = newRoot;
                //Updates tree's root
                this.root = newRoot;
            } else {
                //Insert key into the parent
                node.parent.insertKey(promotedKey);
                //Finds where the promoted key is in the parent's key list
                int index = node.parent.keys.indexOf(promotedKey);
                //Insert right child into parent's children list after the promoted key
                node.parent.children.add(index + 1, rightChild);
                //Updates the parent pointers
                rightChild.parent = node.parent;
            }
        System.out.println("Splitting node with keys: " + node.keys);
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }

    //TODO: Practicing implementation of Preorder and Postorder -> Finished

    private void preorder(TwoFourNode node) {
        if (node == null) return;
        //Visit all keys in current node
        for (int key : node.keys) {
            System.out.print(key + " ");
        }
        //Recursively visit all child subtrees
        for (TwoFourNode child : node.children){
            preorder(child);
        }
    }

    private void postorder(TwoFourNode node) {
        if (node == null) return;
        //Recursively visit all child subtrees
        for (TwoFourNode child : node.children) {
            postorder(child);
        }
        //Visit all keys in current node
        for (int key : node.keys) {
            System.out.print(key + " ");
        }
    }

    public void preorder() {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }

}