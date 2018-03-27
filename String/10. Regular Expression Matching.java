public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1;j<=p.length();j++){
            dp[0][j] = p.charAt(j-1)=='*'?(j==1 || dp[0][j-2]):false;
        }
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=p.length();j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2] || dp[i-1][j] && (p.charAt(j-2)=='.' || p.charAt(j-2) == s.charAt(i-1));
                }else{
                    dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1));
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    // public boolean isMatch(String s, String p) {
    //     boolean dp[][] = new boolean[s.length()+1][p.length()+1];
    //     dp[0][0] = true;
    //     for(int j = 1;j<=p.length();j++){
    //         dp[0][j] = p.charAt(j-1)=='*'?(j==1 || dp[0][j-2]):false;
    //     }
        
    //      /**
    //      * f[i][j]: if s[0..i-1] matches p[0..j-1]
    //      * if p[j - 1] != '*'
    //      *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
    //      * if p[j - 1] == '*', denote p[j - 2] with x
    //      *      f[i][j] is true iff any of the following is true
    //      *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
    //      *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
    //      * '.' matches any single character
    //      */
    //     for(int i = 1;i<=s.length();i++){
    //         for(int j = 1;j<=p.length();j++){
    //             if(p.charAt(j-1)=='*'){
    //                 dp[i][j] = dp[i][j-2] || dp[i-1][j]&&((s.charAt(i-1)==p.charAt(j-2))||p.charAt(j-2)=='.');
    //             }else{
    //                 dp[i][j] = dp[i-1][j-1] && ((s.charAt(i-1)==p.charAt(j-1))||p.charAt(j-1)=='.');
    //             }
    //         }
    //     }
    //     return dp[s.length()][p.length()];
    // }
}
