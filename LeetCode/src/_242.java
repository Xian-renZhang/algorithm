import java.util.Arrays;

public class _242 {
    public static void main(String[] args) {

    }
}

class Solution_242 {

    //region version 1
    public boolean isAnagram(String s, String t) {
        int[] arrayS = new int[26];
        int[] arrayT = new int[26];
        Arrays.fill(arrayS, 0);
        Arrays.fill(arrayT, 0);

        for (int i = 0; i < s.length(); i++) {
            arrayS[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            arrayT[t.charAt(i) - 97]++;
        }

        for (int i = 0; i < arrayS.length; i++) {
            if (arrayS[i] != arrayT[i]) {
                return false;
            }
        }

        return true;
    }
    //endregion

    //region version 2
    public boolean isAnagram_v2(String s, String t) {
        int[] record = new int[26];

        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }

        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
    //endregion
}
