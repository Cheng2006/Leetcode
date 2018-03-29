public class Solution {
    public String multiply(String num1, String num2) {
        char[] result = new char[num1.length()+num2.length()];
        for(int i = num1.length()-1;i>=0;i--){
            int carries = 0;
            for(int j = num2.length()-1;j>=0;j--){
                int curr = (result[i+j+1]==0?0:result[i+j+1]-'0') + Character.getNumericValue(num1.charAt(i))*Character.getNumericValue(num2.charAt(j))+carries;
                carries = curr/10;
                result[i+j+1] = (char)(curr%10+'0');
            }
            result[i] = (char)(carries+'0');
        }
        int i = 0;
        while(i<result.length-1 && result[i]=='0'){
            i++;
        }
        return new String(result,i,result.length-i);
    }
}
