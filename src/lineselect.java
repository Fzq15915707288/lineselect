public class lineselect {

    public static void swap(int a[], int i, int j) {//交换函数
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static int partition(int a[], int p, int r, int val) {
//        int pos = 0;
//        for (int q = p; q <= r; q++) {
//            if (a[q] == val) {
//                pos = q;
//                break;
//            }
//        }
//        swap(a, p, r);

        int i = p, j = r + 1, x = a[p];
        while (true) {
            while (a[++i] < x && i < r) ;
            while (a[--j] > x) ;
            if (i >= j) break;
            swap(a, i, j);
        }
        a[p] = a[j];
        a[j] = x;
        return j;
    }

    public static void bubbleSort(int a[], int p, int r) {
        for (int i = p; i < r; i++) {
            for (int j = i + 1; j <= r; j++) {
                if (a[j] < a[i])
                    swap(a, i, j);
            }
        }
    }

    private static int Select(int a[], int p, int r, int k) {
        if (r - p < 75) {
            bubbleSort(a, p, r);
            return a[p + k - 1];
        }
        for (int i = 0; i <= (r - p - 4) / 5; i++) {
            int s = p + 5 * i, t = s + 4;
            for (int j = 0; j < 3; j++) {
                bubbleSort(a, s, t - j);
            }
            swap(a, p + i, s + 2);
        }
        Comparable x = Select(a, p, p + (r - p - 4) / 5, (r - p + 6) / 10);
        int i = partition(a, p, r, (Integer) x), j = i - p + 1;
        if (k <= j) return Select(a, p, i, k);
        else return Select(a, i + 1, r, k - j);
    }

    public static void main(String[] args) {
        int a[] = {2, 9, 11, 3, 14, 7, 10, 8, 15, 4, 13, 1, 6, 5, 12};
        int i = Select(a, 0, 14, 14);
        System.out.println("i=" + i);
    }


}
