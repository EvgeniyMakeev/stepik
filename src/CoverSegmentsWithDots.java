import java.util.Scanner;

public class CoverSegmentsWithDots {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        scan.close();
        findMaxOfDots(arr);
    }

    private static void findMaxOfDots(int[][] arr) {
        int count = 0;
        int l = arr[0][0];
        int r = arr[0][1];
        int x = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < l) {
                l = arr[i][0];
            }
            if (arr[i][1] < r) {
                l = arr[i][0];
            }
            if (arr[i][0] >= Math.abs(l - r)) {
                count++;
                x = i;
            }
        }
        System.out.println(count);
        System.out.println(x);
    }
}
