

public class TinyUrl2 {
    
    /**
     * customized url doesn't not have to be 6-digit
     * 
     */
    
    private static final String PREFIX = "http://tiny.url/";
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Long MAX_VALUE = (long)Math.pow(62, 6);
    
    private Map<String, String> shortToLong = new HashMap<String, String>();
    private Map<String, String> longToShort = new HashMap<String, String>();
    
    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        // write your code here
        
        if (longToShort.containsKey(long_url)) {
            if (longToShort.get(long_url).equals(key)) {
                return PREFIX + key;
            } else {
                return "error";
            }
        } else if (shortToLong.containsKey(key)) {
            if (shortToLong.get(key).equals(long_url)) {
                return PREFIX + key;
            } else {
                return "error";
            }
        } else {
            longToShort.put(long_url, key);
            shortToLong.put(key, long_url);
            return PREFIX + key;
        }
        
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // write your code here
        if (longToShort.containsKey(long_url)) {
            return PREFIX + longToShort.get(long_url);
        } else {
            long no = (long)(Math.random() * MAX_VALUE );
            String key = getUrl(no);
            
            while (shortToLong.containsKey(key)) {
                no = (long)(Math.random() * MAX_VALUE );
                key = getUrl(no);
            }
            
            longToShort.put(long_url, key);
            shortToLong.put(key, long_url);
            
            return PREFIX + key;
        }
    }
    
    private String getUrl(long num) {
        StringBuffer sb = new StringBuffer();
        
        while (num != 0) {
            int i = (int)(num % 62);
            num = num / 62;
            
            sb.append( BASE62.charAt(i) );
        }
        
        while (sb.length() < 6) {
            sb.append(BASE62.charAt(0));
        }
        
        return sb.toString();
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        // write your code here
        String key = short_url.substring(PREFIX.length());  
        if (shortToLong.containsKey(key)) {
            return shortToLong.get(key);
        } else {
            return "error";
        }
    }
}

