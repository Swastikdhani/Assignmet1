
public class UniqueElements {
    
    // Function to find two unique non-repeating elements in an array
    public static void findUniqueElements(int[] arr) {
        int xorResult = 0;
        for (int num : arr) {
            xorResult ^= num;
        }

        // Get the rightmost set bit (differentiates two unique elements)
        int rightmostSetBit = xorResult & -xorResult;

        int unique1 = 0, unique2 = 0;
        for (int num : arr) {
            if ((num & rightmostSetBit) != 0) {
                unique1 ^= num;
            } else {
                unique2 ^= num;
            }
        }

        System.out.println("The two unique elements are: " + unique1 + " and " + unique2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4};  // Example array
        findUniqueElements(arr);
    }
}
