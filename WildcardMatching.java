// http://n00tc0d3r.blogspot.com/2013/05/wildcard-matching.html
public class WildcardMatching {
    
    public boolean isMatch(String s, String p) {
        // corner case
        if(s == null || p == null) return false;
        
        // corner case - p has more letters than s
        int letterCount = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) != '*') letterCount++;
        }
        if(letterCount > s.length()) return false;
        
        //
        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;
        
        int index = 0, firstMatch = 0;
        while(index < p.length()) {
            char c = p.charAt(index);
            int matcher = -1;
            if(c == '*') {
                for(int i = firstMatch + 1; i < match.length; i++)
                    match[i] = true;
            } else {
                for(int i = s.length(); i > firstMatch; i--) {
                    match[i] = (c == '?' || c == s.charAt(i - 1) ) && match[i - 1];
                    
                    if(match[i]) matcher = i;
                }
                
                if(matcher == -1) return false;
                else firstMatch = matcher;
            }
        
            index++;
        }
        
        return match[match.length - 1];
    }
}
