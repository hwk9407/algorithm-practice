class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> result = new ArrayList<>();
        int maxCandy = Arrays.stream(candies).max().orElseThrow();
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandy) result.add(true);
            else result.add(false);
        }

        return result;
    }
}