public class Q8_FindtheDuplicateNumber {
    public static int findDuplicate(int[] nums) {

        // Phase 1: Find intersection point using while loop
        int slow = nums[0];
        int fast = nums[0];

        // Move them first time manually
        slow = nums[slow];            // slow moves 1 step
        fast = nums[nums[fast]];      // fast moves 2 steps

        // Now use while loop
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // Phase 2: Move slow to start
        slow = nums[0];

        // Move both 1 step until they meet
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // duplicate number
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate);
    }
}
