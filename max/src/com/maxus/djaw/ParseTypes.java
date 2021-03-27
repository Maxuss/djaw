package com.maxus.djaw;



import java.util.Arrays;
import java.util.List;

public class ParseTypes {
    public static void main(String[] args){
        DJaw.DJMessage("null", 0);
    }
    public static String FindParserData(String[] parserArguments){
        List<String> strList = Arrays.asList(
                parserArguments[0].toLowerCase() /*creator*/, parserArguments[1] /*type*/,
                parserArguments[2] /*name*/, parserArguments[3] /*classname*/,
                parserArguments[4] /*stability*/, parserArguments[5] /*version*/
        );
        String joinedString = String.join("_", strList);
        System.out.println(joinedString);
        return joinedString;
    }
}
