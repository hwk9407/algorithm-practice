class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums2) set1.add(num);
        Set<Integer> ans1 = new HashSet<>();
        for (int num : nums1) {
            if (!set1.contains(num)) ans1.add(num);
        }
        answer.add(new ArrayList<>(ans1));


        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) set2.add(num);
        Set<Integer> ans2 = new HashSet<>();
        for (int num : nums2) {
            if (!set2.contains(num)) ans2.add(num);
        }
        answer.add(new ArrayList<>(ans2));

        
        return answer;
    }
}