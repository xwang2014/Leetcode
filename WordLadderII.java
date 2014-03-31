


public class WordLadderII {


/*     TLE 
    private void dfs(HashMap<String, ArrayList<String>> path, String start, String word, 
            ArrayList<ArrayList<String>> result, ArrayList<String> list) {

        
        ArrayList<String> links = path.get(word);
        if(links == null) return;
        for(int i = 0; i < links.size(); i++) {
            String prev = links.get(i);
            
            if(prev.equals(start)) {
                ArrayList<String> ans = new ArrayList<String>(list);
                ans.add(prev);
                Collections.reverse(ans);
                result.add(ans);
            } else {
                list.add(prev);
                dfs(path, start, prev, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, ArrayList<String>> path = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> level = new HashMap<String, Integer>(); 
        Queue<String> queue = new LinkedList<String>();
        int curLevel = 1, nextLevel = 0, depth = 1;
        queue.offer(start);
        level.put(start, 0);
        boolean flag = true;
        
        while(flag && !queue.isEmpty()) {
            for(int t = 0; t < curLevel; t++) {
                String curWord = queue.poll();
                for(int i = 0; i < curWord.length(); i++) {
                    char[] arr = curWord.toCharArray();
                    for(char j = 'a'; j <= 'z'; j++) {
                        if(j == curWord.charAt(i)) continue;
                        arr[i] = j;
                        String convertedWord = new String(arr);
        
                        
                        if(dict.contains(convertedWord) || convertedWord.equals(end)) {
                            if(convertedWord.equals(end)) {
                                flag = false;
                            }
                        
                            if(path.containsKey(convertedWord)) {
                                if(level.get(convertedWord) == level.get(curWord) + 1) {
                                    path.get(convertedWord).add(curWord);
                                    queue.offer(convertedWord);
                                    nextLevel++;
                                }
                            } else {
                                ArrayList<String> list = new ArrayList<String>();
                                list.add(curWord);
                                path.put(convertedWord, list);
                                
                                level.put(convertedWord, depth);
                                
                                if(level.get(convertedWord) == level.get(curWord) + 1) {
                                	nextLevel++;
                                	queue.offer(convertedWord);
                                }
                            }
                            
                       
                        }
                    }
                }
            }
            curLevel = nextLevel;
            nextLevel = 0;
            depth++;
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        list.add(end);
        dfs(path, start, end, result, list);
        
        return result;
    }
*/

}
