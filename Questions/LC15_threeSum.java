import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class LC15_threeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        //传入的是数组nums[]
        int len = nums.length;
        if(nums == null||len<3){
            return result;
        }//如果数组为空或者数组长度小于三，则直接返回空结果，即没有结果
        //给nums数组排序:
        //这样可以保证，当a<b<c时，只有(a,b,c)会被枚举到，而(b,a,c),(c,a,b)等等不会，这样就减少了重复
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int target=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)   break;//如果第一个数就比零大，后面的数值肯定也比零大，没有结果
            target=-nums[i];
            if(i>0&&nums[i]==nums[i-1]) continue;//去重
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[j-1]&&nums[j-1]!=nums[i]) continue;//去重
                for(int k=j+1;k<nums.length;k++){
                    if(nums[k]==nums[k-1]&&nums[k-1]!=nums[j]) continue;
                    if(nums[k]+nums[j]==target&&target!=0){
                        List<Integer> list =new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);//result是一个装载集合的集合，不能单纯往里面添加数值
                        //只能往里面加集合，方法是创建一个集合，把数值填进集合中，再把集合填进result里头
                    }
                }
            }
        }
        if(nums[0]==nums[1]&&nums[0]==0){
            List<Integer> list =new ArrayList<Integer>();
            list.add(0);
            list.add(0);
            list.add(0);
            result.add(list);
        }
        //其次，当a=b时，如果枚举到(a,c,d)的情况，(b,c,d)也会被枚举到，所以要跳过相同的元素
        //即:只有和上一次枚举的元素不相同，我们才会进行枚举

        return result;
    }
    public static void main(String[] args){
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(String.valueOf(threeSum(nums)));
    }
}
