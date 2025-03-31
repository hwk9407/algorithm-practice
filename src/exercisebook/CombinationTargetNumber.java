package exercisebook;

/**
 * 정수 배열 nums가 주어진다.
 * 이 숫자들 사이에 연산자 +, -, * 중 하나를 넣어 수식을 만든다.
 * 연산자 우선순위 없이 왼쪽부터 순차적으로 계산하며,
 * 그렇게 만든 식의 결과가 target과 같은 경우의 수를 구하라.
 */
public class CombinationTargetNumber {

    public static void main(String[] args) {
        int[] nums = {2, 1, 1};
        int target = 4;
        int result = dfs(nums, 1, nums[0], target);
        System.out.println("result = " + result);
    }

    private static int dfs(int[] nums, int idx, int currentResult, int target) {
        if (idx == nums.length) return currentResult == target ? 1 : 0;

        int plus = dfs(nums, idx + 1, currentResult + nums[idx], target);
        int minus = dfs(nums, idx + 1, currentResult - nums[idx], target);
        int multiple = dfs(nums, idx + 1, currentResult * nums[idx], target);

        return plus + minus + multiple;
    }
}
