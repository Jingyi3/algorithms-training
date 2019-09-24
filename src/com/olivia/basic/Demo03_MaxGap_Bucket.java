package com.olivia.basic;

//给定一个数组，求如果排序之后，相邻两数的最大差值，要求时 间复杂度O(N)，且要求不能用非基于比较的排序。
//设计桶结构解决问题：有n个数建立n+1个桶-->保证最大差值一定是在不同的桶之间而非自己的桶内部
//每一个桶内部只存boolean--有没有数，这个桶的最大值，和最小值--最大差值一定是这个桶的最小值和上一个非空桶的最大值之间
public class Demo03_MaxGap_Bucket {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNums = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            //当前数去几号桶，这个桶的max min 更新或者建立，桶有值 更新
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNums[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNums[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNums[bid] = true;
        }
        int res = 0;
        int lasMax = maxs[0];
        int i = 1;
        for (; i < len; i++) {
            if (hasNums[i]){
                res = Math.max(res, mins[i] - lasMax);
                lasMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        //确定一个数在哪个桶
        return (int) (((num - min) * len) / (max - min));
    }
}
