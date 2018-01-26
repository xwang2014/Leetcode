

/**
 * Definition of Column:
 * public class Column {
 *     public int key;
 *     public String value;
 *     public Column(int key, String value) {
 *         this.key = key;
 *         this.value = value;
 *    }
 * }
 */


public class MiniCassandra {
    
    Map<String, TreeMap<Integer, Column>> map;
    
    public MiniCassandra() {
        // do intialization if necessary
        map = new HashMap<String, TreeMap<Integer, Column>>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String raw_key, int column_key, String column_value) {
        // write your code here
        
        if (!map.containsKey(raw_key)) {
            TreeMap<Integer, Column> treemap = new TreeMap<Integer, Column>();
            map.put(raw_key, treemap);
        } 
        
        TreeMap<Integer, Column> tree = map.get(raw_key);
        
        Column c = new Column(column_key, column_value);
        tree.put(column_key, c);
    }

    /*
     * @param raw_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end)
    {
        // write your code here
        
        List<Column> ans = new ArrayList<Column>();
        
        if (!map.containsKey(raw_key)) {
            return ans;
        }
        
        TreeMap<Integer, Column> tree = map.get(raw_key);
        

        for ( Map.Entry <Integer, Column> entry : tree.subMap(column_start, true, column_end, true).entrySet() ) {
           
            ans.add(entry.getValue());
            
        }
        
        return ans;
    }
}

