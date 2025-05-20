

//User function Template for Java

class Solution
{
    /*class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    
    static Map<Node, Node> map = new HashMap<>();

    public static int minTime(Node root, int target) {
        // Your code goes here
        Node node = createParentMap(root, target);
        return solve(node);
    }

    public static int solve (Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Set<Node> vis = new HashSet<>();
        vis.add(node);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                if (map.containsKey(curr) && !vis.contains(map.get(curr))) {
                    vis.add(map.get(curr));
                    q.add(map.get(curr));
                }
                if (curr.right != null && !vis.contains(curr.right)) {
                    vis.add(curr.right);
                    q.add(curr.right);
                }
                if (curr.left != null && !vis.contains(curr.left)) {
                    vis.add(curr.left);
                    q.add(curr.left);
                }
            }
            if (!q.isEmpty()) {
                ans++;
            }
        }
        return ans;
    } 

    public static Node createParentMap(Node root, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node = null;
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr.data == target) {
                node = curr;
            }
            if (curr.left != null) {
                q.add(curr.left);
                map.put(curr.left, curr);
            }
            if (curr.right != null) {
                q.add(curr.right);
                map.put(curr.right, curr);
            }
        }
        return node;
    }
}