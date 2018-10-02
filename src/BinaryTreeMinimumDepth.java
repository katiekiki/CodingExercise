public class BinaryTreeMinimumDepth {

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seventeen = new TreeNode(17);

//        three.left = nine;
//        three.right = twenty;
//        twenty.left = fifteen;
//        twenty.right = seventeen;

        three.left = nine;

        System.out.println("this is the min depth " + minDepth(three));

    }

    public static int minDepth(TreeNode root) {
        return minDepthHelper(root);


    }

    public static int minDepthHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = minDepthHelper(node.left);
        int right = minDepthHelper(node.right);
        return (left == 0 || right == 0 ? right + left + 1 : Math.min(left,right));
    }
}
