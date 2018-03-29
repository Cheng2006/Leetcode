public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i)==')') {
                if(s.charAt(i-1)==')' && i-1-dp[i-1]>=0 && s.charAt(i-1-dp[i-1])=='('){
                    dp[i] = dp[i-1]+2+(i-2-dp[i-1]<0?0:dp[i-2-dp[i-1]]);
                }else if(s.charAt(i-1)=='('){
                    dp[i] = 2+(i-2<0?0:dp[i-2]);
                }
                result = Math.max(result,dp[i]);
            }
        }
        return result;
    }
}
