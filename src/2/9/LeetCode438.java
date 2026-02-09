import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams(s, p).toString());
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> map = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < p.length(); i++) {
                Character c = p.charAt(i);
                map.putIfAbsent(c, 0);
                map.put(c, map.get(c) + 1);
            }
            int l, r;
            l = 0;
            r = 0;
            while (r < s.length()) {
                Character lChar, rChar;
                rChar = s.charAt(r);
                lChar = s.charAt(l);
                if (p.contains(rChar.toString())) {
                    map.putIfAbsent(rChar, 0);
                    map.put(rChar, map.get(rChar) - 1);
                    if (map.get(rChar) == 0) {
                        map.remove(rChar);
                    }
                }
                if (r - l + 1 > p.length() && p.contains(lChar.toString())) {
                    map.putIfAbsent(lChar, 0);
                    map.put(lChar, map.get(lChar) + 1);
                    if (map.get(lChar) == 0) {
                        map.remove(lChar);
                    }
                }
                if (r - l + 1 > p.length()) {
                    l++;
                }

                if (map.isEmpty()) {
                    result.add(l);
                }

                r++;
            }
            return result;
        }
    }
}
