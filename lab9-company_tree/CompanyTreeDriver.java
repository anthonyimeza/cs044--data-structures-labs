

public class CompanyTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Create the root node (e.g., "CEO")
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Create department heads (children of root)
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);
        //Sales Team
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        //Below Sales VP in Hierarchy
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);
        //Dev Team
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        GeneralTreeNode QALead = new GeneralTreeNode("QA Team Lead");
        //devLead and QALead below VP Engineer in Hierarchy
        vpEngineering.addChild(devLead);
        devLead.addChild(dev1);
        devLead.addChild(dev2);
        vpEngineering.addChild(QALead);





        // 2. Perform Traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}
