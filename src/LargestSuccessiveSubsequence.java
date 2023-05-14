import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Найти самую длинную подпоследовательноть в последовательности числе в которой каждый элемент делится на предыдущий

public class LargestSuccessiveSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        input.close();
        System.out.println(lisBottomUp(arr));
    }

    private static int lisBottomUp(int[] arr) {
        int[] d = new int[arr.length];
        int[] prev = new int[arr.length];
        for (int i = 0; i < d.length; i++) {
            d[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && (d[j] + 1) > d[i]) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < d.length; i++) {
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }
}
