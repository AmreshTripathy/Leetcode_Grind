package com.leetcode_grind;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) 
            nums[i] = sc.nextInt();

        int k = sc.nextInt();
        
        sc.close();
        System.out.println(subarraysDivByK(nums, k));
    }

    private static int subarraysDivByK(int[] nums, int k) {
        /*
         * 4 5 0 -2
         * so 4 % 5 = 4 (map -> 4 , 1)
         * 4 + 5 = 9 % 5 = 4 (map -> 4, 2) so previos count will be added
         */

        int count = 0;
        int prefixSum = 0;

        Map<Integer, Integer> map =  new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            int mod = prefixSum % k;
            if (mod < 0)
                mod += k;

            if (map.containsKey(mod)) {
                count += map.get(mod);
                map.put(mod, map.get(mod) + 1);
            } else {
                map.put(mod, 1);
            }
        }

        return count;
    }
}
