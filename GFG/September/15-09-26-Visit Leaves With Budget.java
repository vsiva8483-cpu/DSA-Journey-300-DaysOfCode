/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
import java.util.*;

class Solution {
    public int getCount(Node root, int k) {
        List<Integer> leaves = new ArrayList<>();
        find(root, 1, leaves);

        Collections.sort(leaves);

        int count = 0, cost = 0;

        for (int x : leaves) {
            if (cost + x > k) break;
            cost += x;
            count++;
        }

        return count;
    }

    void find(Node root, int level, List<Integer> leaves) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            leaves.add(level);
            return;
        }

        find(root.left, level + 1, leaves);
        find(root.right, level + 1, leaves);
    }
}
