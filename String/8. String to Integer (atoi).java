public class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0){
            return 0;
        }
        int result = 0;
        int i = 0;
        boolean isPositive = true;;
        while(str.charAt(i)==' '){
            i++;
        }
        if(str.charAt(i)=='+'||str.charAt(i)=='-'){
            isPositive = str.charAt(i++)=='+'?true:false;
        }
        
        while(i<str.length()){
            char curr = str.charAt(i++);
            if(curr>'9' || curr<'0'){
                return isPositive?result:-result;
            }
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && Character.getNumericValue(curr)>Integer.MAX_VALUE%10){
                return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result = result*10+Character.getNumericValue(curr); // can not be Integer.valueOf(curr)  !!!! Integer.valueOf('1')==49
        }
        return isPositive?result:-result;
    }
}
