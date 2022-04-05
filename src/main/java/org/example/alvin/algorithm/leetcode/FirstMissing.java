package org.example.alvin.algorithm.leetcode;

/** LeetCode 41 */
public class FirstMissing {
  public static void main(String[] args) {
    FirstMissing firstMissing = new FirstMissing();
    int[] nums = {1, 3, 3};
    System.out.println(firstMissing.firstMissingPositive(nums));
  }

  public int firstMissingPositive(int[] nums) {
    int numOfOpposite = 0;
    for (int num : nums) {
      numOfOpposite = num > 0 ? numOfOpposite + 1 : numOfOpposite;
    }

    boolean[] tags = new boolean[numOfOpposite + 1];

    for (int num : nums) {
      if (num > 0 && num < numOfOpposite + 1) {
        tags[num] = true;
      }
    }

    int result = 1;
    for (int i = 1; i < tags.length; i++) {
      if (!tags[i]) {
        return i;
      }
    }
    return numOfOpposite + 1;
  }
}
