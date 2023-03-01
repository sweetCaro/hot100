import java.util.ArrayList;
import java.util.Comparator;

public class maxArea_11 {
    public static int maxArea(int[] height){

//        ArrayList<Integer> maxArea = new ArrayList<>();
//        for(int i=0; i<height.length; i++){
//            for(int j=i;j<height.length;j++){
//                if(height[i]>=height[j]){
//                    maxArea.add(height[j]*(j-i));
//                }
//                if(height[i]<height[j]){
//                    maxArea.add(height[i]*(j-i));
//                }
//            }
//
//        }
//        maxArea.sort(Comparator.reverseOrder());
//        result = maxArea.get(0);
//        //用arraylist来做，超出内存限制了
        int result=0;
        int left =0;
        int right = height.length-1;
        int area=0;
        while(left<right){
            area=Math.min(height[left],height[right])*(right-left);
            result=Math.max(result,area);

            if(height[left]>=height[right]){
                left++;
            }
            else{
                right--;
            }

        }

        return result;
    }
    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }
}
