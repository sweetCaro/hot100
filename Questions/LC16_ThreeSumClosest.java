
import java.util.Arrays;

public class LC16_ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int sum;
        int best=100000;//差值，最后要最小的那个
        for(int i=0;i<nums.length-2;i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;

            int j=i+1;
            int k=nums.length-1;
            while(k>j) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    result = sum;
                    break;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;//更新best的值
                    result = best;
                    //System.out.println(best);
                }
                //如果和值大于目标值，向左移动k指针
                if (sum > target) {
                    //但要跳过重复的元素
                    k--;
                    if (k < nums.length - 1 && nums[k] == nums[k + 1]) continue;
                }
                //如果和值小于目标值，向右移动j指针
                if (sum < target) {
                    j++;
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                }
            }

            //以下是把三数之和为零的思路套用了，发现不是一个东西
//            for(int j=i+1;j<nums.length-1;j++) {
//                if(j>i+1&&nums[j]==nums[j-1])   continue;
//                //if(j==k)    break;
//                sum=nums[i]+nums[j]+nums[k];//三个数的和
//                //System.out.println("sum="+sum);
//                //System.out.println("s="+Math.abs(sum-target));
//                //System.out.println("temp="+temp+"\n");
//                if(Math.abs(sum-target)<=temp){//三个数的和与期望和的差值s
//                    temp=Math.abs(sum-target);//每次s都要和之前所定下的最小差值比较
//                    //如果有更小的s，就把差值temp更新成s的值
//                    result=sum;
//                if(k>j)
//                    k--;
//                }
//
//            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target =-2;
        System.out.println(threeSumClosest(nums, target));
    }

}
