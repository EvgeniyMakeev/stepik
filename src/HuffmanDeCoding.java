import java.sql.SQLClientInfoException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Декодировать строку в виде
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */


public class HuffmanDeCoding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfChars = scan.nextInt();
        int lengthOfCode = scan.nextInt();
        if (numberOfChars == 1 && lengthOfCode == 1) {
            System.out.println(scan.next().charAt(0));
        } else if (numberOfChars == 1 && lengthOfCode < 1) {
            StringBuilder decoding = new StringBuilder();
            char c = scan.next().charAt(0);
            for (int i = 0; i <= lengthOfCode + 1; i++) {
                decoding.append(c);
            }
            System.out.println(decoding);
        } else {
            Map<Character, String> chars = new HashMap<>();
            for (int i = 0; i < numberOfChars; i++) {
                String c = scan.next();
                String code = scan.next();
                chars.put(c.charAt(0), code);
            }
            String code = scan.next();
//        System.out.println(numberOfChars);
//        System.out.println(lengthOfCode);
//        System.out.println(chars);
//        System.out.println(code);
            scan.close();

            StringBuilder decoding = new StringBuilder();
            int start = 0;
            int end = 1;
            while (end <= code.length()) {
                String sub = code.substring(start,end);
                if (chars.containsValue(sub)) {
                    decoding.append(getKey(chars, sub));
                    start = end;
                    end = start + 1;
                } else {
                    end++;
                }
            }
            System.out.println(decoding);
        }
    }

    // получаем ключ по значению
    public static Character getKey(Map<Character, String> map, String value) {
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
