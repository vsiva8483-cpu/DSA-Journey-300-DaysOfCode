/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node r1, Node r2) {
        Queue<Node> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(r1); q2.add(r2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() != q2.size()) return false;

            Map<Integer,Integer> m1 = new HashMap<>(), m2 = new HashMap<>();

            for (int i = q1.size(); i > 0; i--) {
                Node n = q1.poll();
                m1.put(n.data, m1.getOrDefault(n.data, 0) + 1);
                if (n.left != null) q1.add(n.left);
                if (n.right != null) q1.add(n.right);
            }

            for (int i = q2.size(); i > 0; i--) {
                Node n = q2.poll();
                m2.put(n.data, m2.getOrDefault(n.data, 0) + 1);
                if (n.left != null) q2.add(n.left);
                if (n.right != null) q2.add(n.right);
            }

            if (!m1.equals(m2)) return false;
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
