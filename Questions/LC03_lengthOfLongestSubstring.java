import java.util.ArrayList;
public class LC03_lengthOfLongestSubstring {
    /*无重复字符的最长子串*/
    public static int lengthOfLongestSubstring(String s){
        int len=0;
        int tempLen=0;
        ArrayList<String> list = new ArrayList<String>();
        String temp;
        for(int i=0;i<s.length();i++){
            //先读一个字符，存进arraylist中，
            //读下一个字符，如果arraylist没有，就存进arraylist中
            //如果arraylist中有，记录arraylist的长度为tempLength并清空arraylist
            //把新读到的字符存进arraylist中，再重复一样的操作
            //再次发现arraylist中有的字符时，将现在arraylist的长度和原先的tempLength作比较，谁长就把谁当作新的tempLength
            //最后返回tempLength
            if(!list.contains(String.valueOf(s.charAt(i)))) {
                list.add(String.valueOf(s.charAt(i)));
                tempLen=list.size();
            }
            else{
                if(len<list.size()) {
                    len = list.size();
                }
                //list.clear();//直接清空太草率了！！
                //应该删掉包括重复字符前面的所有字符
                //把前面
                //list.clear();
                //list.remove(list.indexOf(String.valueOf(s.charAt(i))));
                //System.out.println("what:"+list.subList(0,list.indexOf(String.valueOf(s.charAt(i)))+1));
                list.removeAll(list.subList(0,list.indexOf(String.valueOf(s.charAt(i)))+1));//删掉0到第一次出现这次读到的字符的位置上的元素
                list.add(String.valueOf(s.charAt(i)));
            }
            if(tempLen>len){
                len = tempLen;
            }
            //输出该动态数组list的结果
            //System.out.println(list.toString());


        }
        if(s.length()==1) len =1;
        return len;
    }
    public static void main(String[] args){
        String s ="nfpdmpi";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
