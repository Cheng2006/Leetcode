public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()+1];
        dp[dp.length-1] = 1;
        dp[dp.length-2] = chars[chars.length-1]=='0'?0:1;
        for(int i = dp.length-3;i>=0;i--){
            if(chars[i]=='0'){
                continue;
            }
            dp[i] = Integer.valueOf(s.substring(i,i+2))>26?dp[i+1]:dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
}
