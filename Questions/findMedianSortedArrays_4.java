import java.util.ArrayList;
import java.util.Comparator;

public class findMedianSortedArrays_4{
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        double mid = 0;
        int mid1;
        int mid2;
        ArrayList<Integer> sortedArrays = new ArrayList<>();
        for (int j : nums1) {
            sortedArrays.add(j);
        }
        for (int j : nums2) {
            sortedArrays.add(j);
        }
        sortedArrays.sort(Comparator.naturalOrder());
        System.out.println(sortedArrays);
        if(sortedArrays.size()%2==0){
            mid1=sortedArrays.get(sortedArrays.size()/2);
            mid2=sortedArrays.get(sortedArrays.size()/2-1);
            mid=(mid1+mid2)/2.0;
        }
        if(sortedArrays.size()%2!=0){
            mid=sortedArrays.get(sortedArrays.size()/2);
        }
        return mid;
    }

    public static String format(double value) {
        /*
         * %.5f %表示小数点前任意位数 5表示5位小数 格式后的结果为f表示浮点型
         */
        return String.format("%.5f", value);
    }

    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};

        double mid = findMedianSortedArrays(nums1,nums2);

        System.out.println(format(mid));
    }
}
