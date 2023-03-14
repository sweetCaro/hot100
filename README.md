# hot100
### 🤡第7题：盛最多水的容器
(**要向内移动高度较矮的板**)  
**方法：双指针**  

题目示例：
>[_**1**_ ,8 ,6 ,2 ,5 ,4 ,8 ,3 ,_**7**_]  

在初始时，左右指针分别指向数组的左右两端，它们可以容纳的水量为 *min(1,7) * 8 = 8*。  
* **core**：向内移动**数字较小的指针**  
为什么要移动数字较小的指针？因为如果向内移动较大指针时，在另一头指针不变的条件下，面积只会变小；而如果移动较小指针，面积有变大的可能
>[1 ,**_8_** ,6 ,2 ,5 ,4 ,8 ,3 ,_**7**_]

此时可以容纳的水量为min(8,7) * 7 = 49;  
以此类推：  
>[1 ,**_8_** ,6 ,2 ,5 ,4 ,8 ,**_3_** ,7]   

此时可以容纳的水量为min(8,3) * 6 = 18;  
>[1 ,**_8_** ,6 ,2 ,5 ,4 ,**_8_** ,3 ,7]   

此时可以容纳的水量为min(8,8) * 5 = 40;  
以此类推直至两个指针重合，在这期间对应的容纳水量为 min(6,8) * 4 = 24; min(2,8) * 3 = 6; min(5,8) * 2 = 10; min(4,8) * 1 = 4;  
在移动指针过程中，计算得到的最多容纳量为49，即为最终答案。  

```
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {//当两个指针没有相遇时循环
            //较短板和底边相乘得到面积（是中间值 不是最终答案）
            int area = Math.min(height[l], height[r]) * (r - l);
            //得到
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;//向右移动指针
            }
            else {
                --r;//向左移动指针
            }
        }
        return ans;
    }
}

```
### 🤡第15题：三数之和 
**方法：排序；去重；双指针**  
题目描述：找到数组中加和为零的三个元素，返回这个装了很多三元数组的集合，且不能重复

题目实例：
>输入：nums = [-1,0,1,2,-1,-4]  
输出：[[-1,-1,2],[-1,0,1]]  
解释：  
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。  
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。  
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。  
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。  
注意，输出的顺序和三元组的顺序并不重要。  

1.排序：（为什么要排序？  
其实这道题的总体框架就是三重循环，排完序的结果可以让我们在去重操作的时候更加便利  
如果有相同数值，可以直接跳过（continue！）  
同时也符合使用双指针的逻辑
```
Arrays.sort(nums);
```
2.去重：（无语
一直犯错的一个点：  
一直在写```if(nums[j]==nums[j-1]) continue;```  
忽略了特别重要的情况就是如果```nums[i]```此时就是```nums[j-1]```的情况，比如-1,-1,2  
这个时候```nums[i]```等于-1，```nums[j-1]```也等于-1，然后我就continue，这个结果就被忽略掉了  
所以这个比较就没有意义，因为```nums[j]```还没开始遍历呢，就因为```nums[j-1]```一棍子打死当前的```nums[j]```值  
所以应该要满足的很重要的前提条件是，_**j-1>i**_，如下所示：  
```if(j>i+1&&nums[j]==nums[j-1]) continue;```
```
for(int i=0; i<nums.length; i++) {
    if(i>0&&nums[i]==nums[i-1]) continue;
    ...
    for(int j=i+1;j<nums.length;j++){
        if(j>i+1&&nums[j]==nums[j-1]) continue;
        ...
        while(第三个指针从最右端开始遍历){
        ...
        }
    }
}
```  

3.双指针：  
每次开启新循环时，都有一个k指针从数组最右端开始遍历，```int k=nums.length-1;```  
然后定义j指针，从每个i+1开始遍历  
**要保证**j指针在k指针左侧```j<k```  
如果```nums[j]+nums[k]>target```,第三个指针往左移
如果```j==k```即两个指针重合，由i到尾部已经完全遍历完了都没有找到，退出循环  
向左移动i，缩小范围再重新开始双指针遍历

```
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
```