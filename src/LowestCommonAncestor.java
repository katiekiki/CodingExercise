import java.util.HashMap;
import java.util.Stack;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        // The mapping we're going to use for constructing a tree.
        // For example, {0: [1, 2]} means that 0's left child is 1, and its right
        // child is 2.
        HashMap<Integer, int[]> mapping1 = new HashMap<Integer, int[]>();
        int[] childrenA = {1, 2};
        int[] childrenB = {3, 4};
        int[] childrenC = {5, 6};
        mapping1.put(0, childrenA);
        mapping1.put(1, childrenB);
        mapping1.put(2, childrenC);

        TreeNode head1 = createTree(mapping1, 0);

        // This tree is:
        // head1 = 0
        //        / \
        //       1   2
        //      /\   /\
        //     3  4 5  6


        HashMap<Integer, int[]> mapping2 = new HashMap<Integer, int[]>();
        int[] childrenD = {1, 4};
        int[] childrenE = {3, 8};
        int[] childrenF = {9, 2};
        int[] childrenG = {6, 7};
        mapping2.put(5, childrenD);
        mapping2.put(1, childrenE);
        mapping2.put(4, childrenF);
        mapping2.put(3, childrenG);

        TreeNode head2 = createTree(mapping2, 5);
        // This tree is:
        //  head2 = 5
        //        /   \
        //       1     4
        //      /\    / \
        //     3  8  9  2
        //    /\
        //   6  7


        System.out.println("For head1 and values 1 and 5, the lca is [" + lca(head1, 1, 5).val + "]");
        System.out.println("For head1 and values 3 and 1, the lca is [" + lca(head1, 3, 1).val + "]");
        System.out.println("For head1 and values 1 and 4, the lca is [" + lca(head1, 1, 4).val + "]");
        System.out.println("For head1 and values 0 and 5, the lca is [" + lca(head1, 0, 5).val + "]");
        System.out.println("For head2 and values 4 and 7, the lca is [" + lca(head2, 4, 7).val + "]");
        System.out.println("For head2 and values 3 and 3, the lca is [" + lca(head2, 3, 3).val + "]");
        System.out.println("For head2 and values 8 and 7, the lca is [" + lca(head2, 8, 7).val + "]");
        if (lca(head2, 3, 0) == null) {
            System.out.println("0 does not exist in the tree.");
        } else {
            System.out.println("For head2 and values 3 and 0, the lca is [" + lca(head2, 8, 7).val + "]");
        }

        // lca(head1, 1, 5) should return 0
        // lca(head1, 3, 1) should return 1
        // lca(head1, 1, 4) should return 1
        // lca(head1, 0, 5) should return 0
        // lca(head2, 4, 7) should return 5
        // lca(head2, 3, 3) should return 3
        // lca(head2, 8, 7) should return 1
        // lca(head2, 3, 0) should return null (0 does not exist in the tree)

    }

    // Implement your function below.
    public static TreeNode lca(TreeNode root, int j, int k) {
        Stack<TreeNode> pathToJ = pathToX(root,j);
        Stack<TreeNode> pathToK = pathToX(root,k);
        TreeNode lca = null;

        if (pathToJ == null || pathToK == null) {
            return null;
        }

        while (!pathToJ.isEmpty() && !pathToK.isEmpty()) {
            TreeNode topJ = pathToJ.pop();
            TreeNode topK = pathToK.pop();
            if (topJ == topK) {
                lca = topJ;
            } else {
                break;
            }

        }

        return lca;

    }


    public static Stack<TreeNode> pathToX(TreeNode root, int val) {
        //node doesn't exist
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            Stack<TreeNode> nodes = new Stack<>();
            nodes.push(root);
            return nodes;
        }

        //search right treenodes
        Stack<TreeNode> rightNodes = pathToX(root.right,val);
        if (rightNodes != null) {
            rightNodes.push(root);
            return rightNodes;
        }

        //search left treenodes
        Stack<TreeNode> leftNodes = pathToX(root.left,val);
        if (leftNodes != null) {
            leftNodes.push(root);
            return leftNodes;
        }

        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // A function for creating a tree.
    // Input:
    // - mapping: a node-to-node mapping that shows how the tree should be constructed
    // - headValue: the value that will be used for the head ndoe
    // Output:
    // - The head node of the resulting tree
    public static TreeNode createTree(HashMap<Integer, int[]> mapping, int headValue) {
        TreeNode head = new TreeNode(headValue, null, null);
        HashMap<Integer, TreeNode> nodes = new HashMap<Integer, TreeNode>();
        nodes.put(headValue, head);
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            TreeNode leftChild = new TreeNode(value[0], null, null);
            TreeNode rightChild = new TreeNode(value[1], null, null);
            nodes.put(value[0], leftChild);
            nodes.put(value[1], rightChild);
        }
        for(Integer key : mapping.keySet()) {
            int[] value = mapping.get(key);
            nodes.get(key).left = nodes.get(value[0]);
            nodes.get(key).right = nodes.get(value[1]);
        }
        return head;
    }

}
