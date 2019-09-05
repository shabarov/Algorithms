package ru.shabarov.mezentcev.chapter06;

/**
 * Created by Mikhail on 08.09.2016.
 */
public class Task6_7 {
    public static String trimString(String s){

        StringBuilder sb = new StringBuilder();
        char[] sequence = s.toCharArray();

        for(char c : sequence){
            if(Character.isWhitespace(c)){
                if(sb.length() != 0 && !Character.isWhitespace(sb.charAt(sb.length() - 1))){
                    sb.append(c);
                }
            }else{
                sb.append(c);
            }
        }

        if(Character.isWhitespace(sb.charAt(sb.length()-1))) sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
