package arrays.recurssion.DP.NSUM.string;

import java.util.function.Predicate;

public class StringCompression {
    public static void main(String[] args) {
        String input = "aabbcdaaa";
        String compressed = compress(input);
        System.out.println(compressed);

        Predicate<Integer> p = t->(t>10);
        System.out.println( p.test(20));
    }

    private static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int count=1;
        for (int i=1; i<str.length(); i++) {
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }else{
                sb.append(str.charAt(i-1));
                sb.append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(count);


        return sb.toString();

        
    }

}
