

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        } else {
            return subTree(1, n);
        }        
    }
    
    private List<TreeNode> subTree(int start, int end) {
        List<TreeNode> arr = new ArrayList<TreeNode>();
        if(start > end) {
            TreeNode t = null;
            arr.add(t);
            return arr;
        }
        
        for(int i = start; i <= end; i++ ) {
            List<TreeNode> left = subTree(start, i - 1);
            List<TreeNode> right = subTree(i + 1, end);
            for(int j = 0; j < left.size(); j++ ) {
                for(int k = 0; k < right.size(); k++) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left.get(j);
                    cur.right = right.get(k);
                    arr.add(cur);
                }
            }
            
        }
        return arr;
    }   


