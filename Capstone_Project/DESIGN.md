# System Design: Supply Chain Traceability & Product Recall

## UML Class Design

[![img_1.png](img_1.png)](https://github.com/anthonyimeza/cs044--data-structures-labs/blob/main/Capstone_Project/ProjectUML.png?raw=true)

## Data Structure Selection

* List<TreeNode> (ArrayList) - Used for fast iteration in traversal and preserves recipe order/assembly order.


* Map<String, TreeNode> (HashMap) - Used for its fast retrieval, insertion, and removal speed.


* Set<String> - Preserves uniqueness of store products/raw materials so there isn't duplicated entries or double counting.

## Big-O Expectations

* Node Registration (registerNode) - O(1) average, O(n) worst-case.


* Link Ingredient (linkIngredient) - O(1) average, O(n) worst-case. 


* Raw Material (getRawMaterials) - O(n) worst-case. You would have to visit most nodes in the hierarchy.


* Recall Tracing (flagRecall) - O(n). Scanning/Traversing the hierarchy to find products containing the raw material
would visit nodes/subtrees across the tree hierarchy to find impacted finished products.
