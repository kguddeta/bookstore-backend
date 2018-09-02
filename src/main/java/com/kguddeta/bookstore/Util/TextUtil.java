package com.kguddeta.bookstore.Util;

public class TextUtil {
    public String sanitize(String textToSanitize){
        return textToSanitize.replaceAll("\\s+"," ");
    }
}
