public class ArrayAddUpShowUp {
    public static int addUp(int element) {
        return element * 2;
    }

    public static void showUp(int newElement) {
        System.out.println(newElement);
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 3, 9, 100, 4, 13, 11, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 10) {
                int result = addUp(arr[i]);
                showUp(result);
            }
        }
    }
}