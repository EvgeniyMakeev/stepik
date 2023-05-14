import java.util.*;

// Вывести максимальное число слагаемых для числа n.

public class VariousTerms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        howMatchVT(n);
    }

    private static void howMatchVT(int n) {
        StringBuilder result = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        int sum = 1;
        int i = 2;
        if (n == 0 || n == 1) {
            System.out.println(n + "\n" + n);
        } else {
            set.add(1);
            while (sum < n) {
                set.add(i);
                sum += i;
                i++;
            }
        }
        if (sum == n) {
            for (Integer integer : set) {
                result.append(integer).append(" ");
            }
        } else {
            set.remove(sum - n);
            for (Integer integer : set) {
                result.append(integer).append(" ");
            }
        }
        System.out.println(set.size() + "\n" + result);
    }
}
