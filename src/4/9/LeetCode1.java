import java.util.ArrayList;

public class LeetCode1 {

    public static void main(String[] args) {
        int[] p = new int[5000];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        f2(p, 100000);
    }

    public static int[] f2(int[] nums, int target) {
        int[] num = new int[2];
        int index = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list = f22(nums, target, list1, 2, 0);
        System.out.println(list);
        // for (int i : list) {
        // System.out.print(i + " ");
        // }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static ArrayList<Integer> f22(int[] nums, int target, ArrayList<Integer> list, int n, int index) {
        if (n == 0) {
            return target == 0 ? new ArrayList<>(list) : null;
        }
        if (index == nums.length) {
            return null;
        }
        // 不选当前index形成的list返回
        ArrayList<Integer> p1 = f22(nums, target, list, n, index + 1);
        // 选当前index形成的list返回
        list.add(index);

        ArrayList<Integer> p2 = f22(nums, target - nums[index], list, n - 1, index + 1);
        list.remove(list.size() - 1);
        if (p2 != null) {
            return p2;
        }
        return p1;
    }

}
