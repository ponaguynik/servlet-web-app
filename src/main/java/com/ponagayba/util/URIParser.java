package com.ponagayba.util;


public class URIParser {

    public static String[] parse(String uri) {
        String[] uriSplit = uri.split("/");
        String[] result;
        if (uriSplit.length - 1 < 1) {
            result = new String[1];
            result[0] = "";
            return result;
        }

        result = new String[uriSplit.length - 1];
        System.arraycopy(uriSplit, 1, result, 0, uriSplit.length - 1);
        return result;
    }
}
