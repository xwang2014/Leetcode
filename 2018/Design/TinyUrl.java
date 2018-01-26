

public class TinyUrl {
    
    private static final String PREFIX = "http://tiny.url/";
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Long MAX_VALUE = (long)Math.pow(62, 6);
    
    Map<Long, String> shortToLong = new HashMap<Long, String>();
    Map<String, Long> longToShort = new HashMap<String, Long>();
    
    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        // write your code here
        Long no;
        
        if (longToShort.containsKey(url)) {
            no = longToShort.get(url);
        } else {
            no = (long)(Math.random() * Math.pow(62, 6) );
            longToShort.put(url, no);
            shortToLong.put(no, url);
        }
        
        return getUrl(no);
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
        // write your code here
        Long no = getNum(url);
        
        return shortToLong.get(no);
    }
    
    private String getUrl(long num) {
        StringBuffer sb = new StringBuffer();
        sb.append(PREFIX);
        
        while (num != 0) {
            int i = (int)(num % 62);
            num = num / 62;
            
            sb.append( BASE62.charAt(i) );
        }
        
        // ** padding zeros
        while (sb.length() < PREFIX.length() + 6) {
            sb.append(BASE62.charAt(0));
        }
        
        return sb.toString();
    }
    
    private Long getNum(String shortUrl) {
        Long ans = 0L;
        
        Long base = 1L;
        for (int i = shortUrl.length() - 6; i <= shortUrl.length() - 1; i++) {
            char c = shortUrl.charAt(i);
            int digit = BASE62.indexOf(c);
            ans += digit * base;
            base *= 62;
        }
        
        return ans;
    }
}


