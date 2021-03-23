package com.exchange.exchangeConnectivity.helper;

public class Helper {


    public static String removeQuotesFromStartAndEndOfString(String inputStr) {
        String result = inputStr;
        int firstQuote = inputStr.indexOf('\"');
        int lastQuote = result.lastIndexOf('\"');
        int strLength = inputStr.length();
        if (firstQuote == 0 && lastQuote == strLength - 1) {
            result = result.substring(1, strLength - 1);
        }
        return result;
    }



}
