public class SumUpToFifty {
    public static void main(String[] args) {
        int num = 50, sum = 0;

        for (int i = 1; i <= num; i++) {
            sum = sum + i; 
        }
        
        System.out.println("Sum of First 50 Numbers is = " + sum);
    }
}