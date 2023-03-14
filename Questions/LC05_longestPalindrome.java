public class LC05_longestPalindrome {
    public static String longestPalindrome(String s){
        //dp[i][j] and dp[i+1][j-1] 是状态转移方程，后者是前者去头尾的结果
        //状态转移方程 dp[i][j] = (s[i]==s[j]) and (j-i<3 or dp[i+1][j-1])
        //边界条件 j-i<3，即子串长度为2或3时不用再检查子串是否回文
        //在状态转移方程中，是从长度较短的字符串向长度较长的字符串进行转移
        //因此要注意动态规划的循环顺序
        int len=s.length();
        if(len<2){
            return s;//如果传入的字符串长度只有1，肯定是回文，返回该字符串
        }
        int maxLen=1;
        int begin=0;

        boolean[][] dp = new boolean[len][len];//建立状态布尔数组
        //dp[i][j]表示s[i to j]是否是回文串
        for(int i=0;i<len;i++){
            dp[i][i] = true;//定义所有以自己为左右边界的字符都是回文，赋值true
        }
        char[] charArray = s.toCharArray();
        //Converts this string to a new character array.

        for(int j=1;j<len;j++){//j是列，要一列一列填，所以j在外循环，从第1列开始
            for(int i=0;i<j;i++){//填表的右上半部分，参考左下角的值和边界值
                //i是行，从第0行开始读，不要读到第j行，因为dp[j][j]肯定是true
                if(charArray[i]!=charArray[j]){
                    dp[j][i]=false;
                }else{
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                        //如果左右边界的字符一样，就参考去掉边界后的状态
                        //如果仍是true，说明包括边界的字符串就是回文串
                    }
                }
                //只要dp[i][j] == true 成立，就表示子串s[i to j]是回文，此时记录回文长度和起始位置
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin=i;
                }

            }
        }
        return s.substring(begin,begin+maxLen);

    }
    public static void main (String[] args){
        String s="babad";
        System.out.println(longestPalindrome(s));
    }

}
