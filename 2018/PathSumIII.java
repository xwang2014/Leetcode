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
    
    // Use prefix tree as a hashmap
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        res = 0;
        
        Map<Integer, Integer> prefixTree = new HashMap<Integer, Integer>();
        prefixTree.put(0, 1);
        helper(root, 0, sum, prefixTree);
        
        return res;
    }
    
    private void helper(TreeNode node, int currentSum, int target, Map<Integer, Integer> prefixTree) {
        if (node == null) {
            return;
        }
        
        currentSum += node.val;
        
        if (prefixTree.containsKey(currentSum - target)) {
            res += prefixTree.get(currentSum - target);
        }
        prefixTree.put(currentSum, prefixTree.getOrDefault(currentSum, 0) + 1);

        helper(node.left, currentSum, target, prefixTree);
        helper(node.right, currentSum, target, prefixTree);
        
        prefixTree.put(currentSum, prefixTree.get(currentSum) - 1);
    }
}


