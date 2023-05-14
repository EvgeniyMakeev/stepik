import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Найти самую длинную не возрастающую подпоследовательность в последовательности чисел и вывести её индексы

public class LongestDowngradeSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        input.close();
        lisBottomUp(arr);
    }

    private static void lisBottomUp(int[] arr) {
        int[] d = new int[arr.length];
        int[] prev = new int[arr.length];
        for (int i = 0; i < d.length; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i] && (d[j] + 1) > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < d.length; i++) {
            ans = Math.max(ans, d[i]);
        }

        System.out.println(ans);

        StringBuilder builder = new StringBuilder();
        int k = 0;
        for (int i = 1; i < arr.length; i++) {
            if (d[i] > d[k]) {
                k = i;
            }
        }
        while (k >= 0) {
            builder.insert(0,(k + 1) + " ");
            k = prev[k];
        }
        System.out.println(builder);
    }
}

