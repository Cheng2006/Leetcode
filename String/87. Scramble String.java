public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true; 
        
        int[] letters = new int[256];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)]++;
            letters[s2.charAt(i)]--;
        }
        for (int i=0; i<256; i++) if (letters[i]!=0) return false;
    
        for (int i=1; i<s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) 
             && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
             && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
    //     public boolean isScramble(String s1, String s2) {
    //     if(s1.length()==0||s1.length()!=s2.length()){
    //         return false;
    //     }
    //     //dp
    //     int length = s1.length();
    //     boolean[][][] dp = new boolean[length+1][length][length];
    //     for(int i =0;i<length;i++){
    //         for(int j =0;j<length;j++){
    //             dp[1][i][j] = s1.charAt(i)==s2.charAt(j);
    //         }
    //     }
        
    //     for(int k = 2;k<=length;k++){
    //         for(int i = 0;i<length-k+1;i++){
    //             for(int j = 0;j<length-k+1;j++){
    //                 boolean mark = false;
    //                 for(int l = 1;l<k && !mark;l++){
    //                     mark = dp[l][i][j] && dp[k-l][i+l][j+l] || dp[l][i][j+k-l] && dp[k-l][i+l][j];
    //                 }
    //                 dp[k][i][j] = mark;
    //             }
    //         }
    //     }
        
    //     return dp[length][0][0];
    // }
}
