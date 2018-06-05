

class Solution {
    
    // BFS
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<String>(Arrays.asList(deadends));
        
        if (dead.contains("0000")) {
            return -1;
        }
        
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(target);
        
        int level = 0;
        int size = 1;
        while ( !queue.isEmpty() ) {
            size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                visited.add(cur);
               
                if (cur.equals("0000")) {
                    return level;
                }
                
                for (int digit = 0; digit < 4; digit++) {
                    String up = up(cur, digit);
                    if (!dead.contains(up) && !visited.contains(up)) {
                        queue.offer(up);
                    }
                    
                    String down = down(cur, digit);
                    if (!dead.contains(down) && !visited.contains(down)) {
                        queue.offer(down);
                    }
                }
            }
            
            level += 1;
        } 
        
        return -1;
    }
    
    private String up(String str, int idx) {
        char[] arr = str.toCharArray();
        
        arr[idx] = (arr[idx] == '9') ? '0' : (char)((int)arr[idx] + 1);
        
        return new String(arr);
    }
    
    private String down(String str, int idx) {
        char[] arr = str.toCharArray();
        
        arr[idx] = (arr[idx] == '0') ? '9' : (char)((int)arr[idx] - 1);
        
        return new String(arr); 
    }
}

