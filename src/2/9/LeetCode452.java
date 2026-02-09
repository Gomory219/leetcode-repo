import java.util.Arrays;

public class LeetCode452 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][] {
                // { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 }
                // { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }
                {9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}
        };
        System.out.println(solution.findMinArrowShots(points));
    }

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, ((arr1, arr2) -> {
                return Integer.compare(arr1[0], arr2[0]);
            }));
            int l = points[0][0];
            int r = points[0][1];
            int res = 1;
            for (int i = 0; i < points.length; i++) {
                if (points[i][0] <= r) {
                    l = Integer.max(l, points[i][0]);
                    r = Integer.min(r, points[i][1]);
                } else {
                    res += 1;
                    l = points[i][0];
                    r = points[i][1];
                }
            }
            return res;
        }
    }
}
