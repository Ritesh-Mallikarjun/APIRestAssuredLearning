package June25th_Class_API;

import java.util.HashMap;
import java.util.Map;

public class Lab125 {
    public static void main(String[] args) {
        int a= 100;

        String value = String.valueOf(a);
        System.out.println(value);

        String binvalue = Integer.toBinaryString(a);
        System.out.println(binvalue);

        String hex = Integer.toHexString(a);
        System.out.println(hex);

        char ch = (char) a;
        System.out.println(ch);

//        String s="manda";
////        char ch1[]=s.toCharArray();
////        for (char c:ch1) {
////            System.out.println(c);
////        }
//
//        for (char c :s.toCharArray()) {
//            System.out.println(c);
//        }
        String s = "aabaab";

        // Step 1: Count the occurrences of each character
        Map<Character,Integer> charCountMap = new HashMap();
        for (char c:s.toCharArray()) {
            charCountMap.put(c,charCountMap.getOrDefault(c,0)+1);
        }
        System.out.println(charCountMap);

        StringBuilder result= new StringBuilder();
        int count=0;
        for (char c:s.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                result.append(c);
            }
            else{
                count++;
            }
        }

        if(s.length()==count){
            System.out.println(-1);
        }
        else{
            System.out.println(result.toString());
        }

    }

}
