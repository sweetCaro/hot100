import java.util.ArrayList;
import java.util.List;

class LC17_LetterCombinations {
    //设置全局list作为作为最后结果
    static List<String> list = new ArrayList<String>();
    public static List<String> letterCombinations(String digits){
        if(digits==null || digits.length()==0){
            return list;
        }
        String[] letterMap= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        //树形结构，输入数字的个数决定树的深度，输入数字对应的字母个数决定树的宽度
        backTracking(digits,letterMap,0);
        return list;
    }
    //每次迭代获取字符串，会涉及大量的字符串拼接，所以选择更高效的StringBuilder
    static StringBuilder temp=new StringBuilder();
    public static void backTracking(String digits, String[] letterMap, int index){
        if(index==digits.length()){//当index指向末尾空位置时才算真的结束
            list.add(temp.toString());
            return;
        }
        //str表示当前letterMap里对应的字符串，比如digits如果为23，index此时为0
        //那str表示2对应的abc
        String str=letterMap[digits.charAt(index)-'0'];
        for(int i =0;i<str.length();i++){
            temp.append(str.charAt(i));//
            backTracking(digits,letterMap,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public static void main(String[] args){
        String digits ="";
        System.out.println(letterCombinations(digits));
    }
}
