package orderfirst.orderpos.dbGetData;


public class Decoder {
    
    //Unicode轉中文方法
    private static String unicodeToCZh(String unicode) {
        /** 以 \ u 分割，因為java注釋也能識別unicode，因此中間加了一個空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由於unicode字符串以 \ u 開頭，因此分割出的第一個字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }

    //中文轉Unicode
    private static String ZhToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }
    
/*
    //測試
    public static void main(String[] args) {
        //Unicode碼
        String aa = "\\u5916\\u56fd\\u4eba\\u88ab\\u4e2d\\u56fd\\u8fd9\\u4e00\\u5927\\u52a8\\u4f5c\\u6298\\u670d";
        //轉中文
        String cnAa = unicodeToCn(aa);
        System.out.println("Unicode轉中文結果： "+cnAa);
        //轉Unicode
        String unicodeAa = cnToUnicode(cnAa);
        System.out.println("中文轉Unicode結果： "+unicodeAa);
    }
*/
}
