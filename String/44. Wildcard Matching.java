public class Solution {
    public boolean isMatch(String s,String p) {
        int i = 0;
        int j = 0;
        int lastMatch = 0;
        int lastStar = -1;
        while(i<s.length()){
            if(j<p.length() && p.charAt(j)=='*'){
                lastStar = j;
                lastMatch = i;
                j++;
            }else if(j<p.length() && (p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))){
                i++;
                j++;
            }else if(lastStar!=-1){
                i = ++lastMatch;
                j = lastStar+1;
            }else{
                return false;
            }
        }
        while(j<p.length() && p.charAt(j)=='*'){
            j++;
        }
        return j==p.length();
    }
    
    // public boolean isMatch(String s, String p) {
    //     boolean[] dp = new boolean[s.length()+1];
    //     dp[0] = true;
    //     for(int i = 1;i<=p.length();i++){
    //         if(p.charAt(i-1)=='*'){
    //             for(int j = 1;j<dp.length;j++){
    //                 dp[j] = dp[j-1] || dp[j];
    //             } 
    //         }else{
    //             for(int j = dp.length-1;j>0;j--){
    //                 dp[j] = (p.charAt(i-1)=='?'||p.charAt(i-1)==s.charAt(j-1)) && dp[j-1];
    //             }
    //             dp[0] = false;
    //         }
    //     }
    //     return dp[dp.length-1];
    // }
    
    // public boolean isMatch(String s, String p) {
    //     boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    //     dp[0][0] = true;
    //     for(int j = 1;j<=p.length();j++){
    //         dp[0][j] = p.charAt(j-1)=='*'?dp[0][j-1]:false;
    //     }
    //     for(int i = 1;i<=s.length();i++){
    //         for(int j = 1;j<=p.length();j++){
    //             if(p.charAt(j-1)=='*'){
    //                 dp[i][j] = dp[i][j-1] || dp[i-1][j];
    //             }else{
    //                 dp[i][j] = (p.charAt(j-1)=='?'||p.charAt(j-1)==s.charAt(i-1)) && dp[i-1][j-1];
    //             }
    //         }
    //     }
    //     return dp[s.length()][p.length()];
    // }
}
