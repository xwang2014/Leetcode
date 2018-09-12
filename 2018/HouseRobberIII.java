
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<TreeNode, Integer> use;
    Map<TreeNode, Integer> unuse;
    
    public int rob(TreeNode root) {
        use = new HashMap<>();
        unuse = new HashMap<>();
        
        return Math.max(
            maxVal(root, true),
            maxVal(root, false)
        );
    }
    
    
    private int maxVal(TreeNode node, boolean usable) {
        if (node == null) {
            return 0;
        }
        
        // use current node
        int one = 0;
        if (use.containsKey(node)) {
            one = use.get(node);
        } else {
            one = node.val + maxVal(node.left, false) + maxVal(node.right, false);
            use.put(node, one);
        }

        // no use current node
        int two = 0;
        if (unuse.containsKey(node)) {
            two = unuse.get(node);
        } else {
            two = maxVal(node.left, true) + maxVal(node.right, true);
            unuse.put(node, two);
        }
        
        if (!usable) {
            return two;
        } else {
            return Math.max(one, two);
        }
    }
}


