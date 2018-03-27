public class Solution {
    // public String longestPalindrome(String s) {
    //     int n = s.length();
    //     int index = 0;
    //     int m = 0;
    //     for(int i = 0;i<2*n+1;i++){
    //       int count = 1;
    //       while(i-count>=0 && i+count<2*n+1 && getChar(s,i-count)==getChar(s,i+count)){
    //           count++;
    //       }
    //       if(count-1>m){
    //           m = count-1;
    //           index = i;
    //       }
    //     }
    //     return s.substring((index-m)/2,(index+m)/2);
    // }
    // public char getChar(String s,int i){
    //     return i%2==0?'*':s.charAt(i/2);
    // }
    
    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
        	if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }
    
}
