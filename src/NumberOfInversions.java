import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Такая пара элементов называется инверсией массива.
 Количество инверсий в массиве является в некотором смысле его мерой неупорядоченности:
 например, в упорядоченном по не убыванию массиве инверсий нет вообще, а в массиве,
 упорядоченном по убыванию, инверсию образуют каждые два элемента.)
 */

public class NumberOfInversions {

    private static long countOfPair = 0;
    private static int[] temp;
    private static int[] arr;

    // Сортировка слиянием - Слияние

    // результат будет в том же массиве
    private static void merge(int l, int m, int r) {
        // arr[l...m - 1] arr[m...r - 1] -> temp[l...r - 1] -> res[l...r - 1]
        int i = l;
        int j = m;
        for (int k = l; k < r; k++) {
            if (j == r || (i < m && arr[i] <= arr[j])) {
                temp[k] = arr[i];
                i++;
            } else {
                countOfPair += m - i;
                temp[k] = arr[j];
                j++;
            }
        }
        System.arraycopy(temp, l, arr, l, r - l);
    }

    private static void mergeSort(int l, int r) {
        if (r <= l + 1) {
            return;
        } else {
            // arr[l...r - 1] -> arr[l...m - 1] arr[m...r - 1]

            // >> 1 - побитовый сдвиг - деление на 2
            int m = (l + r) >> 1;
            mergeSort(l, m);
            mergeSort(m, r);
            merge(l, m, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        arr = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        input.close();
        temp = new int[n];
        mergeSort(0, n);
        System.out.println(countOfPair);
    }
}
