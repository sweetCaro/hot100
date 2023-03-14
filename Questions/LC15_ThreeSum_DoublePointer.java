import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum_DoublePointer {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//排序
        for(int i=0; i<nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            int k=nums.length-1;//定义指向数组最右端的指针
            int target = -nums[i];//三数之和中间值
            for(int j=i+1;j<nums.length;j++) {
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                //要保证j指针在k左侧
                while(j<k&&nums[j]+nums[k]>target)
                    k--;
                //如果指针重合，随着j的增加，不会有满足a+b+c=0的情况，退出循环
                if(j==k) break;
                if(nums[j]+nums[k]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums));
    }
}
