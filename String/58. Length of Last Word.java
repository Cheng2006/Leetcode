public class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int prev = 0;
        for(char item : s.toCharArray()){
            if(item==' '){
                prev = result==0?prev:result;
                result = 0;
            }else{
                result++;
            }
        }
        return result==0?prev:result;
    }
}
