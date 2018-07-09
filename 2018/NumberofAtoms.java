class Solution {
    
    int idx = 0;
    public String countOfAtoms(String formula) {
        idx = 0;
        Map<String, Integer> map = helper(formula);
        
        List<String> elements = new ArrayList<String>(map.keySet());
        Collections.sort(elements);
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < elements.size(); i++) {
            int num = map.get(elements.get(i));
            if (num == 1) {
                sb.append(elements.get(i));
            } else {
                sb.append(elements.get(i) + num);
            }
        }
        
        return sb.toString();
    }
    
    
    private Map<String, Integer> helper(String formula) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        boolean flag = true;
        while(flag && idx < formula.length()) {
            // upper case
            if (isUpper(formula.charAt(idx))) {
                // get element string
                int end = idx + 1;
                while (end < formula.length() && isLower(formula.charAt(end)) ) {
                    end += 1;
                }
                String element = formula.substring(idx, end);
                
                // check num suffix
                int quantity = 1;
                int numIndex = end;
                while (numIndex < formula.length() && isNum(formula.charAt(numIndex)) ) {
                    numIndex += 1;
                }
                if (numIndex > end) {
                    quantity = Integer.parseInt( formula.substring(end, numIndex) );
                }
                end = numIndex;
                
                
                
                if (map.containsKey(element)) {
                    map.put(element, map.get(element) + quantity);
                } else {
                    map.put(element, quantity);
                }

                if (end >= formula.length()) {
                    flag = false;
                } else {
                    idx = end;
                }
            } else if (formula.charAt(idx) == '(') {
                idx += 1;
                Map<String, Integer> sub = helper(formula);
                
                map = mergeMap(sub, map);
                
            } else if (formula.charAt(idx) == ')') {
                // check num suffix
                int quantity = 1;
                idx += 1;
                int numIndex = idx;
                
                while (numIndex < formula.length() && isNum(formula.charAt(numIndex)) ) {
                    numIndex += 1;
                } 
                if (numIndex > idx) {
                    quantity = Integer.parseInt( formula.substring(idx, numIndex) );
                }
                idx = numIndex;
                
                // double all map with quantity
                for (String c : map.keySet()) {
                    map.put(c, map.get(c) * quantity);
                }
                return map;
            }
        }
        
        return map;
    }
    
    private Map<String, Integer> mergeMap(Map<String, Integer> m1, Map<String, Integer> m2) {
        for (String c : m1.keySet()) {
            if (m2.containsKey(c)) {
                m2.put(c, m2.get(c) + m1.get(c));
            } else {
                m2.put(c, m1.get(c));
            }
        }
        
        return m2;
    }
    
    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
    
    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }
    
    private boolean isLower(char c) {
        return c >= 'a' && c <= 'z';
    }
}
