


class Solution {
    
    // Solution 1 : represent the tree as HashMap
    int res = 0;
    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i : nums) {
            int level = i / 10;
            int val = i % 10;
            map.put (level, val);
        }
        
        res = 0;
        
        helper(map, 11, 0);
        
        return res;
    }
    
    private void helper(Map<Integer, Integer> map, int node, int currentSum) {
        if (!map.containsKey(node)) {
            return;
        }
        currentSum += map.get(node);
        
        int level = node / 10;
        int pos = node % 10;
        
        int leftChild = (level + 1) * 10 + (2 * pos - 1);
        int rightChild = (level + 1) * 10 + (2 * pos);
        
        if (!map.containsKey(leftChild) && !map.containsKey(rightChild)) {
            res += currentSum;
            return;
        }
        
        helper(map, leftChild, currentSum);
        helper(map, rightChild, currentSum);
        
        currentSum -= map.get(node);
    }
}








