
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (rowIndex < 0) return list;
        
        
        
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }
        
        return list;
    }


