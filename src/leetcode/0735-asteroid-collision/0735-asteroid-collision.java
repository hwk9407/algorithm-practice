class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid : asteroids) {
            boolean flag = true;
            while (flag && !stack.isEmpty() && stack.peekLast() > 0 && asteroid < 0) {
                if (stack.peekLast() < -asteroid) {
                    stack.pollLast();
                } else if (stack.peekLast() == -asteroid) {
                    stack.pollLast();
                    flag = false;
                } else {
                    flag = false;
                }
            }
            if (flag) {
                stack.offerLast(asteroid);
            }
        }
        return stack.stream().mapToInt(Integer::valueOf).toArray();
    }
}