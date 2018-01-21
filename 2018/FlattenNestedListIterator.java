

    Stack<NestedInteger> stack = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        
        stack = new Stack<NestedInteger>();
        
        int len = nestedList.size();
        for (int i = len - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
        
    }

    @Override
    public Integer next() {
        
        if (hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
            
        if (stack.peek().isInteger()) {
            return true;
        }
            
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger ni = stack.pop();
            
            List<NestedInteger> list = ni.getList();
            
            for (int j = list.size() - 1; j >= 0; j--) {
                stack.push(list.get(j));
            }
        }
        
        if (!stack.isEmpty() && stack.peek().getInteger() != null) {
            return true;
        } else {
            return false;
        }
        
    }


