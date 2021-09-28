import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _383 {
    public static void main(String[] args) {

    }
}

class Solution_383 {

    //region version 1
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int temp = map.getOrDefault(c, 0);
            if (temp > 0) {
                map.put(c, temp - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    //endregion

    //region version 2
    public boolean canConstruct_v2(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int temp = ransomNote.charAt(i) - 'a';
            record[temp]--;
            if (record[temp] < 0) {
                return false;
            }
        }
        return true;
    }
    //endregion

}
