public class StringOperations {
    static String processStrings(String str1, String str2, int length) {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        String concatenated = str1 + str2;
        String reversed = new StringBuilder(concatenated).reverse().toString();
        int mid = reversed.length() / 2;
        int start = Math.max(0, mid - length / 2);
        int end = Math.min(reversed.length(), start + length);
        return reversed.substring(start, end);
    }
    public static void main(String[] args) {
        System.out.println(processStrings("hello", "world", 3));
        System.out.println(processStrings("", "test", 5));
    }
}
