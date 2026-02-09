import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode57 {
    public static void main(String[] args) {
        // Solution solution = new Solution();
        BetterSolution bs = new BetterSolution();
        int[][] intervals = new int[][] {
                { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 }
        };
        int[] newIntervals = new int[] { 4, 8 };

        // int[][] insert = solution.insert(intervals, newIntervals);
        int[][] insert = bs.insert(intervals, newIntervals);
        ;

        for (int[] inner : insert) {
            for (int n : inner) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> src = new ArrayList<>(Arrays.asList(intervals));
            List<int[]> target = new ArrayList<>();
            int place = -1;
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] >= newInterval[0]) {
                    src.add(i, newInterval);
                    place = i;
                    break;
                }
            }
            if (place == -1) {
                src.add(newInterval);
                place = src.size() - 1;
            }
            for (int i = 0; i < src.size(); i++) {
                if (target.isEmpty() || src.get(i)[0] > target.get(target.size() - 1)[1]) {
                    target.add(src.get(i));
                } else {
                    target.get(target.size() - 1)[1] = Integer.max(src.get(i)[1], target.get(target.size() - 1)[1]);
                }
            }
            return target.toArray(new int[0][]);

        }
    }

    static class BetterSolution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int l, r;
            l = newInterval[0];
            r = newInterval[1];
            boolean flag = false;
            List<int[]> target = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][1] < l) {
                    target.add(intervals[i]);
                } else if (intervals[i][0] > r) {
                    if (!flag) {
                        target.add(new int[] { l, r });
                    }
                    target.add(intervals[i]);
                    flag = true;
                } else {
                    l = Integer.min(l, intervals[i][0]);
                    r = Integer.max(r, intervals[i][1]);
                }
            }
            if (!flag) {
                target.add(new int[] { l, r });
            }

            return target.toArray(new int[0][]);
        }

    }
}
