import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            sequence[i] = random.nextInt(10000 + 1);
        }
        int minMultiple37 = Integer.MAX_VALUE;
        int maxMultiple73 = Integer.MIN_VALUE;

        for (int num : sequence) {
            if (num % 37 == 0) {
                minMultiple37 = Math.min(minMultiple37, num);
            }
            if (num % 73 == 0) {
                maxMultiple73 = Math.max(maxMultiple73, num);
            }
        }
        int leftBound = Math.min(minMultiple37, maxMultiple73);
        int rightBound = Math.max(minMultiple37, maxMultiple73);

        int count = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < 999; i++) {
            int a = sequence[i];
            int b = sequence[i + 1];

            boolean aInRange = (a > leftBound && a < rightBound);
            boolean bInRange = (b > leftBound && b < rightBound);

            if (aInRange ^ bInRange) { 
                count++;
                int sum = a + b;
                minSum = Math.min(minSum, sum);
            }
        }

        System.out.println(count + " " + minSum);

        scanner.close();
    }
}