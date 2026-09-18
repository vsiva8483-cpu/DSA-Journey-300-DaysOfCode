class Solution {

    int ans = Integer.MAX_VALUE;
    Node prev = null;

    public int absDiff(Node root) {
        inorder(root);
        return ans;
    }

    void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null)
            ans = Math.min(ans, root.data - prev.data);

        prev = root;

        inorder(root.right);
    }
}
