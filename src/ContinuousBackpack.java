import java.util.Scanner;

/**
 * Выведите максимальную стоимость частей предметов
 * (от каждого предмета можно отделить любую часть,
 * стоимость и объём при этом пропорционально уменьшатся),
 * помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 */

public class ContinuousBackpack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        double w = scan.nextInt();
        double[][] arr = new double[n][2];
        double totalPrice = 0;
        double totalW = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = scan.nextInt();
            totalPrice += arr[i][0];
            arr[i][1] = scan.nextInt();
            totalW += arr[i][1];
        }
        scan.close();
        maxOfCostInBackpack(w, arr, totalW, totalPrice);
    }

    private static void maxOfCostInBackpack(double w, double[][] arr, double totalW, double totalPrice) {
        double wLeft = w;
        double totalCost = 0;
        double[][] sortedArr = sorter(arr);
        if (w >= totalW) {
            System.out.printf("%.3f", totalPrice);
        } else {
            while(wLeft > 0){
                for (double[] doubles : sortedArr) {
                    if (wLeft >= doubles[1]) {
                        totalCost += doubles[0];
                        wLeft -= doubles[1];
                        if (wLeft == 0) {
                            break;
                        }
                    } else {
                        totalCost += (doubles[0] / doubles[1]) * wLeft;
                        wLeft = 0;
                    }
                }
            }
            System.out.printf("%.3f", totalCost);
        }
    }

    private static double[][] sorter(double[][] arr) {
        double[][] sortedArr = new double[arr.length][2];
        for (int i = 0; i < sortedArr.length; i++) {
            double max = 0;
            int indexMax = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][1] == 0 && arr[j][0] != 0) {
                    max = arr[j][0];
                    indexMax = j;
                } else if (arr[j][0] / arr[j][1] > max) {
                    max = arr[j][0] / arr[j][1];
                    indexMax = j;
                }
            }
            sortedArr[i][0] = arr[indexMax][0];
            sortedArr[i][1] = arr[indexMax][1];
            arr[indexMax][0] = 0;
            arr[indexMax][1] = 0;
        }
        return sortedArr;
    }
}
