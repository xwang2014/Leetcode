

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        
        int res = 0;
        
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            
            int j = i - 1;
            while (j > 0) {
                int miss = A[j] - A[j - 1];
                if (miss != diff) {
                    break;
                } else {
                    res++;
                    j = j - 1;
                }
            }
            
        }
        
        return res;
    }

