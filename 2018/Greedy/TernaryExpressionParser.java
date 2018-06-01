
class Solution {
/*
    public String parseTernary(String expression) {
        
        if (expression == null || expression.length() < 1) return null;
        
        String buffer = expression;
        
        int question = 0;
        while ( (question = buffer.lastIndexOf('?')) != -1) {
            
            String sub = buffer.substring(question - 1, question + 4);
            String subVal = process(sub);
            
            buffer = buffer.substring(0, question - 1) 
                      + subVal
                      + buffer.substring(question + 4);
        }
        
        return buffer;
    }
    
    private String process(String exp) {
        if (exp.charAt(0) == 'T') {
            return exp.substring(2, 3);
        } else {
            return exp.substring(4, 5);
        }
    }
*/


    // using stack to avoid string concat
    public String parseTernary(String expression) {
        Stack<String> stack = new Stack<String>();
        
        int i = expression.length() - 1;
        while (i >= 0) {
            char c = expression.charAt(i);
            
            if (c == '?') {
                String one = stack.pop();
                String two = stack.pop();
                
                i -= 1;
                char condition = expression.charAt(i);
                if (condition == 'T') {
                    stack.push(one);
                } else {
                    stack.push(two);
                }
                
            } else if (c != ':') {
                stack.push("" + c);
            } // skip :
            
            i--;
        }
        
        return stack.pop();
    }

}


