import java.util.Arrays;

public class LeetCode283 {
    public static void main(String[] args) {
        Solution s = new Solution();
        BetterSolution bs = new BetterSolution();
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        int[] nums0 = new int[] { 0 };
        s.moveZeroes(nums);
        s.moveZeroes(nums0);
        bs.moveZeroes(nums);
        bs.moveZeroes(nums0);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int p1, p2;
            p1 = 0;
            p2 = 0;
            while (p1 < nums.length && p2 < nums.length) {
                if (nums[p1] != 0 && p1 < nums.length) {
                    p1++;
                    continue;
                }
                p2 = p1 + 1;
                while (p2 < nums.length) {
                    if (nums[p2] != 0) {
                        nums[p1] = nums[p2];
                        nums[p2] = 0;
                        break;

                    }
                    p2++;
                    continue;

                }
            }
        }
    }

    static class BetterSolution {
        public void moveZeroes(int[] nums) {
            int l, r;
            l = 0;
            r = 0;
            while (r < nums.length) {
                if (nums[r] != 0) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                }
                r++;
            }
        }
    }
}
