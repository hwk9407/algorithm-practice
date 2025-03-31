package exercisebook;

/**
 * 정수 배열 nums가 주어지고,
 * 각 요소마다 + 또는 - 연산을 붙일 수 있다.
 * 그렇게 해서 나온 모든 조합 중,
 * 총합이 짝수인 경우의 수를 구하라.
 */
public class CombinationTargetNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        int result = evenCount(nums, 0, 0);
        System.out.println("result = " + result);
    }

    private static int evenCount(int[] nums, int idx, int sum) {
        if (idx == nums.length) {
            return sum % 2 == 0 ? 1 : 0;
        }

        int plus = evenCount(nums, idx + 1, sum + nums[idx]);
        int minus = evenCount(nums, idx + 1, sum - nums[idx]);

        return plus + minus;
    }
}
