import java.util.*;

public class BoyerMoore {
    static int lastOccurrence(char[] pattern, int patternLength, char badChar) {
        for (int i = patternLength - 1; i >= 0; i--)
            if (pattern[i] == badChar) return i;
        return -1;
    }
    static int search(String text, String pattern) {
        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();
        int textLength = txt.length;
        int patternLength = pat.length;
        int skip;
        for (int i = 0; i <= textLength - patternLength; i += skip) {
            skip = 0;
            for (int j = patternLength - 1; j >= 0; j--) {
                if (pat[j] != txt[i + j]) {
                    skip = Math.max(1, j - lastOccurrence(pat, patternLength, txt[i + j]));
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(search("ABABDABACDABABCABAB", "ABABCABAB"));
    }
}
