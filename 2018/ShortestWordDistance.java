
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        int dis = Integer.MAX_VALUE;
        int one = -1, two = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                one = i;
            } 
            if (words[i].equals(word2)) {
                two = i;
            }
            
            if (one != -1 && two != -1) {
                dis = Math.min(dis, Math.abs(one - two));
            }
            
        }
        
        return dis;
    }
}

