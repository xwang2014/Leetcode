
public class ValidateIPAddress {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() < 4) {
            return "Neither";
        }

        if (IP.contains(".") && v4(IP)) {
            return "IPv4";
        }

        if (IP.contains(":") && v6(IP)) {
            return "IPv6";
        }

        return "Neither";
    }

    private boolean v6(String val) {
        int cnt = val.length() - val.replace(":", "").length();
        String[] arr = val.split(":");
        if (cnt != 7 || arr.length != 8) {
            return false;
        }


        for (String part : arr) {
            if (!v6Helper(part)) {
                return false;
            }
        }
        return true;
    }

    private boolean v6Helper(String part) {
        if (part.length() < 1 || part.length() > 4) {
            return false;
        }
        part = part.toUpperCase();

        for (int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);

            if (!(( c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'))) {
                return false;
            }
        }

        return true;
    }


    private boolean v4(String val) {
        int cnt = val.length() - val.replace(".", "").length();

        String[] arr = val.split("\\.");
        if (cnt != 3 || arr.length != 4) {
            return false;
        }

        for (String part : arr) {
            if (!v4Helper(part)) {
                return false;
            }
        }

        return true;
    }

    private boolean v4Helper(String part) {
        if (part.length() == 0 || part.length() > 3) {
            return false;
        }

        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }

        for (int i = 0; i < part.length(); i++) {
            if (part.charAt(i) < '0' || part.charAt(i) > '9') {
                return false;
            }
        }

        int val = Integer.parseInt(part);

        return val >= 0 && val <= 255;
    }


    public static void main(String[] args) {
        ValidateIPAddress so = new ValidateIPAddress();

        String IP = "1.0.1.";//"172.16.254.1";//"2001:0db8:85a3:0:0:8A2E:0370:7334:";

        String res = so.validIPAddress(IP);

        System.out.println(res);
    }


}


