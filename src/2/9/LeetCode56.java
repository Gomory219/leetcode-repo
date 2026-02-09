import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] tervals = new int[][] {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        };
        int[][] merge = solution.merge(tervals);
        for (int[] inner : merge) {
            for (int n : inner) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> list = new ArrayList<>();

            Arrays.sort(intervals, (int[] arr1, int[] arr2) -> {
                return Integer.compare(arr1[0], arr2[0]);
            });
            int cur = 0;
            while (cur < intervals.length) {
                int next = cur + 1;
                int l = intervals[cur][0];
                int r = intervals[cur][1];
                while (next < intervals.length) {
                    if (intervals[next][0] > r) {
                        break;
                    }
                    if (intervals[next][1] > r) {
                        r = intervals[next][1];
                    }
                    next++;
                }
                cur = next;
                list.add(new int[] { l, r });
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
