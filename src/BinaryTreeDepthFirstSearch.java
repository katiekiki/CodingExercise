import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeDepthFirstSearch {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        four.left = two;
        two.left = one;
        two.right = three;
        four.right = six;
        six.left = five;
        six.right = seven;

        int[] inputs = {5, 9, 1};

        for (int input: inputs) {
            System.out.println("input is " + input + " and it is in the tree " + dfs(input,four));
        }


        System.out.print("Depth first search "); depthFirstSearchTraversal(four);
        System.out.println();
        System.out.print("Breadth first search "); breadthFirstSearchTraversal(four);
        System.out.println();
        System.out.print("Inorder Traversal "); inorderTraversal(four);
        System.out.println();
        System.out.print("Preorder Traversal "); preorderTraversal(four);
        System.out.println();
        System.out.print("Postorder Traversal "); postorderTraversal(four);
        System.out.println();

    }

    public static boolean dfs(int val, TreeNode node) {
        if (node == null) {
            return false;
        }
        if (val == node.val) {
            return true;
        }

        if (val < node.val) {
            return dfs(val,node.left);
        } else {
            return dfs(val,node.right);
        }
    }

    public static void depthFirstSearchTraversal(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode nextNode = stack.pop();
            System.out.print(nextNode.val + " ");

            if (nextNode.right != null) {
                stack.push(nextNode.right);
            }
            if (nextNode.left != null) {
                stack.push(nextNode.left);
            }
        }

    }

    public static void breadthFirstSearchTraversal(TreeNode node) {
        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()) {
            TreeNode qNode = queue.poll();
            System.out.print(qNode.val + " ");
            if (qNode.left != null) {
                queue.offer(qNode.left);
            }
            if (qNode.right != null) {
                queue.offer(qNode.right);
            }
        }
    }


    //left -> root -> right
    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);

    }

    //root -> left -> right
    public static void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);

    }

    //left -> right -> root
    public static void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.val + " ");

    }
}
