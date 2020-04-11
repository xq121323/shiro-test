package suanfa;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * @author Mechrevo
 * @version v1.0
 * 2020/3/25 19:38
 */
public class Solution_01 {
    public static void main(String[] args) {
        int county = 1000000;
        int[] nums = {1, 3, 5, 2,6,4,8,11,12};
        int target = 14;
        Solution_01 solution02 = new Solution_01();
        TimeInterval timer = DateUtil.timer();
        for (int j = 0; j < county; j++) {
            int[] ints = solution02.twoSum0(nums, target);
        }
        System.out.println("暴力所需时间："+timer.intervalRestart());
        for (int j = 0; j < county; j++) {
            int[] ints = solution02.twoSum1(nums, target);
        }
        System.out.println("hash所需时间："+timer.intervalRestart());
    }

    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum0(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 使用hash
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
