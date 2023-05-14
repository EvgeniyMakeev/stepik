import java.util.*;

public class HuffmanCoding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!count.containsKey(c)) {
                count.put(c, 1);
            } else {
                count.put(c, count.get(c) + 1);
            }
        }
        System.out.println(count);
        ArrayList<Integer> valueList = new ArrayList<>(count.values());
        valueList.sort(Integer::compare);
        StringBuilder result = new StringBuilder();
        for (int i = valueList.size() - 1; i > 0; i--) {
            if (valueList.get(i) > valueList.get(i - 1)) {
                result.append("0");
            } else {
                result.append("1");
            }
            if (i == 1) {
                result.append("0");
            }
        }
        System.out.println(result);
    }
}
