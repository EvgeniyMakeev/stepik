import java.util.Scanner;

// Найдите максимальный вес золота, который можно унести в рюкзаке.

public class Backpack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int w = input.nextInt();
        int n = input.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.println(backpackWithoutRepsBU(w, arr));
    }

    private static int backpackWithoutRepsBU(int wTotal, int[] weights) {
        int[][] d = new int[wTotal + 1][weights.length];
        for (int i = 1; i < weights.length; i++) {
            for (int w = 0; w < d.length; w++) {
                d[w][i] = d[w][i - 1];
                if (weights[i] <= w) {
                    d[w][i] = Math.max(d[w][i], d[w - weights[i]][i - 1] + weights[i]);
                }
            }
        }
        printArr(d);
        return d[wTotal][weights.length - 1];
    }
    private static void printArr(int[][] field) {
        for (int i = 0; i < field.length; i++) {  //идём по строкам
            for (int j = 0; j < field[i].length; j++) { //идём по столбцам
                System.out.print(field[i][j] + " "); //вывод элемента
            }
            System.out.println();
        }
    }
}
