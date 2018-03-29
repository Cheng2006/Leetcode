public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length()==0){
            return false;
        }
        //"2."is accepted
        //"2e2.3" is not accepted
        boolean hasE = false;
        boolean isLastDig = false;
        boolean canDot = true;
        for(int i =0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr<='9' && curr>='0'){
                isLastDig = true;
            }else if(curr=='.' && canDot){
                canDot = false;
            }else if(isLastDig && !hasE && curr=='e'){
                hasE = true;
                canDot = false;
                isLastDig = false;
            }else if((curr=='+'||curr=='-') && (i==0 || s.charAt(i-1)=='e')){
                isLastDig = false;
                canDot = true;
            }else{
                return false;
            }
        }
        return isLastDig;
    }
}
