package ru.shabarov.mezentcev.chapter11;

import java.util.StringTokenizer;

/**
 * Created by Mikhail on 13.09.2016.
 */
public class Task11_8 {
    public static String getLongestWord(String text){
        String delimeter = "\n ,.";
        StringTokenizer st = new StringTokenizer(text, delimeter);
        String longest = null;
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(longest != null) {
                if (longest.length() < token.length()) longest = token;
            }else{
                longest = token;
            }
        }
        return longest;
    }
}
