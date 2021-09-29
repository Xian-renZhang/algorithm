public class _459 {
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) {
            return false;
        }

        int length = s.length();
        int index = 1;

        while (index < length) {
            if (s.charAt(index) == s.charAt(0)) {
                int count = length / index;
                StringBuilder sb = new StringBuilder();
                while (count > 0) {
                    sb.append(s, 0, index);
                    count--;
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
            index++;
        }

        return false;
    }
}
