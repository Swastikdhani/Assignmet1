
public class BitManipulation {

    // Function to count set bits in an integer
    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

    // Function to count total set bits from 1 to n
    public static int countTotalSetBits(int n) {
        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            totalCount += countSetBits(i);
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int n = 10;  // Example value
        System.out.println("Total set bits from 1 to " + n + " is: " + countTotalSetBits(n));
    }
}
