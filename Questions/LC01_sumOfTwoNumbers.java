import java.util.Arrays;

public class LC01_sumOfTwoNumbers {

    public static int[] twoSum(int[] nums, int target){
            for(int i = 0; i < nums.length-1; i++){
                for(int j = i; j < nums.length; j++){
                    if(nums[i]==target-nums[j]){
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
        /**哈希解法
         * Map<Integer, Integer> hashtable = new HashMap<>();
         *         for (int i = 0; i < nums.length; ++i) {
         *             if (hashtable.containsKey(target - nums[i])) {
         *                 return new int[]{hashtable.get(target - nums[i]), i};
         *             }
         *             hashtable.put(nums[i], i);
         *         }
         *         return new int[0];
        */

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }//打印出的是数组的样子，包括两个中括号，所以要转成string哦
}
