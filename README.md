# hot100
### 🤡第7题：盛最多水的容器
**方法一：双指针**  

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
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}

```